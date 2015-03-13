package com.plexobject.yodlee.api.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.plexobject.yodlee.domain.BaseResponse;
import com.plexobject.yodlee.domain.YodleeClientException;
import com.plexobject.yodlee.util.Configuration;

public class ApacheHttpClientHttpDelegate implements HttpDelegate {
    private final String baseUri;
    private final CloseableHttpClient httpClient;
    private final RequestConfig requestConfig;
    private final ObjectMapper jsonMapper;
    private static String LIBRARY_VERSION = ApacheHttpClientHttpDelegate.class
            .getPackage().getImplementationVersion();

    public ApacheHttpClientHttpDelegate(Configuration config) {
        this(config, createDefault(config));
    }

    public ApacheHttpClientHttpDelegate(Configuration config,
            CloseableHttpClient httpClient) {
        this.baseUri = config
                .getProperty("yodleeBaseUrl",
                        "https://rest.developer.yodlee.com/services/srest/restserver/v1.0/");
        this.httpClient = httpClient;
        this.jsonMapper = new ObjectMapper();
        this.jsonMapper.setSerializationInclusion(Include.NON_NULL);
        this.jsonMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.jsonMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,
                false);
        int timeout = config.getInteger("connectionTimeout", 5000);
        this.requestConfig = RequestConfig.custom().setSocketTimeout(timeout)
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout).build();
        if (LIBRARY_VERSION == null) {
            LIBRARY_VERSION = "development version";
        }
    }

    public <T> HttpResponseWrapper<T> doPost(HttpRequest request, Class<T> clazz) {
        List<NameValuePair> parameters = mapToNvps(request.getParameters());

        try {
            HttpPost post = new HttpPost(baseUri + request.getPath());
            return execute(request, post, parameters, clazz);
        } catch (UnsupportedEncodingException e) {
            throw new YodleeClientException(e);
        } catch (IOException e) {
            throw new YodleeClientException(e);
        }
    }

    @Override
    public <T> HttpResponseWrapper<T> doGet(HttpRequest request, Class<T> clazz) {
        try {
            List<NameValuePair> parameters = mapToNvps(request.getParameters());

            URI uri = new URIBuilder(baseUri).setPath(request.getPath())
                    .addParameters(parameters).build();
            System.out.println("REQUEST " + request);
            HttpGet get = new HttpGet(uri);
            return execute(request, get, parameters, clazz);
        } catch (UnsupportedEncodingException e) {
            throw new YodleeClientException(e);
        } catch (IOException e) {
            throw new YodleeClientException(e);
        } catch (URISyntaxException e) {
            throw new YodleeClientException(e);
        }
    }

    public <T> HttpResponseWrapper<T> doDelete(HttpRequest request,
            Class<T> clazz) {
        try {
            List<NameValuePair> parameters = mapToNvps(request.getParameters());

            URI uri = new URIBuilder(baseUri).setPath(request.getPath())
                    .addParameters(parameters).build();

            HttpDelete delete = new HttpDelete(uri);
            return execute(request, delete, parameters, clazz);
        } catch (UnsupportedEncodingException e) {
            throw new YodleeClientException(e);
        } catch (IOException e) {
            throw new YodleeClientException(e);
        } catch (URISyntaxException e) {
            throw new YodleeClientException(e);
        }
    }

    private <T> HttpResponseWrapper<T> execute(HttpRequest request,
            HttpRequestBase baseRequest, List<NameValuePair> parameters,
            Class<T> clazz) throws ClientProtocolException, IOException {
        baseRequest.setConfig(requestConfig);
        if (baseRequest instanceof HttpEntityEnclosingRequestBase) {
            HttpEntity entity = new UrlEncodedFormEntity(parameters, "UTF-8");
            ((HttpEntityEnclosingRequestBase) baseRequest).setEntity(entity);
        }
        System.out.println("REQUEST " + request);

        if (request.hasTimeout()) {
            int timeout = request.getTimeout();

            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(timeout).setSocketTimeout(timeout)
                    .setConnectionRequestTimeout(timeout).build();
            baseRequest.setConfig(config);
        }

        addUserAgent(baseRequest);

        CloseableHttpResponse response = httpClient.execute(baseRequest);
        return handleResponse(baseRequest, response, clazz);
    }

    private <T> HttpResponseWrapper<T> handleResponse(HttpRequestBase request,
            CloseableHttpResponse response, Class<T> clazz) {
        final HttpEntity responseEntity = response.getEntity();
        String strResp = null;
        try {
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                strResp = EntityUtils.toString(entity);
                System.out.println("RESPONSE: " + strResp);
            }
            //
            EntityUtils.consume(responseEntity);
            if (HttpStatus.SC_OK == statusCode) {
                T responseBody = null;
                if (clazz.isArray()) {
                    if (strResp.length() > 0 && strResp.charAt(0) == '[') {
                        responseBody = jsonMapper.readValue(strResp, clazz);
                    } else {
                        BaseResponse error = jsonMapper.readValue(strResp,
                                BaseResponse.class);
                        throw new YodleeClientException(error);
                    }
                } else {
                    responseBody = jsonMapper.readValue(strResp, clazz);
                }
                return HttpResponseWrapper.create(statusCode, responseBody);
            } else {
                throw new YodleeClientException("Unable to interpret response");
            }
        } catch (JsonParseException e) {
            throw new YodleeClientException("Unexpected resp " + strResp);
        } catch (IllegalStateException | IOException e) {
            throw new YodleeClientException("API error " + strResp, e);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
            }
        }
    }

    private static List<NameValuePair> mapToNvps(Map<String, String> params) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Entry<String, String> entry : params.entrySet()) {
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return nvps;
    }

    private static void addUserAgent(HttpMessage httpMessage) {
        httpMessage.addHeader("User-Agent", "plexobject-yodlee-client"
                + LIBRARY_VERSION);
    }

    private static CloseableHttpClient createDefault(Configuration config) {
        if (config.getBoolean("skipVerifyServerName")) {
            HttpsURLConnection
                    .setDefaultHostnameVerifier(new NullHostnameVerifier());
        }
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return httpClient;
    }

    private static class NullHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}

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
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
            post.setConfig(requestConfig);
            HttpEntity entity = new UrlEncodedFormEntity(parameters, "UTF-8");
            post.setEntity(entity);
            System.out.println("REQUEST " + request);

            if (request.hasTimeout()) {
                int timeout = request.getTimeout();

                RequestConfig config = RequestConfig.custom()
                        .setConnectTimeout(timeout).setSocketTimeout(timeout)
                        .setConnectionRequestTimeout(timeout).build();
                post.setConfig(config);
            }

            addUserAgent(post);

            CloseableHttpResponse response = httpClient.execute(post);
            return handleResponse(post, response, clazz);
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
            get.setConfig(requestConfig);

            addUserAgent(get);

            CloseableHttpResponse response = httpClient.execute(get);

            return handleResponse(get, response, clazz);

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
            delete.setConfig(requestConfig);

            addUserAgent(delete);

            CloseableHttpResponse response = httpClient.execute(delete);

            return handleResponse(delete, response, clazz);
        } catch (UnsupportedEncodingException e) {
            throw new YodleeClientException(e);
        } catch (IOException e) {
            throw new YodleeClientException(e);
        } catch (URISyntaxException e) {
            throw new YodleeClientException(e);
        }
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
            EntityUtils.consume(responseEntity);
            // wireLog(request, response, jsonBody);

            if (HttpStatus.SC_OK == statusCode) {
                T responseBody = jsonMapper.readValue(strResp, clazz);
                return HttpResponseWrapper.create(statusCode, responseBody);
            } else if (HttpStatus.SC_CREATED == statusCode) {
                // MfaResponse mfaResponse = jsonMapper.convertValue(jsonBody,
                // MfaResponse.class);
                throw new YodleeClientException("?????");
            } else if (statusCode >= HttpStatus.SC_BAD_REQUEST) {
                //
                // ErrorResponse errorResponse =
                // jsonMapper.convertValue(jsonBody,
                // ErrorResponse.class);
                throw new YodleeClientException("?????");
            } else {
                throw new YodleeClientException(
                        "Unable to interpret Plaid response");
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

        // HttpParams params = new BasicHttpParams();
        // HttpConnectionParams.setConnectionTimeout(params, 10000);
        // HttpConnectionParams.setSoTimeout(params, 30000);
        // SSLContext ctx = SSLContext.getInstance("TLS");
        //
        // ctx.init(null, new TrustManager[] { nullX509TM }, new
        // SecureRandom());
        // SSLSocketFactory ssf = new SSLSocketFactory(ctx);
        // PoolingClientConnectionManager cxMgr = new
        // PoolingClientConnectionManager(
        // SchemeRegistryFactory.createDefault());
        // cxMgr.setMaxTotal(100);
        // cxMgr.setDefaultMaxPerRoute(20);
        //
        // SchemeRegistry sr = cxMgr.getSchemeRegistry();
        // sr.register(new Scheme("https", 443, ssf));
        // return new DefaultHttpClient(cxMgr, params);
    }

    private static class NullHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}

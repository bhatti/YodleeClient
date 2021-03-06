package com.plexobject.yodlee.api.http;

/**
 * This class encapsulates http response including status code
 * 
 * @author shahzad bhatti
 *
 * @param <T>
 */
public class HttpResponseWrapper<T> {
    private int httpStatusCode;
    private T responseBody;

    public static <T> HttpResponseWrapper<T> create(int httpStatusCode,
            T responseBody) {
        HttpResponseWrapper<T> wrapper = new HttpResponseWrapper<T>();

        wrapper.setHttpStatusCode(httpStatusCode);
        wrapper.setResponseBody(responseBody);

        return wrapper;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

    public T getResponseBody() {
        return responseBody;
    }
}

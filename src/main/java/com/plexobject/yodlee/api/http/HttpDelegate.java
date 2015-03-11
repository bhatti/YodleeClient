package com.plexobject.yodlee.api.http;

/**
 * This interface defines basic HTTP methods to make REST API callss
 * 
 * @author shahzad bhatti
 *
 */
public interface HttpDelegate {
    <T> HttpResponseWrapper<T> doPost(HttpRequest request, Class<T> clazz);

    <T> HttpResponseWrapper<T> doGet(HttpRequest request, Class<T> clazz);

    <T> HttpResponseWrapper<T> doDelete(HttpRequest request, Class<T> clazz);
}

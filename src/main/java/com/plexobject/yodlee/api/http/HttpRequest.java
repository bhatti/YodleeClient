package com.plexobject.yodlee.api.http;

import java.util.HashMap;
import java.util.Map;

/**
 * This class encapsulates http request
 * 
 * @author shahzad bhatti
 *
 */
public class HttpRequest {
    private String path;
    private Map<String, String> parameters;
    private Integer timeout;

    public HttpRequest(String path) {
        this(path, 0, new HashMap<String, String>());
    }

    public HttpRequest(String path, Integer timeout, String... parameters) {
        this(path, timeout, toMap(parameters));
    }

    public HttpRequest(String path, String... parameters) {
        this(path, 0, toMap(parameters));
    }

    public HttpRequest(String path, Integer timeout,
            Map<String, String> parameters) {
        this.path = path;
        this.parameters = parameters;
        this.timeout = timeout;
    }

    public HttpRequest addParameter(String key, String value) {
        this.parameters.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public boolean hasTimeout() {
        return timeout != null;
    }

    private static Map<String, String> toMap(String... params) {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < params.length; i += 2) {
            map.put(params[i], params[i + 1]);
        }
        return map;
    }

    @Override
    public String toString() {
        return "HttpRequest [path=" + path + ", parameters=" + parameters
                + ", timeout=" + timeout + "]";
    }
}

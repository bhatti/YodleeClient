package com.plexobject.yodlee.domain;

/**
 * This class encapsulates exception while making API request
 * 
 * @author shahzad bhatti
 *
 */
public class YodleeClientException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public YodleeClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public YodleeClientException(String message) {
        super(message);
    }

    public YodleeClientException(Throwable cause) {
        super(cause);
    }

}

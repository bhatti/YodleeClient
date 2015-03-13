package com.plexobject.yodlee.domain;

/**
 * This class encapsulates exception while making API request
 * 
 * @author shahzad bhatti
 *
 */
public class YodleeClientException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String exceptionType;
    private String referenceCode;

    public YodleeClientException(BaseResponse response) {
        super(response.getMessage());
        this.exceptionType = response.getExceptionType();
        this.referenceCode = response.getReferenceCode();
    }

    public YodleeClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public YodleeClientException(String message) {
        super(message);
    }

    public YodleeClientException(Throwable cause) {
        super(cause);
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

}

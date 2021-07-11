package com.product.productretail.exception;

public class ProductRetailException extends Exception {

    public static final String BUSINESS_EXCEPTION = "Business Exception";
    public static final String TECHNICAL_ERROR = "Technical Error";
    public static final String REST_CALL_EXCEPTION = "Rest Call Exception";
    public static final String INVALID_REQUEST_ERROR = "Invalid Request Error";

    private final String exceptionName;
    private final String exceptionMsg;

    public ProductRetailException(String exceptionName, String exceptionMsg) {

        super(exceptionMsg);
        this.exceptionName = exceptionName;
        this.exceptionMsg = exceptionMsg;
    }

    public ProductRetailException(String exceptionName, String exceptionMsg, Throwable cause) {

        super(exceptionMsg, cause);
        this.exceptionName = exceptionName;
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

}

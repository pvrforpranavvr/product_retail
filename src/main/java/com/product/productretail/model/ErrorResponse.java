package com.product.productretail.model;

import java.util.List;

public class ErrorResponse {

    private String errorName;
    private String errorMessage;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorName, String errorMessage) {
        this.errorName = errorName;
        this.errorMessage = errorMessage;
    }

    public ErrorResponse(String errorName, List<String> errorMessages) {
        this.errorName = errorName;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}


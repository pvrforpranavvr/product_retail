package com.product.productretail.exception.handler;

import com.product.productretail.exception.ProductRetailException;
import com.product.productretail.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ProductRetailExceptionHandler {

    @ExceptionHandler(ProductRetailException.class)
    public ResponseEntity<ErrorResponse> handleProductRetailException(HttpServletRequest req, ProductRetailException ex) {

        HttpStatus httpStatus;
        if (ex.getExceptionName().equals(ProductRetailException.INVALID_REQUEST_ERROR)
                || ex.getExceptionName().equals(ProductRetailException.BUSINESS_EXCEPTION)) {

            httpStatus = HttpStatus.BAD_REQUEST;

        } else {

            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        }

        String exceptionName = ex.getExceptionName();

        if (ProductRetailException.REST_CALL_EXCEPTION.equals(exceptionName)) {

            exceptionName = ProductRetailException.TECHNICAL_ERROR;

        }
        return new ResponseEntity<>(new ErrorResponse(exceptionName, ex.getMessage()), httpStatus);
    }
}

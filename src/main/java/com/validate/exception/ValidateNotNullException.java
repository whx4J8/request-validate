package com.validate.exception;

/**
 * Created by wanghongxing on 15/10/12.
 */
public class ValidateNotNullException extends ValidateException {


    public ValidateNotNullException() {
    }

    public ValidateNotNullException(String message) {
        super(message);
    }

    public ValidateNotNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateNotNullException(Throwable cause) {
        super(cause);
    }

    public ValidateNotNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

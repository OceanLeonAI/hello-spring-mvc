package com.leon.exception;

/**
 * 基类异常
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 4365182970007171436L;

    /**
     * 错误码
     */
    private int errorCode;

    /**
     * 异常信息
     */
    private String errorMessage;

    // ------------------------------------------------------

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // ------------------------------------------------------

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.mlj.tshop.common.exception;

/**
 * 2018/12/08：
 *
 * @author mlj
 */
public class ManagerNotExistException extends Exception {
    public ManagerNotExistException() {
        super();
    }

    public ManagerNotExistException(String message) {
        super(message);
    }

    public ManagerNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerNotExistException(Throwable cause) {
        super(cause);
    }

    protected ManagerNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

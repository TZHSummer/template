package com.mlj.tshop.common.exception;

/**
 * 2018/12/08：
 *
 * @author mlj
 */
public class ManagerNotFindException extends Exception {
    public ManagerNotFindException() {
        super();
    }

    public ManagerNotFindException(String message) {
        super(message);
    }

    public ManagerNotFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerNotFindException(Throwable cause) {
        super(cause);
    }

    protected ManagerNotFindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

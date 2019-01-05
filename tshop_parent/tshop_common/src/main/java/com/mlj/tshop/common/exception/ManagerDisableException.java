package com.mlj.tshop.common.exception;

/**
 * 2018/12/12：管理员账号禁用异常
 *
 * @author mlj
 */
public class ManagerDisableException extends Exception{
    public ManagerDisableException() {
        super();
    }

    public ManagerDisableException(String message) {
        super(message);
    }

    public ManagerDisableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerDisableException(Throwable cause) {
        super(cause);
    }
}

package com.mlj.tshop.common.exception;

/**
 * 2018/12/10：管理员已存在异常
 *
 * @author mlj
 */
public class ManagerExistException extends Exception {
    public ManagerExistException() {
        super();
    }

    public ManagerExistException(String message) {
        super(message);
    }

    public ManagerExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerExistException(Throwable cause) {
        super(cause);
    }
}

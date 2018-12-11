package com.mlj.tshop.common.exception;

/**
 * 2018/12/10：密码错误异常
 *
 * @author mlj
 */
public class PasswordIncorrectException extends Exception{
    public PasswordIncorrectException() {
        super();
    }

    public PasswordIncorrectException(String message) {
        super(message);
    }

    public PasswordIncorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordIncorrectException(Throwable cause) {
        super(cause);
    }
}

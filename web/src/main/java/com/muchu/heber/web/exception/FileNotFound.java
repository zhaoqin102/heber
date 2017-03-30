package com.muchu.heber.web.exception;

/**
 * @author 梁海鹏
 * @createdate 16-12-11 下午10:06
 */
public class FileNotFound extends RuntimeException {

    public FileNotFound(String message) {
        super(message);
    }
}

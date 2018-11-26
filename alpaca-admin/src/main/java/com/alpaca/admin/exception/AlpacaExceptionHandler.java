package com.alpaca.admin.exception;

import com.alpaca.common.system.ResponseMessage;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: AlpacaExceptionHandler
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/24 9:52
 * @Version: 1.0.0
 */
@RestControllerAdvice
public class AlpacaExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 自定义异常
     */
    @ExceptionHandler(AlpacaException.class)
    public ResponseMessage handleAlpacaException(AlpacaException e){

       return   ResponseMessage.error(e.getMessage());

    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseMessage handleDuplicateKeyException(DuplicateKeyException e){
        logger.error(e.getMessage(), e);
        return ResponseMessage.error("数据库中已存在该记录");
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseMessage handleAuthorizationException(AuthorizationException e){
        logger.error(e.getMessage(), e);
        return ResponseMessage.error("没有权限，请联系管理员授权");
    }

    @ExceptionHandler(Exception.class)
    public ResponseMessage handleException(Exception e){
        logger.error(e.getMessage(), e);
        return ResponseMessage.error();
    }
}


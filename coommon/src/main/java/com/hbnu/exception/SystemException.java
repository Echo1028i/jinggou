package com.hbnu.exception;

import com.hbnu.vo.SysResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @Auther caitao
 * @Date 2023/5/8 09:07
 * @Description
 */
@RestControllerAdvice
@Slf4j
public class SystemException {

    @ExceptionHandler(RuntimeException.class)
    public SysResult exception(Throwable throwable){
        throwable.printStackTrace();
        log.info(throwable.getMessage());
        return SysResult.fail("调用失败!");
    }
}

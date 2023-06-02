package com.hbnu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Auther caitao
 * @Date 2023/5/23 14:23
 * @Description
 */
@RestController
public class PortController {
    @Value("${server.port}")
    private String port;

    //动态获取当前服务器端口号
    @RequestMapping("/port")
    public String getPort(){
        return "本次访问的服务器端口号为: "+port;
    }
}

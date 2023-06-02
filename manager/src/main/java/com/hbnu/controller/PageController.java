package com.hbnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @Auther caitao
 * @Date 2023/4/28 08:09
 * @Description
 */
@Controller
@RequestMapping("/page")
public class PageController {


    @RequestMapping("/{pageName}")
    public String page(@PathVariable String pageName){
        return pageName;
    }
}

package com.hbnu.controller;

import com.hbnu.service.FileService;
import com.hbnu.vo.ImageVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.UUID;

/**
 *
 * @Auther caitao
 * @Date 2023/5/19 08:21
 * @Description
 */
@RestController
public class FileController {

    @Resource
    private FileService fileService;

    /**
     * 请求地址：--->http://127.0.0.1:8080/pic/upload?dir=image
     * 请求参数：--->uploadFile
     * 响应数据：--->vo对象{图片的url，图片的宽高}
     */
    @PostMapping("/pic/upload")
    public ImageVO fileUpload(MultipartFile uploadFile){

        return fileService.uploadFile(uploadFile);

    }
}

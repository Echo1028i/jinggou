package com.hbnu.service;

import com.hbnu.vo.ImageVO;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @Auther caitao
 * @Date 2023/5/19 08:38
 * @Description
 */
public interface FileService {
    ImageVO uploadFile(MultipartFile uploadFile);
}

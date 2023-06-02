package com.hbnu.service.impl;

import com.hbnu.service.FileService;
import com.hbnu.vo.ImageVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @Auther caitao
 * @Date 2023/5/19 08:38
 * @Description
 */
@Service
@PropertySource("classpath:/properties/image.properties") //加载properties文件
public class FileServiceImpl implements FileService {

    //定义本地磁盘路径
    @Value("${image.localDirPath}")
    private String localDirPath;

    //定义虚拟路径
    @Value("${image.urlDirPath}")
    private String urlDirPath;

    @Override
    public ImageVO uploadFile(MultipartFile uploadFile) {

        /**
         * 图片上传实现思路：
         * 1、校验文件的格式，图片的格式(.jpg,.png,.jpeg等等)
         * 2、校验恶意文件，比如 aaa.pm4--->改成aaa.jpg  木马.exe
         * 3、图片存储,分文件存储: yyyy/MM/dd
         * 4、上传之后的图片名字,名字不能重复，uuid.图片类型
         */
        // 获取文件名称
        String filename = uploadFile.getOriginalFilename();
        filename =filename.toLowerCase();

        if (!filename.matches("^.+\\.(jpg|png|jpeg)$")){

            return ImageVO.fail();
        }

        try {
            BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
            int width=0;
            int height=0;
            if (bufferedImage!=null){
                 width = bufferedImage.getWidth();
                 height = bufferedImage.getHeight();
                if (width==0||height==0){
                    return ImageVO.fail();
                }
            }

            String dateDirPath = new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
            String realDirPath = localDirPath+dateDirPath;
            File realDirFile = new File(realDirPath);
            if (!realDirFile.exists()){
                realDirFile.mkdirs(); //如果目录不存在，则创建
            }

            //图片上传之后的名字
            String uuid = UUID.randomUUID().toString();
            //获取图片文件的后缀
            String fileType = filename.substring(filename.lastIndexOf("."));
            String realFileName =uuid+fileType;


            //图片真实路径
            String realFilePath = realDirPath+realFileName;
            uploadFile.transferTo(new File(realFilePath)); //开始上传图片
            //图片虚拟路径
            //实现图片回显
            String url = urlDirPath +dateDirPath + realFileName;
            ImageVO imageVO = new ImageVO(0,url,width,height);
            return imageVO;
        } catch (IOException e) {
            e.printStackTrace();
            return ImageVO.fail();
        }

     
    }



}

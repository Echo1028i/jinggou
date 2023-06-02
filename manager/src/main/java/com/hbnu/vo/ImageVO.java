package com.hbnu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 *
 * @Auther caitao
 * @Date 2023/5/19 08:23
 * @Description
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ImageVO {
    private Integer error = 0; //error为0表示成功，1表示失败
    private String url; //表示图片的虚拟路径
    private Integer width; //图片的宽度
    private Integer height; //图片的高度

    public static ImageVO fail(){
        return new ImageVO(1,null,null,null);
    }
}

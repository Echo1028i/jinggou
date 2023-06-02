package com.hbnu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 *
 * @Auther caitao
 * @Date 2023/4/24 10:16
 * @Description
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_item")
public class Item extends BasePojo{
    @TableId(type = IdType.AUTO)
    private Integer id; //商品id
    private String title; //商品标题
    private String sellPoint; //商品卖点
    private Long price; //商品价格
    private Integer num ;//商品数量(库存)
    private String barcode;//商品二维码
    private String image; //商品图片
    private Integer cid;//商品分类
    private Integer status;//商品状态： 1、正常 2、下架
}

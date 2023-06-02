package com.hbnu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 *
 * @Auther caitao
 * @Date 2023/5/12 09:08
 * @Description
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_item_desc")
public class ItemDesc extends BasePojo{
    @TableId
    private Integer itemId; //商品id
    private String itemDesc; //商品描述信息
}

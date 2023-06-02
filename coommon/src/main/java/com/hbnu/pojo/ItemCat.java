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
 * @Date 2023/5/5 08:18
 * @Description
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_item_cat")
public class ItemCat extends BasePojo {
    @TableId(type = IdType.AUTO)
    private Long id; //商品分类id
    private Integer parentId; //商品分类父id
    private String name; //商品分类名称
    private Integer status; // 商品分类的状态
    private Integer sortOrder;//商品排序
    private Boolean isParent; //是否为一级分类


}

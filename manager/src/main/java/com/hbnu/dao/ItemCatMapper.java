package com.hbnu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbnu.pojo.ItemCat;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @Auther caitao
 * @Date 2023/5/5 08:14
 * @Description 商品分类的接口
 */
@Mapper
public interface ItemCatMapper extends BaseMapper<ItemCat> {

}

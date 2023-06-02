package com.hbnu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbnu.dao.ItemCatMapper;
import com.hbnu.pojo.ItemCat;
import com.hbnu.vo.EasyUITree;

import java.util.List;

/**
 *
 * @Auther caitao
 * @Date 2023/5/5 08:13
 * @Description
 */
public interface ItemCatService extends IService<ItemCat>{

    ItemCat findItemCatNameById(Integer id);

    List<EasyUITree> findEasyUITree(Integer parentId);
}

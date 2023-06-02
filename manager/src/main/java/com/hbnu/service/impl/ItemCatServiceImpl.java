package com.hbnu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbnu.dao.ItemCatMapper;
import com.hbnu.dao.ItemMapper;
import com.hbnu.pojo.ItemCat;
import com.hbnu.service.ItemCatService;
import com.hbnu.service.ItemService;
import com.hbnu.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Auther caitao
 * @Date 2023/5/5 08:14
 * @Description
 */
@Service
public class ItemCatServiceImpl extends ServiceImpl<ItemCatMapper, ItemCat> implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public ItemCat findItemCatNameById(Integer id) {
        return itemCatMapper.selectById(id);
    }

    @Override
    public List<EasyUITree> findEasyUITree(Integer parentId) {
        List<EasyUITree> easyUITrees = new ArrayList<>();
        // 根据parentId查询所有的商品分类数据
        List<ItemCat> itemCatList = findItemCatByParentId(parentId);

        //构建EastUITree对象
        for (ItemCat itemCat : itemCatList) {
            Long id = itemCat.getId();
            String text = itemCat.getName();
            //如果父级是closed 否则open
           String state = itemCat.getIsParent() ? "closed" :"open";
           EasyUITree easyUITree =  new EasyUITree(id,text,state);
           easyUITrees.add(easyUITree);
        }
        return easyUITrees;
    }

    private List<ItemCat> findItemCatByParentId(Integer parentId) {
        QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId);
        List<ItemCat> itemCatList = itemCatMapper.selectList(queryWrapper);
        return itemCatList;

    }
}

package com.hbnu.service.impl;

import com.hbnu.dao.ItemDescMapper;
import com.hbnu.dao.ItemMapper;
import com.hbnu.pojo.Item;
import com.hbnu.pojo.ItemDesc;
import com.hbnu.service.ItemService;
import com.hbnu.vo.EasyUITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @Auther caitao
 * @Date 2023/4/28 09:08
 * @Description
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemDescMapper itemDescMapper;


    @Override
    public EasyUITable findItemByPage(Integer page, Integer rows) {
        //1.获取总的数据
        Integer total = itemMapper.selectCount(null);
        //2.获取每页分页的数据
        /**
         * 第一页数据：select * from tb_item limit 0，20
         * 第二页数据：select * from tb_item limit 20，20
         */
        int start = (page -1)* 20;
        List<Item> itemList = itemMapper.findItemByPage(start, rows);

        return new EasyUITable(total,itemList);
    }

    @Override
    public void saveItem(Item item, ItemDesc itemDesc) {
        // 保存商品数据
        item.setStatus(1).setCreated(new Date());
        item.setUpdated(item.getCreated());
        itemMapper.insert(item);

        //保存商品描述信息
        //MyBatis特性：数据添加到数据库后，主键会自动回填
        itemDesc.setItemId(item.getId()).setCreated(item.getCreated());
        itemDesc.setUpdated(item.getUpdated());
        itemDescMapper.insert(itemDesc);


    }


    @Override
    public void updateItem(Item item) {
        item.setUpdated(new Date());
        itemMapper.updateById(item);
    }

    @Override
    public void deleteItem(Integer[] ids) {
        List<Integer> list = Arrays.asList(ids);
        itemMapper.deleteBatchIds(list);

    }

    @Override
    public void updateItemStatus(int status, Integer[] ids) {
        for (Integer id : ids) {
            Item item = itemMapper.selectById(id);
            item.setStatus(status).setUpdated(new Date());
            itemMapper.updateById(item);
        }
    }

    @Override
    public ItemDesc updateItemDesc(Integer id) {
        ItemDesc itemDesc = itemDescMapper.selectById(id);
        return itemDesc;
    }


}

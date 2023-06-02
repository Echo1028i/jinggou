package com.hbnu.service;

import com.hbnu.pojo.Item;
import com.hbnu.pojo.ItemDesc;
import com.hbnu.vo.EasyUITable;

/**
 *
 * @Auther caitao
 * @Date 2023/4/28 09:07
 * @Description
 */
public interface ItemService {

    EasyUITable findItemByPage(Integer start,Integer rows);

    void saveItem(Item item, ItemDesc itemDesc);

    void updateItem(Item item);

    void deleteItem(Integer[] ids);

    void updateItemStatus(int status, Integer[] ids);

    ItemDesc updateItemDesc(Integer id);

}

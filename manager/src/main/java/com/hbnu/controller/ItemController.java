package com.hbnu.controller;

import com.hbnu.pojo.Item;
import com.hbnu.pojo.ItemDesc;
import com.hbnu.service.ItemService;
import com.hbnu.vo.EasyUITable;
import com.hbnu.vo.SysResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * @Auther caitao
 * @Date 2023/4/28 09:08
 * @Description
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource
    private ItemService itemService;

    // 请求地址:http://localhost:8080/item/query?page=1&rows=20
    @GetMapping("/query")
    public EasyUITable findItemByPage(Integer page, Integer rows) {
        return itemService.findItemByPage(page, rows);
    }

    // 请求地址:http://localhost:8080/item/save
    @PostMapping("/save")
    public SysResult saveItem(Item item, ItemDesc itemDesc) {
        itemService.saveItem(item,itemDesc);
        return SysResult.success();
    }

    // 请求地址:http://localhost:8080/item/update

    @PostMapping("/update")
    public SysResult updateItem(Item item) {

        itemService.updateItem(item);
        return SysResult.success();

    }

    //商品上详情desc
    // http://localhost:8080/item/query/item/desc/1474391978
    @GetMapping("/query/item/desc/{id}")
    public SysResult updateItemDesc(@PathVariable Integer id){
       ItemDesc itemDesc = itemService.updateItemDesc(id);
        return SysResult.success(itemDesc);
    }

    // 请求地址:http://localhost:8080/item/delete
    @PostMapping("/delete")
    public SysResult deleteItem(Integer[] ids){
        itemService.deleteItem(ids);
        return SysResult.success();
    }

    // 下架商品
    // http://localhost:8080/item/instock
    @PostMapping("/instock")
    public SysResult instockItem(Integer[] ids){
        int status = 2;
        itemService.updateItemStatus(status,ids);
        return SysResult.success();
    }

    //上架商品 http://localhost:8080/item/reshelf
    @PostMapping("/reshelf")
    public SysResult reshelfItem(Integer[] ids){
        int status = 1;
        itemService.updateItemStatus(status,ids);
        return SysResult.success();
    }


}

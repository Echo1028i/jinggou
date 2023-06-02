package com.hbnu.controller;

import com.hbnu.pojo.ItemCat;
import com.hbnu.service.ItemCatService;
import com.hbnu.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @Auther caitao
 * @Date 2023/5/5 08:13
 * @Description
 */
@RestController
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @PostMapping("/queryItemName")
    public String queryItemName(Integer itemCatId){
        ItemCat itemCat = itemCatService.findItemCatNameById(itemCatId);

        return itemCat.getName();
    }

    @PostMapping("/list")
    public List<EasyUITree> queryList(@RequestParam(value = "id",defaultValue = "0") Integer parentId){
       List<EasyUITree> easyUITrees = itemCatService.findEasyUITree(parentId);
        return easyUITrees;

    }
}

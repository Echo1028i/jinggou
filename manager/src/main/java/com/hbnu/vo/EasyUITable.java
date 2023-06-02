package com.hbnu.vo;

import com.hbnu.pojo.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 *
 * @Auther caitao
 * @Date 2023/4/28 09:00
 * @Description
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class EasyUITable {
    private Integer total;
    private List<Item> rows;
}

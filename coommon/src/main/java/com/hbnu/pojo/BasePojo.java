package com.hbnu.pojo;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;

/**
 *
 * @Auther caitao
 * @Date 2023-10-2023/4/24-10:10
 * @Description
 */
@Data
public class BasePojo implements Serializable {

    private Date created; //创建时间
    private Date updated; // 更新时间
}

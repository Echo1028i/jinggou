package com.hbnu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 *
 * @Auther caitao
 * @Date 2023/5/8 08:17
 * @Description
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysResult {

    private Integer status; //服务器状态码  200(正常)， 201(失败)
    private String msg; //服务器给前端返回的消息
    private Object data; //服务端返回的数据

    public static SysResult success(){
        return new SysResult(200,null,null);
    }

    public static SysResult success(String msg,Object data){
        return new SysResult(200,msg,data);
    }

    public static SysResult success(Object data){
        return new SysResult(200,null,data);
    }

    public static SysResult fail(){
        return new SysResult(201,null,null);
    }

    public static SysResult fail(String msg){
        return new SysResult(201,msg,null);
    }

}

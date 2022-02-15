package com.aaa.sbs.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:授权操作
 * @date 2022/2/14 18:57
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 模拟用户查询
     * @return
     */
    //这两个有任意一个就可以访问
    @Secured({"ROLE_guanliyuan","ROLE_dailishang"})
    @GetMapping("queryAll")
    public String queryAll(){
        return "模拟用户查询";
    }

    /**
     *
     * @param deptNo
     * @return
     */
    @Secured("ROLE_guanliyuan")
    @GetMapping("queryById")
    public String queryById(Integer deptNo){
        return "根据编号查询用户";
    }
    //拥有一个权限就可以
    //@PreAuthorize("hasRole('ROLE_guanliyuan')")
    //两个必须都有
    //@PreAuthorize("hasRole('ROLE_guanliyuan') and hasRole('ROLE_dailishang')")
    //任意拥有一个就可以
    //@PreAuthorize("hasAnyRole('ROLE_guanliyuan','ROLE_dailishang')")
    //该方法可以通过returnObject获取到返回值做判断
    @PostAuthorize("returnObject!=null")
    @GetMapping("add")
    public String add(){
        return "模拟用户添加";
    }
}

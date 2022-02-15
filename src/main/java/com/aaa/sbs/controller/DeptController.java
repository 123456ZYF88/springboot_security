package com.aaa.sbs.controller;

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
@RequestMapping("dept")
public class DeptController {
    /**
     * 模拟部门查询
     * @return
     */
    @GetMapping("queryAll")
    public String queryAll(){
        return "模拟部门查询";
    }

    /**
     * 根据编号查部门
     * @param deptNo
     * @return
     */
    @GetMapping("queryById")
    public String queryById(Integer deptNo){
        return "根据编号查询部门";
    }
    @GetMapping("add")
    public String add(){
        return "模拟部门添加";
    }
}

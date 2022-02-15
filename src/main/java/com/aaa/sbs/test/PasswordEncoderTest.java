package com.aaa.sbs.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 测试BCryptPasswordEncoder
 * @date 2022/2/14 15:37
 */
public class PasswordEncoderTest {
    public static void main(String[] args) {
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密密码
        String password = bCryptPasswordEncoder.encode("tiger");
        System.out.println("密码"+password);
        //验证密码是否正确
        boolean isSuc = bCryptPasswordEncoder.matches("tiger",password);
        System.out.println("密码是否正确"+isSuc);
        boolean isSucl = bCryptPasswordEncoder.matches("tiger","$2a$10$kkB4WomyMeYRhg.iC6g0OubsrZGBvAfX7Cuq0mtDkIbMUpLTahDpy");
        System.out.println("比对过去生成的密码是否正确"+isSucl);
    }
}

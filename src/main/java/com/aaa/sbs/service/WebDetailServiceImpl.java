package com.aaa.sbs.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author zhangyifan
 * @version 8.0
 * @description: 相当与 shrio的realm
 * @date 2022/2/14 10:34
 */
@Service
public class WebDetailServiceImpl  implements UserDetailsService {
    //注入userService接口
/*
    * private UserService userService       */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_guanliyuan,ROLE_dailishang,shanghu,dept:query,dept:update");
        //第一个参数：数据库取出用户名   第二个参数：加密密码   第三个参数：角色/权限集合
        return  new User("root",new BCryptPasswordEncoder().encode("tiger"),grantedAuthorities);
    }
}

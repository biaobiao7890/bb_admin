package com.ma.bb.service.edu.controller;

import com.ma.bb.common.base.result.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author biaob
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {

    /**
     * 登录
     * @return
     */
    @PostMapping("login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("info")
    public R info() {
        return R.ok()
                .data("name", "admin")
                .data("roles","[admin]")
                .data("avatar","http://m.imeitou.com/uploads/allimg/200929/3-200929132437.jpg");
    }
    /**
     * 登出
     */
    @PostMapping("logout")
    public R logout() {
        return R.ok();
    }
}

package com.shuai.provider.service;

import com.shuai.commons.service.CommonsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderService implements CommonsService {
    @Override
    @PostMapping("login")
    public String login(String name, @RequestParam String password) {
//        try {
//            Thread.sleep(2500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("name ： " + name + "，    password：" + password);
        return "登录成功";
    }

    @Override
    @GetMapping("exit")
    public String exit() {
        return "退出成功";
    }
}

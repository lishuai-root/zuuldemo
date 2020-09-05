package com.shuai.comsumer.service;

import com.shuai.commons.service.CommonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComsumerService {

    @Autowired
    private CommonsService service;

    @PostMapping("login")
    public String login(String name, String password) {
        System.out.println("收到请求" + name + "---" + password);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return service.login(name, password);
    }

    @PostMapping("exit")
    public String exit() {
        return service.exit();
    }
}

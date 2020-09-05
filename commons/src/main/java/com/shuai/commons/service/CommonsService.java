package com.shuai.commons.service;

import com.shuai.commons.fallback.ServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider", fallbackFactory = ServiceFallBack.class)
public interface CommonsService {

    @PostMapping("login")
    String login(@RequestBody String name, @RequestParam String password);

    @GetMapping("exit")
    String exit();
}

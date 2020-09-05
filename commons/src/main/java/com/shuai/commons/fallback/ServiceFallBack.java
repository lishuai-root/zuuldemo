package com.shuai.commons.fallback;

import com.shuai.commons.service.CommonsService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceFallBack implements FallbackFactory<CommonsService> {

    @Override
    public CommonsService create(Throwable throwable) {
        return new CommonsService() {
            @Override
            public String login(String name, String password) {
                return "登录失败";
            }

            @Override
            public String exit() {
                return "退出失败";
            }
        };
    }
}

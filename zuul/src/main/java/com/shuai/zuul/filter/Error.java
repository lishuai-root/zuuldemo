package com.shuai.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class Error extends SendErrorFilter {
    @Override
    public Object run() {
        System.out.println("---出现错误---");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletResponse response = currentContext.getResponse();
        response.setCharacterEncoding("utf-8");
        try {
            response.getWriter().write("出现错误了");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

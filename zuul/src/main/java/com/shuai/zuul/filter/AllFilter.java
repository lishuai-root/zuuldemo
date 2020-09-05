package com.shuai.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AllFilter extends ZuulFilter {
    //过滤类型  pre表示在请求之前执行
    //routing在路由请求时调用
    //error处理请求发生错误是调用
    //post在routing和error过滤器之后执行
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器的执行顺序，当一个请求在同一阶段被多个拦截器拦截时的过滤器执行顺序
    //数字越小优先级越高
    @Override
    public int filterOrder() {
        return 0;
    }

    //表示过滤器是否生效，就是这个过滤器要不要执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //编写过滤器拦截的逻辑
    @Override
    public Object run() throws ZuulException {
        //获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取请求对象
        HttpServletRequest request = currentContext.getRequest();
        //获取token
        String token = request.getHeader("token");
        System.out.println(token);
        System.out.println(HttpStatus.FORBIDDEN.value());
        if (StringUtils.isEmpty(token)) {
            //如果没有token，不调用服务接口，网关直接返回
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("请先登录");
            currentContext.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
            HttpServletResponse response = currentContext.getResponse();
            response.setCharacterEncoding("utf-8");
            return null;
        }
        //如果又token，继续执行访问服务接口
        return null;
    }
}

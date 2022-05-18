package com.zengzhaogui.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "zengzhaoguiFilter")
public class zengzhaoguiFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("zengzhaoguiFilter-->brfore chain");
        chain.doFilter(request, response);
        System.out.println("zengzhaoguiFilter-->after chain");
    }
}

package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TestFilter implements Filter {
    private String requestDomain = "http://api3.goodchoice.kr";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = this.requestDomain;
        String queryString = req.getRequestURI() == null ? "" : req.getRequestURI();

        System.out.println("호출 : " + url+req.getRequestURI());

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(this.requestDomain+queryString, String.class);

        res.setStatus(HttpServletResponse.SC_OK);
        res.getWriter().write(result);
        res.getWriter().flush();
        res.getWriter().close();

        //filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}

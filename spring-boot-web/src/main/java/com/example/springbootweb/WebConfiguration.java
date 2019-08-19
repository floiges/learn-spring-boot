package com.example.springbootweb;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration // 添加注解，将自定义 Filter 加入过滤链
public class WebConfiguration {
	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}

	@Bean
	public FilterRegistrationBean testFilterRegistration() {
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new MyFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.addInitParameter("paramName", "paramsValue");
		registrationBean.setName("MyFilter");
		registrationBean.setOrder(1);
		return registrationBean;
	}

	public class MyFilter implements Filter {
		@Override
		public void destroy() {

		}

		@Override
		public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest)servletRequest;
			System.out.println("this is MyFilter, url:" + request.getRequestURI());
			filterChain.doFilter(servletRequest, servletResponse);
		}

		@Override
		public void init(FilterConfig filterConfig) throws ServletException {

		}
	}
}

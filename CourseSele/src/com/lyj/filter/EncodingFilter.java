package com.lyj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	protected String encoding = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (this.encoding != null) {
			request.setCharacterEncoding(this.encoding);
			System.out.println("enconding=" + this.encoding);
			chain.doFilter(request, response);
		}

		// request.setCharacterEncoding("UTF-8");
		// chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.encoding = filterConfig.getInitParameter("encoding");
	}

}

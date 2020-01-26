package com.javashitang;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 判断用户是否有访问权限的过滤器
 */
@Component
public class AccessFilter extends ZuulFilter {
		public String filterType() {
				return "pre";
		}

		public int filterOrder() {
				return 0;
		}

		public boolean shouldFilter() {
				return true;
		}

		public Object run() throws ZuulException {
				RequestContext ctx = RequestContext.getCurrentContext();
				HttpServletRequest request = ctx.getRequest();
				Object accessToken = request.getParameter("accessToken");
				if (accessToken == null) {
						ctx.setSendZuulResponse(false);
						ctx.setResponseStatusCode(401);
						return null;
				}
				return null;
		}
}

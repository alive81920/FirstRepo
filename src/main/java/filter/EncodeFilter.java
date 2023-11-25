package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodeFilter", urlPatterns = "/*")
public class EncodeFilter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		chain.doFilter(req, resp);
	}
}
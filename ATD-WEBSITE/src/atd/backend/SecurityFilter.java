package atd.backend;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter implements Filter {
	public void init(FilterConfig arg0) throws ServletException {
		/* Filter is being placed into service, do nothing. */
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r2 = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) resp;

		if (r2.getSession().getAttribute("username") == null) {
			httpResponse.sendRedirect("/ATD-WEBSITE/login/login.jsp");
			return;
		} else {
			chain.doFilter(req, resp);
		}
	}

	public void destroy() {
		/* Filter is being taken out of service, do nothing. */
	}
}
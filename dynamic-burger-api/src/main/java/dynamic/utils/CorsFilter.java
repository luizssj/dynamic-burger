package dynamic.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsFilter extends OncePerRequestFilter {

	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE");
		res.addHeader("Access-Control-Expose-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With, If-Modified-Since, x-status-error");
		res.addHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With, If-Modified-Since, x-status-error");
		chain.doFilter(req, res);
	}
}
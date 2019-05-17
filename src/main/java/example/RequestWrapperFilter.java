package example;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Rob Winch
 */
@Component
public class RequestWrapperFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, FilterChain filterChain)
			throws ServletException, IOException {
		filterChain.doFilter(new RequestWrapper(httpServletRequest), httpServletResponse);
	}

	@Override
	protected boolean shouldNotFilterErrorDispatch() {
		return false;
	}

	public static class RequestWrapper extends HttpServletRequestWrapper {
		public RequestWrapper(HttpServletRequest request) {
			super(request);
		}
	}
}

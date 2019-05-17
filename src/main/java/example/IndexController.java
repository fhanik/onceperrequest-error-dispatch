package example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Rob Winch
 */
@Controller
public class IndexController {
	@GetMapping(path = {"/", "/error"})
	String index(HttpServletRequest request, Map<String, Object> model) {
		boolean isWrapped = WebUtils.getNativeRequest(request, RequestWrapperFilter.RequestWrapper.class) != null;
		model.put("isWrapped", isWrapped);
		return "index";
	}
}

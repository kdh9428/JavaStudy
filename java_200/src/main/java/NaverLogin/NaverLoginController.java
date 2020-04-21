package NaverLogin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;

import aop.logExecution;

@Controller
public class NaverLoginController {
		
	
		/* NaverLoginBO */
		@Autowired
		private NaverLoginBO naverLoginBO;
		
//		private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
//			this.naverLoginBO = naverLoginBO;
//		}
		
		@logExecution
		@RequestMapping("/login")
	    public ModelAndView login(HttpSession session) {
			System.out.println("확인");
	        /* 네아로 인증 URL을 생성하기 위하여 getAuthorizationUrl을 호출 */
	        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
	        
	        /* 생성한 인증 URL을 View로 전달 */
	        return new ModelAndView("login", "url", naverAuthUrl);
	    }
		
		@RequestMapping("/callback")
		public ModelAndView callback(@RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
			OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
			String apiResult = naverLoginBO.getUserProfile(oauthToken);
			return new ModelAndView("callback", "result", apiResult);
		}
		
		@RequestMapping("/test")
		public String modeltest(Model model) {
			Map<String, Integer> test = new HashMap<String, Integer>();
			test.put("test1", 1);
			test.put("test2", 2);
			test.put("test3", 3);
			test.put("test4", 4);
			model.addAllAttributes(test);
			if(model.containsAttribute("test1")) {
				System.out.println("확인합니다. 테스트를 ! test1이 있습니다.");
			}
			return "mapTest";
		}
}

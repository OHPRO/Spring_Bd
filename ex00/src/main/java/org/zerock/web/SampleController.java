package org.zerock.web;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	//로깅은 로거로 다할것이다.
	
	@RequestMapping("doA")
	public void doA() {
		logger.info("doA Called....부른다으아");
	}
	
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB Called....부른다으아");
	}
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC Called....부른다으아");
		return "result";
	} 
	
	
	@RequestMapping("doD") // 알트+시피트+O 하면 자동으로 import된다.
	public String doD(Model model) {
		
		// domain/ProductVO에 있는 첫번쨰 public ProductVO(String name, double price)
		// 를 생성하는 것이다. (String name은 Sample Product로, double price는 10000원으로)
		// 또한 ProductVO는 따로 설정하지 않으면 앞글자가 소문자로 바뀌게 된다. 그래서 view에 product에 객체로 갖고온다.
		ProductVO product = new ProductVO("Sample Product", 10000);
		logger.info("doD Called....부른다으아"); //문장전체를 위치를 바꾸는 것은 "알트키+화살표 위,아래로"하면 바뀐다.
		model.addAttribute(product); 
		return "productDetail";
	}
	
	@RequestMapping("/doJSON") //JSON처리하려면 그냥 암기하듯이 @ResponseBody하면 끝난다
	public @ResponseBody ProductVO doJSON() { //파라미터는 없고 ProductVO를 JSON형태로 반환하게 된다
		ProductVO vo = new ProductVO("샘플상품", 30000);
		return vo;
	}
	
	
	@RequestMapping("doE")  // RedireactAttributes : redirect하는 경우 리아렉트어트리뷰트를 파라미터를 사용하는 경우는 임시로 값을 넣어서 보낼수 있습니다. 5버전만가능(스프링)
	public String doE(RedirectAttributes rttr) {
		ProductVO product = new ProductVO("Sample Product", 10000);
		logger.info("doE Called....");
		rttr.addFlashAttribute("msg", "This is the message!! with redireacted");
		return "redirect://doC"; //이렇게 리턴하면 위에 있는 doC로 보내지고 그곳의 return 값인 "result"로 해서 views로 들어가게 된다. 
		                         // 따라서 localhost:8080/web/doC를 브라우저에 적으면 위에 "msg", "This is the message!! with redirected"가 뜬다.
	
	} //위에 있는 Rediract가 잘모로겠다면 여서는 JSP로 보여주겠음 (JSP) 위에랑 같은 것이다.
	@RequestMapping("doY")
	public void doY(HttpServletResponse res) throws Exception {  //앞글자 조금 적고 컨트롤+스페이스 누르면 옆에 목록창이 뜨는 것에서 지정해줌
		logger.info("doY Called....부른다으아");
		res.sendRedirect("doC?msg=this is the Massage!! with redirected by doY"); // 여기에 String이 들어오는 것임 //스프링에서는 rttr.addFlashAttribute이 있다. 
			//http://localhost:8086/web/doC?msg=redirect 를 할경우 메세지가 msg와 redirect가 찍혀서 hello reirect가 찍힌다.
		    
 	} 
	
	
	@RequestMapping("doZ")  // RequestParam으로 받을수도 있다. 위에 ModelAtribute말고
	public String doZ(@RequestParam String msg, ModelMap model) {
		logger.info("doZ Called...." +msg);
		model.addAttribute("msg", "z"+ msg); // "msg"(이름다음), "z"+msg (객체를 넣어줌)
		return "result";
	}
}

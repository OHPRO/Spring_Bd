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
	//�α��� �ΰŷ� ���Ұ��̴�.
	
	@RequestMapping("doA")
	public void doA() {
		logger.info("doA Called....�θ�������");
	}
	
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB Called....�θ�������");
	}
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC Called....�θ�������");
		return "result";
	} 
	
	
	@RequestMapping("doD") // ��Ʈ+����Ʈ+O �ϸ� �ڵ����� import�ȴ�.
	public String doD(Model model) {
		
		// domain/ProductVO�� �ִ� ù���� public ProductVO(String name, double price)
		// �� �����ϴ� ���̴�. (String name�� Sample Product��, double price�� 10000������)
		// ���� ProductVO�� ���� �������� ������ �ձ��ڰ� �ҹ��ڷ� �ٲ�� �ȴ�. �׷��� view�� product�� ��ü�� ����´�.
		ProductVO product = new ProductVO("Sample Product", 10000);
		logger.info("doD Called....�θ�������"); //������ü�� ��ġ�� �ٲٴ� ���� "��ƮŰ+ȭ��ǥ ��,�Ʒ���"�ϸ� �ٲ��.
		model.addAttribute(product); 
		return "productDetail";
	}
	
	@RequestMapping("/doJSON") //JSONó���Ϸ��� �׳� �ϱ��ϵ��� @ResponseBody�ϸ� ������
	public @ResponseBody ProductVO doJSON() { //�Ķ���ʹ� ���� ProductVO�� JSON���·� ��ȯ�ϰ� �ȴ�
		ProductVO vo = new ProductVO("���û�ǰ", 30000);
		return vo;
	}
	
	
	@RequestMapping("doE")  // RedireactAttributes : redirect�ϴ� ��� ���Ʒ�Ʈ��Ʈ����Ʈ�� �Ķ���͸� ����ϴ� ���� �ӽ÷� ���� �־ ������ �ֽ��ϴ�. 5����������(������)
	public String doE(RedirectAttributes rttr) {
		ProductVO product = new ProductVO("Sample Product", 10000);
		logger.info("doE Called....");
		rttr.addFlashAttribute("msg", "This is the message!! with redireacted");
		return "redirect://doC"; //�̷��� �����ϸ� ���� �ִ� doC�� �������� �װ��� return ���� "result"�� �ؼ� views�� ���� �ȴ�. 
		                         // ���� localhost:8080/web/doC�� �������� ������ ���� "msg", "This is the message!! with redirected"�� ���.
	
	} //���� �ִ� Rediract�� �߸�ΰڴٸ� ������ JSP�� �����ְ��� (JSP) ������ ���� ���̴�.
	@RequestMapping("doY")
	public void doY(HttpServletResponse res) throws Exception {  //�ձ��� ���� ���� ��Ʈ��+�����̽� ������ ���� ���â�� �ߴ� �Ϳ��� ��������
		logger.info("doY Called....�θ�������");
		res.sendRedirect("doC?msg=this is the Massage!! with redirected by doY"); // ���⿡ String�� ������ ���� //������������ rttr.addFlashAttribute�� �ִ�. 
			//http://localhost:8086/web/doC?msg=redirect �� �Ұ�� �޼����� msg�� redirect�� ������ hello reirect�� ������.
		    
 	} 
	
	
	@RequestMapping("doZ")  // RequestParam���� �������� �ִ�. ���� ModelAtribute����
	public String doZ(@RequestParam String msg, ModelMap model) {
		logger.info("doZ Called...." +msg);
		model.addAttribute("msg", "z"+ msg); // "msg"(�̸�����), "z"+msg (��ü�� �־���)
		return "result";
	}
}

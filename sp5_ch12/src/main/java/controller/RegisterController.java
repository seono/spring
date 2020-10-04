package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	
	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}
	
	
	@PostMapping("/register/step2")
	public String handleStep2(@RequestParam(value = "agree", defaultValue="false") Boolean agree, Model model) {
		if(!agree) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}
	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}
//	@PostMapping("/register/step2")
//	public String handleStep2(HttpServletRequest request) {
//		String agreeParam = request.getParameter("agree");
//		if(agreeParam == null || !agreeParam.equals("true")) {
//			return "register/step1";
//		}
//		return "register/step2";
//	}
	
//	@PostMapping("/register/step3")
//	public String handleStep3(HttpServletRequest request) {
//		String email = request.getParameter("email");
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		String confirmPassword = request.getParameter("confirmPassword");
//	
//		RegisterRequest reqReq = new ReigsterRequest();
//		reqReq.setEmail(email);
//		reqReq.setName(name);
//		....
//	}
	
	@PostMapping("/register/step3")
	public String handleStep3(@Valid RegisterRequest reqReq, Errors errors) {
		if(errors.hasErrors())
			return "register/step2";
		try {
			memberRegisterService.regist(reqReq);
			return "register/step3";
		} catch(DuplicateMemberException ex) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
	
}

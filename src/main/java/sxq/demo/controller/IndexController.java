package sxq.demo.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sxq.demo.manager.UserManager;
import sxq.demo.model.User;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Resource
	UserManager userManager;
	
	@RequestMapping("index")
	public String index(HttpServletRequest request){
		try{
		User user = new User();
		user.setId(123);
		user.setName("xueqiang"+new Date());
		this.userManager.save(user);
		request.setAttribute("list", this.userManager.qeuryUserList());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "index";
		
	}
}

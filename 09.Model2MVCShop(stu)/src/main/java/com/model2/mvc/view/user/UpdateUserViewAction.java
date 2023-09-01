package com.model2.mvc.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;
import com.model2.mvc.service.domain.User;


public class UpdateUserViewAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
																	new String[] {	"/config/commonservice.xml"	 }
									                                   );
		System.out.println("\n");

		//==> Bean/IoC Container �� ���� ȹ���� UserService �ν��Ͻ� ȹ��
		UserService userService = (UserService)context.getBean("userServiceImpl");
		
		String userId=request.getParameter("userId");
		
//		UserService service=new UserServiceImpl();
		User user=userService.getUser(userId);
		
		request.setAttribute("user", user);
		
		return "forward:/user/updateUser.jsp";
	}
}

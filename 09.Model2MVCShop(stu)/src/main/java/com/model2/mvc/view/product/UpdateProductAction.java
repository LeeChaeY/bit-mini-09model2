package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;

public class UpdateProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
																	new String[] {	"/config/commonservice.xml"	 }
									                                   );
		System.out.println("\n");

//		==> Bean/IoC Container �� ���� ȹ���� UserService �ν��Ͻ� ȹ��
		ProductService productService = (ProductService)context.getBean("productServiceImpl");
		
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		String menu = "search";
		
		Product Product = new Product();
		Product.setProdNo(prodNo);
		Product.setProdName(request.getParameter("prodName"));
		Product.setProdDetail(request.getParameter("prodDetail"));
		Product.setManuDate(request.getParameter("manuDate").replace("-", ""));
		Product.setPrice(Integer.parseInt(request.getParameter("price")));
		Product.setFileName(request.getParameter("fileName"));
		
		System.out.println("UpdateProductAction : product : "+Product);
		
//		ProductService service = new ProductServiceImpl();
		productService.updateProduct(Product);
		
		return "redirect:/getProduct.do?prodNo="+prodNo+"&menu="+menu;
	}
}

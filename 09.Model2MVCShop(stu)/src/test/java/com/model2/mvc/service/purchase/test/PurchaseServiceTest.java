package com.model2.mvc.service.purchase.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;


/*
 *	FileName :  UserServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:config/context-*.xml" })
@ContextConfiguration	(locations = {	"classpath:config/context-common.xml",
																	"classpath:config/context-aspect.xml",
																	"classpath:config/context-mybatis.xml",
																	"classpath:config/context-transaction.xml" })
public class PurchaseServiceTest {

	//==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;

//	@Test
	public void testAddPurchase() throws Exception {

		Purchase purchase = new Purchase();
		purchase.setBuyer(new User("testUserId"));
		purchase.setPurchaseProd(new Product(10012));
		purchase.setPaymentOption("0");
		purchase.setReceiverName("testReceiverName");
		purchase.setReceiverPhone("010-1111-2222");
		purchase.setDivyAddr("testDivyAddr");
		purchase.setDivyRequest("testDivyRequest");
		purchase.setDivyDate("2023-07-07");

		purchaseService.addPurchase(purchase);

		purchase = purchaseService.getPurchase(10013);

		//==> console Ȯ��
		System.out.println(purchase);

		//==> API Ȯ��
		Assert.assertEquals("testUserId", purchase.getBuyer().getUserId());
		Assert.assertEquals(10012, purchase.getPurchaseProd().getProdNo());
		Assert.assertEquals("0", purchase.getPaymentOption());
		Assert.assertEquals("testReceiverName", purchase.getReceiverName());
		Assert.assertEquals("010-1111-2222", purchase.getReceiverPhone());
		Assert.assertEquals("testDivyAddr", purchase.getDivyAddr());
		Assert.assertEquals("testDivyRequest", purchase.getDivyRequest());
		Assert.assertEquals('2', purchase.getTranCode());
		Assert.assertEquals("2023-07-07 00:00:00.0", purchase.getDivyDate());

		//		Assert.assertEquals(1, userService.removeUser(user.getUserId()));
	}

//	@Test
	public void testGetPurchase() throws Exception {

		Purchase purchase = new Purchase();

		purchase = purchaseService.getPurchase(10013);
		
		//==> console Ȯ��
		System.out.println(purchase);

		//==> API Ȯ��
		Assert.assertEquals("testUserId", purchase.getBuyer().getUserId());
		Assert.assertEquals(10012, purchase.getPurchaseProd().getProdNo());
		Assert.assertEquals("0", purchase.getPaymentOption());
		Assert.assertEquals("testReceiverName", purchase.getReceiverName());
		Assert.assertEquals("010-1111-2222", purchase.getReceiverPhone());
		Assert.assertEquals("testDivyAddr", purchase.getDivyAddr());
		Assert.assertEquals("testDivyRequest", purchase.getDivyRequest());
		Assert.assertEquals("2", purchase.getTranCode());
		Assert.assertEquals("2023-07-07", purchase.getDivyDate());
	}

//	@Test
	public void testUpdateUser() throws Exception{

		Purchase purchase = purchaseService.getPurchase(10013);
		Assert.assertNotNull(purchase);

//		Assert.assertEquals("testUserId", purchase.getBuyer().getUserId());
//		Assert.assertEquals(10010, purchase.getPurchaseProd().getProdNo());
//		Assert.assertEquals("0", purchase.getPaymentOption());
//		Assert.assertEquals("testReceiverName", purchase.getReceiverName());
//		Assert.assertEquals("010-1111-2222", purchase.getReceiverPhone());
//		Assert.assertEquals("testDivyAddr", purchase.getDivyAddr());
//		Assert.assertEquals("testDivyRequest", purchase.getDivyRequest());
//		Assert.assertEquals("2", purchase.getTranCode());
//		Assert.assertEquals("2023-08-24", purchase.getDivyDate());

		purchase.setPaymentOption("1");
		purchase.setReceiverName("changeReceiverName");
		purchase.setReceiverPhone("010-8888-9999");
		purchase.setDivyAddr("changeDivyAddr");
		purchase.setDivyRequest("changeDivyRequest");
		purchase.setDivyDate("2023-07-07");

		purchaseService.updatePurchase(purchase);

		purchase = purchaseService.getPurchase(10013);
		Assert.assertNotNull(purchase);

		//==> console Ȯ��
		System.out.println(purchase);

		//==> API Ȯ��
		Assert.assertEquals("testUserId", purchase.getBuyer().getUserId());
		Assert.assertEquals(10012, purchase.getPurchaseProd().getProdNo());
		Assert.assertEquals("1", purchase.getPaymentOption());
		Assert.assertEquals("changeReceiverName", purchase.getReceiverName());
		Assert.assertEquals("010-8888-9999", purchase.getReceiverPhone());
		Assert.assertEquals("changeDivyAddr", purchase.getDivyAddr());
		Assert.assertEquals("changeDivyRequest", purchase.getDivyRequest());
		Assert.assertEquals("2", purchase.getTranCode());
		Assert.assertEquals("2023-08-24", purchase.getDivyDate());
	}

	//==>  �ּ��� Ǯ�� �����ϸ�....
//	@Test
	public void testGetPurchaseListAll() throws Exception{
		String userId = "testUserId";

		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		Map<String,Object> map = purchaseService.getPurchaseList(search, userId);

		List<Object> list = (List<Object>)map.get("list");
		Assert.assertEquals(1, list.size());

		//==> console Ȯ��
		//System.out.println(list);

		Integer totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);

		System.out.println("=======================================");

		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchKeyword("");
		map = purchaseService.getPurchaseList(search, userId);

		list = (List<Object>)map.get("list");
		Assert.assertEquals(1, list.size());

		//==> console Ȯ��
		//System.out.println(list);

		totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);
	}

//	@Test
	public void testGetPurchaseListByDate() throws Exception{
		String userId = "testUserId";

		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("1");
		search.setSearchKeyword("2023-08-01,2023-08-30");
		Map<String,Object> map = purchaseService.getPurchaseList(search, userId);

		List<Object> list = (List<Object>)map.get("list");
		Assert.assertEquals(1, list.size());

		//==> console Ȯ��
		//System.out.println(list);

		Integer totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);

		System.out.println("=======================================");

		search.setSearchCondition("1");
		search.setSearchKeyword("2023-08-01,2023-08-02");
		map = purchaseService.getPurchaseList(search, userId);

		list = (List<Object>)map.get("list");
		Assert.assertEquals(0, list.size());

		//==> console Ȯ��
		//System.out.println(list);

		totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);
	}

//	@Test
	public void testGetPurchaseListBySysdate() throws Exception{
		String userId = "testUserId";

		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("2");
		search.setSearchKeyword("2023-08-01,SYSDATE");
		Map<String,Object> map = purchaseService.getPurchaseList(search, userId);

		List<Object> list = (List<Object>)map.get("list");
		Assert.assertEquals(1, list.size());

		//==> console Ȯ��
		System.out.println(list);

		Integer totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);

		System.out.println("=======================================");

		search.setSearchCondition("2");
		search.setSearchKeyword("2023-08-01,2023-08-02");
		map = purchaseService.getPurchaseList(search, userId);

		list = (List<Object>)map.get("list");
		Assert.assertEquals(0, list.size());

		//==> console Ȯ��
		System.out.println(list);

		totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);
	}	 

//	@Test
	public void testUpdateTranCode() throws Exception{
		Purchase purchase = new Purchase();
		purchase.setTranNo(10013);
		purchase.setTranCode("2");
		purchase.setPurchaseProd(new Product(10012));
		
		purchaseService.updateTranCode(purchase);

		purchase = purchaseService.getPurchase(10013);
		Assert.assertNotNull(purchase);

		//==> console Ȯ��
		System.out.println(purchase);

		//==> API Ȯ��
		Assert.assertEquals("3", purchase.getTranCode());

	}
	
//	@Test
	public void testUpdateTranCodeByProd() throws Exception{
		Purchase purchase = new Purchase();
		purchase.setTranNo(10013);
		purchase.setTranCode("3");
		purchase.setPurchaseProd(new Product(10012));
		
		purchaseService.updateTranCode(purchase);

		purchase = purchaseService.getPurchase(10013);
		Assert.assertNotNull(purchase);

		//==> console Ȯ��
		System.out.println(purchase);

		//==> API Ȯ��
		Assert.assertEquals("4", purchase.getTranCode());

	}
}
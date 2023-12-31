<%@ page contentType="text/html; charset=EUC-KR"%>

<html>
<head>
<title>상품 구매 조회</title>

<!-- CDN(Content Delivery Network) 호스트 사용 -->
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>

<script type="text/javascript">
$(function() {
	
	$( "td.ct_btn01:contains('확인')" ).on("click" , function() {
		 	self.location = "/product/listProduct?menu=manage";
	});
	 
	$( "td.ct_btn01:contains('추가등록')" ).on("click" , function() {
		 self.location = "/product/addProduct";
	});
	 
});
</script>

</head>

<body>

<!-- ////////////////// jQuery Event 처리로 변경됨 ///////////////////////// 
<form name="updatePurchase" action="/purchase/updatePurchase" method="post">
////////////////////////////////////////////////////////////////////////////////////////////////// -->
<form>

	다음과 같이 구매가 되었습니다.
	
	<table border=1>
		<tr>
			<td>물품번호</td>
			<td>${ purchase.purchaseProd.prodNo }</td>
			<td></td>
		</tr>
		<tr>
			<td>구매자아이디</td>
			<td>${ purchase.buyer.userId }</td>
			<td></td>
		</tr>
		<tr>
			<td>구매방법</td>
			<td>${ purchase.paymentOption }</td>
			<td></td>
		</tr>
		<tr>
			<td>구매자이름</td>
			<td>${ purchase.receiverName }</td>
			<td></td>
		</tr>
		<tr>
			<td>구매자연락처</td>
			<td>${ purchase.receiverPhone }</td>
			<td></td>
		</tr>
		<tr>
			<td>구매자주소</td>
			<td>${ purchase.divyAddr }</td>
			<td></td>
		</tr>
			<tr>
			<td>구매요청사항</td>
			<td>${ purchase.divyRequest }</td>
			<td></td>
		</tr>
		<tr>
			<td>배송희망일자</td>
			<td>${ purchase.divyDate }</td>
			<td></td>
		</tr>
	</table>
</form>

</body>
</html>
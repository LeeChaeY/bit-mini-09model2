<%@ page contentType="text/html; charset=EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link rel="stylesheet" href="/css/admin.css" type="text/css">

<title>구매정보수정</title>

<!-- CDN(Content Delivery Network) 호스트 사용 -->
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script  src="../javascript/calendar.js"></script>

<script type="text/javascript">

function fncUpdatePurchase() {
	$("form").attr("method" , "POST").attr("action" , "/purchase/updatePurchase").submit();
}

$(function() {
	$( "td.ct_btn01:contains('수정')" ).on("click" , function() {
		fncUpdatePurchase();
	});

	function resetData(){
		javascript:history.go(-1);
	}

	$( "td.ct_btn01:contains('취소')" ).on("click" , function() {
		resetData();
	});

	$( "img[src='../images/ct_icon_date.gif']" ).on("click" , function() {
		show_calendar('document.forms[0].divyDate', $("td[name=divyDate]").val());
	});
});
</script>

</head>

<body bgcolor="#ffffff" text="#000000">
<!-- ////////////////// jQuery Event 처리로 변경됨 ///////////////////////// 
<form name="updatePurchase" method="post"	action="/purchase/updatePurchase">
////////////////////////////////////////////////////////////////////////////////////////////////// -->
<form>

<table width="100%" height="37" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif"  width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left: 10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">구매정보수정</td>
					<td width="20%" align="right">&nbsp;</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>

<table width="600" border="0" cellspacing="0" cellpadding="0"	align="center" style="margin-top: 13px;">
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		<input type="hidden" name="tranNo" value="${ purchase.tranNo }">
	</tr>
	<tr>
		<td width="104" class="ct_write">구매자아이디</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">${ purchase.buyer.userId }</td>
		<input type="hidden" name="buyer.userId" value="${ purchase.buyer.userId }">
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">구매방법</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<select 	name="paymentOption" 	class="ct_input_g" style="width: 100px; height: 19px" 
							maxLength="20" value="${ purchase.paymentOption }">
				<option value="1" selected="selected">현금구매</option>
				<option value="2">신용구매</option>
			</select>
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">구매자이름</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<input 	type="text" name="receiverName" class="ct_input_g" style="width: 100px; height: 19px" 
							maxLength="20" value="${ purchase.receiverName }" />
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">구매자 연락처</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<input 	type="text" name="receiverPhone" class="ct_input_g" style="width: 100px; height: 19px" 
							maxLength="20" value="${ purchase.receiverPhone }" />
		</td>
	</tr>

	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">구매자주소</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<input 	type="text" name=divyAddr class="ct_input_g" style="width: 100px; height: 19px" 
							maxLength="20" value="${ purchase.divyAddr }" />
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">구매요청사항</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<input 	type="text" name="divyRequest" 	class="ct_input_g" style="width: 100px; height: 19px" 
							maxLength="20" value="${ purchase.divyRequest }" />
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">배송희망일자</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td width="200" class="ct_write01">
				<input type="text" readonly="readonly" name="divyDate" class="ct_input_g" 
								style="width: 100px; height: 19px" maxLength="20" value="${ !empty purchase.divyDate ? purchase.divyDate : '' }"/>
				<!-- ////////////////// jQuery Event 처리로 변경됨 ///////////////////////// 
				<img 	src="../images/ct_icon_date.gif" width="15" height="15"	
							onclick="show_calendar('document.updatePurchase.divyDate', document.updatePurchase.divyDate.value)"/>
				////////////////////////////////////////////////////////////////////////////////////////////////// -->
				&nbsp;<img src="../images/ct_icon_date.gif" width="15" height="15" />
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
	<tr>
		<td width="53%"></td>
		<td align="right">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="17" height="23">
					<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
				</td>
				<td background="/images/ct_btnbg02.gif" class="ct_btn01"	style="padding-top: 3px;">
					<!-- ////////////////// jQuery Event 처리로 변경됨 ///////////////////////// 
					<input type="submit" value="수정"/>
					////////////////////////////////////////////////////////////////////////////////////////////////// -->
					수정
				</td>
				<td width="14" height="23">
					<img src="/images/ct_btnbg03.gif" width="14" height="23"/>
				</td>
				<td width="30"></td>
				<td width="17" height="23">
					<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
				</td>
				<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top: 3px;">
					<!-- ////////////////// jQuery Event 처리로 변경됨 ///////////////////////// 
					<a href="javascript:history.go(-1)">취소</a>
					////////////////////////////////////////////////////////////////////////////////////////////////// -->
					취소
				</td>
				<td width="14" height="23">
					<img src="/images/ct_btnbg03.gif" width="14" height="23"/>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>

</body>
</html>
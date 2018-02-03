<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script> 

<html>
<html>
<body>
		<h2><spring:message code="lbl.ResultsPage" text="we have found these cars" /></h2>
<table>
	<tr>
		<th><spring:message code="lbl.Model" text="Model" /></th>
		<th><spring:message code="lbl.Price" text="Price" /></th>
	</tr>
	<c:forEach var="car" items="${cheapestCars}">
		<tr>
            <td>${car.model}</td>  
            <td><fmt:formatNumber value="${car.price}" type="currency" currencySymbol=""/></td>  
		</tr>
	</c:forEach>
</table>	
</body>
</html>
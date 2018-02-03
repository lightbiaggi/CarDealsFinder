<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<!-- <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script> -->
<link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css") %>'>
<link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap-theme.min.css") %>'>
<script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>'></script>
<script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js") %>'></script>

<html>
<head>
	<title>Car Rental</title>
	<style>
	.error 
	{
		color: #ff0000;
		font-weight: bold;
	}
	</style>
	 <script type="text/javascript">
	$(document).ready(function() {
 $(function() {
$("#datepicker").datepicker({dateFormat: 'mm/dd/yy'});
}); 
});
	</script>
</head>

<body>
	<h2><spring:message code="lbl.page" text="Search Car" /></h2>
	<br/>
	<form:form method="post" modelAttribute="carSearch">
		<%-- <form:errors path="*" cssClass="error" /> --%>
		<table>
			<tr>
			 <td><spring:message text="Select Date:" /></td>
			<td><form:input type="date" name="selectedDate" id="datepicker" path="selectedDate"/></td>
			</tr>
			<tr>
				<td><spring:message code="lbl.department" text="location" /></td>
				<td><form:select path="location" items="${allLocations}" itemValue="id" itemLabel="name" /></td>
				<td><form:errors path="location" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Find Best Deal"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
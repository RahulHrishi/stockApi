
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Bodmas Eval</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>

<body>
<c:url var="actionUrl" value="/" />
	<div class="container my-5">
		<h3>Add Exp String</h3>
		<div class="card">
			<div class="card-body">
				<div class="col-md-10">
					<form:form action="${actionUrl}"  modelAttribute="emp" method="POST"
						acceptCharset="UTF-8">

						<form:hidden path="userName" placeholder="Enter your Name"  />
						<form:errors path="userName" />

						<form:input path="expString"  placeholder="Enter Expression String" />
						<form:errors path="expString" />


						<form:hidden path="output"  />

						<form:button id="add" class="btn btn-default">Add</form:button>

						<table border="2" width="70%" cellpadding="2">
							<tr>
								<th>Exp Input</th>
								<th>Value</th>
							</tr>
							<c:forEach var="emp" items="${list}">
								<tr>
									<%-- <td>${emp.userName}</td> --%>
									<td>${emp.expString}</td>
									<td>${emp.output}</td>
								</tr>
							</c:forEach>
							
						</table>
						</form:form>
						<form:form action="/calculate"  modelAttribute="emp" method="GET" acceptCharset="UTF-8">
							<form:button id="calculate" class="btn btn-default">Calculate</form:button>
					</form:form>
				<%-- 	<form:form action="/calculate2"  modelAttribute="emp" method="GET" acceptCharset="UTF-8">
							<form:button id="calculate2" class="btn btn-default">Calculate by Method 2</form:button>
					</form:form> --%>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
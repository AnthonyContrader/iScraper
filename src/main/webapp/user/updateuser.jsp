<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/navbar.jsp"%>
	<br>
	<div class="main">

		<%UserDTO u = (UserDTO) request.getAttribute("dto");%>


		<form id="floatleft"
			action="UserServlet?mode=update&id=<%=u.getId()%>" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Username</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="username"
						value=<%=u.getUsername()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Password</label>
				</div>
				<div class="col-75">
					<input type="text" id="pass" name="password"
						value=<%=u.getPassword()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Usertype</label>
				</div>
				<div class="col-75">
					<select id="type" name="usertype">
						<option value="ADMIN" <%if(u.getUsertype().equals("ADMIN")) {%>
							selected <%}%>>ADMIN</option>
						<option value="USER" <%if(u.getUsertype().equals("USER")) {%>
							selected <%}%>>USER</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="given_name" name="name"
						value=<%=u.getName()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Email</label>
				</div>
				<div class="col-75">
					<input type="text" id="mail" name="email"
						value=<%=u.getEmail()%>>
				</div>
			</div>
			<button type="submit">Edit</button>
		</form>


	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>
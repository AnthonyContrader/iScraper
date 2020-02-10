<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<link href="css/1.css" rel="stylesheet">

<title>Login SAMPLE</title>
</head>
<body id="new">
<div class="container4">
		<img src="css/question.png" alt="Avatar" class="image1">

		<div class="overlay1">

			<h3> Link "Info"</h3>
		</div>
	</div>

	<div class="container3">
		<img src="css/fb.png" alt="Avatar" class="image1">

		<div class="overlay3">

			<h3> Facebook api</h3>
		</div>
	</div>
	<div class="container2">
		<img src="css/adduser.png" alt="Avatar" class="image">

		<div class="overlay">


			<form class="login1" action="UserServlet?mode=insertuser"
				method="post">
				<p>${messaggioCreazione}</p>
				<div class="row">
					<div class="col-25">
						<label for="user">Username</label>
					</div>
					<div class="col-75">
						<input type="text" id="user" name="register_username"
							placeholder="inserisci username" value="">
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="pass">Password</label>
					</div>
					<div class="col-75">
						<input type="text" id="pass" name="register_password"
							placeholder="inserisci password" value="">
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="pass">Name</label>
					</div>
					<div class="col-75">
						<input type="text" id="given_name" name="name"
							placeholder="inserisci il tuo nome" value="">
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="pass">E-mail</label>
					</div>
					<div class="col-75">
						<input type="text" id="mail" name="email"
							placeholder="inserisci la tua e-mail" value="">
					</div>
				</div>
				<div class="row">
					<div class="col-75"></div>
				</div>
				<button type="submit">Insert</button>
			</form>
		</div>
	</div>
	<div class="container">
		<img src="css/login1.png" alt="Avatar" class="image">
		<div class="overlay">
			<form class="login" action="LoginServlet" method="post">
				<p>${messaggio}</p>
				<label for="user">Username: </label>
				<input type="text" id="user"
					name="username" placeholder="Insert username">
				<label for="pass">Password: </label>
				<input type="password" id="pass"
					name="password" placeholder="Insert password">
				<button type="submit" value="Login" name="pulsante">Login</button>
			</form>
		</div>
	</div>
	<script></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<link href="/css/1.css" rel="stylesheet">

<title>Iscraper Login</title>
</head>
<body id="new">
	<div class="container4">
		<img src="/css/question.png" alt="Avatar" class="image1">

		<div class="overlay1">

			<h3>Link "Info"</h3>
		</div>
	</div>

	<div class="container3">
		<img src="/css/fb.png" alt="Avatar" class="image1">

		<div class="overlay3">

			<h3>Facebook api</h3>
		</div>
	</div>
	<div class="container2">
		<img src="/css/adduser.png" alt="Avatar" class="image">

		<div class="overlay">


			<form id="login1" style="position: inherit;heigth: 50%;width: 55%;margin-left: 17.6%;margin-right: 64.4%;margin-top: 7%;margin-bottom: auto;z-index: 1;" action="/user/insertuser" method="post">
		<div class="row">
			<div class="col-25">
				<label for="user">Username</label>
			</div>
			<div class="col-75">
				<input type="text" id="user" name="username"
					placeholder="inserisci username">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="pass">Password</label>
			</div>
			<div class="col-75">
				<input type="text" id="pass" name="password"
					placeholder="inserisci password">
			</div>
		</div>
			<div class="row">
			<div class="col-25">
				<label for="pass">Name</label>
			</div>
			<div class="col-75">
				<input type="text" id="name" name="name"
					placeholder="inserisci nome">
			</div>
		</div>
			<div class="row">
			<div class="col-25">
				<label for="pass">Email</label>
			</div>
			<div class="col-75">
				<input type="text" id="email" name="email"
					placeholder="inserisci email">
			</div>
			</div>
		
					
					

				
		
		
		<button id="type" name="usertype" value="USER" type="submit">Insert</button>
	</form>

		</div>
	</div>
	<div class="container">
		<img src="/css/login1.png" alt="Avatar" class="image">
		<div class="overlay">
			<form class="login" action="/user/login" method="post">

				<h3 style="text-align: center;">Modulo di login</h3>
				<p>${messaggio}</p>
				<label for="user">Username: </label> <input type="text" id="user"
					name="username" placeholder="Insert username"> <label
					for="pass">Password: </label> <input type="password" id="pass"
					name="password" placeholder="Insert password">
				<button type="submit" value="Login" name="pulsante">Login</button>
			</form>
		</div>
	</div>



	<script></script>
</body>
</html>
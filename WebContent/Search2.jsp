  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
	<head>
		<title>Web_Project</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="css/main.css" />
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<h1>Eventually</h1>
				<p>Let us beat the Google！！！</a></p>
			</header>


		<!-- Signup Form -->
			<form  method='get' action='${requestUri}' id="signup-forms">
				<div>
					<select name='type'>
					    <option value="Sports">Sports</option>
					    <option value="Politics">Politics</option>
				    </select>
				</div>
				
				<input type='text' name='keyword' id='keyword' placeholder='Keyword' />
				<input type='submit' value='Search' />
			</form>
		<!-- Footer -->
			<footer id="footer">
				<ul class="icons">
					<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
					<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
					<li><a href="#" class="icon brands fa-github"><span class="label">GitHub</span></a></li>
					<li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
				</ul>
				<ul class="copyright">
					<li>&copy; Untitled.</li><li>Credits: <a href="http://html5up.net">HTML5 UP</a></li>
				</ul>
			</footer>

		<!-- Scripts -->
			<script src="js/main.js"></script>

	</body>
</html>
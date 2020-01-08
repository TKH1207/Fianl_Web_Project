<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Web_Project_Result</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="css/main2.css" />
</head>
<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<h2>Eventually</h2>
			</header>

		<!-- Signup Form -->
			<form id="signup-forms" method="get" action='${requestUri}'>
				<div>
					<select name="type">
					    <option value="sports">Sports</option>
					    <option value="politics">Politics</option>
				    </select>
				</div>
				
				<input type="text" name="keyword" id="keyword" placeholder="Keyword" />
				<input type="submit" value="Search" />
			</form>
			
			
			
			<%
            String[][] orderList = (String[][])  
            request.getAttribute("q");
            for(int i =0 ; i < orderList.length;i++) {%>
	        <a href='<%= orderList[i][1] %>'><%= orderList[i][0] %></a><br>
	        <h style="font-size:5px ;"><%= orderList[i][1] %></h><br><br>
            <%
            }
            %>
            <% %>


		<!-- Scripts -->
			<script src="js/main.js"></script>

</body>
</html>
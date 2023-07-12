<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
<h2>it's created....</h2>

		<form action="saveLead" method= "post">
		<pre>
				First name <input type ="text" name="firstname"/>
				Last  name <input type ="text" name="lastname"/>
				Email Id   <input type ="text" name="email"/>
				Mobile     <input type ="text" name="mobile"/>
				
				<input type ="submit" value="save"/>
		</pre>
		
		</form>
		${msg}
		
</body>
</html>
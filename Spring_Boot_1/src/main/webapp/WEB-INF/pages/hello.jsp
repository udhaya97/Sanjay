<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>
<link href="/main.css" rel="stylesheet" type="text/css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Here</title>
</head>
<body>

      <form action="/save" method="post">
            <div class="container">
                  <div class="row">
                  <div class="col-sm-4"></div>
                  <div class="col-sm-4"></div>
                  <div class="col-sm-4"></div>
                  
                  </div>
            </div>

            <table>
                  <tr>
                        <td>UserName:</td>
                        <td><input type="text" name="userName"></td>

                  </tr>
                  <tr>
                        <td>City:</td>
                        <td><input type="text" name="city"></td>
                  </tr>
                  <tr>
                        <td>Phone Number:</td>
                        <td><input type="number" name="mobile"></td>
                  </tr>

                  
                  
            </table>
            
            <input type="submit" value="Submit">
      </form>
</body>
</html>

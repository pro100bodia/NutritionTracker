Valery Fatova, [17.05.19 20:25]
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>
<body>
<form action="servlet" method="POST">
    Name: <input name="username" />
    <br><br>
    Age: <input name="userage" />
    <br><br>
    Gender: <input type="radio" name="gender" value="female" checked />Female
    <input type="radio" name="gender" value="male" />Male
    <br><br>
    Country: <select name="country">
        <option>Canada</option>
        <option>Spain</option>
        <option>France</option>
        <option>Germany</option>
    </select>
    <br><br>
    Courses:
    <input type="checkbox" name="courses" value="JavaSE" checked />Java SE
    <input type="checkbox" name="courses" value="JavaFX" checked />Java FX
    <input type="checkbox" name="courses" value="JavaEE" checked />Java EE
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>

Valery Fatova, [17.05.19 20:28]
response.setContentType("text/html");
PrintWriter writer = response.getWriter();

String name = request.getParameter("username");
String age = request.getParameter("userage");
String gender = request.getParameter("gender");
String country = request.getParameter("country");
String[] courses = request.getParameterValues("courses");

try {
    writer.println("<p>Name: " + name + "</p>");
    writer.println("<p>Age: " + age + "</p>");
    writer.println("<p>Gender: " + gender + "</p>");
    writer.println("<p>Country: " + country + "</p>");
    writer.println("<h4>Courses</h4>");
    for(String course: courses)
        writer.println("<li>" + course + "</li>");
} finally {
    writer.close();
}
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>First page</title>
    </head>
    <body>
        Hello Library GOIT

        <c:forEach var="student" items="${students}">
            <p>${student}</p>
        </c:forEach>
    </body>
</html>
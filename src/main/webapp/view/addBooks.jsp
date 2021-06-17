<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>GOIT Library</title>
        <style><%@include file="/view/css/style.css"%></style>
    </head>
    <body>
<c:import url="/view/navibar.jsp"/>
        <form name="bookForm" method="post" action="/books">
            Author: <input type="text" name="author"/> <br/>
            Name: <input type="text" name="name"/> <br/>
            Pages: <input type="number" name="countPages"/> <br/>
            Publication Year: <input type="number" min="1900" max="2099" step="1" value="2016" name="publicationYear"/> <br/>
            Description: <input type="text" name="description"/> <br/>
            Genre: <select id="genre" name="genre">
                       <option value="ROMANCE">ROMANCE</option>
                       <option value="DETECTIVE">DETECTIVE</option>
                       <option value="FANTASY">FANTASY</option>
                       <option value="HISTORICAL">HISTORICAL</option>
                       <option value="HORROR">HORROR</option>
                       <option value="WOMEN_FICTION">WOMEN_FICTION</option>
                     </select>
            <input type="submit" value="Add Book" />
        </form>
    </body>
</html>
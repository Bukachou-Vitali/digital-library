<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Create New Book</title>
    </head>
    <body>
        <h3>Create New Book: </h3>

        <form action="<%=request.getContextPath() %>/book/create" method="post">
            <label>Name:</label>
            <input type="text" name="nameBook" value="" placeholder="enter Name"/> <br>

            <label>Author:</label>
            <input type="text" name="authorBook" value="" placeholder="enter Author"/> <br>

            <label>Year:</label>
            <input type="text" name="yearBook" value="" placeholder="enter Year"/> <br>

            <label>Description:</label>
            <input type="text" name="descriptionBook" value="" placeholder="enter Description"/> <br>

            <button type="submit">Save</button>
        </form>
        <form action="<%=request.getContextPath() %>/" method="get">
        <button type="submit">Cancel</button>
        </form>



    </body>
</html>
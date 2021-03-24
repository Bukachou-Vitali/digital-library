<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <body>
        <h2> Library </h2>

        <br/>
        <br/>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Author</th>
                <th>Year</th>
                <th>Description</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
            <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.year}</td>
                <td>${book.description}</td>
                <td>
                    <form action="<%=request.getContextPath() %>/book/delete" method="get">
                         <input type="hidden" name="deleteIdBook" value="${book.id}" placeholder="enter ID"/>
                         <button type="submit">Delete</button>
                    </form>
                </td>
                <td>
                    <form action="<%=request.getContextPath() %>/book/update" method="get">
                    <input type="hidden" name="updateIdBook" value="${book.id}" placeholder="enter ID"/>
                    <button type="submit">Update</button>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        <form action="<%=request.getContextPath() %>/book/create" method="get">
                    <button type="submit">Create New Book</button>
        </form>
    </body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Delete book</title>
    </head>
    <body>


        <table border="1">
             <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Author</th>
                  <th>Year</th>
             </tr>

             <tr>
                  <td>${idDelete}</td>
                  <td>${nameDelete}</td>
                  <td>${authorDelete}</td>
                  <td>${yearDelete}</td>
             </tr>
        </table>

        <h3>Why delete this masterpiece?:(</h3>
        <h3>:(</h3>
        <h3>OK</h3>
        <h3>Are you sure you want to delete this masterpiece? </h3>
        <br/>

        <form action="<%=request.getContextPath() %>/book/delete" method="post">
        <input type="hidden" name="deleteIdBook" value="${idDelete}" placeholder="enter ID"/>
        <button type="submit">Yes</button>
        </form>

        <form action="<%=request.getContextPath() %>/" method="get">
        <button type="submit">No</button>
        </form>



    </body>
</html>
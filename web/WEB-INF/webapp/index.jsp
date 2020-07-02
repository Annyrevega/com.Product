<%--
  Created by IntelliJ IDEA.
  User: anutarevega
  Date: 27.06.2020
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>

    <style type="text/css">
        body {
            text-align: center;
        }

        table {
            margin-left: 15%;
            min-width: 70%;
            border: 1px solid #CCC;
            border-collapse: collapse;
        }

        table tr {
            line-height: 30px;
        }

        table tr th {
            background: #000033;
            color: #FFF;
        }

        table tr td {
            border: 1px solid #CCC;
            margin: 5px;
        }

        input[type=text], input[type=email], input[type=tel] {
            min-width: 60%;
        }

        input[type=submit], a {
            background: green;
            padding: 5px;
            margin: 5px;
            color: #FFF;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>Servlet, JSP and JDBC CRUD Operations</h1>
<c:url value="/customer/register" var="registerUrl"/>
<form action="${'${'}registerUrl}" method="post">
    <table>
        <c:if test="${'${'}customer.product_id ne null}">
            <tr>
                <td>Product_id</td>
                <td><input type="text" name="product_id" value="${'${'}customer.product_id}" readonly="readonly"></td>
            </tr>
        </c:if>
        <tr>
            <td>Product_name:</td>
            <td><input type="text" name="product_name" value="${'${'}customer.product_name}" required></td>
        </tr>
        <tr>
            <td>price:</td>
            <td><input type="text" name="price" value="${'${'}customer.price}" required></td>
        </tr>
        <tr>
            <td>Shop_id:</td>
            <td><input type="text" name="shop_id" value="${'${'}customer.shop_id}" required></td>
        </tr>


        <c:if test="${'${'}customer.product_id ne null}">
            <tr>
                <td colspan="2"><input type="submit" value="Update"></td>
            </tr>
        </c:if>
        <c:if test="${'${'}customer.product_id eq null}">
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </c:if>
    </table>
</form>
<br>
<h1>List of Customers</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Shop Id</th>

        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${'${'}customerList}" var="customer">
        <tr>
            <td>${'${'}customer.product_id}</td>
            <td>${'${'}customer.product_name}</td>
            <td>${'${'}customer.price}</td>
            <td>${'${'}customer.shop_id}</td>


            <td>
                <form action="<c:url value="/customer/update"/>" method="post">
                    <input type="hidden" name="custId" value="${'${'}customer.product_id}">
                    <input type="submit" value="Update">
                </form>
            <td>
                <form action="<c:url value="/customer/delete"/>" method="post">
                    <input type="hidden" name="custId" value="${'${'}customer.product_id}">
                    <input style="background: #F00;" type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
<form method="post" action="setUser">
    Users: <select name="userId">
                <option value="100000" selected>User</option>
                <option value="100001">Admin</option>
            </select>
            <button type="submit">Select</button>
</form>
    <a href="users">users</a><br>
    Alcohol<br>
    <a href="alcohols">alcohol</a><br>
    <a href="alcohols/category/wine">wine</a><br>
    Cigarette<br>
    <a href="cigaretteCategoryFilter">cigarette Category Filter</a><br>
    <a href="cigaretteCategoryWithoutFilter">cigarette Category WithoutFilter</a><br>
    Product<br>
    <a href="productCategoryMilk">Product Category Milk</a><br>
    <a href="productCategoryMeat">Product Category Meat</a>

</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
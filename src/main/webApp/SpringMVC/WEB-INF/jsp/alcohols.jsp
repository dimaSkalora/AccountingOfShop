<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <h3>Alcohol title</h3>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th>Goods Receipt Date</th>
                <th>Category</th>
                <th>Product Name</th>
                <th>Liter</th>
                <th>Balance On The First Day Of The Month</th>
                <th>Received For Month</th>
                <th>Sold For Month</th>
                <th>Balance On The Last Day Of The Month</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <c:forEach items="${alcohols}" var="alcohol">
            <jsp:useBean id="alcohol" scope="page" type="com.shop.of.accounting.model.Alcohol"/>
            <tr>
                <td><c:out value="${alcohol.goodsReceiptDate}"/></td>
                <td><c:out value="${alcohol.category}"/></td>
                <td><c:out value="${alcohol.productName}"/></td>
                <td><c:out value="${alcohol.liter}"/></td>
                <td><c:out value="${alcohol.balanceOnTheFirstDayOfTheMonth}"/></td>
                <td><c:out value="${alcohol.receivedForMonth}"/></td>
                <td><c:out value="${alcohol.soldForMonth}"/></td>
                <td><c:out value="${alcohol.balanceOnTheLastDayOfTheMonth}"/></td>
                <td></td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
</section>

</body>
</html>
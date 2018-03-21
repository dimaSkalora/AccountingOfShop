<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <h3>Product Categor Meat</h3>
    <c:url var="addAction" value="/productCategoryMeat/saveMeat"/>

    <form:form action="${addAction}" commandName="product">
        <table>
            <C:if test="${!empty product.id}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id" readonly="true" size="8" disabled="true"/>
                        <form:hidden path="id"/>
                    </td>
                </tr>
            </C:if>
            <tr>
                <td>
                    <form:label path="goodsReceiptDate">
                        <spring:message text="goodsReceiptDate"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="goodsReceiptDate"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="category">
                        <spring:message text="category"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="category"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="productName">
                        <spring:message text="productName"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="productName"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="amount">
                        <spring:message text="amount"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="amount"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="balanceOnTheFirstDayOfTheMonth">
                        <spring:message text="balanceOnTheFirstDayOfTheMonth"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="balanceOnTheFirstDayOfTheMonth"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="receivedForMonth">
                        <spring:message text="receivedForMonth"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="receivedForMonth"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="soldForMonth">
                        <spring:message text="soldForMonth"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="soldForMonth"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="balanceOnTheLastDayOfTheMonth">
                        <spring:message text="balanceOnTheLastDayOfTheMonth"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="balanceOnTheLastDayOfTheMonth" disabled="true"/>
                    <form:hidden path="balanceOnTheLastDayOfTheMonth"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty product.id}">
                        <input type="submit"
                               value="<spring:message text="Update Product Meat"/> "/>
                    </c:if>
                    <c:if test="${empty product.id}">
                        <input type="submit"
                               value="<spring:message text="Add Product Meat"/> "/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>

    <br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <th>Goods Receipt Date</th>
            <th>Category</th>
            <th>Product Name</th>
            <th>Amount</th>
            <th>Balance On The First Day Of The Month</th>
            <th>Received For Month</th>
            <th>Sold For Month</th>
            <th>Balance On The Last Day Of The Month</th>
            <th></th>
            <th></th>
        </thead>
        <c:forEach items="${categoryMeat}" var="product">
            <jsp:useBean id="product" scope="page" type="com.shop.of.accounting.to.ProductWithBalanceNegative"/>
            <tr class="${product.balanceNegative ? 'reduced' : 'normal'}">
                <td><c:out value="${product.goodsReceiptDate}"/></td>
                <td><c:out value="${product.category}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.amount}"/></td>
                <td><c:out value="${product.balanceOnTheFirstDayOfTheMonth}"/></td>
                <td><c:out value="${product.receivedForMonth}"/></td>
                <td><c:out value="${product.soldForMonth}"/></td>
                <td><c:out value="${product.balanceOnTheLastDayOfTheMonth}"/></td>
                <td><a href="<c:url value="/productCategoryMeat/update?id=${product.id}"/>"/>update</td>
                <td><a href="<c:url value="/productCategoryMeat/delete?id=${product.id}"/>"/>delete</td>
            </tr>
        </c:forEach>
    </table>
</section>

</body>
</html>

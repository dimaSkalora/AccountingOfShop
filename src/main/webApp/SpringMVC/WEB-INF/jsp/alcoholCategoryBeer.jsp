<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
    <h3>Alcohol Category Beer</h3>
    <a href="/alcohols/create/beer">Create Beer</a>

    <c:url var="addAction" value="/alcoholCategoryBeer/saveBeer"/>

    <form:form action="${addAction}" commandName="alcohol">
        <table>
            <c:if test="${!empty alcohol.id}">
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
            </c:if>
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
                    <form:label path="liter">
                        <spring:message text="liter"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="liter"/>
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
                    <c:if test="${!empty alcohol.id}">
                        <input type="submit"
                               value="<spring:message text="Update Beer"/>"/>
                    </c:if>
                    <c:if test="${empty alcohol.id}">
                        <input type="submit"
                               value="<spring:message text="Add Beer"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
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
        </thead>
        <c:forEach items="${categoryBeer}" var="alcohol">
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
                <td><A href="/alcohols/update?id=${alcohol.id}"/>update</td>
                <td><A href="/alcohols/delete?id=${alcohol.id}"/>delete</td>
            </tr>
        </c:forEach>
    </table>
</section>

</body>
</html>

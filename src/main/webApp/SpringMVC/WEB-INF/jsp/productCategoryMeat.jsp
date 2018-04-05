<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript" src="resources/js/productValiation.js" defer></script>
<script type="text/javascript" src="resources/js/dialogUtil.js" defer></script>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <h3 class="text-center"><spring:message code="product.productCategoryMeat"/> </h3>
        <div class="row">
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <c:url var="addAction" value="/productCategoryMeat/saveMeat"/>
                        <form:form action="${addAction}"  name = "addProduct" onsubmit="return(validateProduct());" commandName="product" cssClass="form-horizontal">
                            <table class="table">
                                <tbody>
                                <c:if test="${!empty product.id}">
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
                                            <spring:message code="product.goodsReceiptDate"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="goodsReceiptDate"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="category">
                                            <spring:message code="product.category"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="category"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="productName">
                                            <spring:message code="product.productName"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="productName"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="amount">
                                            <spring:message code="product.amount"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="amount"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="balanceOnTheFirstDayOfTheMonth">
                                            <spring:message code="product.balanceOnTheFirstDayOfTheMonth"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="balanceOnTheFirstDayOfTheMonth"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="receivedForMonth">
                                            <spring:message code="product.receivedForMonth"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="receivedForMonth"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="soldForMonth">
                                            <spring:message code="product.soldForMonth"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="soldForMonth"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="balanceOnTheLastDayOfTheMonth">
                                            <spring:message code="product.balanceOnTheLastDayOfTheMonth"/>
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
                                            <input class="btn btn-primary" type="submit"
                                                   value="<spring:message code="product.editMeat"/>"/>
                                        </c:if>
                                        <c:if test="${empty product.id}">
                                            <input class="btn btn-primary" type="submit"
                                                   value="<spring:message code="product.addMeat"/>"/>
                                        </c:if>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form method="post" action="productCategoryMeat/filter">
                            <dl>
                                <dt><spring:message code="product.startDate"/></dt>
                                <dd><input type="date" name="startDate" value="${param.startDate}"></dd>
                            </dl>
                            <dl>
                                <dt><spring:message code="product.endDate"/></dt>
                                <dd><input type="date" name="endDate" value="${param.endDate}"></dd>
                            </dl>
                            <div class="text-right">
                                <a class="btn btn-danger" href="productCategoryMeat">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                </a>
                                <button class="btn btn-primary" type="submit">
                                    <span class="glyphicon glyphicon-filter" aria-hidden="true"></span>
                                </button>
                                <input type="hidden"
                                       name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form method="post" action="productCategoryMeat/searchByProductName" onclick="return (volidateSearchByProductName(this));" >
                            <dl>
                                <dt><spring:message code="product.filter"/></dt>
                                <dd><input type="text" name="searchByProductName" value="${param.searchByProductName}"></dd>
                                <dd>
                                    <button class="btn btn-primary" type="submit">
                                        <span class="glyphicon glyphicon-filter" aria-hidden="true"></span>
                                    </button>
                                </dd>
                                <input type="hidden"
                                       name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>
                            </dl>
                        </form>
                        <div class="text-right">
                            <a class="btn btn-danger"  href="productCategoryMeat">
                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <table class="table table-bordered">
                <thead>
                    <th><spring:message code="product.goodsReceiptDate"/></th>
                    <th><spring:message code="product.category"/></th>
                    <th><spring:message code="product.productName"/></th>
                    <th><spring:message code="product.amount"/></th>
                    <th><spring:message code="product.balanceOnTheFirstDayOfTheMonth"/></th>
                    <th><spring:message code="product.receivedForMonth"/></th>
                    <th><spring:message code="product.soldForMonth"/></th>
                    <th><spring:message code="product.balanceOnTheLastDayOfTheMonth"/></th>
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
                        <td><A href="productCategoryMeat/update?id=${product.id}"/><spring:message code="product.update"/></td>
                        <td><A href="productCategoryMeat/delete?id=${product.id}"/><spring:message code="product.delete"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

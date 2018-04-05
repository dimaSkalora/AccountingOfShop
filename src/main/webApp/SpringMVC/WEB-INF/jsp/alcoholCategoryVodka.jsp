<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<script type="text/javascript" src="resources/js/alcoholValidation.js" defer></script>
<script type="text/javascript" src="resources/js/dialogUtil.js" defer></script>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <h3 class="text-center"><spring:message code="alcohol.alcoholCategoryVodka"/> </h3>
        <div class="row">
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <c:url var="addAction" value="/alcoholCategoryVodka/saveVodka"/>
                        <form:form action="${addAction}" name = "addAlcohol" onsubmit="return(validate());" commandName="alcohol" cssClass="form-horizontal">
                            <table class="table">
                                <tbody>
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
                                            <spring:message code="alcohol.goodsReceiptDate"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="goodsReceiptDate"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="category">
                                            <spring:message code="alcohol.category"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="category"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="productName">
                                            <spring:message code="alcohol.productName"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="productName"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="liter">
                                            <spring:message code="alcohol.liter"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="liter"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="balanceOnTheFirstDayOfTheMonth">
                                            <spring:message code="alcohol.balanceOnTheFirstDayOfTheMonth"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="balanceOnTheFirstDayOfTheMonth"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="receivedForMonth">
                                            <spring:message code="alcohol.receivedForMonth"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="receivedForMonth"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="soldForMonth">
                                            <spring:message code="alcohol.soldForMonth"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="soldForMonth"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="balanceOnTheLastDayOfTheMonth">
                                            <spring:message code="alcohol.balanceOnTheLastDayOfTheMonth"/>
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
                                            <input class="btn btn-primary" type="submit"
                                                   value="<spring:message code="alcohol.editVodka"/>"/>
                                        </c:if>
                                        <c:if test="${empty alcohol.id}">
                                            <input class="btn btn-primary" type="submit"
                                                   value="<spring:message code="alcohol.addVodka"/>"/>
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
                        <form method="post" action="alcoholCategoryVodka/filter">
                            <dl>
                                <dt><spring:message code="alcohol.startDate"/></dt>
                                <dd><input type="date" name="startDate" value="${param.startDate}"></dd>
                            </dl>
                            <dl>
                                <dt><spring:message code="alcohol.endDate"/></dt>
                                <dd><input type="date" name="endDate" value="${param.endDate}"></dd>
                            </dl>
                            <div class="text-right">
                                <a class="btn btn-danger" href="alcoholCategoryVodka">
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
                        <form method="post" action="alcoholCategoryVodka/searchByProductName" onclick="return (volidateSearchByProductName(this));">
                            <dl>
                                <dt><spring:message code="alcohol.filter"/></dt>
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
                            <a class="btn btn-danger"  href="alcoholCategoryVodka">
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
                <th><spring:message code="alcohol.goodsReceiptDate"/></th>
                <th><spring:message code="alcohol.category"/></th>
                <th><spring:message code="alcohol.productName"/></th>
                <th><spring:message code="alcohol.liter"/></th>
                <th><spring:message code="alcohol.balanceOnTheFirstDayOfTheMonth"/></th>
                <th><spring:message code="alcohol.receivedForMonth"/></th>
                <th><spring:message code="alcohol.soldForMonth"/></th>
                <th><spring:message code="alcohol.balanceOnTheLastDayOfTheMonth"/></th>
                    <th></th>
                    <th></th>
                </thead>
                <c:forEach items="${categoryVodka}" var="alcohol">
                    <jsp:useBean id="alcohol" scope="page" type="com.shop.of.accounting.to.AlcoholWithBalanceNegative"/>
                    <tr class="${alcohol.balanceNegative ? 'reduced' : 'normal'}">
                        <td><c:out value="${alcohol.goodsReceiptDate}"/></td>
                        <td><c:out value="${alcohol.category}"/></td>
                        <td><c:out value="${alcohol.productName}"/></td>
                        <td><c:out value="${alcohol.liter}"/></td>
                        <td><c:out value="${alcohol.balanceOnTheFirstDayOfTheMonth}"/></td>
                        <td><c:out value="${alcohol.receivedForMonth}"/></td>
                        <td><c:out value="${alcohol.soldForMonth}"/></td>
                        <td><c:out value="${alcohol.balanceOnTheLastDayOfTheMonth}"/></td>
                        <td><A href="alcoholCategoryVodka/update?id=${alcohol.id}"/><spring:message code="alcohol.update"/></td>
                        <td><A href="alcoholCategoryVodka/delete?id=${alcohol.id}"/><spring:message code="alcohol.delete"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

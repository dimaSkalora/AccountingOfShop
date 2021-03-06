<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript" src="resources/js/cigareteValidation.js" defer></script>
<script type="text/javascript" src="resources/js/dialogUtil.js" defer></script>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <h3 class="text-center"><spring:message code="cigarette.cigaretteCategoryWithoutFilter"/> </h3>
        <div class="row">
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <c:url var="addAction" value="/cigaretteCategoryWithoutFilter/saveWithoutFilter"/>
                        <form:form action="${addAction}"  name = "addCigarette" onsubmit="return(validateCigarette());" commandName="cigarette" cssClass="form-horizontal">
                            <table class="table">
                                <tbody>
                                <c:if test="${!empty cigarette.id}">
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
                                            <spring:message code="cigarette.goodsReceiptDate"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="goodsReceiptDate"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="category">
                                            <spring:message code="cigarette.category"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="category"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="productName">
                                            <spring:message code="cigarette.productName"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="productName"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="amount">
                                            <spring:message code="cigarette.amount"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="amount"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="balanceOnTheFirstDayOfTheMonth">
                                            <spring:message code="cigarette.balanceOnTheFirstDayOfTheMonth"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="balanceOnTheFirstDayOfTheMonth"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="receivedForMonth">
                                            <spring:message code="cigarette.receivedForMonth"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="receivedForMonth"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="soldForMonth">
                                            <spring:message code="cigarette.soldForMonth"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="soldForMonth"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="balanceOnTheLastDayOfTheMonth">
                                            <spring:message code="cigarette.balanceOnTheLastDayOfTheMonth"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="balanceOnTheLastDayOfTheMonth" disabled="true"/>
                                        <form:hidden path="balanceOnTheLastDayOfTheMonth"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <c:if test="${!empty cigarette.id}">
                                            <input class="btn btn-primary" type="submit"
                                                   value="<spring:message code="cigarette.editWithoutFilter"/>"/>
                                        </c:if>
                                        <c:if test="${empty cigarette.id}">
                                            <input class="btn btn-primary" type="submit"
                                                   value="<spring:message code="cigarette.addWithoutFilter"/>"/>
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
                        <form method="post" action="cigaretteCategoryWithoutFilter/filter">
                            <dl>
                                <dt><spring:message code="cigarette.startDate"/></dt>
                                <dd><input type="date" name="startDate" value="${param.startDate}"></dd>
                            </dl>
                            <dl>
                                <dt><spring:message code="cigarette.endDate"/></dt>
                                <dd><input type="date" name="endDate" value="${param.endDate}"></dd>
                            </dl>
                            <div class="text-right">
                                <a class="btn btn-danger" href="cigaretteCategoryWithoutFilter">
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
                        <form method="post" action="cigaretteCategoryWithoutFilter/searchByProductName" onclick="return (volidateSearchByProductName(this));" >
                            <dl>
                                <dt><spring:message code="cigarette.filter"/></dt>
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
                            <a class="btn btn-danger"  href="cigaretteCategoryWithoutFilter">
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
                    <th><spring:message code="cigarette.goodsReceiptDate"/></th>
                    <th><spring:message code="cigarette.category"/></th>
                    <th><spring:message code="cigarette.productName"/></th>
                    <th><spring:message code="cigarette.amount"/></th>
                    <th><spring:message code="cigarette.balanceOnTheFirstDayOfTheMonth"/></th>
                    <th><spring:message code="cigarette.receivedForMonth"/></th>
                    <th><spring:message code="cigarette.soldForMonth"/></th>
                    <th><spring:message code="cigarette.balanceOnTheLastDayOfTheMonth"/></th>
                    <th></th>
                    <th></th>
                </thead>
                <c:forEach items="${categoryWithoutFilter}" var="cigarette">
                    <jsp:useBean id="cigarette" scope="page" type="com.shop.of.accounting.to.CigarettelWithBalanceNegative"/>
                    <tr class="${cigarette.balanceNegative ? 'reduced' : 'normal'}">
                        <td><c:out value="${cigarette.goodsReceiptDate}"/></td>
                        <td><c:out value="${cigarette.category}"/></td>
                        <td><c:out value="${cigarette.productName}"/></td>
                        <td><c:out value="${cigarette.amount}"/></td>
                        <td><c:out value="${cigarette.balanceOnTheFirstDayOfTheMonth}"/></td>
                        <td><c:out value="${cigarette.receivedForMonth}"/></td>
                        <td><c:out value="${cigarette.soldForMonth}"/></td>
                        <td><c:out value="${cigarette.balanceOnTheLastDayOfTheMonth}"/></td>
                        <td><A href="cigaretteCategoryWithoutFilter/update?id=${cigarette.id}"/><spring:message code="cigarette.update"/></td>
                        <td><A href="cigaretteCategoryWithoutFilter/delete?id=${cigarette.id}"/><spring:message code="cigarette.delete"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
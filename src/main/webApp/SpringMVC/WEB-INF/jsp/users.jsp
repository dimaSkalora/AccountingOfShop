<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <h3 class="text-center"><spring:message code="user.title"/></h3>
        <div class="row">
            <div class="col-sm-8">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <c:url var="addAction" value="/users/create"/>

                        <form:form action="${addAction}" commandName="user">
                            <table class="table">
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
                                    <td>
                                        <form:label path="name">
                                            <spring:message code="user.name"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="name"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="email">
                                            <spring:message code="user.email"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="email"/>
                                    </td>
                                    <td>
                                        <form:label path="password">
                                            <spring:message code="user.password"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="password"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td/>
                                    <td/>
                                    <td/>
                                    <td colspan="2">
                                          <input class="btn btn-primary" type="submit"
                                                   value="<spring:message code="user.add"/>"/>

                                    </td>
                                </tr>
                            </table>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th><spring:message code="user.name"/></th>
                    <th><spring:message code="user.email"/></th>
                    <th><spring:message code="user.roles"/></th>
                    <th><spring:message code="user.active"/></th>
                    <th><spring:message code="user.registered"/></th>
                    <th/>
                    <th/>
                </tr>
                </thead>
                <c:forEach items="${users}" var="user">
                    <jsp:useBean id="user" scope="page" type="com.shop.of.accounting.model.User"/>
                    <tr>
                        <td><c:out value="${user.name}"/></td>
                        <td><a href="mailto:${user.email}">${user.email}</a></td>
                        <td>${user.roles}</td>
                        <td><input type="checkbox"
                                   <c:if test="${user.enabled}">checked</c:if>/>
                        </td>
                        <td><fmt:formatDate value="${user.registered}" pattern="dd-MMMM-yyyy"/></td>
                        <td><a href="<c:url value="/users/update/${user.id}"/>"/><span class="glyphicon glyphicon-pencil" aria-hidden="true"></td>
                        <td><a href="<c:url value="/users/delete/${user.id}"/>"/><span class="glyphicon glyphicon-remove" aria-hidden="true"></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
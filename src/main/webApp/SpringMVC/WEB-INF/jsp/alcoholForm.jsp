<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
    <jsp:useBean id="alcohol" type="com.shop.of.accounting.model.Alcohol" scope="request"/>
    <h3>"${alcohol.isNew() ? 'alcoholAdd' : 'alcoholEdit'}"</h3>
    <hr>
    <form method="post" action="/alcohols/save">
        <input type="hidden" name="id" value="${alcohol.id}">
        <dl>
            <dt>goodsReceiptDate:</dt>
            <dd><input type="date" value="${alcohol.goodsReceiptDate}" name = "goodsReceiptDate" required></dd>
        </dl>
        <dl>
            <dt>category:</dt>
            <dd><input type="text" value="${alcohol.category}" size="10" name="category" required></dd>
        </dl>
        <dl>
            <dt>productName:</dt>
            <dd><input type="text" value="${alcohol.productName}" size="15" name="productName" required></dd>
        </dl>
        <dl>
            <dt>liter:</dt>
            <dd><input type="step" value="${alcohol.liter}" size="5" name="liter" required></dd>
        </dl>
        <dl>
            <dt>balanceOnTheFirstDayOfTheMonth:</dt>
            <dd><input type="number" value="${alcohol.balanceOnTheFirstDayOfTheMonth}" size="15" name="color" balanceOnTheFirstDayOfTheMonth></dd>
        </dl>
        <dl>
            <dt>receivedForMonth:</dt>
            <dd><input type="number" value="${alcohol.receivedForMonth}" name="receivedForMonth" required></dd>
        </dl>
        <dl>
            <dt>soldForMonth:</dt>
            <dd><input type="number" value="${alcohol.soldForMonth}" name="soldForMonth" required></dd>
        </dl>
        <dl>
            <dt>balanceOnTheLastDayOfTheMonth:</dt>
            <dd><input type="number" value="${alcohol.balanceOnTheLastDayOfTheMonth}" name="balanceOnTheLastDayOfTheMonth" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
<%--    <c:url var="addAction" value="/alcohols/save"/>

    <form:form action="${addAction}" commandName="alcohol">
        <table>
                &lt;%&ndash;        <c:if test="${!empty user.name}">
                            <tr>
                                <td>
                                    <form:label path="id">
                                        <spring:message text="ID"/>
                                    </form:label>
                                </td>
                                <td>
                           &lt;%&ndash;         <form:input path="id" readonly="true" size="8" disabled="true"/>
                                    <form:hidden path="id"/>&ndash;%&gt;
                                    <form:input path="id" />
                                </td>
                            </tr>
                        </c:if>&ndash;%&gt;
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
                    <form:input path="balanceOnTheLastDayOfTheMonth"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty alcohol.id}">
                        <input type="submit"
                               value="<spring:message text="Update User"/>"/>
                    </c:if>
                    <c:if test="${empty alcohol.id}">
                        <input type="submit"
                               value="<spring:message text="Add User"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>--%>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

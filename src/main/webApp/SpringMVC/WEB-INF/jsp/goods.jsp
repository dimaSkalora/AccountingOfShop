<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-md-7 col-md-offset-2">
                <div class="text-center">
                    <h2><spring:message code="app.title"/></h2>
                </div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center">
                            <h3><spring:message code="goods.listofGoods"/></h3>
                        </div>
                        <div class="container">
                            <ul class="list-unstyled">
                                <li><h4><ins><spring:message code="goods.alcohol"/></ins></h4>
                                    <ul>
                                        <li><a  href="alcoholCategoryWine"><spring:message code="goods.alcoholCategoryWine"/></a></li>
                                        <li><a  href="alcoholCategoryVodka"><spring:message code="goods.alcoholCategoryVodka"/></a></li>
                                        <li><a  href="alcoholCategoryBeer"><spring:message code="goods.alcoholCategoryBeer"/></a></li>
                                    </ul>
                                </li>
                                <li><h4><ins><spring:message code="goods.cigarette"/></ins></h4>
                                    <ul>
                                        <li><a  href="cigaretteCategoryFilter"><spring:message code="goods.cigaretteCategoryFilter"/></a></li>
                                        <li><a  href="cigaretteCategoryWithoutFilter"><spring:message code="goods.cigaretteCategoryWithoutFilter"/></a></li>
                                    </ul>
                                </li>
                                <li><h4><ins><spring:message code="goods.product"/></ins></h4>
                                    <ul>
                                        <li><a  href="productCategoryMilk"><spring:message code="goods.productCategoryMilk"/></a></li>
                                        <li><a  href="productCategoryMeat"><spring:message code="goods.productCategoryMeat"/></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
             </div>
         </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

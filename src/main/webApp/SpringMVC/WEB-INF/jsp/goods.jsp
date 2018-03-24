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
                    <h2>Accounting Of Shop</h2>
                </div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center">
                            <h3>Список товаров:</h3>
                        </div>
                        <div class="container">
                            <ul class="list-unstyled">
                                <li><h4><ins>Alcohol</ins></h4>
                                    <ul>
                                        <li><a  href="alcoholCategoryWine">Alcohool Category Wine</a></li>
                                        <li><a  href="alcoholCategoryVodka">Alcohool Category Vodka</a></li>
                                        <li><a  href="alcoholCategoryBeer">Alcohool Category Beer</a></li>
                                    </ul>
                                </li>
                                <li><h4><ins>Cigarette</ins></h4>
                                    <ul>
                                        <li><a  href="cigaretteCategoryFilter">Cigarette Category Filter</a></li>
                                        <li><a  href="cigaretteCategoryWithoutFilter">Cigarette Category Without Filter</a></li>
                                    </ul>
                                </li>
                                <li><h4><ins>Product</ins></h4>
                                    <ul>
                                        <li><a  href="productCategoryMilk">Product Category Milk</a></li>
                                        <li><a  href="productCategoryMeat">Product Category Meat</a></li>
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

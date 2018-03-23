<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--<header>
    <a href="${pageContext.request.contextPath}/"></a>&nbsp;|&nbsp;<a href="users">Users</a>
    <a href="${pageContext.request.contextPath}/"></a>&nbsp;|&nbsp;<a href="alcohols">Alcohols</a>
    <a href="${pageContext.request.contextPath}/"></a>&nbsp;|&nbsp;<a href="/">home</a>
    <a href="${pageContext.request.contextPath}/"></a>&nbsp;|&nbsp;<a href="cigaretteCategoryFilter">cigaretteCategoryFilter</a>
    <a href="${pageContext.request.contextPath}/"></a>&nbsp;|&nbsp;<a href="cigaretteCategoryWithoutFilter">cigaretteCategoryWithoutFilter</a>

</header>--%>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Алкоголь<b class="caret"></b></a>
                <ul id="menu1" class="dropdown-menu">
                    <li><a href="alcoholCategoryVodka">Водка</a></li>
                    <li><a href="alcoholCategoryWine">Вино</a></li>
                    <li><a href="alcoholCategoryBeer">Пиво</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Отделенная ссылка</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Сигареты<b class="caret"></b></a>
                <ul id="menu2" class="dropdown-menu">
                    <li><a href="cigaretteCategoryFilter">С фильтром</a></li>
                    <li><a href="cigaretteCategoryWithoutFilter">Без фильтра</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Отделенная ссылка</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Продукты<b class="caret"></b></a>
                <ul id="menu3" class="dropdown-menu">
                    <li><a href="productCategoryMilk">Молочные</a></li>
                    <li><a href="productCategoryMeat">Мясные</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Отделенная ссылка</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">REST<b class="caret"></b></a>
                <ul id="menu4" class="dropdown-menu">
                    <li><a href="/accountingOfShop/rest/admin/users" target="_blank">/rest/admin/users</a></li>
                    <li><a href="/accountingOfShop/rest/admin/users/100001" target="_blank">/rest/admin/users/100001</a></li>
                    <li class="divider"></li>
                    <li><a href="/accountingOfShop/rest/profile/alcohols" target="_blank">/rest/profile/alcohols</a></li>
                    <li><a href="/accountingOfShop/rest/profile/alcohols/filter/?startDate=2018-03-11&endDate=2018-03-15"
                           target="_blank">/rest/profile/alcohols/filter</a></li>
                    <li><a href="/accountingOfShop/rest/profile/alcohols/category/водка" target="_blank">/rest/profile/alcohols/водка</a></li>
                    <li><a href="/accountingOfShop/rest/profile/alcohols/category/вино" target="_blank">/rest/profile/alcohols/вино</a></li>
                    <li><a href="/accountingOfShop/rest/profile/alcohols/category/пиво" target="_blank">/rest/profile/alcohols/пиво</a></li>
                    <li class="divider"></li>
                    <li><a href="/accountingOfShop/rest/profile/cigarettes" target="_blank">/rest/profile/cigarettes</a></li>
                    <li><a href="/accountingOfShop/rest/profile/cigarettes/filter?startDate=2018-03-11&endDate=2018-03-16"
                           target="_blank">/rest/profile/cigarettes/filter</a></li>
                    <li><a href="/accountingOfShop/rest/profile/cigarettes/category/с фильтром" target="_blank">/rest/profile/cigarettes/category/с фильтром</a></li>
                    <li><a href="/accountingOfShop/rest/profile/cigarettes/category/без фильтра" target="_blank">/rest/profile/cigarettes/category/без фильтра</a></li>
                    <li class="divider"></li>
                    <li><a href="/accountingOfShop/rest/profile/products" target="_blank">/rest/profile/products</a></li>
                    <li><a href="/accountingOfShop/rest/profile/products/filter?startDate=2018-03-11&endDate=2018-03-16"
                           target="_blank">/rest/profile/products/filter</a></li>
                    <li><a href="/accountingOfShop/rest/profile/products/category/молочные" target="_blank">/rest/profile/products/category/молочные</a></li>
                    <li><a href="/accountingOfShop/rest/profile/products/category/мясные" target="_blank">/rest/profile/products/category/мясные</a></li>
                    <li><a href="/accountingOfShop" target="_blank"></a></li>
                </ul>
            </li>
        </ul>
        <div class="collapse navbar-collapse">
            <form class="navbar-form navbar-right">
                <a class="btn btn-info" href="users">user.title</a>

                <a class="btn btn-primary" href="">
                    <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                </a>
            </form>
        </div>
    </div>
</div>
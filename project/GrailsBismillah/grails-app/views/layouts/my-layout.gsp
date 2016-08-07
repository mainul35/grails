<%--
  Created by IntelliJ IDEA.
  User: Touhid Mia
  Date: 04/07/2015
  Time: 09:51 PM
--%>
<!DOCTYPE html>
<html>
<header>
    <g:render template="/layouts/includeFiles"/>
</header>
<body>

<g:render template="/layouts/header"/>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <g:render template="/layouts/left-menu"/>
        </div>
        <div class="col-md-9">
            <g:layoutBody/>
        </div>
    </div>
</div>
<g:render template="/layouts/footer"/>
</body>
</html>
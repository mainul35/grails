<meta name="layout" content="login">
<div id="global-wrapper">
    <div id="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h1 class="text-center login-title">Login Here</h1>
                    <div class="account-wall">

                        <asset:image src="logo.png" class="profile-img"/>
                        <g:form controller="authentication" action="doLogin" class="form-signin">
                        <input type="text" name="email" class="form-control" placeholder="Email" required autofocus>
                        <input type="password" name="password" class="form-control" placeholder="Password" required>
                        <button class="btn btn-lg btn-primary btn-block" name="doLogin" type="submit">Login</button>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
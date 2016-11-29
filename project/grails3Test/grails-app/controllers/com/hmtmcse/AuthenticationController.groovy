package com.hmtmcse

class AuthenticationController {

    def index() {
        redirect(action: "login")
    }
    def login() {}

    def logout() {
        log.info "User agent: " + request.getHeader("User-Agent")
        session.invalidate()
        redirect(action: "login")
    }

    def doLogin() {
        if (params.email && params.password){
            def userInfo = Operator.findByEmailAndPassword(params.email,params.password?.encodeAsMD5());
            if (userInfo){
                session["user"] = userInfo.name
                redirect(controller: "dashboard");
                return;
            }
        }
        flash.message = [info:"invalid email or password",success:false]
        redirect(action:"login",controller: "authentication")
    }

}

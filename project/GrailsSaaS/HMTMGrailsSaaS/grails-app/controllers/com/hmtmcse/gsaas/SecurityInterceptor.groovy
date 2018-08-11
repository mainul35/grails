package com.hmtmcse.gsaas


class SecurityInterceptor {

    MemberService memberService

    SecurityInterceptor() {
        matchAll().excludes(controller: "authentication")
    }

    boolean before() {
        if (!memberService.isAuthenticated()) {
            redirect(controller: "authentication", action: "login")
            return false
        }
        return true
    }

}

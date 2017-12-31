package com.hmtmcse.phonebook.controllers

import com.hmtmcse.phonebook.MemberService

class AuthenticationController {

    MemberService memberService

    def index() {}

    def login() {}

    def registration() {
        [member: flash.redirectParams]
    }

    def doLogin() {
        if (memberService.doLogin(params.email, params.password)){
            redirect(controller: "dashboard", action: "index")
        }else{
            redirect(controller: "authentication", action: "login")
        }
    }

    def doRegistration() {
        def response = memberService.registerMember(params)
        if (response.isSuccess){
            memberService.setMemberAuthorization(response.model)
            redirect(controller: "dashboard", action: "index")
        }else{
            flash.redirectParams = response.model
            redirect(controller: "authentication", action: "registration")
        }
    }
}

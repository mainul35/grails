package com.hmtmcse.phonebook.controllers

import com.hmtmcse.phonebook.Member

class AuthenticationController {

    def index() { }

    def login() { }

    def registration() {
        [member:flash.redirectParams]
    }

    def doLogin() {
        redirect(controller:"authentication", action:"index")
    }

    def doRegistration() {
        Member member = new Member(params)
        if (member.validate()){

        } else{
            flash.redirectParams = member
            redirect(controller:"authentication", action:"registration")
        }
    }
}

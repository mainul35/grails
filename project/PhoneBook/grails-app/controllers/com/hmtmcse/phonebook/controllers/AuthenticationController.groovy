package com.hmtmcse.phonebook.controllers

class AuthenticationController {

    def index() { }

    def login() { }

    def registration() { }

    def doLogin() {
        redirect(controller:"authentication", action:"index")
    }
}

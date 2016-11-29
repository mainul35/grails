package com.hmtmcse.basic

class SimpleController {

    def bismillah() {
        render "Bismillahir Rahmanier Rahim"
    }

    def redirectTo(){
        redirect(action: "redirectHere")
    }

    def redirectHere(){

    }
}

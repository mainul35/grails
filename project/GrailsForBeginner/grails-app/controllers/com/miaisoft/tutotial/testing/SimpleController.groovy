package com.miaisoft.tutotial.testing

import com.miaisoft.tutorial.testing.Simple

class SimpleController {

    def index() {
        redirect action: 'hello'
    }



    def hello() {
        render "hello"
    }

    def home() {
        render view: "homePage", model: [title: "Hello World"]
    }

    def consumeBook() {
        def book = request.XML
        render "The title is ${book.title}."
    }

    def consumeBookJSON() {
        def book = request.JSON
        render "The title is ${book.title}."
    }

    def save() {
        def simple = new Simple(params)
        if (simple.save(flush: true)) {
            flash.message = message(
                    code: 'default.created.message',
                    args: [message(code: 'save', default: 'Saved'), simple.id])
            redirect(action: "show", id: simple.id)
        }
        else {
            render(view: "create", model: [bookInstance: simple])
        }
    }

}

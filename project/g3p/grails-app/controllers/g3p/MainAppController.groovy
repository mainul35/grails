package g3p

class MainAppController {

    def index() {
        render("Message: " + g.message(code: 'message.name') + " Core: " + g.message(code: "mia.vai"))
    }

    def gsp() {

    }


}

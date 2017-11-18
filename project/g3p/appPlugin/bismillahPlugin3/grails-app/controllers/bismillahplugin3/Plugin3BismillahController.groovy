package bismillahplugin3

class Plugin3BismillahController {

    def index() {
        render("Message: " + g.message(code: 'message.name') + " Core: " + g.message(code: "mia.vai"))
    }
}

package bismillahplugin2

import com.touhid.JarTesting

class PluginTestingController {

    def index() {
        render("Class 2")
    }

    def jar(){
        JarTesting jarTesting = new JarTesting();
        String m = jarTesting.printMessage()
        render ("Message: " + m)
    }

}

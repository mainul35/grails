package bismillahplugin

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import com.touhid.JarTesting

class BismillahPluginController {

    def index() {
        render view: "/abc.gsp"
    }

    def lib(){
        String webURL = "http://www.ielts-mentor.com/reading-sample/academic-reading/35-ielts-academic-reading-sample-10-absenteeism-in-nursing";
        Document document = Jsoup.connect(webURL).get();
        render(document.toString())
    }

    def jar(){
        JarTesting jarTesting = new JarTesting();
        String m = jarTesting.printMessage()
        render ("Message: " + m)
    }

}

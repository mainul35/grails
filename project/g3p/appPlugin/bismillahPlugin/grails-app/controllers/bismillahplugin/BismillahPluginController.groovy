package bismillahplugin

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class BismillahPluginController {

    def index() {
        render("Bismillah Plugin Index.")
    }

    def lib(){
        String webURL = "http://www.ielts-mentor.com/reading-sample/academic-reading/35-ielts-academic-reading-sample-10-absenteeism-in-nursing";
        Document document = Jsoup.connect(webURL).get();
        render(document.toString())
    }
}

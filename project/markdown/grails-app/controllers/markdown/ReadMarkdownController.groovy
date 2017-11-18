package markdown

import org.commonmark.node.*
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer

class ReadMarkdownController {

    def index() {

        Parser parser = Parser.builder().build()
        Node document = parser.parse("This is **Sparta**")
        HtmlRenderer renderer = HtmlRenderer.builder().build()
        render(renderer.render(document))

    }
}

package exprement

import grails.gsp.PageRenderer
import grails.util.GrailsWebMockUtil
import grails.util.Holders
import grails.web.context.ServletContextHolder
import org.grails.web.servlet.mvc.GrailsWebRequest
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.support.WebApplicationContextUtils

import javax.servlet.http.HttpServletRequest

class ThreadTestController {

    def index() {
        Thread.start {

            def webRequest = RequestContextHolder.getRequestAttributes()
            if(!webRequest) {
                def servletContext  = ServletContextHolder.getServletContext()
                def applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext)
                webRequest =  GrailsWebMockUtil.bindMockWebRequest(applicationContext)
            }


//            HttpServletRequest _request = PageRenderer.PageRenderRequestCreator.createInstance("/page/dummy")
//            _request.IS_DUMMY = true
//            GrailsWebRequest webRequest = new GrailsWebRequest(_request, PageRenderer.PageRenderResponseCreator.createInstance(new PrintWriter(new StringWriter())), Holders.servletContext)
            RequestContextHolder.setRequestAttributes(webRequest)
            println(RequestContextHolder.getRequestAttributes())
        }

    }
}

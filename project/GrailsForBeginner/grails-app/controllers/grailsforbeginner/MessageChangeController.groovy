package grailsforbeginner

import org.codehaus.groovy.grails.context.support.PluginAwareResourceBundleMessageSource


class MessageChangeController {


    PluginAwareResourceBundleMessageSource messageSource;
    private static final String MESSAGE_FILE_DIR = "WEB-INF/resources/messages"


    def index() {


        messageSource.pluginBaseNames.add("C:\\Users\\touhid\\Desktop\\message\\messages.properties");
//        messageSource.pluginBaseNames.remove();
        messageSource.clearCache()
       render(messageSource.pluginBaseNames)
    }



    def myMessage(){
        render(g.message(code:"mymessage"))
    }

}

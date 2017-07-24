package g3p

import grails.boot.GrailsApp
import grails.boot.config.GrailsApplicationPostProcessor
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.context.annotation.Bean

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Bean
    GrailsApplicationPostProcessor grailsApplicationPostProcessor() {
        File file = new File("glib/bismillahPlugin-0.1.jar")
        URL[] urls = [file.toURI().toURL()]
        Thread.currentThread().setContextClassLoader(new URLClassLoader (urls, applicationContext.getClassLoader()))
        return new ExperimentGrailsApplicationPostProcessor( this, applicationContext, classes() as Class[])
    }


}
package g3p;

import grails.boot.config.GrailsApplicationPostProcessor;
import grails.core.GrailsApplicationLifeCycle;
import org.springframework.context.ApplicationContext;

/**
 * Created by touhid on 23-Jul-17.
 */
public class ExperimentGrailsApplicationPostProcessor extends GrailsApplicationPostProcessor {


    public ExperimentGrailsApplicationPostProcessor(GrailsApplicationLifeCycle lifeCycle, ApplicationContext applicationContext, Class[] classes) {
        super(lifeCycle, applicationContext, classes);
    }
}

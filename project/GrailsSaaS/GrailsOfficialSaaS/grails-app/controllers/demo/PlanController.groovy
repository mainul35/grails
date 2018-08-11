package demo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import static grails.gorm.multitenancy.Tenants.*

@Slf4j
@CompileStatic
class PlanController {
    static allowedMethods = [index: 'GET', save: 'POST', delete: 'DELETE']

    PlanService planService
    AbulService abulService

    def index() {
        [planList: abulService.list()]
    }

    def save(SavePlanCommand cmd) {
        if ( cmd.hasErrors() ) {
            render status: 422
            return
        }

        planService.save(cmd.title)
        render status: 201
    }
}

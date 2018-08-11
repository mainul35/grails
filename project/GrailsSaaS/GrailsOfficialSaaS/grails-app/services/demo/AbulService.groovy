package demo

import grails.gorm.multitenancy.CurrentTenant


@CurrentTenant
class AbulService {

    def list() {
        return Plan.list()
    }
}

package com.hmtmcse.d

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class OperatorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Operator.list(params), model:[operatorCount: Operator.count()]
    }

    def show(Operator operator) {
        respond operator
    }

    def create() {
        respond new Operator(params)
    }


    def save(Operator operator) {
        if (operator == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (operator.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond operator.errors, view:'create'
            return
        }

        operator.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'operator.label', default: 'Operator'), operator.id])
                redirect operator
            }
            '*' { respond operator, [status: CREATED] }
        }
    }

    def edit(Operator operator) {
        respond operator
    }


    def update(Operator operator) {
        if (operator == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (operator.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond operator.errors, view:'edit'
            return
        }

        operator.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'operator.label', default: 'Operator'), operator.id])
                redirect operator
            }
            '*'{ respond operator, [status: OK] }
        }
    }


    def delete(Operator operator) {

        if (operator == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        operator.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'operator.label', default: 'Operator'), operator.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'operator.label', default: 'Operator'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

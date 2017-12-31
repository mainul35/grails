package com.hmtmcse.phonebook.controllers

import com.hmtmcse.phonebook.ContactGroup
import com.hmtmcse.phonebook.ContactGroupService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ContactGroupController {

    ContactGroupService contactGroupService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        [contactGroups: contactGroupService.list(params)]
    }

    def show(Integer id) {
        [contactGroup:contactGroupService.get(id)]
    }

    def create() {
        [contactGroup: flash.redirectParams]
    }

    def save() {
        def response = contactGroupService.save(params)
        if (response.isSuccess) {
            redirect(controller: "contactGroup", action: "index")
        } else {
            flash.redirectParams = response.model
            redirect(controller: "contactGroup", action: "create")
        }
    }

    def edit(Long id) {
        respond contactGroupService.get(id)
    }

    def update(ContactGroup contactGroup) {
        if (contactGroup == null) {
            notFound()
            return
        }

        try {
            contactGroupService.save(contactGroup)
        } catch (ValidationException e) {
            respond contactGroup.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'contactGroup.label', default: 'ContactGroup'), contactGroup.id])
                redirect contactGroup
            }
            '*'{ respond contactGroup, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        contactGroupService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'contactGroup.label', default: 'ContactGroup'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contactGroup.label', default: 'ContactGroup'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

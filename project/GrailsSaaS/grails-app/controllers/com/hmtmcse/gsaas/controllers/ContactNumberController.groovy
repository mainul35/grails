package com.hmtmcse.gsaas.controllers

import com.hmtmcse.gsaas.PhoneBookService
import grails.converters.JSON

class ContactNumberController {

    PhoneBookService phoneBookService

    def number() {
        [numbers: phoneBookService.getContactNumbersByContactId(params.id)]
    }

    def delete(Integer id){
        render(phoneBookService.deleteContactNumber(id) as JSON)
    }
}

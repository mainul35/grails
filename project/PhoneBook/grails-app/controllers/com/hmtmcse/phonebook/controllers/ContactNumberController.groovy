package com.hmtmcse.phonebook.controllers

import com.hmtmcse.phonebook.PhoneBookService

class ContactNumberController {

    PhoneBookService phoneBookService

    def number() {
        [numbers: phoneBookService.getContactNumbersByContactId(params.id)]
    }
}

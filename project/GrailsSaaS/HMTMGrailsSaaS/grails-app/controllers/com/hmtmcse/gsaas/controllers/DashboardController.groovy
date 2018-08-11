package com.hmtmcse.gsaas.controllers

import com.hmtmcse.gsaas.PhoneBookService

class DashboardController {

    PhoneBookService phoneBookService

    def index() {
        [report: phoneBookService.getReport()]
    }

    def create() {

    }
}

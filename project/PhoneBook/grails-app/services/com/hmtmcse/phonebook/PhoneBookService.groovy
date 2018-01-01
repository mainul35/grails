package com.hmtmcse.phonebook


class PhoneBookService {

    def saveContactNumber(Contact contact, def type, def number) {
        if (type instanceof String && number instanceof String && !number.equals("")) {
            new ContactNumber(number: number, contact: contact, type: type).save(flush: true)
        }else{
            Integer index = 0;
            number.each {
                if (it) {
                    contact.addToContactNumber([type: type[index], number: it]).save(flush: true)
                    index++
                }
            }
        }
    }

    def updateContactNumber() {

    }

    def deleteContactNumber() {

    }

}

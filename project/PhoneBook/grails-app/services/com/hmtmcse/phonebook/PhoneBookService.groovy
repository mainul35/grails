package com.hmtmcse.phonebook


class PhoneBookService {

    ContactService contactService

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

    def deleteContactNumber(Serializable id) {
        ContactNumber contactNumber = ContactNumber.get(id)
        if (contactNumber){
            contactNumber.delete(flush: true)
            return AppUtil.infoMessage("Deleted")
        }
        return AppUtil.infoMessage( "Unable to Delete", false)
    }



    def getContactNumbersByContactId(Serializable id){
        def contact = contactService.get(id)
        if (contact){
            return ContactNumber.createCriteria().list {
                eq("contact", contact)
            }
        }
        return []
    }

}

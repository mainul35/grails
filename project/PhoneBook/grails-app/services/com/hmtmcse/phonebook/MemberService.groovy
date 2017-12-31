package com.hmtmcse.phonebook

import grails.web.servlet.mvc.GrailsParameterMap

class MemberService {

    private static final String AUTHORIZED = "AUTHORIZED"

    def registerMember(GrailsParameterMap params) {
        Member member = new Member(params)
        def response = AppUtil.saveResponse(false, member)
        if (member.validate()) {
            response.isSuccess = true
            member.save()
        }
        return response
    }

    def setMemberAuthorization(Member member) {
        def authorization = [isLoggedIn: true, member: member]
        AppUtil.getAppSession()[AUTHORIZED] = authorization
    }

    def doLogin(String email, String password){
        password = password.encodeAsMD5()
        Member member = Member.findByEmailAndPassword(email, password)
        if (member){
            setMemberAuthorization(member)
            return true
        }
        return false
    }

    boolean isAuthenticated(){
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        if (authorization && authorization.isLoggedIn){
            return true
        }
        return false
    }

    def getMemberName(){
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        def member = authorization?.member
        return "${member.firstName} ${member.lastName}"
    }

}

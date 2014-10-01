package grailsforbeginner

import com.sun.org.apache.xml.internal.security.utils.Base64

import java.nio.charset.Charset

class BasicAuthenticationService {

    def check(def request) {
        if (request && request.getHeader('Authorization')){
            String authHeader = request.getHeader('Authorization').substring("Basic".length()).trim()
            def headerByte = Base64.decode(authHeader);
            String userPass = new String(headerByte,Charset.forName("UTF-8"))
            final String[] values = userPass.split(":", 2);
            if (values[0].equals("touhid") && values[1].equals("touhid")){
                return true
            }else{
                return false
            }
        }
    }
}

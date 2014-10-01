package grailsforbeginner

import com.sun.org.apache.xml.internal.security.utils.Base64

import java.nio.charset.Charset

class BasicAuthenticationService {

    def serviceMethod(def request) {

        String authHeader = request.getHeader('Authorization').substring("Basic".length()).trim()
        def aByte = Base64.decode(authHeader);
        String userPass = new String(aByte,Charset.forName("UTF-8"))


        final String authorization = httpRequest.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.decode(base64Credentials),
                    Charset.forName("UTF-8"));
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
        }
    }
}

package starter

import com.touhid.DomainAbstraction

class AppConfiguration extends DomainAbstraction{

    Integer id
    String accessKey
    String secretKey

    static constraints = {
        secretKey(nullable: true)
    }
}

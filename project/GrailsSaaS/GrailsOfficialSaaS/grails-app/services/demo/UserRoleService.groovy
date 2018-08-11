package demo

import grails.gorm.services.Query
import grails.gorm.services.Service
import groovy.transform.CompileStatic

@Service(UserRole)
@CompileStatic
interface UserRoleService {

    @Query("""select $user.username from ${User user}""")
    List<String> findAllUsernameByAuthority(String authority)

    UserRole save(User user, Role role)
    void deleteByUser(User user)
}
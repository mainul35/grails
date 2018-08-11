package demo

import groovy.transform.CompileStatic

@CompileStatic
class DatabaseProvisioningService {

    UserRoleService userRoleService

    List<DatabaseConfiguration> findAllDatabaseConfiguration() {
        List<String> usernames = userRoleService.findAllUsernameByAuthority(VillainService.ROLE_VILLAIN)
        usernames.collect { findDatabaseConfigurationByUsername(it) }
    }

    DatabaseConfiguration findDatabaseConfigurationByUsername(String username) {
        new DatabaseConfiguration(dataSourceName: username, configuration: configurationByUsername(username))
    }

    Map<String, Object> configurationByUsername(String username) {
        [
                'hibernate.hbm2ddl.auto':'none',
                'username': 'root',
                'password': '',
                'url':"jdbc:mysql://localhost/$username"
        ] as Map<String, Object>
    }
}


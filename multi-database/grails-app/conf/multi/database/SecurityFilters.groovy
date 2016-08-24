package multi.database

import com.hmtmcse.DataSourceService
import com.hmtmcse.UserHolder

class SecurityFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                if (params.int('user')) {
                    UserHolder.setEnvironment([id: params.int('user')]);
                    DataSourceService dataSourceService = new DataSourceService();
                    dataSourceService.setApplicationContext(grailsApplication.mainContext);
                    dataSourceService.grailsApplication = grailsApplication;
                    dataSourceService.registerBean(
                            params.user.toString(),
                            "jdbc:mysql://localhost/user${params.user}?useUnicode=yes&characterEncoding=UTF-8",
                            "root", ""
                    );
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}

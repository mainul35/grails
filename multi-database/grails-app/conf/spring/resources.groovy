// Place your Spring DSL code here
import org.springframework.jdbc.datasource.DriverManagerDataSource
import com.hmtmcse.UserHolder
import com.hmtmcse.SwitchableDataSource

// Place your Spring DSL code here
beans = {
    parentDataSource(DriverManagerDataSource) { bean ->
        bean.'abstract' = true;
        driverClassName = 'com.mysql.jdbc.Driver'
        username = "root"
    }

    "rootDataSource"(DriverManagerDataSource) { bean ->
        bean.parent = parentDataSource;
        bean.scope = 'prototype';
        url = "jdbc:mysql://localhost/user${UserHolder.DEFAULT}?useUnicode=yes&characterEncoding=UTF-8";
        username = "root"
    }

    def dataSources = [:]
    dataSources[UserHolder.DEFAULT] = ref("rootDataSource");

    dataSource(SwitchableDataSource) {
        targetDataSources = dataSources
    }
}
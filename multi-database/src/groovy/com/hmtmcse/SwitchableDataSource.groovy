package com.hmtmcse

import grails.util.Holders
import org.springframework.context.ApplicationContext
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource

import javax.sql.DataSource


class SwitchableDataSource extends AbstractRoutingDataSource {
    def applicationContext

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext
    }

    protected DataSource determineTargetDataSource() {
        def user = UserHolder.getEnvironment();
        try {
            DriverManagerDataSource ds = super.determineTargetDataSource();
            return ds;
        }
        catch (Exception ex) {
            println "--->Error:: ${ex.getMessage()}";
            try {
                def ga = Holders.getGrailsApplication();
                String beanFullName = UserHolder.DS_PREFIX + user.id + UserHolder.DS_POSTFIX;
                if(user && user.id && ga.mainContext.containsBean( beanFullName ) ) {
                    println "Using data source: '${beanFullName}'";
                    return ga.mainContext.getBean(beanFullName);
                }
            }
            catch (Exception ex2) {
                println "--->Error:: ${ex2.getMessage()}";
            }
        }
    }

    @Override
    protected Object determineCurrentLookupKey() {
        def user = UserHolder.getEnvironment();
        return user?.id ?: UserHolder.DEFAULT;
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
    }
}

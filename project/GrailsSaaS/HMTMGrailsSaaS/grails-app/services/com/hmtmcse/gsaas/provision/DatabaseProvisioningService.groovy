package com.hmtmcse.gsaas.provision

import org.grails.orm.hibernate.HibernateDatastore


class DatabaseProvisioningService {

    HibernateDatastore hibernateDatastore


    def initVirtualInstances() {

    }

    def placeHolderDb(String databaseName){
        hibernateDatastore.getConnectionSources().addConnectionSource(databaseName, databaseConfigurationConfig(databaseName))
    }


    Map<String, Object> databaseConfigurationConfig(String database, String dbUsername = 'root', String dbPassword = '') {
        return [
                'hibernate.hbm2ddl.auto':'none',
                'username': dbUsername,
                'logSql': true,
                'password': dbPassword,
                'url':"jdbc:mysql://localhost/${database}"
        ] as Map<String, Object>
    }



}

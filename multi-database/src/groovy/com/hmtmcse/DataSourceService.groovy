package com.hmtmcse

import grails.spring.BeanBuilder
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.support.GenericApplicationContext


class DataSourceService implements ApplicationContextAware {
    ApplicationContext applicationContext;
    public GrailsApplication grailsApplication;

    @Override
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * Add new bean to system
     * @param beanName
     * @param dsurl
     * @param uid
     * @param pwd
     * @return
     */
    def registerBean( String beanName, String dsurl, String uid, String pwd ) {
        String beanFullName = UserHolder.DS_PREFIX + beanName + UserHolder.DS_POSTFIX;
        if( !applicationContext.containsBean( beanFullName ) ) {
            def bb = new BeanBuilder()
            bb.beans {
                "$beanFullName" { bean ->
                    bean.parent = ref('parentDataSource');
                    bean.scope = 'prototype';
                    url = dsurl;
                    username = uid
                    password = pwd
                }
            }
            bb.registerBeans( applicationContext );

            println "Added $beanFullName"
        }
        else {
            println "Already got a bean called $beanFullName"
        }
    }

    /**
     * Remove bean from system
     * @param beanName
     * @return
     */
    def deRegisterBean( String beanName ) {
        if( applicationContext.containsBean( beanName ) ) {
            (applicationContext as GenericApplicationContext).removeBeanDefinition( beanName )
            println "Removed $beanName"
        }
        else {
            println "Trying to deRegister a bean $beanName that I don't know about"
        }
    }
}
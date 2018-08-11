package demo

import grails.gorm.MultiTenant
import groovy.transform.CompileStatic

@CompileStatic
trait VirtualInstance<D> extends MultiTenant{

}
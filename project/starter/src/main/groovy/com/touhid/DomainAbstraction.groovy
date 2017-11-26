package com.touhid

import starter.DefaultConfiguration;

abstract class DomainAbstraction {

    DefaultConfiguration defaultConfiguration = null

    static constraints = {
        defaultConfiguration(nullable:true)
    }

}

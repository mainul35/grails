How to create Grails Plugin?
---
```bash
Run From command prompt
-> grails create-plugin pluginName

Added below lines in settings.gradle file of core app
-> include "pluginName"


Added below configuation in build.gradle file of core app

grails {
    plugins {
        compile project(':myplugin')
    }
}

Note: You can also declare the dependency within the dependencies block, however you will not get subproject reloading if you do this!

```


Need to Know
1. GrailsAutoConfiguration
	a. Collection<Class> classes()
2. GrailsApplicationPostProcessor
3. GrailsApp
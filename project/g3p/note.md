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


Plugin 
1. CorePluginFinder
2. pluginManager.loadPlugins()
3. attemptLoadPlugins(ClassLoader gcl)
4. CorePluginFinder
5. loadCorePluginsFromResources
6. attemptCorePluginClassLoad




Lookup
------------------------------------------------------------------------
1. GrailsAutoConfiguration			>>>			grailsApplicationPostProcessor
2. GrailsApplicationPostProcessor	>>>			GrailsApplicationPostProcessor
		pluginManager = new DefaultGrailsPluginManager(grailsApplication)
		initializeGrailsApplication(ApplicationContext applicationContext)
		pluginManager.loadPlugins()
3. DefaultGrailsPluginManager	>>>			attemptLoadPlugins(ClassLoader gcl)
		List<GrailsPlugin> findCorePlugins()
		
		
		

Need to Study
--------------------------------------------------------------------------
1. ApplicationContextAware
2. customizePluginManager(pluginManager)


Plugin Loadin
------------------------------------
1. loadCorePluginsFromResources
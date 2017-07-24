package g3p;

public class JarLoader {

    public static synchronized void loadLibrary(java.io.File jar, ClassLoader classLoader)
    {
        try {
            /*We are using reflection here to circumvent encapsulation; addURL is not public*/
            java.net.URLClassLoader loader = (java.net.URLClassLoader)classLoader;
            java.net.URL url = jar.toURI().toURL();
            /*Disallow if already loaded*/
            for (java.net.URL it : java.util.Arrays.asList(loader.getURLs())){
                if (it.equals(url)){
                    return;
                }
            }
            java.lang.reflect.Method method = java.net.URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{java.net.URL.class});
            method.setAccessible(true); /*promote the method to public access*/
            method.invoke(loader, new Object[]{url});
        } catch (final java.lang.NoSuchMethodException |
                java.lang.IllegalAccessException |
                java.net.MalformedURLException |
                java.lang.reflect.InvocationTargetException e){
        }
    }
}

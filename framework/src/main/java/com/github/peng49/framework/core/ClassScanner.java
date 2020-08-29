package com.github.peng49.framework.core;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassScanner {
    public static List<Class<?>> scanClasses(String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace(".", "/");
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(path);
        Enumeration<URL> resources = loader.getResources(path);

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            System.out.println(resource);
            if (resource.getProtocol().contains("jar")) {
                System.out.println("jar");
                JarURLConnection jarURLConnection = (JarURLConnection) resource.openConnection();
                String jarFilePath = jarURLConnection.getJarFile().getName();
                classes.addAll(getClassFromJar(jarFilePath, path));
            } else {
                System.out.println("file");
                //todo
            }
        }
        return classes;
    }

    private static List<String> getAllPath(String path) {
        List<String> pathArray = new ArrayList<>();

        return pathArray;
    }


    private static List<Class<?>> getClassesFormPath(String path) {
        List<Class<?>> classes = new ArrayList<>();
        List<String> allPath = getAllPath(path);

        for (String s : allPath) {

        }

        return classes;
    }

    private static List<? extends Class<?>> getClassFromJar(String jarFilePath, String path) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        JarFile jarFile = new JarFile(jarFilePath);
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            String name = jarEntry.getName();
            System.out.println(name);
            if (name.startsWith(path) && name.endsWith(".class")) {
                String classFullName = name.replace("/", ".").substring(0, name.length() - 6);
                classes.add(Class.forName(classFullName));
            }
        }
        return classes;
    }
}

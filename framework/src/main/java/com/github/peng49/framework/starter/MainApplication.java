package com.github.peng49.framework.starter;

import com.github.peng49.framework.core.ClassScanner;
import com.github.peng49.framework.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

import java.io.IOException;
import java.util.List;

public class MainApplication {
    public static void run(Class<?> cls, String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Hello mini spring!");
        try {
            TomcatServer tomcatServer = new TomcatServer(args);

            List<Class<?>> classes = ClassScanner.scanClasses(cls.getPackage().getName());
            System.out.println(classes);
            classes.forEach(it -> System.out.println(it.getName()));

            tomcatServer.startServer();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}

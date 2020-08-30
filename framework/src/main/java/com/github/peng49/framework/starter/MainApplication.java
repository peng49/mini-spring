package com.github.peng49.framework.starter;

import com.github.peng49.framework.beans.BeanFactory;
import com.github.peng49.framework.core.ClassScanner;
import com.github.peng49.framework.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

import java.io.IOException;
import java.util.List;

public class MainApplication {
    public static void run(Class<?> cls, String[] args) {
        System.out.println("Hello mini spring!");
        try {
            TomcatServer tomcatServer = new TomcatServer(args);
            List<Class<?>> classes = ClassScanner.scanClasses(cls.getPackage().getName());
            BeanFactory.initBean(classes);

            BeanFactory.forEachBeans();

            tomcatServer.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

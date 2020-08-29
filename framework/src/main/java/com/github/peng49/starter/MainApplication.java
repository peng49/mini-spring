package com.github.peng49.starter;

import com.github.peng49.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

public class MainApplication {
    public static void run(Class<?> cls, String[] args) {
        System.out.println("Hello mini spring!");
        try {
            TomcatServer tomcatServer = new TomcatServer(args);
            tomcatServer.startServer();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}

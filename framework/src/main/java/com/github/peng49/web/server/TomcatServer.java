package com.github.peng49.web.server;

import com.github.peng49.web.servlet.TestServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

public class TomcatServer {
    private Tomcat tomcat;

    private String[] args;

    public TomcatServer(String[] args) {
        this.args = args;
    }

    public void startServer() throws LifecycleException {
        tomcat = new Tomcat();
        tomcat.setPort(9999);
        tomcat.start();

        StandardContext context = new StandardContext();
        context.setPath("");//设置路径
        context.addLifecycleListener(new Tomcat.FixContextListener());//生命周期监听器

        //实例化servlet,注册到tomcat内
        TestServlet servlet = new TestServlet();

        Tomcat.addServlet(context, "test-servlet", servlet).setAsyncSupported(true);// 将servlet 注册到context容器内，并设置支持异步

        //添加一个uri映射
        context.addServletMappingDecoded("/test", "test-servlet");

        //将context 容器和 tomcat host 容器关联
        tomcat.getHost().addChild(context);

        //为防止线程退出，添加一个常驻线程
        Thread awaitThread = new Thread("tomcat_await_thread") {
            @Override
            public void run() {
                TomcatServer.this.tomcat.getServer().await();
            }
        };
        awaitThread.setDaemon(false);//非守护线程
        awaitThread.start();
    }
}

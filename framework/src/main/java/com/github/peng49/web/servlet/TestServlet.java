package com.github.peng49.web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class TestServlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.getWriter().println("servlet test");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}

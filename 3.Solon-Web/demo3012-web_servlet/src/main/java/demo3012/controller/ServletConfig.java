package demo3012.controller;

import org.noear.solon.annotation.Configuration;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

@Configuration
public class ServletConfig implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {

    }
}

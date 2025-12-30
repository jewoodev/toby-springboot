package tobyspring.infraconfig.autoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.infraconfig.ConditionalMyOnClass;
import tobyspring.infraconfig.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Value("${contextPath}")
    String contextPath;

    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory tomcatWebServerFactory() {
        var serverFactory = new TomcatServletWebServerFactory();

        System.out.println(this.contextPath);

        serverFactory.setContextPath(this.contextPath);
        return serverFactory;
    }
}

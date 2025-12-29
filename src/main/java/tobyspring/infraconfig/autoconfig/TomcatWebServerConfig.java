package tobyspring.infraconfig.autoconfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.infraconfig.ConditionalMyOnClass;
import tobyspring.infraconfig.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean
    public ServletWebServerFactory tomcatWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
}

package tobyspring.infraconfig.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.infraconfig.ConditionalMyOnClass;
import tobyspring.infraconfig.EnableMyConfigurationProperties;
import tobyspring.infraconfig.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {
    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory tomcatWebServerFactory(ServerProperties serverProperties) {
        var serverFactory = new TomcatServletWebServerFactory();

        serverFactory.setContextPath(serverProperties.getContextPath());
        serverFactory.setPort(serverProperties.getPort());

        return serverFactory;
    }
}

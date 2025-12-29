package tobyspring.infraconfig.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.infraconfig.ConditionalMyOnClass;
import tobyspring.infraconfig.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {
    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory jettyWebServerFactory() {
        return new JettyServletWebServerFactory();
    }
}

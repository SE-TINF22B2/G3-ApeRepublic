package de.aperepublic.server;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link ServerApplication}.
 */
@Generated
public class ServerApplication__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'serverApplication'.
   */
  public static BeanDefinition getServerApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServerApplication.class);
    beanDefinition.setTargetType(ServerApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(ServerApplication.class);
    beanDefinition.setInstanceSupplier(ServerApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}

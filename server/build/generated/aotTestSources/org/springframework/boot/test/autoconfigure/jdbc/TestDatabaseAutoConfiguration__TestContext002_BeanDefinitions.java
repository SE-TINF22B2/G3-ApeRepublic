package org.springframework.boot.test.autoconfigure.jdbc;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TestDatabaseAutoConfiguration}.
 */
@Generated
public class TestDatabaseAutoConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'testDatabaseAutoConfiguration'.
   */
  public static BeanDefinition getTestDatabaseAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestDatabaseAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(TestDatabaseAutoConfiguration::new);
    return beanDefinition;
  }
}

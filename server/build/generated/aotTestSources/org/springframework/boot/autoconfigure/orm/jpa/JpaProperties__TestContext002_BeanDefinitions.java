package org.springframework.boot.autoconfigure.orm.jpa;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JpaProperties}.
 */
@Generated
public class JpaProperties__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'jpaProperties'.
   */
  public static BeanDefinition getJpaPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaProperties.class);
    beanDefinition.setInstanceSupplier(JpaProperties::new);
    return beanDefinition;
  }
}

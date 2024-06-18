package org.springframework.data.jpa.repository.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JpaRepositoryConfigExtension}.
 */
@Generated
public class JpaRepositoryConfigExtension__BeanDefinitions {
  /**
   * Get the bean definition for 'jpaRepositoryConfigExtension#0'.
   */
  public static BeanDefinition getJpaRepositoryConfigExtensionBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaRepositoryConfigExtension.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setLazyInit(true);
    beanDefinition.setInstanceSupplier(JpaRepositoryConfigExtension::new);
    return beanDefinition;
  }
}

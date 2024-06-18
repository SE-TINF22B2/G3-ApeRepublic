package org.springframework.data.repository.core.support;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.repository.config.PropertiesBasedNamedQueriesFactoryBean;

/**
 * Bean definitions for {@link PropertiesBasedNamedQueries}.
 */
@Generated
public class PropertiesBasedNamedQueries__BeanDefinitions {
  /**
   * Get the bean definition for 'named-queries#0'.
   */
  public static BeanDefinition getNamedqueriesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PropertiesBasedNamedQueriesFactoryBean.class);
    beanDefinition.getPropertyValues().addPropertyValue("locations", "classpath*:META-INF/jpa-named-queries.properties");
    beanDefinition.getPropertyValues().addPropertyValue("ignoreResourceNotFound", true);
    beanDefinition.setInstanceSupplier(PropertiesBasedNamedQueriesFactoryBean::new);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'named-queries#1'.
   */
  public static BeanDefinition getNamedqueriesBeanDefinition1() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PropertiesBasedNamedQueriesFactoryBean.class);
    beanDefinition.getPropertyValues().addPropertyValue("locations", "classpath*:META-INF/jpa-named-queries.properties");
    beanDefinition.getPropertyValues().addPropertyValue("ignoreResourceNotFound", true);
    beanDefinition.setInstanceSupplier(PropertiesBasedNamedQueriesFactoryBean::new);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'named-queries#2'.
   */
  public static BeanDefinition getNamedqueriesBeanDefinition2() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PropertiesBasedNamedQueriesFactoryBean.class);
    beanDefinition.getPropertyValues().addPropertyValue("locations", "classpath*:META-INF/jpa-named-queries.properties");
    beanDefinition.getPropertyValues().addPropertyValue("ignoreResourceNotFound", true);
    beanDefinition.setInstanceSupplier(PropertiesBasedNamedQueriesFactoryBean::new);
    return beanDefinition;
  }
}

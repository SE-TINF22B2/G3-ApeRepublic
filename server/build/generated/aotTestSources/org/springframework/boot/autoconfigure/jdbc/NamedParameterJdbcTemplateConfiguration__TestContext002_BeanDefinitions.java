package org.springframework.boot.autoconfigure.jdbc;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Bean definitions for {@link NamedParameterJdbcTemplateConfiguration}.
 */
@Generated
public class NamedParameterJdbcTemplateConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'namedParameterJdbcTemplateConfiguration'.
   */
  public static BeanDefinition getNamedParameterJdbcTemplateConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NamedParameterJdbcTemplateConfiguration.class);
    beanDefinition.setInstanceSupplier(NamedParameterJdbcTemplateConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'namedParameterJdbcTemplate'.
   */
  private static BeanInstanceSupplier<NamedParameterJdbcTemplate> getNamedParameterJdbcTemplateInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NamedParameterJdbcTemplate>forFactoryMethod(NamedParameterJdbcTemplateConfiguration.class, "namedParameterJdbcTemplate", JdbcTemplate.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(NamedParameterJdbcTemplateConfiguration.class).namedParameterJdbcTemplate(args.get(0)));
  }

  /**
   * Get the bean definition for 'namedParameterJdbcTemplate'.
   */
  public static BeanDefinition getNamedParameterJdbcTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NamedParameterJdbcTemplate.class);
    beanDefinition.setPrimary(true);
    beanDefinition.setDependsOn("dataSourceScriptDatabaseInitializer");
    beanDefinition.setInstanceSupplier(getNamedParameterJdbcTemplateInstanceSupplier());
    return beanDefinition;
  }
}

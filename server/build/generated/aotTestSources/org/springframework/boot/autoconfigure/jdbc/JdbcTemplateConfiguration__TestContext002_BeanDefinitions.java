package org.springframework.boot.autoconfigure.jdbc;

import javax.sql.DataSource;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Bean definitions for {@link JdbcTemplateConfiguration}.
 */
@Generated
public class JdbcTemplateConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'jdbcTemplateConfiguration'.
   */
  public static BeanDefinition getJdbcTemplateConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JdbcTemplateConfiguration.class);
    beanDefinition.setInstanceSupplier(JdbcTemplateConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jdbcTemplate'.
   */
  private static BeanInstanceSupplier<JdbcTemplate> getJdbcTemplateInstanceSupplier() {
    return BeanInstanceSupplier.<JdbcTemplate>forFactoryMethod(JdbcTemplateConfiguration.class, "jdbcTemplate", DataSource.class, JdbcProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(JdbcTemplateConfiguration.class).jdbcTemplate(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'jdbcTemplate'.
   */
  public static BeanDefinition getJdbcTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JdbcTemplate.class);
    beanDefinition.setPrimary(true);
    beanDefinition.setDependsOn("dataSourceScriptDatabaseInitializer");
    beanDefinition.setInstanceSupplier(getJdbcTemplateInstanceSupplier());
    return beanDefinition;
  }
}

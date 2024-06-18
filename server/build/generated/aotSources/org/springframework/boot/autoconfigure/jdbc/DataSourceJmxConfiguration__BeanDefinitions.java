package org.springframework.boot.autoconfigure.jdbc;

import javax.sql.DataSource;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DataSourceJmxConfiguration}.
 */
@Generated
public class DataSourceJmxConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'dataSourceJmxConfiguration'.
   */
  public static BeanDefinition getDataSourceJmxConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceJmxConfiguration.class);
    beanDefinition.setInstanceSupplier(DataSourceJmxConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link DataSourceJmxConfiguration.Hikari}.
   */
  @Generated
  public static class Hikari {
    /**
     * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.jdbc.DataSourceJmxConfiguration$Hikari'.
     */
    private static BeanInstanceSupplier<DataSourceJmxConfiguration.Hikari> getHikariInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<DataSourceJmxConfiguration.Hikari>forConstructor(DataSource.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> new DataSourceJmxConfiguration.Hikari(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'hikari'.
     */
    public static BeanDefinition getHikariBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceJmxConfiguration.Hikari.class);
      beanDefinition.setInstanceSupplier(getHikariInstanceSupplier());
      return beanDefinition;
    }
  }
}

package org.springframework.boot.actuate.autoconfigure.jdbc;

import java.util.Map;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.health.HealthContributor;

/**
 * Bean definitions for {@link DataSourceHealthContributorAutoConfiguration}.
 */
@Generated
public class DataSourceHealthContributorAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration'.
   */
  private static BeanInstanceSupplier<DataSourceHealthContributorAutoConfiguration> getDataSourceHealthContributorAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DataSourceHealthContributorAutoConfiguration>forConstructor(ObjectProvider.class)
            .withGenerator((registeredBean, args) -> new DataSourceHealthContributorAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'dataSourceHealthContributorAutoConfiguration'.
   */
  public static BeanDefinition getDataSourceHealthContributorAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceHealthContributorAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getDataSourceHealthContributorAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dbHealthContributor'.
   */
  private static BeanInstanceSupplier<HealthContributor> getDbHealthContributorInstanceSupplier() {
    return BeanInstanceSupplier.<HealthContributor>forFactoryMethod(DataSourceHealthContributorAutoConfiguration.class, "dbHealthContributor", Map.class, DataSourceHealthIndicatorProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DataSourceHealthContributorAutoConfiguration.class).dbHealthContributor(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'dbHealthContributor'.
   */
  public static BeanDefinition getDbHealthContributorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HealthContributor.class);
    beanDefinition.setInstanceSupplier(getDbHealthContributorInstanceSupplier());
    return beanDefinition;
  }
}

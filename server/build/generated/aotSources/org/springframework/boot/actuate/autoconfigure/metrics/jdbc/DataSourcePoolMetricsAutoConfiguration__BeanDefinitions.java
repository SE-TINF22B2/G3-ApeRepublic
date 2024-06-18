package org.springframework.boot.actuate.autoconfigure.metrics.jdbc;

import java.util.Map;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DataSourcePoolMetricsAutoConfiguration}.
 */
@Generated
public class DataSourcePoolMetricsAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'dataSourcePoolMetricsAutoConfiguration'.
   */
  public static BeanDefinition getDataSourcePoolMetricsAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourcePoolMetricsAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(DataSourcePoolMetricsAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration}.
   */
  @Generated
  public static class HikariDataSourceMetricsConfiguration {
    /**
     * Get the bean definition for 'hikariDataSourceMetricsConfiguration'.
     */
    public static BeanDefinition getHikariDataSourceMetricsConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration.class);
      beanDefinition.setInstanceSupplier(DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'hikariDataSourceMeterBinder'.
     */
    private static BeanInstanceSupplier<DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration.HikariDataSourceMeterBinder> getHikariDataSourceMeterBinderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration.HikariDataSourceMeterBinder>forFactoryMethod(DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration.class, "hikariDataSourceMeterBinder", ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration.class).hikariDataSourceMeterBinder(args.get(0)));
    }

    /**
     * Get the bean definition for 'hikariDataSourceMeterBinder'.
     */
    public static BeanDefinition getHikariDataSourceMeterBinderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourcePoolMetricsAutoConfiguration.HikariDataSourceMetricsConfiguration.HikariDataSourceMeterBinder.class);
      beanDefinition.setInstanceSupplier(getHikariDataSourceMeterBinderInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration}.
   */
  @Generated
  public static class DataSourcePoolMetadataMetricsConfiguration {
    /**
     * Get the bean definition for 'dataSourcePoolMetadataMetricsConfiguration'.
     */
    public static BeanDefinition getDataSourcePoolMetadataMetricsConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration.class);
      beanDefinition.setInstanceSupplier(DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'dataSourcePoolMetadataMeterBinder'.
     */
    private static BeanInstanceSupplier<DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration.DataSourcePoolMetadataMeterBinder> getDataSourcePoolMetadataMeterBinderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration.DataSourcePoolMetadataMeterBinder>forFactoryMethod(DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration.class, "dataSourcePoolMetadataMeterBinder", Map.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration.class).dataSourcePoolMetadataMeterBinder(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'dataSourcePoolMetadataMeterBinder'.
     */
    public static BeanDefinition getDataSourcePoolMetadataMeterBinderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourcePoolMetricsAutoConfiguration.DataSourcePoolMetadataMetricsConfiguration.DataSourcePoolMetadataMeterBinder.class);
      beanDefinition.setInstanceSupplier(getDataSourcePoolMetadataMeterBinderInstanceSupplier());
      return beanDefinition;
    }
  }
}

package org.springframework.boot.actuate.autoconfigure.metrics.data;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.boot.actuate.metrics.data.DefaultRepositoryTagsProvider;
import org.springframework.boot.actuate.metrics.data.MetricsRepositoryMethodInvocationListener;
import org.springframework.boot.actuate.metrics.data.RepositoryTagsProvider;

/**
 * Bean definitions for {@link RepositoryMetricsAutoConfiguration}.
 */
@Generated
public class RepositoryMetricsAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.actuate.autoconfigure.metrics.data.RepositoryMetricsAutoConfiguration'.
   */
  private static BeanInstanceSupplier<RepositoryMetricsAutoConfiguration> getRepositoryMetricsAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RepositoryMetricsAutoConfiguration>forConstructor(MetricsProperties.class)
            .withGenerator((registeredBean, args) -> new RepositoryMetricsAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'repositoryMetricsAutoConfiguration'.
   */
  public static BeanDefinition getRepositoryMetricsAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositoryMetricsAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getRepositoryMetricsAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'repositoryTagsProvider'.
   */
  private static BeanInstanceSupplier<DefaultRepositoryTagsProvider> getRepositoryTagsProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DefaultRepositoryTagsProvider>forFactoryMethod(RepositoryMetricsAutoConfiguration.class, "repositoryTagsProvider")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(RepositoryMetricsAutoConfiguration.class).repositoryTagsProvider());
  }

  /**
   * Get the bean definition for 'repositoryTagsProvider'.
   */
  public static BeanDefinition getRepositoryTagsProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DefaultRepositoryTagsProvider.class);
    beanDefinition.setInstanceSupplier(getRepositoryTagsProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'metricsRepositoryMethodInvocationListener'.
   */
  private static BeanInstanceSupplier<MetricsRepositoryMethodInvocationListener> getMetricsRepositoryMethodInvocationListenerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MetricsRepositoryMethodInvocationListener>forFactoryMethod(RepositoryMetricsAutoConfiguration.class, "metricsRepositoryMethodInvocationListener", ObjectProvider.class, RepositoryTagsProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RepositoryMetricsAutoConfiguration.class).metricsRepositoryMethodInvocationListener(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'metricsRepositoryMethodInvocationListener'.
   */
  public static BeanDefinition getMetricsRepositoryMethodInvocationListenerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MetricsRepositoryMethodInvocationListener.class);
    beanDefinition.setInstanceSupplier(getMetricsRepositoryMethodInvocationListenerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'metricsRepositoryMethodInvocationListenerBeanPostProcessor'.
   */
  private static BeanInstanceSupplier<MetricsRepositoryMethodInvocationListenerBeanPostProcessor> getMetricsRepositoryMethodInvocationListenerBeanPostProcessorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MetricsRepositoryMethodInvocationListenerBeanPostProcessor>forFactoryMethod(RepositoryMetricsAutoConfiguration.class, "metricsRepositoryMethodInvocationListenerBeanPostProcessor", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> RepositoryMetricsAutoConfiguration.metricsRepositoryMethodInvocationListenerBeanPostProcessor(args.get(0)));
  }

  /**
   * Get the bean definition for 'metricsRepositoryMethodInvocationListenerBeanPostProcessor'.
   */
  public static BeanDefinition getMetricsRepositoryMethodInvocationListenerBeanPostProcessorBeanDefinition(
      ) {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositoryMetricsAutoConfiguration.class);
    beanDefinition.setTargetType(MetricsRepositoryMethodInvocationListenerBeanPostProcessor.class);
    beanDefinition.setInstanceSupplier(getMetricsRepositoryMethodInvocationListenerBeanPostProcessorInstanceSupplier());
    return beanDefinition;
  }
}

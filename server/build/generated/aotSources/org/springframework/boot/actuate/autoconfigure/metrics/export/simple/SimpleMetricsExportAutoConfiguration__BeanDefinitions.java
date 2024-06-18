package org.springframework.boot.actuate.autoconfigure.metrics.export.simple;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.simple.SimpleConfig;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SimpleMetricsExportAutoConfiguration}.
 */
@Generated
public class SimpleMetricsExportAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'simpleMetricsExportAutoConfiguration'.
   */
  public static BeanDefinition getSimpleMetricsExportAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleMetricsExportAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(SimpleMetricsExportAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'simpleMeterRegistry'.
   */
  private static BeanInstanceSupplier<SimpleMeterRegistry> getSimpleMeterRegistryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SimpleMeterRegistry>forFactoryMethod(SimpleMetricsExportAutoConfiguration.class, "simpleMeterRegistry", SimpleConfig.class, Clock.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SimpleMetricsExportAutoConfiguration.class).simpleMeterRegistry(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'simpleMeterRegistry'.
   */
  public static BeanDefinition getSimpleMeterRegistryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleMeterRegistry.class);
    beanDefinition.setDestroyMethodNames("close");
    beanDefinition.setInstanceSupplier(getSimpleMeterRegistryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'simpleConfig'.
   */
  private static BeanInstanceSupplier<SimpleConfig> getSimpleConfigInstanceSupplier() {
    return BeanInstanceSupplier.<SimpleConfig>forFactoryMethod(SimpleMetricsExportAutoConfiguration.class, "simpleConfig", SimpleProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SimpleMetricsExportAutoConfiguration.class).simpleConfig(args.get(0)));
  }

  /**
   * Get the bean definition for 'simpleConfig'.
   */
  public static BeanDefinition getSimpleConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleConfig.class);
    beanDefinition.setInstanceSupplier(getSimpleConfigInstanceSupplier());
    return beanDefinition;
  }
}

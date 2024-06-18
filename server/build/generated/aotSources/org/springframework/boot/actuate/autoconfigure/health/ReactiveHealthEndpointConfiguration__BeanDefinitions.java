package org.springframework.boot.actuate.autoconfigure.health;

import java.util.Map;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.health.HealthEndpointGroups;
import org.springframework.boot.actuate.health.ReactiveHealthContributorRegistry;

/**
 * Bean definitions for {@link ReactiveHealthEndpointConfiguration}.
 */
@Generated
public class ReactiveHealthEndpointConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'reactiveHealthEndpointConfiguration'.
   */
  public static BeanDefinition getReactiveHealthEndpointConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveHealthEndpointConfiguration.class);
    beanDefinition.setInstanceSupplier(ReactiveHealthEndpointConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'reactiveHealthContributorRegistry'.
   */
  private static BeanInstanceSupplier<ReactiveHealthContributorRegistry> getReactiveHealthContributorRegistryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReactiveHealthContributorRegistry>forFactoryMethod(ReactiveHealthEndpointConfiguration.class, "reactiveHealthContributorRegistry", Map.class, Map.class, HealthEndpointGroups.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ReactiveHealthEndpointConfiguration.class).reactiveHealthContributorRegistry(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'reactiveHealthContributorRegistry'.
   */
  public static BeanDefinition getReactiveHealthContributorRegistryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveHealthContributorRegistry.class);
    beanDefinition.setInstanceSupplier(getReactiveHealthContributorRegistryInstanceSupplier());
    return beanDefinition;
  }
}

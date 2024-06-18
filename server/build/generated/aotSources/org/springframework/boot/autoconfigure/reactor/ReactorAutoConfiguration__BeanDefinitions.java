package org.springframework.boot.autoconfigure.reactor;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReactorAutoConfiguration}.
 */
@Generated
public class ReactorAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.reactor.ReactorAutoConfiguration'.
   */
  private static BeanInstanceSupplier<ReactorAutoConfiguration> getReactorAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReactorAutoConfiguration>forConstructor(ReactorProperties.class)
            .withGenerator((registeredBean, args) -> new ReactorAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'reactorAutoConfiguration'.
   */
  public static BeanDefinition getReactorAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactorAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getReactorAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }
}

package org.springframework.boot.autoconfigure.reactor.netty;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.http.client.ReactorResourceFactory;

/**
 * Bean definitions for {@link ReactorNettyConfigurations}.
 */
@Generated
public class ReactorNettyConfigurations__BeanDefinitions {
  /**
   * Bean definitions for {@link ReactorNettyConfigurations.ReactorResourceFactoryConfiguration}.
   */
  @Generated
  public static class ReactorResourceFactoryConfiguration {
    /**
     * Get the bean definition for 'reactorResourceFactoryConfiguration'.
     */
    public static BeanDefinition getReactorResourceFactoryConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactorNettyConfigurations.ReactorResourceFactoryConfiguration.class);
      beanDefinition.setInstanceSupplier(ReactorNettyConfigurations.ReactorResourceFactoryConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'reactorResourceFactory'.
     */
    private static BeanInstanceSupplier<ReactorResourceFactory> getReactorResourceFactoryInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ReactorResourceFactory>forFactoryMethod(ReactorNettyConfigurations.ReactorResourceFactoryConfiguration.class, "reactorResourceFactory", ReactorNettyProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ReactorNettyConfigurations.ReactorResourceFactoryConfiguration.class).reactorResourceFactory(args.get(0)));
    }

    /**
     * Get the bean definition for 'reactorResourceFactory'.
     */
    public static BeanDefinition getReactorResourceFactoryBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactorResourceFactory.class);
      beanDefinition.setInstanceSupplier(getReactorResourceFactoryInstanceSupplier());
      return beanDefinition;
    }
  }
}

package org.springframework.boot.autoconfigure.web.reactive.function.client;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.http.client.ReactorResourceFactory;

/**
 * Bean definitions for {@link ClientHttpConnectorFactoryConfiguration}.
 */
@Generated
public class ClientHttpConnectorFactoryConfiguration__BeanDefinitions {
  /**
   * Bean definitions for {@link ClientHttpConnectorFactoryConfiguration.ReactorNetty}.
   */
  @Generated
  public static class ReactorNetty {
    /**
     * Get the bean definition for 'reactorNetty'.
     */
    public static BeanDefinition getReactorNettyBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ClientHttpConnectorFactoryConfiguration.ReactorNetty.class);
      beanDefinition.setInstanceSupplier(ClientHttpConnectorFactoryConfiguration.ReactorNetty::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'reactorClientHttpConnectorFactory'.
     */
    private static BeanInstanceSupplier<ReactorClientHttpConnectorFactory> getReactorClientHttpConnectorFactoryInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ReactorClientHttpConnectorFactory>forFactoryMethod(ClientHttpConnectorFactoryConfiguration.ReactorNetty.class, "reactorClientHttpConnectorFactory", ReactorResourceFactory.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ClientHttpConnectorFactoryConfiguration.ReactorNetty.class).reactorClientHttpConnectorFactory(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'reactorClientHttpConnectorFactory'.
     */
    public static BeanDefinition getReactorClientHttpConnectorFactoryBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactorClientHttpConnectorFactory.class);
      beanDefinition.setInstanceSupplier(getReactorClientHttpConnectorFactoryInstanceSupplier());
      return beanDefinition;
    }
  }
}

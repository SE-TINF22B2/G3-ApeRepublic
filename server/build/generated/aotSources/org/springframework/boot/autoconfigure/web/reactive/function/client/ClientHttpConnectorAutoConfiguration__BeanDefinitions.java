package org.springframework.boot.autoconfigure.web.reactive.function.client;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.http.client.reactive.ClientHttpConnector;

/**
 * Bean definitions for {@link ClientHttpConnectorAutoConfiguration}.
 */
@Generated
public class ClientHttpConnectorAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'clientHttpConnectorAutoConfiguration'.
   */
  public static BeanDefinition getClientHttpConnectorAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ClientHttpConnectorAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ClientHttpConnectorAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webClientHttpConnector'.
   */
  private static BeanInstanceSupplier<ClientHttpConnector> getWebClientHttpConnectorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ClientHttpConnector>forFactoryMethod(ClientHttpConnectorAutoConfiguration.class, "webClientHttpConnector", ClientHttpConnectorFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ClientHttpConnectorAutoConfiguration.class).webClientHttpConnector(args.get(0)));
  }

  /**
   * Get the bean definition for 'webClientHttpConnector'.
   */
  public static BeanDefinition getWebClientHttpConnectorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ClientHttpConnector.class);
    beanDefinition.setLazyInit(true);
    beanDefinition.setInstanceSupplier(getWebClientHttpConnectorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webClientHttpConnectorCustomizer'.
   */
  private static BeanInstanceSupplier<WebClientCustomizer> getWebClientHttpConnectorCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebClientCustomizer>forFactoryMethod(ClientHttpConnectorAutoConfiguration.class, "webClientHttpConnectorCustomizer", ClientHttpConnector.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ClientHttpConnectorAutoConfiguration.class).webClientHttpConnectorCustomizer(args.get(0)));
  }

  /**
   * Get the bean definition for 'webClientHttpConnectorCustomizer'.
   */
  public static BeanDefinition getWebClientHttpConnectorCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebClientCustomizer.class);
    beanDefinition.setLazyInit(true);
    beanDefinition.setInstanceSupplier(getWebClientHttpConnectorCustomizerInstanceSupplier());
    return beanDefinition;
  }
}

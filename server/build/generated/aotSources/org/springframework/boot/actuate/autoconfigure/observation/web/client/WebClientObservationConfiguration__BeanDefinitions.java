package org.springframework.boot.actuate.autoconfigure.observation.web.client;

import io.micrometer.observation.ObservationRegistry;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.boot.actuate.metrics.web.reactive.client.ObservationWebClientCustomizer;

/**
 * Bean definitions for {@link WebClientObservationConfiguration}.
 */
@Generated
public class WebClientObservationConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'webClientObservationConfiguration'.
   */
  public static BeanDefinition getWebClientObservationConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebClientObservationConfiguration.class);
    beanDefinition.setInstanceSupplier(WebClientObservationConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'observationWebClientCustomizer'.
   */
  private static BeanInstanceSupplier<ObservationWebClientCustomizer> getObservationWebClientCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ObservationWebClientCustomizer>forFactoryMethod(WebClientObservationConfiguration.class, "observationWebClientCustomizer", ObservationRegistry.class, ObjectProvider.class, ObservationProperties.class, MetricsProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebClientObservationConfiguration.class).observationWebClientCustomizer(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'observationWebClientCustomizer'.
   */
  public static BeanDefinition getObservationWebClientCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ObservationWebClientCustomizer.class);
    beanDefinition.setInstanceSupplier(getObservationWebClientCustomizerInstanceSupplier());
    return beanDefinition;
  }
}

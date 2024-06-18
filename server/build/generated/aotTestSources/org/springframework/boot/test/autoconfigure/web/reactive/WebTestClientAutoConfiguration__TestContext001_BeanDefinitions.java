package org.springframework.boot.test.autoconfigure.web.reactive;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link WebTestClientAutoConfiguration}.
 */
@Generated
public class WebTestClientAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'webTestClientAutoConfiguration'.
   */
  public static BeanDefinition getWebTestClientAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebTestClientAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(WebTestClientAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springBootWebTestClientBuilderCustomizer'.
   */
  private static BeanInstanceSupplier<SpringBootWebTestClientBuilderCustomizer> getSpringBootWebTestClientBuilderCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringBootWebTestClientBuilderCustomizer>forFactoryMethod(WebTestClientAutoConfiguration.class, "springBootWebTestClientBuilderCustomizer", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebTestClientAutoConfiguration.class).springBootWebTestClientBuilderCustomizer(args.get(0)));
  }

  /**
   * Get the bean definition for 'springBootWebTestClientBuilderCustomizer'.
   */
  public static BeanDefinition getSpringBootWebTestClientBuilderCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringBootWebTestClientBuilderCustomizer.class);
    beanDefinition.setInstanceSupplier(getSpringBootWebTestClientBuilderCustomizerInstanceSupplier());
    return beanDefinition;
  }
}

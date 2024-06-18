package de.aperepublic.server.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.web.client.RestTemplate;

/**
 * Bean definitions for {@link RestTemplateConfig}.
 */
@Generated
public class RestTemplateConfig__TestContext003_BeanDefinitions {
  /**
   * Get the bean definition for 'restTemplateConfig'.
   */
  public static BeanDefinition getRestTemplateConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RestTemplateConfig.class);
    beanDefinition.setTargetType(RestTemplateConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(RestTemplateConfig.class);
    beanDefinition.setInstanceSupplier(RestTemplateConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'restTemplate'.
   */
  private static BeanInstanceSupplier<RestTemplate> getRestTemplateInstanceSupplier() {
    return BeanInstanceSupplier.<RestTemplate>forFactoryMethod(RestTemplateConfig.class, "restTemplate", RestTemplateBuilder.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RestTemplateConfig.class).restTemplate(args.get(0)));
  }

  /**
   * Get the bean definition for 'restTemplate'.
   */
  public static BeanDefinition getRestTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RestTemplate.class);
    beanDefinition.setInstanceSupplier(getRestTemplateInstanceSupplier());
    return beanDefinition;
  }
}

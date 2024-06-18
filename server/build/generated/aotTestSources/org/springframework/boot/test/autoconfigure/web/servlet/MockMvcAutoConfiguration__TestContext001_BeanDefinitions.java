package org.springframework.boot.test.autoconfigure.web.servlet;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

/**
 * Bean definitions for {@link MockMvcAutoConfiguration}.
 */
@Generated
public class MockMvcAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration'.
   */
  private static BeanInstanceSupplier<MockMvcAutoConfiguration> getMockMvcAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MockMvcAutoConfiguration>forConstructor(WebApplicationContext.class, WebMvcProperties.class)
            .withGenerator((registeredBean, args) -> new MockMvcAutoConfiguration(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'mockMvcAutoConfiguration'.
   */
  public static BeanDefinition getMockMvcAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MockMvcAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getMockMvcAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mockMvcBuilder'.
   */
  private static BeanInstanceSupplier<DefaultMockMvcBuilder> getMockMvcBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<DefaultMockMvcBuilder>forFactoryMethod(MockMvcAutoConfiguration.class, "mockMvcBuilder", List.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MockMvcAutoConfiguration.class).mockMvcBuilder(args.get(0)));
  }

  /**
   * Get the bean definition for 'mockMvcBuilder'.
   */
  public static BeanDefinition getMockMvcBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DefaultMockMvcBuilder.class);
    beanDefinition.setInstanceSupplier(getMockMvcBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springBootMockMvcBuilderCustomizer'.
   */
  private static BeanInstanceSupplier<SpringBootMockMvcBuilderCustomizer> getSpringBootMockMvcBuilderCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringBootMockMvcBuilderCustomizer>forFactoryMethod(MockMvcAutoConfiguration.class, "springBootMockMvcBuilderCustomizer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(MockMvcAutoConfiguration.class).springBootMockMvcBuilderCustomizer());
  }

  /**
   * Get the bean definition for 'springBootMockMvcBuilderCustomizer'.
   */
  public static BeanDefinition getSpringBootMockMvcBuilderCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringBootMockMvcBuilderCustomizer.class);
    beanDefinition.setInstanceSupplier(getSpringBootMockMvcBuilderCustomizerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mockMvc'.
   */
  private static BeanInstanceSupplier<MockMvc> getMockMvcInstanceSupplier() {
    return BeanInstanceSupplier.<MockMvc>forFactoryMethod(MockMvcAutoConfiguration.class, "mockMvc", MockMvcBuilder.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MockMvcAutoConfiguration.class).mockMvc(args.get(0)));
  }

  /**
   * Get the bean definition for 'mockMvc'.
   */
  public static BeanDefinition getMockMvcBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MockMvc.class);
    beanDefinition.setInstanceSupplier(getMockMvcInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link MockMvcAutoConfiguration.WebTestClientMockMvcConfiguration}.
   */
  @Generated
  public static class WebTestClientMockMvcConfiguration {
    /**
     * Get the bean definition for 'webTestClientMockMvcConfiguration'.
     */
    public static BeanDefinition getWebTestClientMockMvcConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(MockMvcAutoConfiguration.WebTestClientMockMvcConfiguration.class);
      beanDefinition.setInstanceSupplier(MockMvcAutoConfiguration.WebTestClientMockMvcConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'webTestClient'.
     */
    private static BeanInstanceSupplier<WebTestClient> getWebTestClientInstanceSupplier() {
      return BeanInstanceSupplier.<WebTestClient>forFactoryMethod(MockMvcAutoConfiguration.WebTestClientMockMvcConfiguration.class, "webTestClient", MockMvc.class, List.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MockMvcAutoConfiguration.WebTestClientMockMvcConfiguration.class).webTestClient(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'webTestClient'.
     */
    public static BeanDefinition getWebTestClientBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebTestClient.class);
      beanDefinition.setInstanceSupplier(getWebTestClientInstanceSupplier());
      return beanDefinition;
    }
  }
}

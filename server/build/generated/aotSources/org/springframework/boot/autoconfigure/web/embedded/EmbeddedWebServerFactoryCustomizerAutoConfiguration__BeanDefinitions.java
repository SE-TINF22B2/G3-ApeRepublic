package org.springframework.boot.autoconfigure.web.embedded;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.env.Environment;

/**
 * Bean definitions for {@link EmbeddedWebServerFactoryCustomizerAutoConfiguration}.
 */
@Generated
public class EmbeddedWebServerFactoryCustomizerAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'embeddedWebServerFactoryCustomizerAutoConfiguration'.
   */
  public static BeanDefinition getEmbeddedWebServerFactoryCustomizerAutoConfigurationBeanDefinition(
      ) {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EmbeddedWebServerFactoryCustomizerAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(EmbeddedWebServerFactoryCustomizerAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link EmbeddedWebServerFactoryCustomizerAutoConfiguration.TomcatWebServerFactoryCustomizerConfiguration}.
   */
  @Generated
  public static class TomcatWebServerFactoryCustomizerConfiguration {
    /**
     * Get the bean definition for 'tomcatWebServerFactoryCustomizerConfiguration'.
     */
    public static BeanDefinition getTomcatWebServerFactoryCustomizerConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EmbeddedWebServerFactoryCustomizerAutoConfiguration.TomcatWebServerFactoryCustomizerConfiguration.class);
      beanDefinition.setInstanceSupplier(EmbeddedWebServerFactoryCustomizerAutoConfiguration.TomcatWebServerFactoryCustomizerConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'tomcatWebServerFactoryCustomizer'.
     */
    private static BeanInstanceSupplier<TomcatWebServerFactoryCustomizer> getTomcatWebServerFactoryCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<TomcatWebServerFactoryCustomizer>forFactoryMethod(EmbeddedWebServerFactoryCustomizerAutoConfiguration.TomcatWebServerFactoryCustomizerConfiguration.class, "tomcatWebServerFactoryCustomizer", Environment.class, ServerProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EmbeddedWebServerFactoryCustomizerAutoConfiguration.TomcatWebServerFactoryCustomizerConfiguration.class).tomcatWebServerFactoryCustomizer(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'tomcatWebServerFactoryCustomizer'.
     */
    public static BeanDefinition getTomcatWebServerFactoryCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TomcatWebServerFactoryCustomizer.class);
      beanDefinition.setInstanceSupplier(getTomcatWebServerFactoryCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link EmbeddedWebServerFactoryCustomizerAutoConfiguration.NettyWebServerFactoryCustomizerConfiguration}.
   */
  @Generated
  public static class NettyWebServerFactoryCustomizerConfiguration {
    /**
     * Get the bean definition for 'nettyWebServerFactoryCustomizerConfiguration'.
     */
    public static BeanDefinition getNettyWebServerFactoryCustomizerConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EmbeddedWebServerFactoryCustomizerAutoConfiguration.NettyWebServerFactoryCustomizerConfiguration.class);
      beanDefinition.setInstanceSupplier(EmbeddedWebServerFactoryCustomizerAutoConfiguration.NettyWebServerFactoryCustomizerConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'nettyWebServerFactoryCustomizer'.
     */
    private static BeanInstanceSupplier<NettyWebServerFactoryCustomizer> getNettyWebServerFactoryCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<NettyWebServerFactoryCustomizer>forFactoryMethod(EmbeddedWebServerFactoryCustomizerAutoConfiguration.NettyWebServerFactoryCustomizerConfiguration.class, "nettyWebServerFactoryCustomizer", Environment.class, ServerProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EmbeddedWebServerFactoryCustomizerAutoConfiguration.NettyWebServerFactoryCustomizerConfiguration.class).nettyWebServerFactoryCustomizer(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'nettyWebServerFactoryCustomizer'.
     */
    public static BeanDefinition getNettyWebServerFactoryCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(NettyWebServerFactoryCustomizer.class);
      beanDefinition.setInstanceSupplier(getNettyWebServerFactoryCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }
}

package org.springframework.boot.autoconfigure.http.codec;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.codec.CodecProperties;
import org.springframework.boot.web.codec.CodecCustomizer;

/**
 * Bean definitions for {@link CodecsAutoConfiguration}.
 */
@Generated
public class CodecsAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'codecsAutoConfiguration'.
   */
  public static BeanDefinition getCodecsAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CodecsAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(CodecsAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link CodecsAutoConfiguration.DefaultCodecsConfiguration}.
   */
  @Generated
  public static class DefaultCodecsConfiguration {
    /**
     * Get the bean definition for 'defaultCodecsConfiguration'.
     */
    public static BeanDefinition getDefaultCodecsConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(CodecsAutoConfiguration.DefaultCodecsConfiguration.class);
      beanDefinition.setInstanceSupplier(CodecsAutoConfiguration.DefaultCodecsConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'defaultCodecCustomizer'.
     */
    private static BeanInstanceSupplier<CodecCustomizer> getDefaultCodecCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<CodecCustomizer>forFactoryMethod(CodecsAutoConfiguration.DefaultCodecsConfiguration.class, "defaultCodecCustomizer", CodecProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CodecsAutoConfiguration.DefaultCodecsConfiguration.class).defaultCodecCustomizer(args.get(0)));
    }

    /**
     * Get the bean definition for 'defaultCodecCustomizer'.
     */
    public static BeanDefinition getDefaultCodecCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(CodecCustomizer.class);
      beanDefinition.setInstanceSupplier(getDefaultCodecCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link CodecsAutoConfiguration.JacksonCodecConfiguration}.
   */
  @Generated
  public static class JacksonCodecConfiguration {
    /**
     * Get the bean definition for 'jacksonCodecConfiguration'.
     */
    public static BeanDefinition getJacksonCodecConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(CodecsAutoConfiguration.JacksonCodecConfiguration.class);
      beanDefinition.setInstanceSupplier(CodecsAutoConfiguration.JacksonCodecConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'jacksonCodecCustomizer'.
     */
    private static BeanInstanceSupplier<CodecCustomizer> getJacksonCodecCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<CodecCustomizer>forFactoryMethod(CodecsAutoConfiguration.JacksonCodecConfiguration.class, "jacksonCodecCustomizer", ObjectMapper.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CodecsAutoConfiguration.JacksonCodecConfiguration.class).jacksonCodecCustomizer(args.get(0)));
    }

    /**
     * Get the bean definition for 'jacksonCodecCustomizer'.
     */
    public static BeanDefinition getJacksonCodecCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(CodecCustomizer.class);
      beanDefinition.setInstanceSupplier(getJacksonCodecCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }
}

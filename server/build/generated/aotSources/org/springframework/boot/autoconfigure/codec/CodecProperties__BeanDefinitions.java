package org.springframework.boot.autoconfigure.codec;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CodecProperties}.
 */
@Generated
public class CodecProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'codecProperties'.
   */
  public static BeanDefinition getCodecPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CodecProperties.class);
    beanDefinition.setInstanceSupplier(CodecProperties::new);
    return beanDefinition;
  }
}

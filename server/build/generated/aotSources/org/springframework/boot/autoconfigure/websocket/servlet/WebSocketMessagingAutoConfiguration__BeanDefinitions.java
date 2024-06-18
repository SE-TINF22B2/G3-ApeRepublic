package org.springframework.boot.autoconfigure.websocket.servlet;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link WebSocketMessagingAutoConfiguration}.
 */
@Generated
public class WebSocketMessagingAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'webSocketMessagingAutoConfiguration'.
   */
  public static BeanDefinition getWebSocketMessagingAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSocketMessagingAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(WebSocketMessagingAutoConfiguration::new);
    return beanDefinition;
  }
}

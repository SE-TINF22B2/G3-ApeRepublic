package org.springframework.boot.autoconfigure.netty;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NettyAutoConfiguration}.
 */
@Generated
public class NettyAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.netty.NettyAutoConfiguration'.
   */
  private static BeanInstanceSupplier<NettyAutoConfiguration> getNettyAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NettyAutoConfiguration>forConstructor(NettyProperties.class)
            .withGenerator((registeredBean, args) -> new NettyAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'nettyAutoConfiguration'.
   */
  public static BeanDefinition getNettyAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NettyAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getNettyAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }
}

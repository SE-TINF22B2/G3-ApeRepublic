package de.aperepublic.server.config;

import de.aperepublic.server.services.FinnhubStockPriceService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link FinnhubStockPriceConfig}.
 */
@Generated
public class FinnhubStockPriceConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'finnhubStockPriceConfig'.
   */
  public static BeanDefinition getFinnhubStockPriceConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FinnhubStockPriceConfig.class);
    beanDefinition.setTargetType(FinnhubStockPriceConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(FinnhubStockPriceConfig.class);
    beanDefinition.setInstanceSupplier(FinnhubStockPriceConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'runner'.
   */
  private static BeanInstanceSupplier<ApplicationRunner> getRunnerInstanceSupplier() {
    return BeanInstanceSupplier.<ApplicationRunner>forFactoryMethod(FinnhubStockPriceConfig.class, "runner", FinnhubStockPriceService.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(FinnhubStockPriceConfig.class).runner(args.get(0)));
  }

  /**
   * Get the bean definition for 'runner'.
   */
  public static BeanDefinition getRunnerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ApplicationRunner.class);
    beanDefinition.setInstanceSupplier(getRunnerInstanceSupplier());
    return beanDefinition;
  }
}

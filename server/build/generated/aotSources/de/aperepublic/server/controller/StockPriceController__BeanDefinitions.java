package de.aperepublic.server.controller;

import de.aperepublic.server.services.FinnhubStockPriceService;
import de.aperepublic.server.services.StockPriceService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link StockPriceController}.
 */
@Generated
public class StockPriceController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'stockPriceController'.
   */
  private static BeanInstanceSupplier<StockPriceController> getStockPriceControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<StockPriceController>forConstructor(StockPriceService.class, FinnhubStockPriceService.class)
            .withGenerator((registeredBean, args) -> new StockPriceController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'stockPriceController'.
   */
  public static BeanDefinition getStockPriceControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(StockPriceController.class);
    InstanceSupplier<StockPriceController> instanceSupplier = getStockPriceControllerInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(StockPriceController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}

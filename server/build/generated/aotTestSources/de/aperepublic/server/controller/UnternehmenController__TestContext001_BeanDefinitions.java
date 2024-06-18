package de.aperepublic.server.controller;

import de.aperepublic.server.services.FinnhubCompanyProfile2Service;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UnternehmenController}.
 */
@Generated
public class UnternehmenController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'unternehmenController'.
   */
  private static BeanInstanceSupplier<UnternehmenController> getUnternehmenControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<UnternehmenController>forConstructor(FinnhubCompanyProfile2Service.class)
            .withGenerator((registeredBean, args) -> new UnternehmenController(args.get(0)));
  }

  /**
   * Get the bean definition for 'unternehmenController'.
   */
  public static BeanDefinition getUnternehmenControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UnternehmenController.class);
    beanDefinition.setInstanceSupplier(getUnternehmenControllerInstanceSupplier());
    return beanDefinition;
  }
}

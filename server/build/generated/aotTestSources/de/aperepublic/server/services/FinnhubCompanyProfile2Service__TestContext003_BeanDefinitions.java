package de.aperepublic.server.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.web.client.RestTemplate;

/**
 * Bean definitions for {@link FinnhubCompanyProfile2Service}.
 */
@Generated
public class FinnhubCompanyProfile2Service__TestContext003_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'finnhubCompanyProfile2Service'.
   */
  private static BeanInstanceSupplier<FinnhubCompanyProfile2Service> getFinnhubCompanyProfileServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FinnhubCompanyProfile2Service>forConstructor(RestTemplate.class)
            .withGenerator((registeredBean, args) -> new FinnhubCompanyProfile2Service(args.get(0)));
  }

  /**
   * Get the bean definition for 'finnhubCompanyProfile2Service'.
   */
  public static BeanDefinition getFinnhubCompanyProfileServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FinnhubCompanyProfile2Service.class);
    beanDefinition.setInstanceSupplier(getFinnhubCompanyProfileServiceInstanceSupplier());
    return beanDefinition;
  }
}

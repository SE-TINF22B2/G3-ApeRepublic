package org.springframework.boot.test.context;

import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ImportsContextCustomizer}.
 */
@Generated
public class ImportsContextCustomizer__TestContext002_BeanDefinitions {
  /**
   * Bean definitions for {@link ImportsContextCustomizer.ImportsCleanupPostProcessor}.
   */
  @Generated
  public static class ImportsCleanupPostProcessor {
    /**
     * Get the bean instance supplier for 'org.springframework.boot.test.context.ImportsContextCustomizer$ImportsCleanupPostProcessor'.
     */
    private static BeanInstanceSupplier<ImportsContextCustomizer.ImportsCleanupPostProcessor> getImportsCleanupPostProcessorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ImportsContextCustomizer.ImportsCleanupPostProcessor>forConstructor(String.class)
              .withGenerator((registeredBean, args) -> new ImportsContextCustomizer.ImportsCleanupPostProcessor(args.get(0)));
    }

    /**
     * Get the bean definition for 'importsCleanupPostProcessor'.
     */
    public static BeanDefinition getImportsCleanupPostProcessorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ImportsContextCustomizer.ImportsCleanupPostProcessor.class);
      beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
      beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, "de.aperepublic.server.Repository.StockRepositoryTest");
      beanDefinition.setInstanceSupplier(getImportsCleanupPostProcessorInstanceSupplier());
      return beanDefinition;
    }
  }
}

package org.springframework.boot.autoconfigure.domain;

import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link EntityScanPackages}.
 */
@Generated
public class EntityScanPackages__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.domain.EntityScanPackages'.
   */
  private static BeanInstanceSupplier<EntityScanPackages> getEntityScanPackagesInstanceSupplier() {
    return BeanInstanceSupplier.<EntityScanPackages>forConstructor(String[].class)
            .withGenerator((registeredBean, args) -> new EntityScanPackages(args.get(0)));
  }

  /**
   * Get the bean definition for 'entityScanPackages'.
   */
  public static BeanDefinition getEntityScanPackagesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EntityScanPackages.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, new String[] {"de.aperepublic.server.Entity"});
    beanDefinition.setInstanceSupplier(getEntityScanPackagesInstanceSupplier());
    return beanDefinition;
  }
}

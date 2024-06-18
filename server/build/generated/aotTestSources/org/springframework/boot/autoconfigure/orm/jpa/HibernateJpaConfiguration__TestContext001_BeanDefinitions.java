package org.springframework.boot.autoconfigure.orm.jpa;

import javax.sql.DataSource;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HibernateJpaConfiguration}.
 */
@Generated
public class HibernateJpaConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaConfiguration'.
   */
  private static BeanInstanceSupplier<HibernateJpaConfiguration> getHibernateJpaConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HibernateJpaConfiguration>forConstructor(DataSource.class, JpaProperties.class, ConfigurableListableBeanFactory.class, ObjectProvider.class, HibernateProperties.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> new HibernateJpaConfiguration(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7), args.get(8), args.get(9)));
  }

  /**
   * Get the bean definition for 'hibernateJpaConfiguration'.
   */
  public static BeanDefinition getHibernateJpaConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HibernateJpaConfiguration.class);
    beanDefinition.setInstanceSupplier(getHibernateJpaConfigurationInstanceSupplier());
    return beanDefinition;
  }
}

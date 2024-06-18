package org.springframework.boot.autoconfigure.orm.jpa;

import java.lang.String;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceManagedTypes;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Bean definitions for {@link JpaBaseConfiguration}.
 */
@Generated
public class JpaBaseConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'transactionManager'.
   */
  private static BeanInstanceSupplier<PlatformTransactionManager> getTransactionManagerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PlatformTransactionManager>forFactoryMethod(JpaBaseConfiguration.class, "transactionManager", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(JpaBaseConfiguration.class).transactionManager(args.get(0)));
  }

  /**
   * Get the bean definition for 'transactionManager'.
   */
  public static BeanDefinition getTransactionManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PlatformTransactionManager.class);
    beanDefinition.setInstanceSupplier(getTransactionManagerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jpaVendorAdapter'.
   */
  private static BeanInstanceSupplier<JpaVendorAdapter> getJpaVendorAdapterInstanceSupplier() {
    return BeanInstanceSupplier.<JpaVendorAdapter>forFactoryMethod(JpaBaseConfiguration.class, "jpaVendorAdapter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(JpaBaseConfiguration.class).jpaVendorAdapter());
  }

  /**
   * Get the bean definition for 'jpaVendorAdapter'.
   */
  public static BeanDefinition getJpaVendorAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaVendorAdapter.class);
    beanDefinition.setInstanceSupplier(getJpaVendorAdapterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'entityManagerFactoryBuilder'.
   */
  private static BeanInstanceSupplier<EntityManagerFactoryBuilder> getEntityManagerFactoryBuilderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<EntityManagerFactoryBuilder>forFactoryMethod(JpaBaseConfiguration.class, "entityManagerFactoryBuilder", JpaVendorAdapter.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(JpaBaseConfiguration.class).entityManagerFactoryBuilder(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'entityManagerFactoryBuilder'.
   */
  public static BeanDefinition getEntityManagerFactoryBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EntityManagerFactoryBuilder.class);
    beanDefinition.setInstanceSupplier(getEntityManagerFactoryBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'entityManagerFactory'.
   */
  private static BeanInstanceSupplier<LocalContainerEntityManagerFactoryBean> getEntityManagerFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<LocalContainerEntityManagerFactoryBean>forFactoryMethod(JpaBaseConfiguration.class, "entityManagerFactory", EntityManagerFactoryBuilder.class, PersistenceManagedTypes.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(JpaBaseConfiguration.class).entityManagerFactory(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'entityManagerFactory'.
   */
  public static BeanDefinition getEntityManagerFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LocalContainerEntityManagerFactoryBean.class);
    beanDefinition.setPrimary(true);
    beanDefinition.setDependsOn("dataSourceScriptDatabaseInitializer");
    beanDefinition.setInstanceSupplier(getEntityManagerFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link JpaBaseConfiguration.PersistenceManagedTypesConfiguration}.
   */
  @Generated
  public static class PersistenceManagedTypesConfiguration {
    /**
     * Get the bean definition for 'persistenceManagedTypesConfiguration'.
     */
    public static BeanDefinition getPersistenceManagedTypesConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaBaseConfiguration.PersistenceManagedTypesConfiguration.class);
      beanDefinition.setInstanceSupplier(JpaBaseConfiguration.PersistenceManagedTypesConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance for 'persistenceManagedTypes'.
     */
    private static PersistenceManagedTypes getPersistenceManagedTypesInstance() {
      List<String> managedClassNames = List.of("de.aperepublic.server.Entity.Position", "de.aperepublic.server.Entity.Stock", "de.aperepublic.server.Entity.Users");
      List<String> managedPackages = List.of();
      return PersistenceManagedTypes.of(managedClassNames, managedPackages);
    }

    /**
     * Get the bean definition for 'persistenceManagedTypes'.
     */
    public static BeanDefinition getPersistenceManagedTypesBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaBaseConfiguration.PersistenceManagedTypesConfiguration.class);
      beanDefinition.setTargetType(PersistenceManagedTypes.class);
      beanDefinition.setPrimary(true);
      beanDefinition.setInstanceSupplier(PersistenceManagedTypesConfiguration::getPersistenceManagedTypesInstance);
      return beanDefinition;
    }
  }
}

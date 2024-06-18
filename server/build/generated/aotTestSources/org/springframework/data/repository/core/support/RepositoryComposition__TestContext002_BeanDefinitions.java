package org.springframework.data.repository.core.support;

import java.util.Collections;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;

/**
 * Bean definitions for {@link RepositoryComposition}.
 */
@Generated
public class RepositoryComposition__TestContext002_BeanDefinitions {
  /**
   * Bean definitions for {@link RepositoryComposition.RepositoryFragments}.
   */
  @Generated
  public static class RepositoryFragments {
    /**
     * Get the bean instance supplier for 'jpa.UserRepository.fragments#0'.
     */
    private static BeanInstanceSupplier<RepositoryFragmentsFactoryBean> getFragmentsInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<RepositoryFragmentsFactoryBean>forConstructor(List.class)
              .withGenerator((registeredBean, args) -> new RepositoryFragmentsFactoryBean(args.get(0)));
    }

    /**
     * Get the bean definition for 'fragments#0'.
     */
    public static BeanDefinition getFragmentsBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositoryFragmentsFactoryBean.class);
      beanDefinition.setTargetType(ResolvableType.forClass(RepositoryFragmentsFactoryBean.class));
      beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
      beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, Collections.emptyList());
      beanDefinition.setInstanceSupplier(getFragmentsInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'jpa.UsersRepository.fragments#0'.
     */
    private static BeanInstanceSupplier<RepositoryFragmentsFactoryBean> getFragmentsInstanceSupplier1(
        ) {
      return BeanInstanceSupplier.<RepositoryFragmentsFactoryBean>forConstructor(List.class)
              .withGenerator((registeredBean, args) -> new RepositoryFragmentsFactoryBean(args.get(0)));
    }

    /**
     * Get the bean definition for 'fragments#0'.
     */
    public static BeanDefinition getFragmentsBeanDefinition1() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositoryFragmentsFactoryBean.class);
      beanDefinition.setTargetType(ResolvableType.forClass(RepositoryFragmentsFactoryBean.class));
      beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
      beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, Collections.emptyList());
      beanDefinition.setInstanceSupplier(getFragmentsInstanceSupplier1());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'jpa.StockRepository.fragments#0'.
     */
    private static BeanInstanceSupplier<RepositoryFragmentsFactoryBean> getFragmentsInstanceSupplier2(
        ) {
      return BeanInstanceSupplier.<RepositoryFragmentsFactoryBean>forConstructor(List.class)
              .withGenerator((registeredBean, args) -> new RepositoryFragmentsFactoryBean(args.get(0)));
    }

    /**
     * Get the bean definition for 'fragments#0'.
     */
    public static BeanDefinition getFragmentsBeanDefinition2() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositoryFragmentsFactoryBean.class);
      beanDefinition.setTargetType(ResolvableType.forClass(RepositoryFragmentsFactoryBean.class));
      beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
      beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, Collections.emptyList());
      beanDefinition.setInstanceSupplier(getFragmentsInstanceSupplier2());
      return beanDefinition;
    }
  }
}

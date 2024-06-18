package de.aperepublic.server.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UserAuthController}.
 */
@Generated
public class UserAuthController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UserAuthController apply(RegisteredBean registeredBean,
      UserAuthController instance) {
    AutowiredFieldValueResolver.forRequiredField("userAuthService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}

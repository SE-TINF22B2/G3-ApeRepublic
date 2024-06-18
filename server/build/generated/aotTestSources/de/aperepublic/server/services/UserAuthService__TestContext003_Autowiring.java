package de.aperepublic.server.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UserAuthService}.
 */
@Generated
public class UserAuthService__TestContext003_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UserAuthService apply(RegisteredBean registeredBean, UserAuthService instance) {
    AutowiredFieldValueResolver.forRequiredField("activeUserService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}

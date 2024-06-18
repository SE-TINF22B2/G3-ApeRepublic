package org.springframework.test.context.aot;

import de.aperepublic.server.ControllerConfigTest__TestContext001_ApplicationContextInitializer;
import de.aperepublic.server.Repository.StockRepositoryTest__TestContext002_ApplicationContextInitializer;
import de.aperepublic.server.ServerApplicationTests__TestContext003_ApplicationContextInitializer;
import java.lang.Class;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.aot.generate.Generated;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Generated mappings for {@link AotTestContextInitializers}.
 */
@Generated
public class AotTestContextInitializers__Generated {
  public static Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> getContextInitializers(
      ) {
    Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> map = new HashMap<>();
    map.put("de.aperepublic.server.ControllerConfigTest", () -> new ControllerConfigTest__TestContext001_ApplicationContextInitializer());
    map.put("de.aperepublic.server.controller.UnternehmenControllerTest", () -> new ControllerConfigTest__TestContext001_ApplicationContextInitializer());
    map.put("de.aperepublic.server.Repository.StockRepositoryTest", () -> new StockRepositoryTest__TestContext002_ApplicationContextInitializer());
    map.put("de.aperepublic.server.Repository.UsersRepositoryTest", () -> new StockRepositoryTest__TestContext002_ApplicationContextInitializer());
    map.put("de.aperepublic.server.ServerApplicationTests", () -> new ServerApplicationTests__TestContext003_ApplicationContextInitializer());
    map.put("de.aperepublic.server.services.UserAuthServiceTest", () -> new ServerApplicationTests__TestContext003_ApplicationContextInitializer());
    return map;
  }

  public static Map<String, Class<? extends ApplicationContextInitializer<?>>> getContextInitializerClasses(
      ) {
    Map<String, Class<? extends ApplicationContextInitializer<?>>> map = new HashMap<>();
    map.put("de.aperepublic.server.ControllerConfigTest", ControllerConfigTest__TestContext001_ApplicationContextInitializer.class);
    map.put("de.aperepublic.server.controller.UnternehmenControllerTest", ControllerConfigTest__TestContext001_ApplicationContextInitializer.class);
    map.put("de.aperepublic.server.Repository.StockRepositoryTest", StockRepositoryTest__TestContext002_ApplicationContextInitializer.class);
    map.put("de.aperepublic.server.Repository.UsersRepositoryTest", StockRepositoryTest__TestContext002_ApplicationContextInitializer.class);
    map.put("de.aperepublic.server.ServerApplicationTests", ServerApplicationTests__TestContext003_ApplicationContextInitializer.class);
    map.put("de.aperepublic.server.services.UserAuthServiceTest", ServerApplicationTests__TestContext003_ApplicationContextInitializer.class);
    return map;
  }
}

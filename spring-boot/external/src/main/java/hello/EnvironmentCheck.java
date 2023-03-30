package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@Slf4j
@ComponentScan
public class EnvironmentCheck {

  private final Environment env;

  public EnvironmentCheck(Environment env) {
    this.env = env;
  }

  @PostConstruct
  public void init() {
    String url = env.getProperty("url");
    String username = env.getProperty("username");
    String password = env.getProperty("password");
    log.info("env url={}", url);
    log.info("env username={}", username);
    log.info("env password={}", password);
  }
}

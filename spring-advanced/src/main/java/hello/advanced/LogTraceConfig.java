package hello.advanced;

import hello.advanced.trace.logtrace.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

  @Bean
  public LogTrace logTrace() {
    return new ThreadLocalLogTrace();
  }
}

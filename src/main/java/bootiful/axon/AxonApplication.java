package bootiful.axon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AxonApplication {

  public static void main(String[] args) {
    SpringApplication.run(AxonApplication.class, args);
  }

  @Bean
  InitializingBean initializingBean(ObjectMapper objectMapper) {
    return () -> objectMapper.activateDefaultTyping(
        objectMapper.getPolymorphicTypeValidator(),
        DefaultTyping.JAVA_LANG_OBJECT
    );
  }

}

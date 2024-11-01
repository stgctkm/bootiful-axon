package bootiful.axon;

import org.springframework.boot.SpringApplication;

public class TestAxonApplication {

  public static void main(String[] args) {
    SpringApplication.from(AxonApplication::main).with(TestcontainersConfiguration.class).run(args);
  }

}

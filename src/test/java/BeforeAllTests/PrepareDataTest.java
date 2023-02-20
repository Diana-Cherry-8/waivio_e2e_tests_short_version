package BeforeAllTests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PrepareDataTest {


  @Test
  @Tag("prepare")
  void prepare() {
    //Code witch will run before all test
    //You can run it with command: "-Dgroups=prepare clean test"
  }
}

package AfterAllTests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ClearDataTest {

  @Test
  @Tag("clear")
  void clear() {
    //Code witch will runs after all test
    //You can run it with command: "-Dgroups=clear clean test"
  }

}

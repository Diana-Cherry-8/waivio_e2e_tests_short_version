package Extensions;

import static Helpers.Screenshots.screenshot;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

//Makes screenshot after test fail
public class MyAfterTestExecutionCallback implements AfterTestExecutionCallback {

  @Override
  public void afterTestExecution(ExtensionContext context) {
    if (context.getExecutionException().isPresent()) {
      screenshot();
    }
  }

}

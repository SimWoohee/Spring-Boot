package hello.proxy.pureproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject{
    @Override
    public String operation() throws InterruptedException {
      log.info("실제 객체 호출");
      Thread.sleep(1000);
      return "data";
    }
}

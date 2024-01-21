package hello.proxy.decoproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecoProxy implements Component{

    //client -> timedeco -> message -> real 객체

    private Component component;

    public TimeDecoProxy(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("TimeDecoProxy 실행");
        long startTime = System.currentTimeMillis();

        String result = component.operation();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeDecoRator 종료 resultTime={}", resultTime);

        return result;
    }
}

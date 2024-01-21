package hello.proxy.concreteproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteTimeProxy extends ConcreteLogic{

    private ConcreteLogic concreteLogic;

    public ConcreteTimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        log.info("ConcreteTimeProxy 실행");

        long startTime = System.currentTimeMillis();

        String result = concreteLogic.operation();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("ConcreteTimeProxy 종료 resultTime={}", resultTime);

        return result;
    }
}

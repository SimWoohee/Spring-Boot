package hello.strategy;

import lombok.extern.slf4j.Slf4j;

import javax.naming.Context;

@Slf4j
public class ContextV1Test {
    public static void main(String[] args) {
        //전략 패턴 사용
//        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
//        ContextV1 contextV1 = new ContextV1(strategyLogic1);
//        contextV1.execute();
//
//
//        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
//        ContextV1 contextV2 = new ContextV1(strategyLogic2);
//        contextV2.execute();

        //익명 내부 클래스, 인터페이스의 구현체를 바로 구현
//        strategyV2();
//        strategyV3();

        //Context를 실핼할 때 마다 전략을 인수로 전달한다.
        //콜백
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());


        //익명 내부 클래스로 변경
        //콜백
        ContextV2 contextV3 = new ContextV2();
        contextV2.execute(() -> log.info("가능"));
        contextV2.execute(() -> log.info("가능"));

    }

    static void strategyV2(){
        Strategy strategyLogic1 = () -> log.info("비지니스 로직 1 실행");
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();
    }

    static void strategyV3(){
        Strategy strategyLogic2 = () -> log.info("비지니스 로직 2 실행");
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }
}

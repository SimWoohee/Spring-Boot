package hello.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 *  필드에 전략을 보관하는 방식
 */
@Slf4j
public class ContextV2 {
    public void execute(Strategy strategy){
        long startTime = System.currentTimeMillis();
        //비지니스 로직 실행
        //핵심 기능
        strategy.call();
        //비지니스 로직 종료

        //부가 기능
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("비지니스 로직1 실행 시간 : " + resultTime);
    }
}

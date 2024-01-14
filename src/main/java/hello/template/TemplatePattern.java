package hello.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class TemplatePattern {

    // TemplatePattern : 변하지 않는 부분만 남겨두고 변하는 부분을 별도로 호출해서 해결한다.
    // 변하는 로직들을 추상 메소드로 만들고 구현체를 만들어 비지니스 구현한다.

    public void execute(){

        //변하지 않는 부분만 남겨두고 변하는 부분을 별도로 호출해서 해결한다.
        long startTime = System.currentTimeMillis();
        //비지니스 로직 실행
        //핵심 기능
        call();
        //비지니스 로직 종료

        //부가 기능
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);

    }

    protected abstract void call();
}

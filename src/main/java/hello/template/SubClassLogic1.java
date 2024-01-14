package hello.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic1 extends TemplatePattern{
    @Override
    protected void call() {
        log.info("비즈니스 로직1 실행");
    }
}

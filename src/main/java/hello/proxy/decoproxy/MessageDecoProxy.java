package hello.proxy.decoproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecoProxy implements Component{

    private Component component;

    public MessageDecoProxy(Component component) {
        this.component = component;
    }
    @Override
    public String operation() {
        log.info("MessageDecoProxy 실행");

        String operation = component.operation();
        String decoResult = "******" + operation + "******";

        //실제 객체의 응답을 변형하는 부가기능 추가
        log.info("MessageDcorator 꾸미기 적용 전 = {}, 적용 후={}", operation, decoResult);
        return decoResult;
    }
}

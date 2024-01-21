package hello.proxy.concreteproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteLogic {

    public String operation(){
        log.info("ConcreteLogic 실행");
        return "data";
    }
}

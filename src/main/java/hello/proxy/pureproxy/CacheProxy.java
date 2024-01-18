package hello.proxy.pureproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{

    //호출해야되는 대상
    private Subject target;

    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() throws InterruptedException {

        //처음 호출시 cacheValue value는 null 이기때문에 실제 객체(target)를 호출하고
        //두번째 호출시에는 cacheValue가 null이 아니라서 cacheProxy에 있는 값을 return 한다.

        log.info("프록시 호출");
        if(cacheValue == null){
            cacheValue = target.operation();
        }
        return cacheValue;
    }
}

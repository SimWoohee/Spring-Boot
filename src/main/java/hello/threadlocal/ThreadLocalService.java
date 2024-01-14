package hello.threadlocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public String save(String message) throws InterruptedException {
        log.info("저장 name={} -> nameStore={}", message, threadLocal.get());
        threadLocal.set(message);
        Thread.sleep(1000);
        log.info("조회 nameStore={}", threadLocal.get());
        return threadLocal.get();
    }
}

package hello.springtx.exception;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class RollbackTest {

    @Autowired
    RollbackService rollbackService;

    @Test
    void runtimeExcetion(){
        rollbackService.runtimeException();
    }


    @TestConfiguration
    static class RollbackTestConfig{

        @Bean
        RollbackService rollbackService(){
            return new RollbackService();
        }
    }

    @Slf4j
    static class RollbackService{
        @Transactional  //런타임 예외 발생 : 롤백
        public void runtimeException(){
            log.info("call runtimeException");
            throw new RuntimeException();
        }

        @Transactional  //체크 예외 발생 :  커밋
        public void checkedException() throws MyException{
            log.info("call checkException");
            throw new MyException();
        }
        @Transactional(rollbackFor = MyException.class) //체크 예외 rollbackFor 지정 : 롤백
        public void rollbackFor() throws MyException{
            log.info("call checkException");
            throw new MyException();
        }

    }

    static class MyException extends Exception{

    }
}

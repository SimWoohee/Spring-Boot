package hello.jdkdynamic;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    public static void main(String[] args) throws Exception {

        reflection1();
    }

    public static void reflection(){

        Hello target = new Hello();

        //공통 로직1 시작
        log.info("start");
        String result = target.callA();
        log.info("result={}", result);
        //공통 로직1 종료

        //공통 로직2 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result={}", result2);
        //공통 로직2 종료


        //공통로직1과 공통로직2의 소스는 동일하다
        //차이점은 호출하는 메소드만 다르다!
        // => 공통 로직1과 공통 로직2를 하나의 메서드로 뽑아서 합칠 수 있을까?
        //String result2 = xxxxx; => 동적 처리 필요, 이럴떄 필요한게 리플렉션이다.
    }

    public static void reflection1() throws Exception {
        //클래스 정보 추출
        Class aClass = Class.forName("hello.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();


        //메소드 정보를 가져오는 방법
        Method callA = aClass.getMethod("callA");
        Object invoke = callA.invoke(target);

        log.info("result1{}", invoke);


        Method callB = aClass.getMethod("callB");
        Object invoke2 = callB.invoke(target);

        log.info("result1{}", invoke2);

        //그런데 target.callA(), target.callB() 메서드를 직접 호출하면 되지 이렇게 메서드 정보를 획득해서 메서드를 호출하면
        //어떤 효과가 있을까? 여기서 중요한 핵심은 클래스나 메서드 정보를 동적으로 변경할 수 있다는 점이다.

    }


    public static void reflection2() throws Exception {
        //클래스 정보 추출
        Class aClass = Class.forName("hello.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        //메소드정보를 추상화하여 공통화 시킬수 있다
        //메소드 정보를 가져오는 방법
        Method callA = aClass.getMethod("callA");
        dynamicCall(callA, target);

        Method callB = aClass.getMethod("callB");
        dynamicCall(callB, target);

    }


    public static void dynamicCall(Method method, Object object) throws InvocationTargetException, IllegalAccessException {
        
        Hello target = new Hello();

        //공통 로직1 시작
        log.info("start");
        Object invoke = method.invoke(target);
        log.info("result={}", invoke);
        //공통 로직1 종료

    }


    static class Hello{
        public String callA(){
            log.info("callA");
            return "A";

        }

        public String callB(){
            log.info("callB");
            return "B";

        }
    }
}

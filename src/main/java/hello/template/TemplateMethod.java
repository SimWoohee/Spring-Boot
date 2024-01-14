package hello.template;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
public class TemplateMethod {

    //중복되는 소스들이 많고 중간중간에 고유하게 비지니스 로직이 들어가는 소스들을 템플릿 페턴으로 변경
    //=> TemplatePattern 참고

    public static void logic1(){
        long startTime = System.currentTimeMillis();
        //비지니스 로직 실행
        //핵심 기능
        System.out.println("비지니스 로직1 실행");
        //비지니스 로직 종료

        //부가 기능
        long endTime = System.currentTimeMillis();
        long resultTime = startTime - endTime;
        System.out.println("비지니스 로직1 실행 시간 : " + resultTime);

    }


    public static void logic2(){
        long startTime = System.currentTimeMillis();
        //비지니스 로직 실행
        //핵심 기능
        System.out.println("비지니스 로직2 실행");
        //비지니스 로직 종료

        //부가 기능
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("비지니스 로직2 실행 시간 : " + resultTime);

    }
    public static void main(String[] args) {
        //logic1();
        //logic2();

        //templatePattern 적용
        TemplatePattern templatePattern = new SubClassLogic1();
        templatePattern.execute();


        TemplatePattern templatePattern2 = new SubClassLogic2();
        templatePattern2.execute();

    }

}

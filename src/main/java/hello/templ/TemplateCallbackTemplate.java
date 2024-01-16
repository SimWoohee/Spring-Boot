package hello.templ;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateCallbackTemplate {

    public static void main(String[] args) {

    }

    // 템플릿 콜백 패턴 - 익명 내부 클래스

    void callbackV1(){


        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(() -> log.info("콜백 패턴"));

    }


}

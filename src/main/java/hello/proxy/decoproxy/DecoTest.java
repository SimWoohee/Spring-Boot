package hello.proxy.decoproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoTest {

    public static void main(String[] args) {


//        //client -> Real 객체 호출
//        Component realComponent = new RealComponent();
//        DecoClient decoClient = new DecoClient(realComponent);
//        decoClient.execute();
//
//        //decoProxy 패턴 적용 하여 응답값 변경
//        RealComponent realComponent1 = new RealComponent();
//        MessageDecoProxy messageDecoProxy = new MessageDecoProxy(realComponent1);
//        DecoClient decoClient1 = new DecoClient(messageDecoProxy);
//        decoClient1.execute();



        //Client -> timeProxy -> messageProxy -> Real 객체
        RealComponent realComponent2 = new RealComponent();
        MessageDecoProxy messageDecoProxy1 = new MessageDecoProxy(realComponent2);
        TimeDecoProxy timeDecoProxy = new TimeDecoProxy(messageDecoProxy1);
        DecoClient decoClient2 = new DecoClient(timeDecoProxy);
        decoClient2.execute();


    }
}

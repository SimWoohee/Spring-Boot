package hello.proxy.concreteproxy;

public class ConcreteTest {

    public static void main(String[] args) {

        //프록시 도입 전
        noProxy();


        //클래스 기반 proxy 구조
        addProxy();


    }

    public static void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);
        concreteClient.execute();

    }

    public static void addProxy(){
        //ConcreteClient는 다형성에 의해 ConcreteTimeProxy도 주입할수 있고 실제 객체 ConcreteLogic도 주입가능하다.
        //ConcreteTimeProxy는 ConcreteLogic을 상속 받았기 때문이다.
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteLogic concreteTimeProxy = new ConcreteTimeProxy(concreteLogic);
        ConcreteClient concreteClient = new ConcreteClient(concreteTimeProxy);
        concreteClient.execute();

    }


}

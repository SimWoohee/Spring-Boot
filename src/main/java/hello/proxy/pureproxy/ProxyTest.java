package hello.proxy.pureproxy;

public class ProxyTest {
    public static void main(String[] args) throws InterruptedException {

        //Client(proxyClient) -> Server(RealSubject)
        RealSubject realSubject = new RealSubject();
        ProxyClient proxyClient = new ProxyClient(realSubject);


        proxyClient.execute();
        proxyClient.execute();
        proxyClient.execute();

        //데이터가 한번 조회하면 변하지 않는 데이터라면 어딘가에 보관해두고 이미 조회한 데이터를 사용하는 것 => 캐시
        //캐시도 접근 자체를 제어하는 기능중에 하나이다.

        //프록시 적용
        //Client -> cacheProxy -> ReadSubject
        RealSubject realSubject1 = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject1);
        ProxyClient proxyClient1 = new ProxyClient(cacheProxy);

        proxyClient1.execute();
        proxyClient1.execute();
        proxyClient1.execute();



    }
}

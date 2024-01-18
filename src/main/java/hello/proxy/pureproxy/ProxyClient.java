package hello.proxy.pureproxy;

public class ProxyClient {
    private Subject subject;

    public ProxyClient(Subject subject) {
        this.subject = subject;
    }

    public void execute() throws InterruptedException {
        subject.operation();
    }
}

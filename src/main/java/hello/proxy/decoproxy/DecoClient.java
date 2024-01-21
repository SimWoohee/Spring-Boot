package hello.proxy.decoproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoClient {

    private  Component component;

    public DecoClient(Component component) {
        this.component = component;
    }

    public void execute(){
        String operation = component.operation();
        log.info("result = {}", operation);
    }
}

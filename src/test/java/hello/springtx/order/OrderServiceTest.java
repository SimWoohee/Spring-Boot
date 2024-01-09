package hello.springtx.order;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
class OrderServiceTest {

    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

    @Test
    void order() throws NotEnoughMoneyException {

        //given
        Order order = new Order();
        order.setContents("정상");

        //when
        orderService.order(order);

        //then
        Order order1 = orderRepository.findById(order.getId()).get();
        Assertions.assertThat(order1.getPayStatus()).isEqualTo("완료");

    }


    @Test
    void runtimeException() throws NotEnoughMoneyException{

        //given
        Order order = new Order();
        order.setContents("예외");

        //when
        Assertions.assertThatThrownBy(() -> orderService.order(order))
                .isInstanceOf(RuntimeException.class);

        //then
        Optional<Order> byId = orderRepository.findById(order.getId());
        //Assertions.assertThat(byId.isEmpty()).isTrue();

    }


    @Test
    void bizException() throws NotEnoughMoneyException{

        //given
        Order order = new Order();
        order.setContents("잔고부족");

        //when
        try {
            orderService.order(order);
        }catch (NotEnoughMoneyException e){
            log.info("고객에게 잔고 부족을 알리고 별도의 계좌로 입금하도록 안내");
        }

        //then
        Optional<Order> byId = orderRepository.findById(order.getId());
        if(!byId.isEmpty()){
            Order order1 = byId.get();
            log.info("test" + order1.getContents());
        }else{
            log.info("test fail");
        }

    }
}
package moe.cnkirito.demo.rsocket;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * @author daofeng.xjf
 */
public class RsocketClient {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/rsocket-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // get remote service proxy

        while (true) {
            try {
                Mono<String> monoResult = demoService.requestMonoWithMonoArg(Mono.just("A"), Mono.just("B"));
                monoResult.doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                }).block();

                Flux<String> fluxResult = demoService.requestFluxWithFluxArg(Flux.just("A", "B", "C"), Flux.just("1", "2", "3"));
                fluxResult.doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                }).blockLast();

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

}

package moe.cnkirito.demo.rsocket;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DemoService {

    Mono<String> requestMonoWithMonoArg(Mono<String> m1, Mono<String> m2);

    Flux<String> requestFluxWithFluxArg(Flux<String> f1, Flux<String> f2);

}
package com.webflux.webflux.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
public class DemoService {

    public Mono<String> buscarMensagemUnica() {
        return Mono.just("Mensagem do serviço");
    }

    public Flux<String> buscarMensagensMultiplas() {
        List<String> mensagens = List.of("Mensagem 1", "Mensagem 2", "Mensagem 3");
        return Flux.fromIterable(mensagens)
                .delayElements(Duration.ofSeconds(1));
    }

}

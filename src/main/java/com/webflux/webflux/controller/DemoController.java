package com.webflux.webflux.controller;

import com.webflux.webflux.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/service/single")
    public Mono<String> serviceSingle() {
        return demoService.buscarMensagemUnica();
    }

    @GetMapping("/service/multi")
    public Flux<String> serviceMulti() {
        return demoService.buscarMensagensMultiplas();
    }
}

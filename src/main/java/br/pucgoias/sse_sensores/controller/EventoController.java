package br.pucgoias.sse_sensores.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import br.pucgoias.sse_sensores.service.EventoService;

@RestController
@RequestMapping("/sensores")
@CrossOrigin(origins = "*")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping(
        value = "/stream",
        produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public SseEmitter stream(
        @RequestHeader(
            value = "Last-Event-ID",
            required = false
        ) String lastId
    ) {

        SseEmitter emitter = new SseEmitter(-1L);

        eventoService.registrar(emitter);

        emitter.onCompletion(() ->
                eventoService.remover(emitter));

        emitter.onTimeout(() ->
                eventoService.remover(emitter));

        emitter.onError((e) ->
                eventoService.remover(emitter));

        return emitter;
    }
}
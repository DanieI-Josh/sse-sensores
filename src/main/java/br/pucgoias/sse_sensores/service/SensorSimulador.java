package br.pucgoias.sse_sensores.service;

import java.io.IOException;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.pucgoias.sse_sensores.model.LeituraTemperatura;

@Component
public class SensorSimulador {

    private final EventoService eventoService;

    private final Random random = new Random();

    private final String[] sensores = {
            "sala",
            "server",
            "externo"
    };

    public SensorSimulador(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @Scheduled(fixedRate = 2000)
    public void emitirLeituras() throws IOException {

        for (String sensor : sensores) {

            LeituraTemperatura leitura =
                    new LeituraTemperatura(
                            sensor,
                            20 + random.nextDouble() * 10,
                            System.currentTimeMillis()
                    );

            eventoService.publicar(
                    "temperatura",
                    leitura
            );
        }
    }
}
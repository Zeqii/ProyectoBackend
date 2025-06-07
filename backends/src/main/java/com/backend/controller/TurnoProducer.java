package com.backend.controller;

import com.backend.config.RabbitConfig;
import com.backend.dto.TurnoEventDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/turnos")
@Tag(name = "Productor RabbitMQ", description = "Producer para enviar turnos a RabbitMQ")
public class TurnoProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostMapping("/enviar")
    @Operation(
        summary = "Enviar turno a la cola",
        description = "Envía un objeto de tipo TurnoEventDTO a RabbitMQ a través del exchange definido, usando la routing key 'turno.nuevo'."
    )
    public ResponseEntity<?> enviarTurnoACola(@RequestBody TurnoEventDTO dto) {
        try {
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "turno.nuevo", dto);
            return ResponseEntity.ok("Turno enviado a la cola correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al enviar el turno a la cola: " + e.getMessage());
        }
    }
}

package com.backend.utils;


import com.backend.config.RabbitConfig;
import com.backend.dto.TurnoEventDTO;
import com.umg.proy.milibreria.db.MySQLConnector;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TurnoConsumer {

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void recibirTurno(TurnoEventDTO dto) {
        try {
            System.out.println("📥 Recibido desde cola: " + dto.codigo);

            String query = """
                INSERT INTO turnos 
                (codigo, tipo_servicio, estado, fecha_creacion, prioridad, dpicliente, comentario) 
                VALUES (?, ?, ?, NOW(), ?, ?, ?)
            """;

            MySQLConnector.insert(
                query,
                dto.codigo,
                dto.tipoServicio,
                dto.estado,
                dto.prioridad,
                dto.dpicliente,
                dto.comentario
            );

            System.out.println("✅ Turno guardado correctamente en la base de datos.");

        } catch (Exception e) {
            System.err.println("❌ Error al insertar turno recibido desde RabbitMQ: " + e.getMessage());
        }
    }
}
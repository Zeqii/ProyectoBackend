package com.backend.controller;

import com.backend.dto.UpdateTurnoDTO;
import com.umg.proy.milibreria.db.MySQLConnector;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;
import java.util.Stack;

@RestController
@RequestMapping("/api/turnos")
@Tag(name = "Gestión de Turnos", description = "Endpoints para administrar turnos")
public class TurnoController {

    @GetMapping
    public ResponseEntity<?> getAllTurnos() {
        try {
            Stack<Map<String, Object>> turnos = new Stack<>();
            turnos.addAll(MySQLConnector.selectList("SELECT * FROM turnos ORDER BY fecha_creacion DESC"));
            return ResponseEntity.ok(turnos);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al consultar turnos: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    @Tag(name = "Gestión de Turnos", description = "Endpoints para eliminar turnos")
    public ResponseEntity<?> deleteTurno(@PathVariable Long id) {
        try {
            MySQLConnector.update("DELETE FROM turnos WHERE id = ?", id);
            return ResponseEntity.ok("Turno eliminado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al eliminar el turno: " + e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTurno(@PathVariable Long id, @RequestBody UpdateTurnoDTO dto) {
        try {
            String query = """
                UPDATE turnos SET 
                    codigo = ?, 
                    tipo_servicio = ?, 
                    estado = ?, 
                    fecha_atencion = ?, 
                    prioridad = ?, 
                    dpicliente = ?, 
                    comentario = ?
                WHERE id = ?
            """;

            MySQLConnector.update(
                query,
                dto.codigo,
                dto.tipoServicio,
                dto.estado,
                dto.fechaAtencion,
                dto.prioridad,
                dto.dpicliente,
                dto.comentario,
                id
            );

            return ResponseEntity.ok("Turno actualizado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al actualizar el turno: " + e.getMessage());
        }
    }
    
    @GetMapping("/estadisticas")
    public ResponseEntity<?> getEstadisticasPorEstado() {
        try {
            Stack<Map<String, Object>> estadisticas = new Stack<>();
            estadisticas.addAll(MySQLConnector.selectList("SELECT estado, COUNT(*) AS cantidad FROM turnos GROUP BY estado"));
            return ResponseEntity.ok(estadisticas);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al obtener estadísticas: " + e.getMessage());
        }
    }
}

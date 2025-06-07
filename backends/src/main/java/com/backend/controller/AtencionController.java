package com.backend.controller;

import com.backend.dto.TurnoDTO;
import com.backend.utils.ColaTurnos;
import com.umg.proy.milibreria.db.MySQLConnector;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/cola")
@Tag(name = "Simulación de Cola", description = "Atencion de turnos")
public class AtencionController {

    private final ColaTurnos cola = new ColaTurnos();

    @GetMapping("/cargar")
    @Operation(summary = "Cargar cola desde base de datos", description = "Carga turnos con estado pendiente en orden FIFO desde la base de datos")
    public ResponseEntity<?> cargarCola() {
        try {
            cola.cargarDesdeBaseDeDatos();
            return ResponseEntity.ok("Cola cargada. Total de turnos: " + cola.tamanio());
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Error al cargar cola: " + e.getMessage());
        }
    }

    @GetMapping("/siguiente")
    @Operation(summary = "Ver siguiente turno", description = "Devuelve el próximo turno en la cola sin retirarlo")
    public ResponseEntity<?> verSiguiente() {
        TurnoDTO siguiente = cola.verSiguiente();
        return siguiente != null
            ? ResponseEntity.ok(siguiente)
            : ResponseEntity.status(404).body("No hay turnos en la cola.");
    }

    @PostMapping("/atender")
    @Operation(summary = "Atender turno", description = "Retira el turno de la cola y actualiza su estado en la base de datos")
    public ResponseEntity<?> atenderTurno() {
        TurnoDTO atendido = cola.atenderSiguiente();

        if (atendido == null) {
            return ResponseEntity.status(404).body("No hay turnos por atender.");
        }

        try {
            String update = "UPDATE turnos SET estado = 'atendido', fecha_atencion = NOW() WHERE id = ?";
            MySQLConnector.update(update, atendido.getId());
            return ResponseEntity.ok("Turno atendido: " + atendido.getCodigo());
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Error al actualizar turno: " + e.getMessage());
        }
    }
}
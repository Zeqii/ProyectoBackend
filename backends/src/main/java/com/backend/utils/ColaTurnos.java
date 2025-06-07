package com.backend.utils;



import com.backend.dto.TurnoDTO;
import com.umg.proy.milibreria.db.MySQLConnector;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ColaTurnos {

    private final Queue<TurnoDTO> cola = new LinkedList<>();

    public void cargarDesdeBaseDeDatos() throws SQLException {
        cola.clear(); // Limpiar antes de cargar

        var turnosDB = MySQLConnector.selectList(
            "SELECT * FROM turnos WHERE LOWER(estado) = 'pendiente' ORDER BY fecha_creacion ASC"
        );

        for (Map<String, Object> row : turnosDB) {
            TurnoDTO turno = new TurnoDTO();
            turno.setId(((Number) row.get("id")).longValue());
            turno.setCodigo((String) row.get("codigo"));
            turno.setTipoServicio((String) row.get("tipo_servicio"));
            turno.setEstado((String) row.get("estado"));
            turno.setFechaCreacion(row.get("fecha_creacion").toString());
            turno.setFechaAtencion(row.get("fecha_atencion") != null ? row.get("fecha_atencion").toString() : null);
            turno.setPrioridad((int) row.get("prioridad"));
            turno.setDpicliente((String) row.get("dpicliente"));
            turno.setComentario((String) row.get("comentario"));

            cola.offer(turno);
        }

        System.out.println("📥 Cola cargada desde base de datos. Total: " + cola.size());
    }

    public TurnoDTO atenderSiguiente() {
        return cola.poll();
    }

    public TurnoDTO verSiguiente() {
        return cola.peek();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public int tamanio() {
        return cola.size();
    }
}
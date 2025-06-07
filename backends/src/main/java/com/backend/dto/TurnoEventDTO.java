package com.backend.dto;

import java.io.Serializable;

public class TurnoEventDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public String codigo;
    public String tipoServicio;
    public String estado;
    public String fechaCreacion;
    public int prioridad;
    public String dpicliente;
    public String comentario;
}
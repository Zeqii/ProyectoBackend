package com.backend.dto;

public class TurnoDTO {
    private Long id;
    private String codigo;
    private String tipoServicio;
    private String estado;
    private String fechaCreacion;
    private String fechaAtencion;
    private int prioridad;
    private String dpicliente;
    private String comentario;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getFechaAtencion() { return fechaAtencion; }
    public void setFechaAtencion(String fechaAtencion) { this.fechaAtencion = fechaAtencion; }

    public int getPrioridad() { return prioridad; }
    public void setPrioridad(int prioridad) { this.prioridad = prioridad; }

    public String getDpicliente() { return dpicliente; }
    public void setDpicliente(String dpicliente) { this.dpicliente = dpicliente; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}
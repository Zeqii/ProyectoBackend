package com.backend.dto;

public class UpdateTurnoDTO {
  
	public String codigo;
    public String tipoServicio;
    public String estado;
    public String fechaAtencion;
    public int prioridad;
    public String dpicliente;
    public String comentario;
    
    public String getCodigo() {
  		return codigo;
  	}
  	public void setCodigo(String codigo) {
  		this.codigo = codigo;
  	}
  	public String getTipoServicio() {
  		return tipoServicio;
  	}
  	public void setTipoServicio(String tipoServicio) {
  		this.tipoServicio = tipoServicio;
  	}
  	public String getEstado() {
  		return estado;
  	}
  	public void setEstado(String estado) {
  		this.estado = estado;
  	}
  	public String getFechaAtencion() {
  		return fechaAtencion;
  	}
  	public void setFechaAtencion(String fechaAtencion) {
  		this.fechaAtencion = fechaAtencion;
  	}
  	public int getPrioridad() {
  		return prioridad;
  	}
  	public void setPrioridad(int prioridad) {
  		this.prioridad = prioridad;
  	}
  	public String getDpicliente() {
  		return dpicliente;
  	}
  	public void setDpicliente(String dpicliente) {
  		this.dpicliente = dpicliente;
  	}
  	public String getComentario() {
  		return comentario;
  	}
  	public void setComentario(String comentario) {
  		this.comentario = comentario;
  	}
    
}
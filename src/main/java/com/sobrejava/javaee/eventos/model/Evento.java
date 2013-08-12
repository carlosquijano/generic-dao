package com.sobrejava.javaee.eventos.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTS")
public class Evento implements Serializable {
    
    public static final String SEVERIDAD_INFO = "INFO";
    
    public static final String SEVERIDAD_ERROR = "ERROR";
    
    public static final String SEVERIDAD_DEBUG = "DEBUG";
    
    public static final String SEVERIDAD_FATAL = "FATAL";
    
    @Id
    @Column(name = "EVENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventoId;
    
    @Column(name = "SEVERITY", length = 32)
    private String severidad;
    
    @Column(name = "MESSAGE", length = 512)
    private String mensaje;
    
    @Column(name = "STAMP")
    private Timestamp fecha;

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public String getSeveridad() {
        return severidad;
    }

    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}

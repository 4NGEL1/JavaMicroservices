package com.axity.ejercicio.EjercicioApi.commons;

import java.io.Serializable;

public class RespuestaBase implements Serializable {
    private static final long serialVersionUID = 1L;
    private int Status;
    private String message;

    public RespuestaBase(){

    }

    public RespuestaBase(int status, String message) {
        this.Status = status;
        this.message = message;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
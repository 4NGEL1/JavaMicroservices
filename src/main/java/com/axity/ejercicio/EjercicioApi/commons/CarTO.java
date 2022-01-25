package com.axity.ejercicio.EjercicioApi.commons;

import java.io.Serializable;

public class CarTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private int Id;

    private String Marca;

    private String Modelo;

    private String Color;

    private String Placa;

    public void CarTo(String marca, String modelo, String color, String placa){

    }

    public CarTO(int id,String marca, String modelo, String color, String placa) {
        this.Id = id;
        this.Marca = marca;
        this.Modelo = modelo;
        this.Color = color;
        this.Placa = placa;
    }

    public Integer getId() {
        return Math.toIntExact(Id);
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        this.Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        this.Modelo = modelo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        this.Placa = placa;
    }

}
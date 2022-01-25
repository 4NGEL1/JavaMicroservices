package com.axity.ejercicio.EjercicioApi.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;


import javax.persistence.*;
import java.util.Objects;

@EntityScan
@Table(name="cars")
public class CarDTO{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "Marca")
    private String Marca;
    @Column(name = "Modelo")
    private String Modelo;
    @Column(name = "Color")
    private String Color;
    @Column(name = "Placa")
    private String Placa;
    public CarDTO(){

    }

    public CarDTO(String marca, String modelo, String color, String placa) {
        //this.Id = Math.toIntExact(id);
        this.Marca = marca;
        this.Modelo = modelo;
        this.Color = color;
        this.Placa = placa;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = Long.valueOf(Math.toIntExact(id));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarDTO)) return false;
        CarDTO carDTO = (CarDTO) o;
        return Objects.equals(Id, carDTO.Id) && Objects.equals(Marca, carDTO.Marca) && Objects.equals(Modelo, carDTO.Modelo) && Objects.equals(Color, carDTO.Color) && Objects.equals(Placa, carDTO.Placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Marca, Modelo, Color, Placa);
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "Id=" + Id +
                ", Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", Color='" + Color + '\'' +
                ", Placa='" + Placa + '\'' +
                '}';
    }
}

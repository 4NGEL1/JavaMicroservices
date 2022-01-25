package com.axity.ejercicio.EjercicioApi.commons;

import java.util.List;

public class CarResponseTO extends RespuestaBase {
    private static final long serialVersionUID = 1L;
    private List<CarTO> cars;


    public List<CarTO> getCar(){
        return cars;
    }

    public void setCar(List<CarTO> cars){
        this.cars=cars;
    }

}
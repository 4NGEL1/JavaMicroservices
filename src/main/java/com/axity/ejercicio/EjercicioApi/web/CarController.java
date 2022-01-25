package com.axity.ejercicio.EjercicioApi.web;
import java.util.ArrayList;
import java.util.List;


import com.axity.ejercicio.EjercicioApi.commons.CarResponseTO;
import com.axity.ejercicio.EjercicioApi.commons.CarTO;
import com.axity.ejercicio.EjercicioApi.commons.RespuestaBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "*",allowedHeaders="*")
@RequestMapping("auto") //Ruta para la repuesta Home
@RestController
public class CarController{

    @GetMapping(value="/test",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> test(){
        return new ResponseEntity<>("Compile Ok", HttpStatus.OK);
    }
    //Get para obtener todos los registros
    @GetMapping(value="/",produces = {MediaType.APPLICATION_JSON_VALUE})
    //      La respuesta es una lista con todos los elementos
    public ResponseEntity<CarResponseTO> Allcar() {
        try {
            verifyEmpty(getData());
            CarResponseTO cars = new CarResponseTO();
            cars.setMessage("Registros encontrados");
            cars.setStatus(200);
            cars.setCar(getData());
            return new ResponseEntity<>(cars, HttpStatus.OK); //Respuesta para el peticion
        } catch (Exception e){
            CarResponseTO cars = new CarResponseTO();
            cars.setMessage("Parametros Desconocido");
            cars.setStatus(400);
            return new ResponseEntity<>(cars, HttpStatus.BAD_REQUEST); //Respuesta para el peticion
        }
    }
    // Peticion Get por Id
    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
            //Respuesta en la clase CarTO als er un solo elemento
    public ResponseEntity<CarTO> findById(){
        try {
            verifyEmpty(getData());
            int id = (int) Math.floor(Math.random() * 60 + 1);
            CarResponseTO car = new CarResponseTO();
            car.setStatus(200);
            car.setCar(getData());
            return new ResponseEntity<>(car.getCar().get(id), HttpStatus.OK); //Respuesta de la peticion
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //Respuesta para el peticion
        }

    }

    //Peticio para ingresar a la "Base de datos"
    @PostMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
                        //Respuesta Base dado que solo se da el feedback de lo ocurrido
    public ResponseEntity<RespuestaBase> create(@RequestBody CarTO user){
        RespuestaBase response = new RespuestaBase(200,"Entrada Creada Correctamente");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    //Respuesta en la clase RespuestaBase al ser una modificacion a la BD
    public ResponseEntity<RespuestaBase> deleteById(){
        try {
            verifyEmpty(getData());
            int id = (int) Math.floor(Math.random() * 60 + 1);
            CarResponseTO car = new CarResponseTO();
            car.getCar().remove(id); //Remover de la "base de datos" el elemento correspondiente al Id
            RespuestaBase response = new RespuestaBase();
            response.setMessage("Auto Eliminado");
            response.setStatus(200);
            return new ResponseEntity<>(response,HttpStatus.OK); //Respuesta de la peticion
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //Respuesta para el peticion
        }

    }

    //Metodo para simular registros de la Base de datos
    public static List<CarTO> getData(){
        List<CarTO> response = new ArrayList<CarTO>();
        String marcas[] = {"Ford","Dodge","Mazda","Chevrolet"};
        String Colores[] = {"Rojo","Blanco","Amarillo","Azul","Negro"};
        String Placas[] = {"AS3","VF5","WR7","FH6","PR6"};
        int datos = (int) Math.floor(Math.random()*60);
        for(int i = 0; i<datos;i++){
            response.add(new CarTO(i,marcas[(int) Math.floor(Math.random()*marcas.length)],
                    "Model",Colores[(int) Math.floor(Math.random()*Colores.length)],
                    Placas[(int)Math.floor(Math.random()*Placas.length)]));
        }
        return response;
    }

    public static void verifyEmpty(List<CarTO> Lista){
        if(Lista.isEmpty()){
            throw new NullPointerException();
        }
    }

}
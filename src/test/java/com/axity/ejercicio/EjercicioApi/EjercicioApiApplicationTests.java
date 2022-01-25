package com.axity.ejercicio.EjercicioApi;

import com.axity.ejercicio.EjercicioApi.commons.CarResponseTO;
import com.axity.ejercicio.EjercicioApi.commons.CarTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.axity.ejercicio.EjercicioApi.web.CarController;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class EjercicioApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void SetDataIsNotNull(){
		CarResponseTO a = new CarResponseTO();
		a.setCar(CarController.getData());
		Assertions.assertTrue(a.getCar().size()>0);
	}

	@Test
	void SizeSetDataIsOneUnitLessAfterDeleteMtehod(){
		int id = (int) 1;
		CarResponseTO car = new CarResponseTO();
		car.setCar(CarController.getData());
		int before = car.getCar().size();
		car.getCar().remove(id);
		Assertions.assertEquals(before-1,car.getCar().size());
	}

	@Test
	void SizeSetDataIsOneUnitMoreAfterPostMethod(){
		CarResponseTO car = new CarResponseTO();
		car.setCar(CarController.getData());
		int before = car.getCar().size();
		car.getCar().add(new CarTO(1,"Ford","Fiest","Negro","R"));
		Assertions.assertEquals(before+1,car.getCar().size());
	}


}

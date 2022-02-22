package com.example;

import org.springframework.stereotype.Component;

import com.example.ioc.Servicio;

@Component
public class Servicioimpl implements Servicio {

	public Servicioimpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("Soy el servicio");

	}

}

package com.gesinv.gestioninventario.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor

public class ExceptionResponse {

	private LocalDateTime fecha;
	private String mensaje;
	private String detalles;
	
	

}

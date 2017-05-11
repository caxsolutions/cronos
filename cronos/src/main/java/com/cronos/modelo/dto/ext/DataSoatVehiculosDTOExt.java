package com.cronos.modelo.dto.ext;

import java.util.Date;

import com.cronos.modelo.P10soat;

public class DataSoatVehiculosDTOExt extends P10soat {
	
	private Date fechafinalvigencia;
	private String estadosoat;
	private String estadovigencia;

	public DataSoatVehiculosDTOExt() {
	}

	public Date getFechafinalvigencia() {
		return fechafinalvigencia;
	}

	public void setFechafinalvigencia(Date fechafinalvigencia) {
		this.fechafinalvigencia = fechafinalvigencia;
	}

	public String getEstadosoat() {
		return estadosoat;
	}

	public void setEstadosoat(String estadosoat) {
		this.estadosoat = estadosoat;
	}

	public String getEstadovigencia() {
		return estadovigencia;
	}

	public void setEstadovigencia(String estadovigencia) {
		this.estadovigencia = estadovigencia;
	}
	
}

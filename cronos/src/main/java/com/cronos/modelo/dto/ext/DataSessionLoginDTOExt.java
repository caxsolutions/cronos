package com.cronos.modelo.dto.ext;

import java.io.Serializable;

import com.cronos.modelo.P00empresa;
import com.cronos.modelo.P00usuario;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura/
*
*/
public class DataSessionLoginDTOExt implements Serializable {
    private static final long serialVersionUID = 1L;

    private P00usuario p00usuario;
    private P00empresa p00empresa;
    private Boolean changePassXDate;
    private Boolean changePassXValidation;
    private Boolean estadoPassword;

	public DataSessionLoginDTOExt() {
		super();
	}

	/**
	 * @return the p00usuario
	 */
	public P00usuario getP00usuario() {
		return p00usuario;
	}

	/**
	 * @param p00usuario the p00usuario to set
	 */
	public void setP00usuario(P00usuario p00usuario) {
		this.p00usuario = p00usuario;
	}

	/**
	 * @return the p00empresa
	 */
	public P00empresa getP00empresa() {
		return p00empresa;
	}

	/**
	 * @param p00empresa the p00empresa to set
	 */
	public void setP00empresa(P00empresa p00empresa) {
		this.p00empresa = p00empresa;
	}

	/**
	 * @return the changePassXDate
	 */
	public Boolean getChangePassXDate() {
		return changePassXDate;
	}

	/**
	 * @param changePassXDate the changePassXDate to set
	 */
	public void setChangePassXDate(Boolean changePassXDate) {
		this.changePassXDate = changePassXDate;
	}

	/**
	 * @return the changePassXValidation
	 */
	public Boolean getChangePassXValidation() {
		return changePassXValidation;
	}

	/**
	 * @param changePassXValidation the changePassXValidation to set
	 */
	public void setChangePassXValidation(Boolean changePassXValidation) {
		this.changePassXValidation = changePassXValidation;
	}

	/**
	 * @return the estadoPassword
	 */
	public Boolean getEstadoPassword() {
		return estadoPassword;
	}

	/**
	 * @param estadoPassword the estadoPassword to set
	 */
	public void setEstadoPassword(Boolean estadoPassword) {
		this.estadoPassword = estadoPassword;
	}
}

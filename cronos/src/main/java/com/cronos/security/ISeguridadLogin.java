/**
 * @autor CACP - RFAST9 6/07/2016
 */
package com.cronos.security;

import java.io.InputStream;

import com.cronos.modelo.P00empresa;
import com.cronos.modelo.P00usuario;

/**
 * @autor luxos CACP - RFAST9 6/07/2016
 *
 */
public interface ISeguridadLogin {

	/**
	 * Metodo que destruye la session al cerrar o un error en el sistema.
	 */
	public abstract void destroySession() throws Exception;

	/**
	 * Metodo que retorna el obj de empresa de la session de usuario logueado.
	 */
	public abstract P00empresa getEmpresaUsuario();

	/**
	 * Metodo que retorna el obj de usuario de la session de usuario logueado.
	 */
	public abstract P00usuario getUsuarioLogin();

	/**
	 * Metodo que valida si el usuario que se esta logueando debe o no cambiar la clave.
	 * Debe cambiar la clave si :
	 * 
	 * 	1. No tiene una clave asignada en el campo validacion de la tabla p00usuario.
	 *  2. verificar si tiene permiso para poder cambiar la clave.
	 *  
	 *  @return
	 *  true = Debe cambiar la clave
	 *  false = No debe cambiar la clave
	 */
	public abstract Boolean validaAsignacionClaveUsuario(P00usuario usuario)
			throws Exception;

	/**
	 * Metodo que valida si el usuario que se esta logueando debe o no cambiar la clave (Solo por vencimiento).
	 * Debe cambiar la clave si :
	 * 
	 * 	1. Si la fechacambio es menor o igual a la fecha actual.
	 *  2. verificar si tiene permiso para poder cambiar la clave.
	 *  
	 *  @return
	 *  true = Debe cambiar la clave
	 *  false = No debe cambiar la clave
	 */
	public abstract Boolean validaVencimientoClaveUsuario(P00usuario usuario)
			throws Exception;

	/**
	 * Este metodo valida si el usuario logueado tiene el mismo password.
	 * Este metodo solo valida la clave digita en el login
	 * @throws Exception
	 * @param P00usuario
	 * @param passwordLogue (cadena sin encriptada en md5)
	 * @return Boolean
	 *  true = La clave es valida para el usuario 
	 */
	public abstract Boolean validaPasswordLogin(P00usuario usuario,
			String passwordLogue) throws Exception;

	/**
	 * Metodo que cambia el password del usuario login por solicitud.
	 * @param String = cadena del login sin encriptar
	 * @return Boolean = true : se cambio con exito, false : error al cambiar.
	 */
	public abstract Boolean cambiarPasswordUserLogin(String passChange)
			throws Exception;

	//************************************** cifradores *********************************************************************
	/**
	 * Metodo que convierte cadena a MD5.
	 */
	public abstract String convertStringToMd5(String claveLogin);

	// *******************************DATOS DE LA EMPRESA*******************************//
	public abstract String checkString(String text);

	/**
	 * Metodo que retorna un inputStream con la imagen o logo de la base de datos p00empresa,
	 * si no existen, por defecto envia las imagenes logotipo1Encabezado y logotipo2Encabezado respectivamente.
	 * @author CACP - 20-08-2015
	 */
	public abstract InputStream getLogosEmpresa()throws Exception;

}
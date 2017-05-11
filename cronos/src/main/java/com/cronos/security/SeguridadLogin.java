package com.cronos.security;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cronos.modelo.P00empresa;
import com.cronos.modelo.P00perfil;
import com.cronos.modelo.P00usuario;
import com.cronos.modelo.control.IP00empresaLogic;
import com.cronos.modelo.control.IP00perfilLogic;
import com.cronos.modelo.control.IP00usuarioLogic;
import com.cronos.modelo.dto.ext.DataSessionLoginDTOExt;

@Scope("singleton")
@Service("SeguridadLogin")
public class SeguridadLogin implements ISeguridadLogin {

	@Resource
	private SessionFactory sessionFactory;

	@Autowired
    private IP00usuarioLogic logicP00usuario;

    @Autowired
    private IP00empresaLogic logicP00empresa;
    
    @Autowired
    private IP00perfilLogic logicP00perfil;

    @Autowired
	private HttpServletRequest request;

    private  String msg2010 = "La entidad p00usuario no debe ser nula.";
    private  String msg2011 = "El usuario no tiene permisos para cambiar la contrasena.";
    private  String msg2012 = "El usuario no tiene una contrasena asignada.";
    private  String msg2007 = "Esta cuenta Cronos no existe. Escribe otra direccion de correo electronico.";
    private  String msg2004 = "Debe digitar el usuario y la contrasena para ingresar al sistema.";

	public SeguridadLogin() {
	}
	
	/**
	 * Metodo que destruye la session al cerrar o un error en el sistema.
	 */
	@Override
	public void destroySession()throws Exception{
    	try {
			
    		request.getSession(true).invalidate();

		} catch (Exception e) {
			throw e;
		}
    }
    

	/**
	 * Metodo que retorna el obj de empresa de la session de usuario logueado.
	 */
	@Transactional(readOnly = true)
	public P00empresa getEmpresaUsuario(){

		P00empresa p00empresa = new P00empresa();
		
		try {
			
			DataSessionLoginDTOExt dataSessionLoginDTOExt = (DataSessionLoginDTOExt)request.getSession().getAttribute("DataSessionLogin");

			if(dataSessionLoginDTOExt != null && dataSessionLoginDTOExt.getP00empresa() != null){
		
				p00empresa = dataSessionLoginDTOExt.getP00empresa();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return p00empresa;
	}
    
	/**
	 * Metodo que retorna el obj de usuario de la session de usuario logueado.
	 */
	@Transactional(readOnly = true)
	public P00usuario getUsuarioLogin(){

    	P00usuario p00usuario = new P00usuario();
		
		try {

			DataSessionLoginDTOExt dataSessionLoginDTOExt = (DataSessionLoginDTOExt)request.getSession().getAttribute("DataSessionLogin");
			p00usuario = dataSessionLoginDTOExt.getP00usuario();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return p00usuario;
	}
    
    
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
	@Transactional(readOnly = true)    
    public Boolean validaAsignacionClaveUsuario(P00usuario usuario) throws Exception{

		try {
		
			Boolean valida = false;
			
			if(usuario == null || usuario.getRowidusuario() == null){
				throw new Exception(msg2010); 
			}
			
			P00usuario p00usuario = logicP00usuario.getP00usuario(usuario.getRowidusuario());
			
			if(p00usuario != null && p00usuario.getRowidusuario() != null){
    			
    			if(p00usuario.getCambiacontrasena()){
    				
    				if(p00usuario.getValidacion() == null || p00usuario.getValidacion().isEmpty()){
    					
    					valida = true;
    				}
    			}
    		}else{
    			throw new Exception(msg2007);
    		}
			
			return valida;
			
		} catch (Exception e) {
			throw e;
		}
	}
	

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
	@Transactional(readOnly = true)    
    public Boolean validaVencimientoClaveUsuario(P00usuario usuario) throws Exception{

		try {
		
			Boolean valida = false;
			
			if(usuario == null || usuario.getRowidusuario() == null){
				throw new Exception(msg2010); 
			}
			
			P00usuario p00usuario = logicP00usuario.getP00usuario(usuario.getRowidusuario());
			
			if(p00usuario != null && p00usuario.getRowidusuario() != null){
    			
    			if(p00usuario.getCambiacontrasena()){
    				
    				if(p00usuario.getFechacambio() != null){
    					if(p00usuario.getFechacambio().before(new Date()) || p00usuario.getFechacambio().equals(new Date())){
    						valida = true;
    					}
    				}
    			}else{
    				throw new Exception(msg2011);
    			}
    			
    		}else{
    			throw new Exception(msg2007);
    		}
			
			return valida;
			
		}catch (Exception e) {
			throw e;
		}
    }
    

	/**
	 * Este metodo valida si el usuario logueado tiene el mismo password.
	 * Este metodo solo valida la clave digita en el login
	 * @throws Exception
	 * @param P00usuario
	 * @param passwordLogue (cadena sin encriptada en md5)
	 * @return Boolean
	 *  true = La clave es valida para el usuario 
	 */
	@Transactional(readOnly = true)    
    public Boolean validaPasswordLogin(P00usuario usuario, String passwordLogue) throws Exception{
    	try {
    		
    		Boolean valida = false;
    		
    		if(passwordLogue == null || passwordLogue.isEmpty()){
    			throw new Exception(msg2004);
    		}
    		
    		if(usuario == null){
    			throw new Exception(msg2007);
    		}
    		
    		String passwordEncript = convertStringToMd5(passwordLogue);
    		
    		P00usuario p00usuario = logicP00usuario.getP00usuario(usuario.getRowidusuario());
    		
    		if(p00usuario != null && p00usuario.getRowidusuario() != null){
    			
    			if(p00usuario.getValidacion() != null && !p00usuario.getValidacion().isEmpty()){
    				
        			if(p00usuario.getValidacion().equalsIgnoreCase(passwordEncript)){
        				valida = true;
        			}
    			}else{
        			throw new Exception(msg2012);
        		}
    			
    			return valida;
    			
    		}else{
    			throw new Exception(msg2007);
    		}
			
		} catch (Exception e) {
			throw e;
		}
    }
	
	/**
	 * Metodo que cambia el password del usuario login por solicitud.
	 * @param String = cadena del login sin encriptar
	 * @return Boolean = true : se cambio con exito, false : error al cambiar.
	 */
	public Boolean cambiarPasswordUserLogin(String passChange)throws Exception{
		try {
			
			Boolean estado = false;
			
			P00usuario p00usuario = getUsuarioLogin();
			P00perfil p00perfil = logicP00perfil.getP00perfil(p00usuario.getP00perfil().getRowidperfil());
			
			if((p00usuario != null && p00usuario.getRowidusuario() != null) && (p00perfil != null && p00perfil.getRowidperfil() != null)){
				
				String passMd5 = convertStringToMd5(passChange);
				
				p00usuario.setValidacion(passMd5);
				
				Calendar calendar = Calendar.getInstance();
            	calendar.setTime(new Date()); // Configuramos la fecha que se recibe
            	calendar.add(Calendar.DAY_OF_YEAR, p00perfil.getDiasvigencia());  // numero de dias a anadir

            	p00usuario.setFechacambio(calendar.getTime());
				
            	logicP00usuario.updateP00usuario(p00usuario);
            	
            	cambioParametrosAtributoSession();
            	
            	estado = true;
			}
			
			return estado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Metodo que cambia los valores de los parametros a las atributos de la session
	 * DataSessionLogin
	 * cambia los valores de 
	 * setChangePassXValidation
	 * setChangePassXDate
	 */
	private void cambioParametrosAtributoSession(){
		try {
			
			DataSessionLoginDTOExt dataSessionLoginDTOExt = (DataSessionLoginDTOExt)request.getSession().getAttribute("DataSessionLogin");
			
			dataSessionLoginDTOExt.setChangePassXDate(false);
			dataSessionLoginDTOExt.setChangePassXValidation(false);
			
			request.getSession().setAttribute("DataSessionLogin", dataSessionLoginDTOExt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}    

	//************************************** cifradores *********************************************************************

	public String convertStringToMd5(String claveLogin){
		try {
			
			return getStringMessageDigest(claveLogin, "MD5");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
    /***
     * Convierte un arreglo de bytes a String usando valores hexadecimales
     * @param digest arreglo de bytes a convertir
     * @return String creado a partir de <code>digest</code>
     */
    private static String toHexadecimal(byte[] digest){
    	
        String hash = "";
        
        for(byte aux : digest) {
        
        	int b = aux & 0xff;
            
        	if (Integer.toHexString(b).length() == 1){
        		hash += "0";
        	}
        	
            hash += Integer.toHexString(b);
        }
        
        return hash;
    }

    /***
     * Encripta un mensaje de texto mediante algoritmo de resumen de mensaje.
     * @param message texto a encriptar
     * @param algorithm algoritmo de encriptacion, puede ser: MD2, MD5, SHA-1, SHA-256, SHA-384, SHA-512
     * @return mensaje encriptado
     */
    private static String getStringMessageDigest(String message, String algorithm){
    	
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
        
            digest = messageDigest.digest();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        return toHexadecimal(digest);
    }
    //****************************************************************************************************************************
    
	// *******************************DATOS DE LA EMPRESA*******************************//
	public String checkString(String text) {	
		if (text == null) {
			return "";
		}
		return text;
	}

	/**
	 * Metodo que retorna un inputStream con la imagen o logo de la base de datos p00empresa,
	 * si no existen, por defecto envia las imagenes logotipo1Encabezado y logotipo2Encabezado respectivamente.
	 * @author CACP - 20-08-2015
	 */
	public InputStream getLogosEmpresa() throws Exception {
		try {
			/*
			File img1 = new File(Utiles.getRealPath(ReporteUtil.imagesReportPath + ReporteUtil.logotipo1Encabezado));
			InputStream logo = new FileInputStream(img1);			

			DataSessionEmpresaLoginDTOExt dataSessionEmpresaLoginDTOExt = getObjDataSessionEmpresaLoginDTO();

			if(dataSessionEmpresaLoginDTOExt != null){
				
				if(dataSessionEmpresaLoginDTOExt.getLogo2() != null && !dataSessionEmpresaLoginDTOExt.getLogo2().isEmpty()){
					
					byte[] logo2 = org.apache.commons.codec.binary.Base64.decodeBase64(dataSessionEmpresaLoginDTOExt.getLogo2());
					logo = new ByteArrayInputStream(logo2);
				}else{
					
					File img2 = new File(Utiles.getRealPath(ReporteUtil.imagesReportPath + ReporteUtil.logotipo2Encabezado));
					logo = new FileInputStream(img2);			
				}
			}
			*/
			return null; //logo

		} catch (Exception e) {
			throw e;
		}
	}
	
	// *******************************DATOS DE LA EMPRESA*******************************//	
}

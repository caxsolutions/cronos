package com.cronos.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.cronos.modelo.P00empresa;
import com.cronos.modelo.P00perfil;
import com.cronos.modelo.P00usuario;
import com.cronos.modelo.control.IP00empresaLogic;
import com.cronos.modelo.control.IP00perfilLogic;
import com.cronos.modelo.control.IP00usuarioLogic;
import com.cronos.modelo.dto.ext.DataSessionLoginDTOExt;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Component("zathuraCodeAuthenticationProvider")
public class ZathuraCodeAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ISeguridadLogin logicSeguridadLogin;
	
	@Autowired
	private IP00usuarioLogic logicP00usuario;

	@Autowired
	private IP00perfilLogic logicP00perfil;
	
	@Autowired
	private IP00empresaLogic logicP00empresa;
	
    //////////////////// mensajes para el login NO BORRAR ////////////////////////
    private  String msg2004 = "Debe digitar el usuario y la contraseña para ingresar al sistema.";
    private  String msg2007 = "Esta cuenta Cronos no existe. Escribe otra dirección de correo electrónico.";
    private  String msg2016 = "El usuario no esta habilitado.";
    private  String msg2017 = "El perfil del usuario no esta habilitado.";
    private  String msg2015 = "No se encontro una empresa asociada al usuario.";

	/**
     * Security Implementation
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	try {
			
            String name = authentication.getName();
            String password = authentication.getCredentials() != null ? authentication.getCredentials().toString() : null;

            if((name == null || name.isEmpty()) || (password == null || password.isEmpty())){
            	throw new Exception(msg2004);
            }
            
            P00usuario p00usuario = validandoDataLogin(name, password);
            
            DataSessionLoginDTOExt dataSessionLoginDTOExt = crearObjDataSession(p00usuario);
            
            final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

            final UserDetails principal = new User(name, logicSeguridadLogin.convertStringToMd5(password), grantedAuths);
            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, logicSeguridadLogin.convertStringToMd5(password), grantedAuths);

            ///creando atributos para la session del sistema. ////////////////////
        	request.getSession().setAttribute("DataSessionLogin", dataSessionLoginDTOExt);
        	request.getSession().setAttribute("errorLogin", null);

            return auth;
            
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * metdo que valida los datos de autenticancion
     * @autor CACP - RFAST9 6/07/2016
     * @param name
     * @param password
     * @throws Exception
     */
    private P00usuario validandoDataLogin(String name, String password)throws Exception{
    	try {
    		
    		P00usuario p00usuario = new P00usuario();
			
            if((name == null || name.isEmpty()) || (password == null || password.isEmpty())){
            	throw new Exception(msg2004);
            }

            String passwordMd5 = logicSeguridadLogin.convertStringToMd5(password);
            
            Object[] variables = {
            		"usuario", true, name, "=",
            		"validacion", true, passwordMd5, "=",
            };
            List<P00usuario> p00usuarioList = logicP00usuario.findByCriteria(variables, null, null);
            
            if(p00usuarioList != null && p00usuarioList.size() > 0){
            	
            	p00usuario = p00usuarioList.get(p00usuarioList.size()-1);
            	
            }else{
            	throw new Exception(msg2007);
            }
            
            return p00usuario;
    		
		} catch (Exception e) {
			throw e;
		}
    }

    /**
     * metdo que que valida los datos y carga un dto con los datos de session.
     * @autor CACP - RFAST9 6/07/2016
     * @param p00usuario
     * @throws Exception
     */
    private DataSessionLoginDTOExt crearObjDataSession(P00usuario p00usuario)throws Exception{
    	try {

	        //se valida si el usuario esta habilitado ///////////////
	        if(p00usuario != null && !p00usuario.getHabilita()){
	        	throw new Exception(msg2016);
	        }
	        //////////////////////////////////////////////////////////////////////////////////

	        //se valida si el perfil el usuario esta habilitado ///////////////
	        if(p00usuario != null && (p00usuario.getP00perfil() != null && p00usuario.getP00perfil().getRowidperfil() != null)){
	        	
	        	P00perfil p00perfil = logicP00perfil.getP00perfil(p00usuario.getP00perfil().getRowidperfil());
	        	
	        	if(p00perfil != null && !p00perfil.getHabilita()){
	        		throw new Exception(msg2017);
	        	}
	        }
	        //////////////////////////////////////////////////////////////////////////////////

	        // validando la empresa /////////////////////////////////////
	        P00empresa p00empresaUserLogin = new P00empresa();
	        if(p00usuario.getP00empresa() != null){
	        	p00empresaUserLogin = logicP00empresa.getP00empresa(p00usuario.getP00empresa().getRowidempresa());
	        }else{
	        	throw new Exception(msg2015);
	        }
	        ////////////////////////////////////////////////////////////
	        
        	DataSessionLoginDTOExt dataSessionLoginDTOExt = new DataSessionLoginDTOExt();

            dataSessionLoginDTOExt.setP00usuario(p00usuario);
            dataSessionLoginDTOExt.setP00empresa(p00empresaUserLogin);
            dataSessionLoginDTOExt.setEstadoPassword(true);
        	
        	//metodo que valida si el usuario debe cambiar la clave por que no se le ha asignado una.
        	if(logicSeguridadLogin.validaAsignacionClaveUsuario(p00usuario)){
        		dataSessionLoginDTOExt.setChangePassXValidation(true);
        	}
        	
        	// metodo que valida si el usuario debe cambiar la clave por vencimiento.
        	if(logicSeguridadLogin.validaVencimientoClaveUsuario(p00usuario)){
        		dataSessionLoginDTOExt.setChangePassXDate(true);
        	}
        	
    		return dataSessionLoginDTOExt;
    		
		} catch (Exception e) {
			throw e;
		}
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

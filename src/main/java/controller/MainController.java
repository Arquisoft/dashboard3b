package controller;

import hello.MainController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Citizen;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import business.CitizenService;
import business.impl.CitizenServiceImpl;
import util.Encriptador;
import util.ParticipantsException;
import util.VerificadorEmail;

@Controller
public class MainController {

	
	 private static final Logger logger = Logger.getLogger(MainController.class);
	    private List<Object> sseEmitters = Collections.synchronizedList(new ArrayList<>());

	private CitizenService citizenService;


	    @RequestMapping("/")
	    public String landing(Model model) {
	        return "login";
	    }

	//
	// @RequestMapping("/hola")
	// public String hola(Model model) {
	// model.addAttribute("nombre", "Luis");
	// return "saludo";
	// }
	//
	@RequestMapping("/inicio")
	public String log() {
		return "login";
	}

	// Salimos de sesion
	@RequestMapping("/salir")
	public String salir(Model model, HttpSession session) {
		session.removeAttribute("user");
		model.addAttribute("user", null);

		return "login";

	}

//	@RequestMapping("/testUsuario")
//	public String testUsuario(Model model, HttpSession session) {
//		@SuppressWarnings("deprecation")
//		Date fecha = new Date(0, 0, 0);
//		Citizen user = new Citizen("testUser", Encriptador.encriptar("ss"),
//				"email@test.com", "123T", "TestName", "TestApp", fecha,
//				"C/test", "España");
//		model.addAttribute("user", user);
//		session.setAttribute("user", user);
//		return "infoUsuario";
//	}
	//
	//
	//
	 @RequestMapping(value = "/entrar", method = RequestMethod.POST)
	public String getParticipantInfo(HttpSession session, Model modelo,
			@RequestParam String nombre, @RequestParam String password) {
	
	 if(nombre.length()<=0 || password.length()<=0) {
	 modelo.addAttribute("err", "Complete todos los campos");
	 return "login";
	 }
	 citizenService = new CitizenServiceImpl();
	 
	 try {
	// user = userService.findLoggableUser(nombre, password);
	
	if(user==null){
	 modelo.addAttribute("err", "Usuario no encontrado");
	 return "login";
	 }
	 System.err.println();
	
	 session.setAttribute("user", user);
	 } catch (ParticipantsException e) {
	 modelo.addAttribute("err", e.getMessage());
	 return "login";
	 }
	//
	// //retornara la "web" con info del usuario
	// modelo.addAttribute("user", user);
	// return "infoUsuario";
	// }
	//
	// @RequestMapping(value = "/volverAinfo",
	// method = RequestMethod.GET)
	// public String getParticipantInfo(HttpSession session,Model
	// modelo,@ModelAttribute("user") UserInfo usuario) {
	// modelo.addAttribute("user", session.getAttribute("user"));
	//
	// return "infoUsuario";
	// }
	//
	// @RequestMapping(value = "/cambiarE")
	// public String navegarCambiarEmail(Model modelo)
	// {
	// modelo.addAttribute("err", " ");
	// return "cambiarEmail";
	// }
	//
	//
	//
	// @RequestMapping(value = "/cambioEmail",
	// method = RequestMethod.POST)
	// public String changeEmail(HttpSession session, Model
	// modelo,@ModelAttribute("user") UserInfo usuario, @RequestParam String
	// password,
	// @RequestParam String newEmail){
	// userService = new CitizenServiceImpl();
	// UserInfo user = (UserInfo) session.getAttribute("user");
	//
	// try {
	//
	// if(!password.equals(Encriptador.desencriptar(user.getPassword()))){
	// modelo.addAttribute("err", "Contraseña incorrecta");
	// return "cambiarEmail";
	// }
	// if(!VerificadorEmail.validateEmail(newEmail)) {
	// modelo.addAttribute("err", "Email incorrecto");
	// return "cambiarEmail";
	// }
	//
	// modelo.addAttribute("err", "");
	// userService.changeEmail(user, newEmail);
	// modelo.addAttribute("err","");
	// session.setAttribute("user", user);
	// modelo.addAttribute("success","Se ha actualizado la contraseña correctamente");
	// return "exito";
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// modelo.addAttribute("err",e.getMessage());
	// return "error";
	// }
	// }
	//
	// @RequestMapping(value = "/cambiar")
	// public String navegarCambiarContrasena( Model modelo,
	// @ModelAttribute("user") UserInfo usuario)
	// {
	// modelo.addAttribute("user",usuario);
	// modelo.addAttribute("err", " ");
	// return "cambiarPass";
	// }
	//
	//
	// @RequestMapping(value = "/cambio",
	// method = RequestMethod.POST)
	// public String changePassword(HttpSession session, Model
	// modelo,@ModelAttribute("user") UserInfo usuario, @RequestParam String
	// password,
	// @RequestParam String newPassword1,@RequestParam String newPassword2){
	// userService = new CitizenServiceImpl();
	// UserInfo user = (UserInfo) session.getAttribute("user");
	// try {
	//
	// if(!password.equals(Encriptador.desencriptar(user.getPassword()))){
	// modelo.addAttribute("err", "Contraseña incorrecta");
	// return "cambiarPass";
	// }
	// if(newPassword1.length()<=0) {
	// modelo.addAttribute("err", "Escriba la nueva contraseña");
	// return "cambiarPass";
	// }
	// if(!newPassword1.equals(newPassword2)){
	// modelo.addAttribute("err", "Las contraseñas deben coincidir");
	// return "cambiarPass";
	// }
	//
	// modelo.addAttribute("err", "");
	// userService.changePassword(user, newPassword1);
	// modelo.addAttribute("err","");
	// modelo.addAttribute("user", user);
	// session.setAttribute("user", user);
	// modelo.addAttribute("success","Se ha actualizado la contraseña correctamente");
	// return "exito";
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// modelo.addAttribute("err",e.getMessage());
	// return "error";
	// }
	// }
	//

}
package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Administrador;
import model.Citizen;
import model.exception.BusinessException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import business.CitizenService;
import business.SystemService;
import business.impl.CitizenServiceImpl;
import business.impl.SystemServiceImpl;
import util.Encriptador;
import util.VerificadorEmail;

@Controller
@Scope("session")
public class MainController {
	//
	// @Autowired
	// private KafkaProducer kafkaProducer;

	private boolean test = true;

	private static final Logger logger = Logger.getLogger(MainController.class);
	private List<Object> sseEmitters = Collections
			.synchronizedList(new ArrayList<>());

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

	// @RequestMapping("/testUsuario")
	// public String testUsuario(Model model, HttpSession session) {
	// @SuppressWarnings("deprecation")
	// Date fecha = new Date(0, 0, 0);
	// Citizen user = new Citizen("testUser", Encriptador.encriptar("ss"),
	// "email@test.com", "123T", "TestName", "TestApp", fecha,
	// "C/test", "España");
	// model.addAttribute("user", user);
	// session.setAttribute("user", user);
	// return "infoUsuario";
	// }
	//
	//
	//
	@RequestMapping(value = "/entrar", method = RequestMethod.POST)
	public String getParticipantInfo(HttpSession session, Model modelo,
			@RequestParam String nombre, @RequestParam String password) {

		/******************
		 * TEST ************************ Test administrador para acceder a
		 * dashboard sin BD : Usuario: admin Password: admin
		 * 
		 * Test ciudadano para acceder a informacion sin BD: Usuario: ciudadano
		 * Password: ciudadano
		 * 
		 * */
		if (test) {
			if (nombre.equals("admin") && password.equals("admin")) {
				Administrador admin = new Administrador("admin", "admin");
				session.setAttribute("user", admin);
				session.setAttribute("tipo", "admin");
				return "dashboard";

			} else if (nombre.equals("ciudadano1")
					&& password.equals("ciudadano")) {
				Citizen citizen = new Citizen("testCitizen", "apellidos",
						"testemail@email", new Date(0), "direccion",
						"nacionalidad", "DNI", "ciudadano1", "ciudadano");

				session.setAttribute("user", citizen);
				session.setAttribute("tipo", "ciudadano");
				modelo.addAttribute("user", citizen);
				return "infoUsuario";
			} else {
				modelo.addAttribute("err", "Usuario no encontrado");
				return "login";
			}
		}
		/**
	 * 
	 * ******************************************************/
		if (nombre.length() <= 0 || password.length() <= 0) {
			modelo.addAttribute("err", "Complete todos los campos");
			return "login";
		}

		try {
			SystemService sService = new SystemServiceImpl();
			Administrador admin = sService.findLoggableAdmin(nombre, password);
			if (admin != null) {
				session.setAttribute("user", admin);
				session.setAttribute("tipo", "admin");
				return "dashboard";
			} else {

				Citizen ciudadano = sService.findLoggableCitizen(nombre,
						password);
				if (ciudadano == null && admin == null) {
					modelo.addAttribute("err", "Usuario no encontrado");
					return "login";
				} else {
					session.setAttribute("user", ciudadano);
					session.setAttribute("tipo", "ciudadano");
					modelo.addAttribute("user", ciudadano);
					return "infoUsuario";
				}
			}
		} catch (BusinessException e) {
			modelo.addAttribute("err", e.getMessage());
			return "login";
		}
	}

	//
	 @RequestMapping(value = "/volverAinfo",
	 method = RequestMethod.GET)
	 public String getParticipantInfo(HttpSession session,Model
 modelo,
			@ModelAttribute("user") Citizen usuario) {
	 modelo.addAttribute("user", session.getAttribute("user"));
	
	 return "infoUsuario";
	 }
	//
	@RequestMapping(value = "/cambiarE")
	public String navegarCambiarEmail(Model modelo) {
		modelo.addAttribute("err", " ");
		return "cambiarEmail";
	}

	//
	//
	@RequestMapping(value = "/cambioEmail", method = RequestMethod.POST)
	public String changeEmail(HttpSession session, Model modelo,
			@ModelAttribute("user") Citizen usuario,
			@RequestParam String password, @RequestParam String newEmail) {
		CitizenService cService = new CitizenServiceImpl();
		Citizen user = (Citizen) session.getAttribute("user");

		try {
			if((test && password.equals("ciudadano")) || password.equals(Encriptador.desencriptar(user.getPassword()))){

				if (!VerificadorEmail.validateEmail(newEmail)) {
					modelo.addAttribute("err", "Email incorrecto");
					return "cambiarEmail";
				}

				modelo.addAttribute("err", "");
				if(!test) cService.changeEmail(user, newEmail);
				else user.setEmail(newEmail);
				
				session.setAttribute("user", user);
				modelo.addAttribute("success",
						"Se ha actualizado el email correctamente");
				return "exito";

			}
			else{
				modelo.addAttribute("err", "Contraseña incorrecta");
				return "cambiarEmail";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			modelo.addAttribute("err", e.getMessage());
			return "error";
		}
	}
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
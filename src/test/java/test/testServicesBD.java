package test;

import static org.junit.Assert.*;

import java.sql.Date;


import model.Administrador;
import model.Citizen;
import model.exception.BusinessException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import persistence.AdministradorFinder;
import persistence.CitizenFinder;
import util.EliminarTester;
import business.CitizenService;
import business.SystemService;
import business.impl.CitizenServiceImpl;
import business.impl.SystemServiceImpl;
import controller.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class testServicesBD {

	Citizen testCitizen;
	Administrador admin;
	
	SystemService sService = new SystemServiceImpl();
	CitizenService cService = new CitizenServiceImpl();
	
	@Before
	public void setUp() {
		
		testCitizen= new Citizen("nombre", "apellidos","testemail@email", new Date(0), "direccion",
				"nacionalidad","DNI", "usuario", "password");
	
	}
	

	@Test
	public void testFinder() throws BusinessException{
		
		cService.addCitizen(testCitizen);
		
		
		Citizen encontrado= CitizenFinder.findByUser(testCitizen.getUsuario());
		Citizen encontrado2 = sService.findLoggableCitizen(testCitizen.getNombre(), testCitizen.getPassword());
		
		Administrador adminEncontrado =  AdministradorFinder.findByUserAndPass("admin", "admin");
		Administrador adminEncontrado2 = sService.findLoggableAdmin("admin", "admin");
		
		assertNotNull(encontrado);
		assertNotNull(encontrado2);
		assertNotNull(adminEncontrado);
		assertNotNull(adminEncontrado2);
		
		assertEquals(encontrado.getDNI(),testCitizen.getNombre());
		assertEquals(encontrado2.getDNI(),testCitizen.getNombre());
		
		assertEquals(adminEncontrado.getUsuario(),admin.getUsuario());
		assertEquals(adminEncontrado2.getUsuario(),admin.getUsuario());
	
	}
	
	@Test
	public void testUpdate() throws BusinessException {
		
		String emailViejo = sService.findLoggableCitizen(testCitizen.getUsuario(), testCitizen.getPassword()).getEmail();
		String nuevoEmail= "email2@email.com";
		assertEquals(testCitizen.getEmail(), emailViejo);

		cService.changeEmail(testCitizen, nuevoEmail);
		
		assertEquals((CitizenFinder.findByUser(testCitizen.getUsuario()).getEmail()), nuevoEmail);
		
		cService.changeEmail(testCitizen, emailViejo);
		
		assertEquals((CitizenFinder.findByUser(testCitizen.getUsuario()).getEmail()), emailViejo);
		
		
	}
	
	@Test
	public void noExisteEnBDTest() {


		Citizen noCitizen= new Citizen("nombreNoExisteEnBD", "apellidos","testemail@email", new Date(0), "direccion",
				"nacionalidad","DNI", "usuario", "password");
		System.out.println(noCitizen.getApellidos());
	//	assertNull(CitizenFinder.findByUser(noCitizen.getUsuario()));
	}
	


	@After
	public void limpiarTest(){
		EliminarTester.borrarTester(testCitizen.getUsuario());
	
	}

}

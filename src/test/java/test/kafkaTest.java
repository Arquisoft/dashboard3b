package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

import model.Categoria;
import model.Citizen;
import model.Comentario;
import model.Sugerencia;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import business.CitizenService;
import business.impl.CitizenServiceImpl;
import controller.Application;
import dashboard.kafka.Message;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class kafkaTest {
	
	Citizen testCitizen;
	Categoria testCategoria;
	Sugerencia testSugerencia;
	Comentario testComentario;
	
	@Before
	public void setUp() {
		Date fecha = new Date(0,0,0);
		testCitizen= new Citizen("nombre", "apellidos","testemail@email",fecha , "direccion",
				"nacionalidad","DNI", "usuario", "password");
		testCategoria = new Categoria("testCategoria",fecha,fecha, 2);
		testSugerencia = new Sugerencia(testCitizen,"titulo", "contenido", testCategoria);
		testComentario = new Comentario(testCitizen,testSugerencia,"contenido" );
	}
	

	@Test
	public void testGSON(){
		String comentario = Message.setMessage(testComentario);
		Comentario comentarioDeJSON=Message.getComentarioFromJSON(comentario);
		
		assertEquals(comentarioDeJSON, testComentario);
	}

	private void limpiarTest(){

	}

}

package test;

import static org.junit.Assert.*;

import java.util.Date;

import kafka.Message;
import model.Categoria;
import model.Citizen;
import model.Comentario;
import model.Sugerencia;
import model.VotoComentario;
import model.VotoSugerencia;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import controller.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class kafkaTest {
	
	Citizen testCitizen;
	Categoria testCategoria;
	Sugerencia testSugerencia;
	Comentario testComentario;
	VotoComentario testVotoComentario;
	VotoSugerencia testVotoSugerencia;
	
	@Before
	public void setUp() {
		Date fecha = new Date();
		testCitizen= new Citizen("nombre", "apellidos","testemail@email",fecha , "direccion",
				"nacionalidad","DNI", "usuario", "password");
		testCategoria = new Categoria("testCategoria",fecha,fecha, 2);
		testSugerencia = new Sugerencia(testCitizen,"titulo", "contenido", testCategoria);
		testComentario = new Comentario(testCitizen,testSugerencia,"contenido" );
		testVotoComentario = new VotoComentario(testComentario, testCitizen, true);
		testVotoSugerencia = new VotoSugerencia(testSugerencia, testCitizen, true);
	}
	

	@Test
	public void testGSON(){
		
		String comentario = Message.setMessage(testComentario);
		Comentario comentarioDeJSON=Message.getComentarioFromJSON(comentario);
		
		String categoria = Message.setMessage(testCategoria);
		Categoria categoriaDeJSON=Message.getCategoriaFromJSON(categoria);
		
		String sugerencia = Message.setMessage(testSugerencia);
		Sugerencia sugerenciaDeJSON=Message.getSugerenciaFromJSON(sugerencia);
		
		String votoComentario = Message.setMessage(testVotoComentario);
		VotoComentario votoComentarioDeJSON=Message.getVotoComentarioFromJSON(votoComentario);
		 

		String votoSugerencia = Message.setMessage(testVotoSugerencia);
		VotoSugerencia votoSugerenciaDeJSON=Message.getVotoSugerenciaFromJSON(votoSugerencia);
		 
		assertEquals(votoSugerenciaDeJSON.getSugerencia(), testVotoSugerencia.getSugerencia());
		assertEquals(votoComentarioDeJSON.getComentario(), testVotoComentario.getComentario());
		assertEquals(sugerenciaDeJSON, testSugerencia);
		assertEquals(categoriaDeJSON, testCategoria);
		assertEquals(comentarioDeJSON, testComentario);
		
	}



}

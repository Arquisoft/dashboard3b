package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

import model.Citizen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import business.CitizenService;
import business.impl.CitizenServiceImpl;
import controller.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class kafkaTest {
	
	
	
	@Before
	public void setUp() {
		

	}
	

	@Test
	public void testFinder(){
		
		
		
	}

	private void limpiarTest(){
//		EliminarTester.borrarTester(testUser.getUsuario());
//		EliminarTester.borrarTester(testUser2.getUsuario());
	}

}

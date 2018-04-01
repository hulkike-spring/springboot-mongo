package com.example.ejemplomongo;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ejemplomongo.model.entities.Cliente;
import com.example.ejemplomongo.model.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EjemploMongoApplicationTests {
	@Autowired
	ClienteRepository clienteRepository;
	
	@Test
	public void insertTest() {
		Cliente c = new Cliente();
		c.setIdCliente(1);//agrego esta por que si no la prueba se revienta el el delete aunque no le tengo los assert
		c.setDireccion("avenida siempre viva 123");
		c.setEdad(20);
		c.setNombre("Bart 4");
		clienteRepository.save(c);
	}
	
	@Test
	public void findAllTest() {
		List<Cliente> lista =clienteRepository.findAll();
		System.out.println("aca consulta todo lo que esta en la colección");
		for (Cliente cliente : lista) {
			System.out.println(cliente.toString());
		}
		
	}
	
	@Test
	public void findbyIdTest() {
		Optional<Cliente> c =clienteRepository.findById(new Integer(1));
		System.out.println("aca se entrega la consulta por el id"+c.toString());
		
	}
	
	@Test
	public void deleteTest() {
		Optional<Cliente> c =clienteRepository.findById(new Integer(1));
		clienteRepository.delete(c.get());;
		System.out.println("aca se eliminar el cliente con id 1");
	}
	
	@Test
	public void updateTest() {
		Optional<Cliente> c =clienteRepository.findById(new Integer(2));
		if (c!=null) {
			//cambio los datos del que trajo de la base de datos
			Cliente clienteActualizar = c.get();
			clienteActualizar.setDireccion("ya no es siempre viva");
			clienteRepository.save(clienteActualizar);//ojo si cambia el id crea uno nuevo la llave no la puede cambiar
		}
		
		System.out.println("aca actualizo");
	}

	//la esta haciendo en orden que el quiere toca mirar como se cambia eso pero para este ejercicio no importa


	@Test
	public void contextLoads() {
	}

}

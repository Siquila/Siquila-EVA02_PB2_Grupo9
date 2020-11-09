package ar.edu.unlam.pb2.AlquilerDeVehiculos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAgencia {
	
	@Test
	public void queSePuedaAlquilarUnVehiculo () {
		Agencia agencia = new Agencia("agencia de prueba");
		Cliente clienteNuevo = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		Conductor conductorNuevo = new Conductor("juan", "perez", 99333444, (byte) 21, Licencias.TURISMO);
		Turismo vehiculoAAgregar = new Turismo("ff111", "ASD123", "Reno", "AUDI", 4);
		
		agencia.agregarCliente(clienteNuevo);
		agencia.agregarConductor(conductorNuevo);
		agencia.agregarVehiculo(vehiculoAAgregar);
		
		agencia.alquilar(clienteNuevo, conductorNuevo, vehiculoAAgregar, 4);
		
		assertTrue(agencia.alquilar(clienteNuevo, conductorNuevo, vehiculoAAgregar, 4));
	}
	
	
	@Test
	public void queSePuedaDevolverUnVehiculo () {
		Agencia agencia = new Agencia("agencia de prueba");
		Cliente clienteNuevo = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		Conductor conductorNuevo = new Conductor("juan", "conductor", 99333444, (byte) 21, Licencias.TURISMO);
		Turismo vehiculoAAgregar = new Turismo("ff111", "ASD123", "Reno", "AUDI", 4);
		
		agencia.agregarCliente(clienteNuevo);
		agencia.agregarConductor(conductorNuevo);
		agencia.agregarVehiculo(vehiculoAAgregar);
		
		agencia.alquilar(clienteNuevo, conductorNuevo, vehiculoAAgregar, 4);
		
		assertTrue(agencia.devolver(clienteNuevo, conductorNuevo, vehiculoAAgregar, 4.0));
	}
	
	@Test
	public void queNoHayaDosClientesIguales() {
		Agencia agencia = new Agencia("agencia de prueba");
		Cliente clienteNuevo = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		Cliente clienteDuplicado = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		
		agencia.agregarCliente(clienteNuevo);
		agencia.agregarCliente(clienteDuplicado);

		// no toma el hashcode? *******
		assertEquals(agencia.clientes.size(),1);
	}
	
}

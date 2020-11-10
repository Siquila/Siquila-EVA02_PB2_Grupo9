package ar.edu.unlam.pb2.AlquilerDeVehiculos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.net.Inet4Address;

public class TestAgencia {
	@Test
	public void queSePuedaAgregarUnCliente(){
		Agencia agencia = new Agencia("agencia de prueba");
		Cliente clienteNuevo = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);

		assertTrue(agencia.agregarCliente(clienteNuevo));
	}

	@Test
	public void queSePuedaAgregarUnConductor(){
		Agencia agencia = new Agencia("agencia de prueba");
		Cliente clienteNuevo = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		Conductor conductorNuevo = new Conductor("juan", "perez", 99333444, (byte) 21, Licencias.TURISMO);

		assertTrue(agencia.agregarConductor(conductorNuevo));
	}

	@Test
	public void queSePuedaAgregarUnVehiculo(){
		Agencia agencia = new Agencia("agencia de prueba");
		Turismo vehiculoAAgregar = new Turismo("ff111", "ASD123", "AUDI", "R8", 4, 0.0);

		assertTrue(agencia.agregarVehiculo(vehiculoAAgregar));
	}
	
	@Test
	public void queSePuedaAlquilarUnVehiculo () {
		Agencia agencia = new Agencia("agencia de prueba");
		Cliente clienteNuevo = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		Conductor conductorNuevo = new Conductor("juan", "perez", 99333444, (byte) 21, Licencias.TURISMO);
		Turismo vehiculoAAgregar = new Turismo("ff111", "ASD123", "AUDI", "R8", 4, 0.0);
		
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
		Turismo vehiculoAAgregar = new Turismo("ff111", "ASD123","AUDI", "R8", 4, 0.0);
		
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
		Cliente clienteNuevo2 = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		
		agencia.agregarCliente(clienteNuevo);
		agencia.agregarCliente(clienteNuevo2);


		assertEquals(1, agencia.clientes.size());
	}
	
	@Test
	public void queNoAlquileSiElConductorNoTieneLaLicenciaCorrecta() {
		Agencia agencia = new Agencia("agencia de prueba");
		Cliente clienteNuevo = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		Conductor conductorNuevo = new Conductor("juan", "perez", 99333444, (byte) 21, Licencias.CAMION);
		Turismo vehiculoAAgregar = new Turismo("ff111", "ASD123", "AUDI", "R8", 4, 0.0);
		
		agencia.agregarCliente(clienteNuevo);
		agencia.agregarConductor(conductorNuevo);
		agencia.agregarVehiculo(vehiculoAAgregar);
		
		assertTrue(!agencia.alquilar(clienteNuevo, conductorNuevo, vehiculoAAgregar, 4));
	}

	@Test
	public void queNoSePuedaAlquilarAutoNoDisponible(){
		Agencia agencia = new Agencia("agencia de prueba");
		Cliente clienteNuevo = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		Conductor conductorNuevo = new Conductor("juan", "perez", 99333444, (byte) 21, Licencias.CAMION);
		Turismo vehiculoAAgregar = new Turismo("ff111", "ASD123", "AUDI", "R8", 4, 0.0);
		Cliente clienteNuevo2 = new Cliente("rodrigo", "rodriguez", 46514132, (byte) 45, Tarjetas.VISA);


		agencia.agregarCliente(clienteNuevo);
		agencia.agregarCliente(clienteNuevo2);
		agencia.agregarConductor(conductorNuevo);
		agencia.agregarVehiculo(vehiculoAAgregar);
		agencia.alquilar(clienteNuevo,conductorNuevo, vehiculoAAgregar, 4);
		assertTrue(!agencia.alquilar(clienteNuevo2,conductorNuevo, vehiculoAAgregar, 4));


	}

	@Test
	public void siCoincideElConductorConElIdDelVehiculoAsignado(){
		Agencia agencia = new Agencia("agencia de prueba");
		Cliente clienteNuevo = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		Conductor conductorNuevo = new Conductor("juan", "perez", 99333444, (byte) 21, Licencias.CAMION);
		Turismo vehiculoAAgregar = new Turismo("ff111", "ASD123", "AUDI", "R8", 4, 0.0);

		agencia.agregarCliente(clienteNuevo);
		agencia.agregarConductor(conductorNuevo);
		agencia.agregarVehiculo(vehiculoAAgregar);
		agencia.alquilar(clienteNuevo,conductorNuevo, vehiculoAAgregar, 4);

		assertEquals(conductorNuevo.getVehiculoAsignado(), vehiculoAAgregar.getId());

	}

	@Test
	public void queFacture(){
		Agencia agencia = new Agencia("agencia de prueba");
		Cliente clienteNuevo = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		Conductor conductorNuevo = new Conductor("juan", "perez", 99333444, (byte) 21, Licencias.CAMION);
		Turismo vehiculoAAgregar = new Turismo("ff111", "ASD123", "AUDI", "R8", 4, 0.0);

		agencia.agregarCliente(clienteNuevo);
		agencia.agregarConductor(conductorNuevo);
		agencia.agregarVehiculo(vehiculoAAgregar);
		agencia.alquilar(clienteNuevo,conductorNuevo, vehiculoAAgregar, 4);
		agencia.devolver(clienteNuevo,conductorNuevo, vehiculoAAgregar, 20.0);

		assertEquals(806.0, agencia.facturar(clienteNuevo, 4, 20.0, vehiculoAAgregar), 0.01);
	}

	@Test
	public void queSumoLosKilometros(){
		Agencia agencia = new Agencia("agencia de prueba");
		Cliente clienteNuevo = new Cliente("juan", "perez", 99333444, (byte) 21, Tarjetas.VISA);
		Conductor conductorNuevo = new Conductor("juan", "perez", 99333444, (byte) 21, Licencias.CAMION);
		Turismo vehiculoAAgregar = new Turismo("ff111", "ASD123", "AUDI", "R8", 4, 0.0);
		Double veinte =20.0;


		agencia.agregarCliente(clienteNuevo);
		agencia.agregarConductor(conductorNuevo);
		agencia.agregarVehiculo(vehiculoAAgregar);

		agencia.alquilar(clienteNuevo,conductorNuevo, vehiculoAAgregar, 4);
		agencia.devolver(clienteNuevo,conductorNuevo, vehiculoAAgregar, veinte);

		assertEquals(veinte, vehiculoAAgregar.getKilometrosInicial(), 0.01);
	}





}

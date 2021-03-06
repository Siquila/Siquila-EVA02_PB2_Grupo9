package ar.edu.unlam.pb2.AlquilerDeVehiculos;

import java.util.ArrayList;
import java.util.HashSet;




public class Agencia {
	
	 ArrayList <Renting> vehiculos= new ArrayList<Renting>();			
	 HashSet <Cliente> clientes=new HashSet <Cliente>();			
	 HashSet <Conductor> conductores = new HashSet <Conductor>();
	 
	 
	 ///////************************/////	
	
	 
	 String nombre;
	public Agencia(String nombre) {
		this.nombre = nombre;
	}

	public Boolean agregarVehiculo(Renting vehiculo){	
	return vehiculos.add(vehiculo);
	}
	
	
	
	////////***********************/////////
	
	
	public Vehiculo buscarVehiculo(String id) {
		Vehiculo vehiculoEncontrado = null;
		for(int i=0;i<vehiculos.size();i++){
			if(((Vehiculo)vehiculos.get(i)).getId().equals(id))		
				vehiculoEncontrado=(Vehiculo)vehiculos.get(i);			
		}
		return vehiculoEncontrado;
	}		
	
		
	public Boolean agregarCliente(Cliente nuevoCliente)	{
			if(nuevoCliente.getEdad()>=18)
				return clientes.add(nuevoCliente);
			return false;
		}	
	
	
	public Cliente buscarCliente(Cliente clienteAbuscar)	{
		Cliente clienteEncontrado = null;
		if(clientes.contains(clienteAbuscar)) {
			clienteEncontrado = clienteAbuscar;
		}
			
		return clienteEncontrado;
	}	
	
	private void asignarConductor(Conductor conductor, String idVehiculo) {
		
		if (conductores.contains(conductor)) {	
		
		if(buscarVehiculo(idVehiculo) != null){
			conductor.setDisponible(false);
			conductor.setVehiculoAsignado(idVehiculo);
			for(int i=0;i<vehiculos.size();i++){
				if(((Vehiculo)vehiculos.get(i)).getId().equals(idVehiculo))		
					((Vehiculo)vehiculos.get(i)).setDisponible(false);;			
			}
			
			}
		}
	}

private void librarConductor(Conductor conductor, String idVehiculo) {
		
		if (conductores.contains(conductor)) {	
		
		if(buscarVehiculo(idVehiculo) != null){
			conductor.setDisponible(true);
			conductor.setVehiculoAsignado(" ");
			for(int i=0;i<vehiculos.size();i++){
				if(((Vehiculo)vehiculos.get(i)).getId().equals(idVehiculo))		
					((Vehiculo)vehiculos.get(i)).setDisponible(true);;			
			}
			
			}
		}
	}
	public Boolean alquilar(Cliente cliente,Conductor conductor, Renting vehiculoAalquilar, Integer diasDeAlquiler)		{
		Boolean sePudoAlquilar = false;
		if(buscarCliente(cliente)!= null) {

			
			if(buscarVehiculo(((Vehiculo)vehiculoAalquilar).getId()) != null) {
				asignarConductor (conductor,((Vehiculo)vehiculoAalquilar).id);
				cliente.setAlquilO(true);
			
				if(vehiculoAalquilar instanceof Turismo && conductor.getTipoDeLicencia()==Licencias.TURISMO){
					((Turismo)vehiculoAalquilar).setDiasDeAlquiler(diasDeAlquiler);
					((Turismo)vehiculoAalquilar).alquilar(cliente,diasDeAlquiler);
					sePudoAlquilar=true;
					}
					
				if(vehiculoAalquilar instanceof Furgoneta && conductor.getTipoDeLicencia()==Licencias.FURGONETA){
					((Turismo)vehiculoAalquilar).setDiasDeAlquiler(diasDeAlquiler);
					((Furgoneta)vehiculoAalquilar).alquilar(cliente,diasDeAlquiler);

					sePudoAlquilar=true;	
				}
			
				if(vehiculoAalquilar instanceof Camion && conductor.getTipoDeLicencia()==Licencias.CAMION){
					((Turismo)vehiculoAalquilar).setDiasDeAlquiler(diasDeAlquiler);
					((Camion)vehiculoAalquilar).alquilar(cliente,diasDeAlquiler);

					sePudoAlquilar=true;	
				}
			}
		
		}
		return sePudoAlquilar;
	}
	
	public Boolean devolver(Cliente cliente,Conductor conductor, Renting vehiculoAdevolver, Double kmActual)		{
		Boolean sePudoDevolver = false;
		if(buscarCliente(cliente)!= null) {
			
			if(buscarVehiculo(((Vehiculo)vehiculoAdevolver).getId()) != null) {
				librarConductor( conductor, ((Vehiculo)vehiculoAdevolver).id);

				if(vehiculoAdevolver instanceof Turismo){
					((Turismo)vehiculoAdevolver).devolver(cliente,kmActual);
					cliente.setAlquilO(false);
					sePudoDevolver=true;
					}
					
				if(vehiculoAdevolver instanceof Furgoneta){
					((Furgoneta)vehiculoAdevolver).devolver(cliente,kmActual);
					cliente.setAlquilO(false);
					sePudoDevolver=true;
					}
			
				if(vehiculoAdevolver instanceof Camion){
					((Camion)vehiculoAdevolver).devolver(cliente,kmActual);
					cliente.setAlquilO(false);
					sePudoDevolver=true;
					}
			}
		
		}
		return sePudoDevolver;
	
	}
	
	public Boolean agregarConductor(Conductor conductor)	{

		return conductores.add(conductor);
	}
	public Conductor buscarConductor(Conductor conductorAbuscar) {
	Conductor conductorEncontrado = null;
	if(conductores.contains(conductorAbuscar)) {
		conductorEncontrado = conductorAbuscar;
	}
		
	return conductorEncontrado;
	}

	public Double facturar(Cliente cliente, Integer diasAlquilados, Double kmRecorridos, Renting vehiculo){
		Double precioFurgonetaDia = 80.50;
		Double precioFurgonetaKm = 15.20;
		Double precioCamionDia = 100.50;
		Double precioCamionKm = 20.20;
		Double precioTruismoDia = 100.50;
		Double precioTurismoKm = 20.20;
		Double precioFinal = 0.0;

		if(buscarCliente(cliente)!= null){

			if(vehiculo instanceof Furgoneta){
				precioFinal	= precioFurgonetaDia * diasAlquilados + precioFurgonetaKm * kmRecorridos;
			}
			if(vehiculo instanceof Camion){
				precioFinal = precioCamionDia * diasAlquilados + precioFurgonetaKm * kmRecorridos;
			}
			if(vehiculo instanceof Turismo){
				precioFinal = precioTruismoDia * diasAlquilados + precioTurismoKm * kmRecorridos;
			}
		}
		return precioFinal;
	}


}

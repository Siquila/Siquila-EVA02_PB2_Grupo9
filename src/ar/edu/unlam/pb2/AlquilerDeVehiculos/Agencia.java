package ar.edu.unlam.pb2.AlquilerDeVehiculos;

import java.util.ArrayList;
import java.util.HashSet;




public class Agencia {
	
	 ArrayList <Renting> vehiculos= new ArrayList<Renting>();			
	 HashSet <Cliente> clientes=new HashSet <Cliente>();			
	 HashSet <Conductor> conductores = new HashSet <Conductor>();
	 
	 
	public Boolean agregarVehiculo(Renting vehiculo){	
	return vehiculos.add(vehiculo);
	}
	
	public Vehiculo buscarVehiculo(String matricula) {
		Vehiculo vehiculoEncontrado = null;
		for(int i=0;i<vehiculos.size();i++){
			if(((Vehiculo)vehiculos.get(i)).getMatricula().equals(matricula))		
				vehiculoEncontrado=(Vehiculo)vehiculos.get(i);			
		}
		return vehiculoEncontrado;
	}		
		
	public Boolean agregarCliente(Cliente nuevoCliente)	{
			return clientes.add(nuevoCliente);
		}	
	
	// no busca por dni, cambie porque en un hashset no puedo usar el metodo get() como en el list
	public Cliente buscarCliente(Cliente clienteAbuscar)	{
		Cliente clienteEncontrado = null;
		if(clientes.contains(clienteAbuscar)) {
			clienteEncontrado = clienteAbuscar;
		}
			
		return clienteEncontrado;
	}	

	public void alquilar(Cliente cliente, Vehiculo vehiculo)		{
		if(buscarCliente(cliente)!= null) {
			
			if(buscarVehiculo(vehiculo.getMatricula()) != null) {
				
			
				if(vehiculo instanceof Turismo){
					((Turismo)vehiculo).alquilar(cliente);	
				
					}
					
				if(vehiculo instanceof Furgoneta){
					((Furgoneta)vehiculo).alquilar(cliente);
					}
			
				else{
					((Camion)vehiculo).alquilar(cliente);	
					}
			}
		
		}
	
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

}

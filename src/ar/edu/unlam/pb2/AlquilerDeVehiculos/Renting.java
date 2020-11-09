package ar.edu.unlam.pb2.AlquilerDeVehiculos;

 interface  Renting {

	public Boolean alquilar(Cliente cliente, Integer diasDeAlquiler);
	
	public Boolean devolver(Cliente cliente, Double kmActual);

}

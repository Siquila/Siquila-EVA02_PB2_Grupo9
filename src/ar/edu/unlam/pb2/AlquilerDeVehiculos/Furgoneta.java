package ar.edu.unlam.pb2.AlquilerDeVehiculos;

public class Furgoneta extends Vehiculo implements Renting{

	public Furgoneta(String id, String matricula, String marca, String modelo, Integer numeroDePuertas) {
		super(id, matricula, marca, modelo, numeroDePuertas);
		// TODO Auto-generated constructor stub
		this.precioPorDia = 80.50;
		this.precioPorKilometro = 15.20;
	}

	@Override
	protected String mostrarDetalles() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void devolver(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alquilar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	



}

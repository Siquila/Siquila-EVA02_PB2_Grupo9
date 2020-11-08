package ar.edu.unlam.pb2.AlquilerDeVehiculos;

public class Camion extends Vehiculo implements Renting{
	
	private Boolean tieneGrua;
	
	public Camion(String id, String matricula, String marca, String modelo, Integer numeroDePuertas,  Boolean tieneGrua) {
		super(id, matricula, marca, modelo,  numeroDePuertas);
		// TODO Auto-generated constructor stub
		this.tieneGrua = tieneGrua;
		this.precioPorDia = 100.50;
		this.precioPorKilometro = 20.20;
		
	}

	@Override
	protected String mostrarDetalles() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean getTieneGrua() {
		return tieneGrua;
	}

	public void setTieneGrua(Boolean tieneGrua) {
		this.tieneGrua = tieneGrua;
	}



	@Override
	public void alquilar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devolver(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}
	
	
	



	

	

}

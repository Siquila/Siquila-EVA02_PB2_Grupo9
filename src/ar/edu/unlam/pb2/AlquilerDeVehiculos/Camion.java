package ar.edu.unlam.pb2.AlquilerDeVehiculos;

public class Camion extends Vehiculo implements Renting{
	
	private Boolean tieneGrua;
	
	public Camion(String id, String matricula, String marca, String modelo, Integer numeroDePuertas,  Boolean tieneGrua) {
		super(id, matricula, marca, modelo,  numeroDePuertas);
		
		this.tieneGrua = tieneGrua;
		this.precioPorDia = 100.50;
		this.precioPorKilometro = 20.20;
		this.disponible = true;
		
	}

	@Override
	protected String mostrarDetalles() {
		
		return "Id: "+ this.id+" - "+"Marca: "+this.marca+ " - "+"Modelo:"+this.modelo+ " - "+"Tiene Grua: "+this.tieneGrua+" - "+"Matricula: "+this.matricula+ " - "+"Disponible: "+this.disponible;
	}

	public Boolean getTieneGrua() {
		return tieneGrua;
	}

	public void setTieneGrua(Boolean tieneGrua) {
		this.tieneGrua = tieneGrua;
	}


	@Override
	public Boolean devolver(Cliente cliente, Double kmActual) {
		Boolean devuelto = false;
		if(cliente.getAlquilO()) {
		this.kmRecorridos = this.kilometrosInicial - kmActual;
		this.kilometrosInicial = this.kmRecorridos;		
		devuelto= true;
		}
		
		return devuelto;
	}

	@Override
	public Boolean alquilar(Cliente cliente, Integer diasDeAlquiler) {
		Boolean alquilado =false;
		Double plus= 50.0;
		if (!cliente.getAlquilO()) {
			this.diasDeAlquiler = diasDeAlquiler;		
			alquilado = true;
		if (this.tieneGrua) {
			this.precioPorDia += plus;
		}
			
		}
		return alquilado;
	}

	
	
	



	

	

}

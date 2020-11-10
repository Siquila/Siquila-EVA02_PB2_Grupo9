package ar.edu.unlam.pb2.AlquilerDeVehiculos;

public class Furgoneta extends Vehiculo implements Renting{

	public Furgoneta(String id, String matricula, String marca, String modelo, Integer numeroDePuertas, Double kmInicial) {
		super(id, matricula, marca, modelo, numeroDePuertas, kmInicial);
		
		this.precioPorDia = 80.50;
		this.precioPorKilometro = 15.20;
		this.disponible =true;
		this.kilometrosInicial = kmInicial;
	}

	@Override
	protected String mostrarDetalles() {
		
		return "Id: "+ this.id+" - "+"Marca: "+this.marca+ " - "+"Modelo:"+this.modelo+ " - "+"Matricula: "+this.matricula+ " - "+"Disponible: "+this.disponible;
	}

	@Override
	public Boolean alquilar(Cliente cliente, Integer diasDeAlquiler) {

		Boolean alquilado =false;

		if (!cliente.getAlquilO()) {
			this.diasDeAlquiler = diasDeAlquiler;
	
			alquilado = true;
			
		}
		return alquilado;
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




	



}

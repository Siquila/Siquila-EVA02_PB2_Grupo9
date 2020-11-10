package ar.edu.unlam.pb2.AlquilerDeVehiculos;

public class Turismo extends Vehiculo implements Renting{
	
	private Integer cantidadDeAsientos;

	public Turismo(String id, String matricula, String marca, String modelo,Integer numeroDePuertas, Double kmInicial) {
		super(id, matricula, marca, modelo, numeroDePuertas, kmInicial);
		
		this.precioPorDia = 100.50;
		this.precioPorKilometro = 20.20;
		this.cantidadDeAsientos=32;
		this.disponible = true;
		this.kilometrosInicial = kmInicial;

	}

	public Integer getCantidadDeAsientos() {
		return cantidadDeAsientos;
	}

	public void setCantidadDeAsientos(Integer cantidadDeAsientos) {
		this.cantidadDeAsientos = cantidadDeAsientos;
	}

	@Override
	protected String mostrarDetalles() {
	
		return "Id: "+ this.id+" - "+"Marca: "+this.marca+ " - "+"Modelo:"+this.modelo+ " - "+"Asientos: "+" - "+"Matricula: "+this.matricula+ " - "+"Disponible: "+this.disponible;
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
			this.setKmRecorridos(kmActual - this.kilometrosInicial);
			this.kilometrosInicial += this.kmRecorridos;
			devuelto= true;
			}
			
			return devuelto;
	}








}

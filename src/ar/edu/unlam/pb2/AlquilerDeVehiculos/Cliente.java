package ar.edu.unlam.pb2.AlquilerDeVehiculos;

public class Cliente extends Persona{
	
	private Boolean alquilO;
	private Tarjetas tipoDeTarjeta;

	public Cliente(String nombre, String apellido, Integer dni, Byte edad, Tarjetas tipoDeTarjeta) {
		super(nombre, apellido, dni, edad);
		this.setTipoDeTarjeta(tipoDeTarjeta);
		this.alquilO = false;
	}
	
	

	public Boolean getAlquilO() {
		return alquilO;
	}

	public void setAlquilO(Boolean alquilO) {
		this.alquilO = alquilO;
	}

	public Tarjetas getTipoDeTarjeta() {
		return tipoDeTarjeta;
	}

	public void setTipoDeTarjeta(Tarjetas tipoDeTarjeta) {
		this.tipoDeTarjeta = tipoDeTarjeta;
	} 

	

}

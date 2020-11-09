package ar.edu.unlam.pb2.AlquilerDeVehiculos;

public class Conductor extends Persona{
	
	private Licencias tipoDeLicencia;
	private String vehiculoAsignado;
	private Boolean disponible;
	
	public Conductor(String nombre, String apellido, Integer dni, Byte edad,Licencias tipoDeLicencia) {
		super(nombre, apellido, dni, edad);
		this.vehiculoAsignado = " ";
		this.disponible=true;
		this.tipoDeLicencia = tipoDeLicencia;
	}

	public String getVehiculoAsignado() {
		return vehiculoAsignado;
	}

	public void setVehiculoAsignado(String vehiculoAsignado) {
		this.vehiculoAsignado = vehiculoAsignado;
	}

	public Licencias getTipoDeLicencia() {

		return tipoDeLicencia;
	}

	public void setTipoDeLicencia(Licencias tipoDeLicencia) {
		this.tipoDeLicencia = tipoDeLicencia;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}


}

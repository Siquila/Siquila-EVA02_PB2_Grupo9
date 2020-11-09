package ar.edu.unlam.pb2.AlquilerDeVehiculos;

public abstract class Vehiculo {

	// que se ordene por marca
	
	protected String id;
	protected String matricula;
	protected String marca;
	protected String modelo;
	protected Integer numeroDePuertas;
	protected Boolean disponible;
	
	protected Integer diasDeAlquiler;
	protected Double precioPorDia;
	protected Double kilometrosInicial;
	protected Double kmRecorridos;
	protected Double precioPorKilometro;
	
	protected Vehiculo(String id, String matricula, String marca, String modelo, Integer numeroDePuertas) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.numeroDePuertas = numeroDePuertas;
		this.disponible = true;
	}

	protected abstract String mostrarDetalles();
	
	public  String getMatricula() {
		return matricula;
	}
	
	public Double getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(Double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public String getId() {
		return id;
	}
		
	public Integer getNumeroDePuertas() {
		return numeroDePuertas;
	}

	public void setNumeroDePuertas(Integer numeroDePuertas) {
		this.numeroDePuertas = numeroDePuertas;
	}

	public Integer getDiasDeAlquiler() {
		return diasDeAlquiler;
	}

	public void setDiasDeAlquiler(Integer diasDeAlquiler) {
		this.diasDeAlquiler = diasDeAlquiler;
	}

	public Double getPrecioPorDia() {
		return precioPorDia;
	}

	public void setPrecioPorDia(Double precioPorDia) {
		this.precioPorDia = precioPorDia;
	}

	public Double getPrecioPorKilometro() {
		return precioPorKilometro;
	}

	public void setPrecioPorKilometro(Double precioPorKilometro) {
		this.precioPorKilometro = precioPorKilometro;
	}

	public void setId(String id) {
		this.id = id;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Double getKilometrosInicial() {
		return kilometrosInicial;
	}

	public void setKilometrosInicial(Double kilometrosInicial) {
		this.kilometrosInicial = kilometrosInicial;
	}
	
	
}

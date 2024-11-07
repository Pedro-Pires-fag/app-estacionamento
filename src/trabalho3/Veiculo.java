package trabalho3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Veiculo {

	List<Veiculo> veiculos = new ArrayList<>();

	private String placa;
	private String modelo;
	private Tipo tipo;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;

	public Veiculo() { 
	}

	public Veiculo(String placa, String modelo, Tipo tipo, LocalDateTime checkIn) {
		this.placa = placa;
		this.modelo = modelo;
		this.tipo = tipo;
		this.checkIn = checkIn;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
	}

	public String toString() {
		return "Veiculo [veiculos=" + veiculos + ", placa=" + placa + ", modelo=" + modelo + ", tipo=" + tipo
				+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]\n";
	}
	
	public void registrarVeiculo (Veiculo veiculo) {
		veiculos.add(veiculo);
	}
	
	public double payment(LocalDateTime checkIn, LocalDateTime checkOut) {
		double payment = checkOut.getHour() - checkIn.getHour();
		if (payment <= 1)
			return 5.0;
		else if(payment <= 3)
			return payment * 10;
		else
			return payment * 15;
	}
	public void listarVeiculos () {
		for (Veiculo veiculo : veiculos) {
			veiculo.toString();
		}
	}

}

package trabalho3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Vaga extends Veiculo{

	List<Vaga> vagas = new ArrayList<>();

	private int numero;
	private Tipo tipo;
	private boolean disponibilidade;
	private Veiculo veiculo;

	public Vaga() {

	}

	
	public Vaga(int numero, Tipo tipo, boolean disponibilidade, Veiculo veiculo) {
		this.numero = numero;
		this.tipo = tipo;
		this.disponibilidade = disponibilidade;
		this.veiculo = veiculo;
	}


	public Vaga(int numero, Tipo tipo, boolean disponibilidade) {
		this.numero = numero;
		this.tipo = tipo;
		this.disponibilidade = disponibilidade;
	}
	
	

	public Vaga(int numero, Tipo tipo) {
		this.numero = numero;
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public boolean isDisponibilidade(int numero) {
		return disponibilidade;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public String toString() {
		return "Numero: " + numero + ", tipo: " + tipo + ", disponibilidade: " + disponibilidade;
	}
	
	public void adicionaVaga(Vaga vaga) {
		vagas.add(vaga);
	}
	
	
	public void listarVagas() {
		System.out.println("VAGAS\n");
		for (Vaga vaga : vagas) {
			if(vaga.getVeiculo() != null)
			System.out.println(vaga.toString() +  ", Veiculo: " + vaga.getVeiculo().getPlaca() + ", " + vaga.getVeiculo().getModelo() + "\n");
			else
				System.out.println(vaga.toString());
		}
	}
	
	public void checkIn(LocalDateTime checkIn, Veiculo veiculo, int numero) {
		for (Vaga vaga : vagas) {
			if(vaga.getNumero() == numero) {
				if(vaga.getTipo().equals(veiculo.getTipo())) {
				vaga.setVeiculo(veiculo);
				this.disponibilidade = false;
				veiculo.registrarVeiculo(veiculo);
				System.out.println("Check-In realizado");
				}
				else
					System.out.println("Vaga ocupada ou inválida");
			}			
		}
		
	}
	
	public double checkOut(LocalDateTime checkOut, String placa) {
		double payment = 0.0;
		for (Vaga vaga : vagas) {
			if(vaga.getVeiculo().getPlaca().equals(placa)) {
				vaga.getVeiculo().setCheckOut(checkOut);
				payment =  vaga.getVeiculo().payment(vaga.getVeiculo().getCheckIn(), checkOut);
				vaga.setVeiculo(null);
				this.disponibilidade = true;
				System.out.println("Check-Out realizado");
			}
		}
		return payment;
	}

}

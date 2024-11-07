package trabalho3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Estacionamento {

	public static void main(String[] args) {
		executar();
		
		
	}

	public static void executar() {
		Vaga vagas =  new Vaga();

		Scanner scan = new Scanner(System.in);
		System.out.println(" 1- Adicionar vaga\n 2- Listar vagas\n 3- Entrada de Veiculo\n");
		int opcao = scan.nextInt();

		while (opcao != 6) {
			switch (opcao) {
			case 1: {
				try
				{
					System.out.print("\nNumero da vaga:");
					int numero = scan.nextInt();
					System.out.print("Tipo da vaga:");
					Tipo tipo = Tipo.valueOf(scan.next());
					Vaga vaga = (new Vaga(numero, tipo, true));
					vagas.adicionaVaga(vaga);
					break;
				}
				catch (IllegalArgumentException e) {
					System.out.println("Tipo de vaga inválido. (PEQUENO, MEDIO, GRANDE");
				}
					
			}
			case 2: {
				vagas.listarVagas();
				break;
			}
			case 3:
			{
				try
				{
				System.out.println("Numero da vaga: ");
				int numero = scan.nextInt();
				System.out.print("Placa: ");
				String placa = scan.next();
				System.out.print("Modelo: ");
				String modelo = scan.next();
				System.out.print("Tipo: ");
				Tipo tipo = Tipo.valueOf(scan.next());
				LocalDateTime checkIn = LocalDateTime.now();
				Veiculo veiculo = new Veiculo(placa, modelo, tipo, checkIn);
				vagas.checkIn(checkIn, veiculo, numero);
				break;
				}
				catch(IllegalArgumentException e) {
					System.out.println("Tipo de veículo inváido (PEQUENO, MEDIO, GRANDE)");
				}
			}
			case 4:
			{
				System.out.println("Placa: ");
				String placa = scan.next();
				LocalDateTime checkOut = LocalDateTime.now();
				System.out.println(vagas.checkOut(checkOut, placa));
				break;
			}
			}
			System.out.println(" 1- Adicionar vaga\n 2- Listar vagas\n 3- Entrada de Veiculo\n 4- Saida de Veiculo\n 5- Relatório de vagas\n 6- Sair\n");
			opcao = scan.nextInt();			
			
		}
		scan.close();
	}

}

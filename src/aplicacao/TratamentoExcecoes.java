package aplicacao;

import java.util.Scanner;
import modelo.entidades.ContaCorrente;
import modelo.excecoes.Excecoes;

public class TratamentoExcecoes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Informe os dados da conta corrente: ");
			System.out.print("Numero: ");
			int numeroDaConta = sc.nextInt();
			System.out.print("Correntista: ");
			sc.nextLine();
			String correntista = sc.nextLine();
			System.out.print("Saldo inicial: ");
			Double saldoDaConta = sc.nextDouble();
			System.out.print("Limite de saque: ");
			Double limiteDeSaque = sc.nextDouble();
			System.out.println();
			System.out.print("Informe o valor do saque: ");
			Double saque = sc.nextDouble();
			//Instancia��o do objeto/classe 'ContaCorrente'
			ContaCorrente cc = new ContaCorrente(numeroDaConta, correntista, saldoDaConta, limiteDeSaque);
			//Chamada do M�todo 'saque'
			cc.saque(saque);
			System.out.println(cc);
		}
		catch (Excecoes e1) {
			System.out.println("N�o � poss�vel realizar a transa��o: " + e1.getMessage());
		}
		catch (RuntimeException e1) {
			System.out.println("Ooops! Ocorreu um erro inesperado! Programa encerrado.");
		}
		sc.close();
	}
}

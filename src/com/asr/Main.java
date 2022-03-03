package com.asr;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opcao;
		double valorMovimentacao;
		String tipoConta;
		
		Cliente cliente = new Cliente();
		System.out.println("Digite o nome do cliente: ");
		String novoCliente = scan.next();
		cliente.setNome(novoCliente);
		
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);
		System.out.println(novoCliente + " conta criada com sucesso");
		System.out.println();
		
		
		do {
			System.out.println("Escolha a uma opcao abaixo: ");
			System.out.println("Para imprimir extrato digite 1:");
			System.out.println("Para sacar digite 2:");
			System.out.println("Para depositar digite 3:");
			System.out.println("Para transferir digite 4:");
			System.out.println("Para sair digite 0:");
			
		
			opcao = scan.nextInt();
			System.out.println("Voce escolheu a opcao "+ opcao);
			
			switch(opcao) {
			case 1:
				cc.imprimirExtrato();
				poupanca.imprimirExtrato();
				System.out.println();
				break;
			case 2:
				System.out.println("Digite o valor que deseja sacar: ");
				valorMovimentacao = scan.nextDouble();
				cc.sacar(valorMovimentacao);
				System.out.println();
				break;
			case 3:
				System.out.println("Digite 1 para CC ou 2 para Poupanca: ");
				opcao = scan.nextInt();
				System.out.println("Digite o valor que deseja depositar: ");
				valorMovimentacao = scan.nextDouble();
				if(opcao == 1) {
					cc.depositar(valorMovimentacao);
				}
				else {
					poupanca.depositar(valorMovimentacao);
				}
				System.out.println();
				break;
			case 4:
				System.out.println("Origem do dinheiro 1 CC 2 Poupanca:");
				opcao = scan.nextInt();
				System.out.println("Digite o valor da transferencia:");
				valorMovimentacao = scan.nextDouble();
				if(opcao == 1) {
					cc.transferir(valorMovimentacao, poupanca);
				}
				else {
					poupanca.transferir(valorMovimentacao, cc);
				}
				System.out.println();
				break;
			}
		} while(opcao != 0);
		
		
		
		scan.close();
	}
}
 
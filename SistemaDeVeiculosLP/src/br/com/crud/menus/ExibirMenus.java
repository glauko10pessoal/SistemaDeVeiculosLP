package br.com.crud.menus;

public class ExibirMenus {
	
	public static void menuPrincipal() {
		System.out.println("---------PRINCIPAL--------");
		System.out.println("1 - Menu de Motoristas");
		System.out.println("2 - Menu de Veiculos");
		System.out.println("3 - Menu de Abastecimentos");
		System.out.println("0 - Sair do Sistema");
	}
	
	public static void menuVeiculos() {
		System.out.println("------menuMotoristas------");
		System.out.println("1- Cadastrar Veiculo"); //Informar  placa,  modelo e capacidadeTanque, 
		System.out.println("2- Buscar por placa"); //Informar a placa
		System.out.println("3- Listar todos os veiculos"); //IMprimir a placa e modelo
		System.out.println("4- Atribuir um motorista a um veiculo"); //Buscar o motorista pelo cpf, buscar o veiculo pela placa,se existir, atribuir
		System.out.println("5- Listar Veiculos por CPF do motorista"); //IMprimir a placa e modelo
		System.out.println("6- Listar Todos os veiculos que tem capacidade de tanque maior que 50"); 
		System.out.println("0- SAIR DO Menu de Motorista\n\n"); //Informar o nome e CPF
	}
	
	public static void menuMotoristas() {
		System.out.println("------menuMotoritas------");
		System.out.println("1- Cadastrar Motoristas"); //Informar o nome e CPF, cpf sendo único
		System.out.println("2- Buscar por CPF"); 
		//3-Listar motoristas
		System.out.println("0- SAIR DO Menu de Motorista\n\n");	
	}
	
	public static void menuAbastecimentos() {
		System.out.println("------menuAbastecimentos------");
		System.out.println("1- Cadastrar Abastecimento de um veículo"); //Informar o nome e CPF, cpf sendo único
		System.out.println("2- Listar abastecimentos do veículo");
		System.out.println("0- SAIR DO Menu de Motorista\n\n");
	}
		
	}

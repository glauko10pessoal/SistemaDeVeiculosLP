package br.com.crud.model;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.crud.banco.BancoMotoristas;

public class Motorista {
	
	private String cpf;
	private String nome;
	
	public Motorista(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getCpf(){
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
// -----------------------------------------------
	
	/*public Motorista buscarMotorista(String cpf) {
		boolean motoristaExiste = motoristaExiste(cpf);
			if (motoristaExiste == true){
				return motoristaExiste;
			}
			else {
				System.out.println("Motorista não existe!");
			}
		return null;
}*/
	
	/*public boolean motoristaExiste(String cpf) {
		boolean motoristaExistente = false;
		Motorista motorista = null;
		for(Motorista mot: BancoMotoristas.motoristas) {
			if (mot.getCpf().equals(cpf)) {
				motoristaExistente = true;
				motorista = mot;
			}
		}
		return motoristaExistente;
	}*/
// -------------------------------------------------------
	
	public static boolean cadastrarMotorista(String nome, String cpf) {
		Scanner scanner = new Scanner(System.in);
		String opCadastro = "true";
		boolean voltarParaMenuMotoristas = false;
		while(opCadastro.equals("true") && voltarParaMenuMotoristas == false) {
			if (verificarSeCpfSoTemNumeros(cpf) && verificarSeNomeSoTemLetras(nome)) {
				boolean motoristaExiste = Motorista.verificarSeMotoristaExiste(cpf);
				Motorista newMotorista = new Motorista(nome, cpf);
				if (motoristaExiste == true) {
					System.out.println("Motorista já cadastrado!");
					voltarParaMenuMotoristas = true;
					break;
				}
				else {
					if(!nome.isBlank() && !cpf.isBlank()) {
						BancoMotoristas.motoristas.add(newMotorista);
						System.out.printf("Motorista: %s com CPF %s cadastrado!\n", nome, cpf);
						voltarParaMenuMotoristas = true;
						break;
					}
					else if(nome.isBlank() && cpf.isBlank()) {
						System.out.printf("Você não digitou nem um nome nem um CPF para o motorista! Cadastro falhou \n");
					}
					else if(nome.isBlank()) {
						System.out.printf("Você não digitou um nome para o motorista! Cadastro falhou \n");
					}
					else if(cpf.isBlank()) {
						System.out.printf("Você não digitou um CPF para o motorista! Cadastro falhou \n");
					}
				}
			}
			
			boolean nomeSoTemLetras = verificarSeNomeSoTemLetras(nome);
			boolean querEntrarNoLoop = true;
			if (nomeSoTemLetras == false) {
				System.out.println("Você digitou caracteres INVÁLIDOS para o NOME do motorista (só são aceitas LETRAS no nome!)");
				while ((nomeSoTemLetras == false) && (querEntrarNoLoop == true)) {
					System.out.println("Digite '1' se quiser refazer o cadastro. Caso queira voltar para o menuMotoristas, digite '2'!");
					System.out.println("Digite a opção desejada: ");
					String opRefazer = scanner.nextLine();
					if (opRefazer.equals("1")) {
						opCadastro = "false";
						querEntrarNoLoop = false;
						System.out.println("Voltando para o cadastro. . .\n");//OLHA ESSA LINHA
						break;
					}
					else if (opRefazer.equals("2")) {
						System.out.println("Voltando para o menuMotoristas. . .\n");//OLHA ESSA LINHA!
						voltarParaMenuMotoristas = true;
						break;
					}
					else {
						System.out.println("Opção inválida, tente novamente: ");
						continue;
					}
				}
			}
			
			
			if (!verificarSeCpfSoTemNumeros(cpf)) {
				System.out.println("Você digitou caracteres INVÁLIDOS para o CPF do motorista (só são aceitos NÚMEROS no CPF!)");
				break;
			}
		}
		return voltarParaMenuMotoristas;
	}
	
	public static boolean voltarMenu(boolean opcao) {
		boolean voltarMenu = opcao;
		return voltarMenu;
	}
	
	public static Motorista buscarMotorista(String cpf) {
		Motorista motorista = null;
		boolean motoristaEncontrado = false;
			for(Motorista mot: BancoMotoristas.motoristas) {
				if (mot.getCpf().equals(cpf)) {
					motorista = mot;
					motoristaEncontrado = true;
					if(motoristaEncontrado == true) {
						break;
					}
					else{
						System.out.println("Motorista não existe!");
					}
				}
			}
		return motorista;
	}
	
	public static boolean verificarSeMotoristaExiste(String cpf) {
		boolean motoristaExiste = false;
		for(Motorista mot: BancoMotoristas.motoristas) {
			if (mot.getCpf().equals(cpf)) {
				motoristaExiste = true;
				return motoristaExiste;
			}
		}
		return motoristaExiste;
	}
	
	//Verificar se cpf contém apenas números
	//Verificar se nome contém apenas letras
	public static boolean verificarSeNomeSoTemLetras(String nome) {
	    boolean soTemLetras = true;
	    int naoLetra = 0;
		char[] myArray = nome.toCharArray();
	    char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	    for (char letra: myArray) {
		    for(int j = 0; j < 52; j++) {
		    	
		    	if (letra == ' ') {
		    		
		    	}
		    	else if (letra == alfabeto[j]) {
		    		break;
		    	}
		    	else if(j == 51) {
		    		naoLetra ++;
		    	}
		    }
	    }
	    if (naoLetra > 0) {
	    	soTemLetras = false;
	    	return soTemLetras;
	    }
	    return soTemLetras;
	}
	
	public static boolean verificarSeCpfSoTemNumeros(String cpf) {
		/**
		 * Retorna true se só tiver números, caso tiver algo além de números, retorna false!
		 */
		boolean cpfSoTemNumeros = false;
		if(cpf.matches("^\\d+$")) {
			cpfSoTemNumeros = true;
		}
		return cpfSoTemNumeros;
	}
// -----------------------------------------------------------
	
}

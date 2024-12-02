package br.com.crud.principal;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.crud.model.Abastecimento;
import br.com.crud.model.Motorista;
import br.com.crud.model.Veiculo;
import br.com.crud.banco.BancoVeiculos;
import br.com.crud.menus.ExibirMenus;

public class Main {
	public static void main(String[] args) {
		iniciarSistema();
		
	}	
		
	/**
	 * 
	 */
	public static void iniciarSistema() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			ExibirMenus.menuPrincipal();
			String op = scanner.nextLine();
				while (op.equals("1")) {
					ExibirMenus.menuMotoristas();
					System.out.println("Digite a opção desejada: ");
					String opMotoristas = scanner.nextLine();
						while (opMotoristas.equals("1")) {
							System.out.println("--Cadastrar Motorista--");
							System.out.println("Digite o nome do motorista: ");
							String nome = scanner.nextLine();
							System.out.println("Agora digite o CPF do motorista: ");
							String cpf = scanner.nextLine();
							boolean voltarMenuOpcao = Motorista.cadastrarMotorista(nome, cpf);
							if(voltarMenuOpcao == true) {
								op = "";
								break;
							}
						}
						
						while(opMotoristas.equals("2")) {
							System.out.println("--Buscar motorista por CPF--");
							System.out.print("Digite o CPF do motorista que queres buscar: ");
							boolean voltarMenuOpcao = false;
							String cpf = scanner.nextLine();
							Motorista motorista = Motorista.buscarMotorista(cpf);
							if(motorista != null) {
								System.out.println(motorista.getNome());
							}
							else {
								System.out.println("Motorista não encontrado!");
							}
							System.out.println("Você quer buscar novamente ou voltar para o menuPincipal?");
							System.out.println("Digite 1 para tentar novamente // Digite 2 para voltar para o menuMotoristas");
							String opcao = scanner.nextLine();
							
							if(opcao.equals("1")) {
								continue;
							}
							if(opcao.equals("2")) {
								System.out.println("Voltando para o menu principal... \n");
								op = "";
								break;
							}
						}
						if(opMotoristas.equals("0")) {
							System.out.println("Voltando para o menu principal... \n");
							op = "";
							break;
						}
						else if(op == "") {
							
						}
						else {
							System.out.println("Opção inválida!");
						}
				}
				while(op.equals("2")) {
					ExibirMenus.menuVeiculos();
					String opVeiculos = scanner.nextLine();
					if(opVeiculos.equals("1")) {
						//1- Cadastrar Veiculo
						System.out.println("--Cadastrar Veículo--");
						System.out.println("Digite a placa do veículo: ");
						Veiculo.cadastrarVeiculo();
					}
					else if(opVeiculos.equals("2")) {
						//2- Buscar por placa
						System.out.println("--Buscar Veículo por placa--");
						System.out.println("Digite a placa do veículo que queres buscar: ");
						String placa = scanner.nextLine();
						Veiculo veiculoBuscado = Veiculo.buscarVeiculo(placa);
						if(veiculoBuscado != null) {
							System.out.printf("Placa: " + veiculoBuscado.getPlaca() + "\n");
							System.out.printf("Capacidade do tanque: " + veiculoBuscado.getCapacidadeDoTanque() + "\n");
							System.out.printf("Modelo: " + veiculoBuscado.getModelo() + "\n");
							if (veiculoBuscado.getMotorista() != null) {
								System.out.printf("Motorista: " + veiculoBuscado.getMotorista().getNome() + "\n");
							}
						}
						else {
							System.out.println("Não existe veículo com essa placa!");
						}
					}
					else if(opVeiculos.equals("3")) {
						//3- Listar todos os veiculos
						if(!BancoVeiculos.veiculos.isEmpty()) {
							int contador = 1;
							for(Veiculo vei : BancoVeiculos.veiculos) {
								System.out.println("--Listar todos os veículos--");
								System.out.println("###########################");
								System.out.printf("Veículo Nº" + contador + "\n");
								System.out.println("--------------------");
								System.out.printf("Placa: " + vei.getPlaca() + "\n");
								System.out.printf("Capacidade do tanque: " + vei.getCapacidadeDoTanque() + "\n");
								System.out.printf("Modelo: " + vei.getModelo() + "\n");
								if (vei.getMotorista() != null) {
									System.out.printf("Motorista: " + vei.getMotorista().getNome() + "\n");
								}
								System.out.println("--------------------");
								System.out.printf("###########################" + "\n" + "\n");
								contador += 1;
							}
						}
						else {
							System.out.println("Nenhum veículo cadastrado!");
						}
					}
					else if(opVeiculos.equals("4")) {
						//4- Atribuir um motorista a um veiculo
						System.out.println("--Atribuir motorista a um veículo--");
						System.out.println("Digite a placa do veículo que queres atribuir um motorista!");
						String placa = scanner.nextLine();
						Veiculo veiculoBuscado = Veiculo.buscarVeiculo(placa);
						boolean veiculoExiste = Veiculo.verificarSeVeiculoExiste(placa);
						
						if(veiculoExiste == true && veiculoBuscado.getMotorista() != null) {
							System.out.println("Digite o cpf do motorista que você deseja atribuir ao veículo");
							String cpf = scanner.nextLine();
							if (Motorista.buscarMotorista(cpf) != null) {
								Motorista motorista = Motorista.buscarMotorista(cpf);
								veiculoBuscado.setMotorista(motorista);
								System.out.printf("Motorista " + motorista + "atribuido ao veículo " + veiculoBuscado);
							}
							else {
								System.out.println("Você está tentando atribuir, ao veículo, um motorista que não existe!");
							}
						}
						else if(veiculoExiste == false) {
							System.out.println("Você quer atribuir um motorista a um veículo que não existe!");
						}
						else {
							System.out.println("O veículo já tem um motorista!");
						}
					}
					else if(opVeiculos.equals("5")) {
						//5- Listar Veiculos por CPF do motorista
						System.out.println("--Listar veículos do motorista--");
						System.out.println("Digite o CPF do motorista que queres listar os veículos: ");
						String cpf = scanner.nextLine();
						Motorista motorista = Motorista.buscarMotorista(cpf);
						ArrayList<Veiculo> veiculosDoMotorista = new ArrayList<>();
						if(Motorista.verificarSeMotoristaExiste(cpf)) {
							for(Veiculo vei: BancoVeiculos.veiculos) {
								if (vei.getMotorista() == motorista) {
									veiculosDoMotorista.add(vei);
								}
							}
							if(veiculosDoMotorista.isEmpty()) {
								System.out.println("Este motorista não tem nenhum veículo!");
							}
							else {
								System.out.printf("Aqui estão todos os veículos do motorista " + motorista.getNome() + "\n");
								int contador = 1;
								for(Veiculo vei: veiculosDoMotorista) {
									System.out.println("###########################");
									System.out.printf("Veículo Nº" + contador + "do motorista" + motorista.getNome() + "\n");
									System.out.println("--------------------");
									System.out.printf("Placa: " + vei.getPlaca() + "\n");
									System.out.printf("Capacidade do tanque: " + vei.getCapacidadeDoTanque() + "\n");
									System.out.printf("Modelo: " + vei.getModelo() + "\n");
									if (vei.getMotorista() != null) {
										System.out.printf("Motorista: " + vei.getMotorista().getNome() + "\n");
									}
									System.out.println("--------------------");
									System.out.printf("###########################" + "\n" + "\n");
									contador += 1;
								}
							}
					}
					else {
							System.out.println("Motorista não existe!");
					}
				}
					else if(opVeiculos.equals("6")) {
						//6- Listar Todos os veiculos que tem capacidade de tanque maior que 50
						System.out.println("--Listar Todos os veiculos que tem capacidade de tanque maior que a desejada--");
						System.out.print("Você quer os veículos ACIMA de qual capacidade do tanque? Resposta: ");
						int capacidadeDoTanque = scanner.nextInt();
						ArrayList<Veiculo> veiculosDesejados = new ArrayList<>();
						for(Veiculo vei: BancoVeiculos.veiculos) {
							if(vei.getCapacidadeDoTanque() > capacidadeDoTanque) {
								veiculosDesejados.add(vei);
							}
						}
						if(veiculosDesejados.isEmpty()) {
							System.out.printf("Nenhum veículo cadastrado tem capacidade acima de " + capacidadeDoTanque + "\n");
						}
						else {
							int contador = 1;
							for(Veiculo vei: veiculosDesejados) {
								System.out.println("###########################");
								System.out.printf("Veículo Nº" + contador + "com capacidade maior que " + capacidadeDoTanque + "\n");
								System.out.println("--------------------");
								System.out.printf("Placa: " + vei.getPlaca() + "\n");
								System.out.printf("Capacidade do tanque: " + vei.getCapacidadeDoTanque() + "\n");
								System.out.printf("Modelo: " + vei.getModelo() + "\n");
								if (vei.getMotorista() != null) {
									System.out.printf("Motorista: " + vei.getMotorista().getNome() + "\n");
								}
								System.out.println("--------------------");
								System.out.printf("###########################" + "\n" + "\n");
								contador += 1;
							}
						}
					}
					else if(opVeiculos.equals("0")) {
						System.out.println("Voltando para o menu principal... \n");
						op = "";
						break;
					}
					else {
						System.out.println("Opção inválida, voltando para o menu principal. . . \n");
					}
				}
			while(op.equals("3")) {
				ExibirMenus.menuAbastecimentos();
				String opAbastecimentos = scanner.nextLine();
				if(opAbastecimentos.equals("1")) {
					//1- Cadastrar Abastecimento de um veículo
					System.out.println("--Cadastrar abastecimentos para um veículo--");
					System.out.println("Digite a placa do veículo que queres cadastrar abastecimentos: ");
					String placa = scanner.nextLine();
					if(Veiculo.verificarSeVeiculoExiste(placa)) {
						System.out.println("Digite a quantidade de litros que foi abastecida: ");
						int litrosAbastecidos = scanner.nextInt();
						scanner.nextLine();
						Abastecimento.cadastrarAbastecimento(placa, litrosAbastecidos);
						System.out.printf("Voltando para menu principal... \n");
					}
					else {
						System.out.println("Você está tentando adicionar abastecimento a um veículo inexistente!");
					}
				}
				else if(opAbastecimentos.equals("2")) {
					//2- Listar abastecimentos do veículo
					System.out.println("--Listar abastecimentos do veículo--");
					System.out.println("Digite a placa do veículo que queres listar os abastecimentos");
					String placa = scanner.nextLine();
					if (Veiculo.verificarSeVeiculoExiste(placa)) {
						Veiculo veiculo = Veiculo.buscarVeiculo(placa);
						for(Abastecimento abast: veiculo.abastecimentos) {
							System.out.println("-------------------");
							abast.mostrarAbastecimento();
							System.out.println("-------------------");
						}
					}
					else {
							System.out.println("Veículo não existe! ");
					}
				}
				else if(opAbastecimentos.equals("0")) {
					System.out.println("Voltando para o menu principal... \n");
					op = "";
					break;
				}
				
			}
			if(op.equals("0")) {
				System.out.println("Saindo do sistema. . .");
				break;
			}
			else if(op.equals("")) {
				//bloco de comando criado apenas para ele não cair no else quando retornar uma opção voltando de algum menu!
			}
			else {
				System.out.println("OPÇÃO iNVÁLIDA, tente novamente: ");
			}

		}
		
		
		
		
	}
}
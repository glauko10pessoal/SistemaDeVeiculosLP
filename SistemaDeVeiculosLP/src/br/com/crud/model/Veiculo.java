package br.com.crud.model;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.crud.banco.BancoVeiculos;

public class Veiculo {
	private String placa;
	private int capacidadeDoTanque;
	private String modelo;
	private Motorista motorista;
	public ArrayList<Abastecimento> abastecimentos = new ArrayList<>();

	
	public Veiculo(String placa, int capacidadeDoTanque, String modelo){
		this.placa = placa;
		this.capacidadeDoTanque = capacidadeDoTanque;
		this.modelo = modelo;
	}
	
	public String getPlaca() {
		return this.placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public int getCapacidadeDoTanque() {
		return this.capacidadeDoTanque;
	}
	public void setCapacidadeDoTanque(int capacidadeDoTanque) {
		this.capacidadeDoTanque = capacidadeDoTanque;
	}

	public String getModelo() {
		return this.modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Motorista getMotorista() {
		return this.motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	public static void cadastrarVeiculo() {
		Scanner scanner = new Scanner(System.in);
		String placa = scanner.nextLine();
		boolean veiculoExiste = Veiculo.verificarSeVeiculoExiste(placa);
		if (veiculoExiste == true) {
			System.out.println("Veículo já cadastrado!");
			return;
		}
		System.out.println("Digite a capacidade do tanque do veículo: ");
		int capacidadeDoTanque = scanner.nextInt();
		System.out.println("Digite o modelo do veículo: ");
		//ERRO AQUI, PRA RESOLVER O ERRO É SÓ COLOCAR ESSE SCANNER.NEXT LINE, MAS PRA FICAR DE MANEIRA "MAIS BONITA", É MELHOR VER O NEGÓCIO QUE EU GUARDEI NO NAVEGADOR ENSINANDO A USAR MELHOR A CLASSE SCANNER!
		scanner.nextLine();
		String modelo = scanner.nextLine();
		Veiculo newVeiculo = new Veiculo(placa, capacidadeDoTanque, modelo);
		System.out.println("Deseja cadastrar um motorista para o veículo? [1] - Sim /// [2] - Não");
		String opMotorista = scanner.nextLine();
		if(opMotorista.equals("1")) {
			System.out.println("Digite o CPF do motorista: ");
			String cpf = scanner.nextLine();
			Motorista motorista = Motorista.buscarMotorista(cpf);
			newVeiculo.setMotorista(motorista);
		}
		else if(opMotorista.equals("2")) {
			System.out.println("Voltando. . ." + "\n");
		}
		BancoVeiculos.veiculos.add(newVeiculo);
		System.out.printf("Veículo de placa %s cadastrado com êxito! %n", placa);
	}
	
	public static Veiculo buscarVeiculo(String placa) {
		Veiculo veiculo = null;
		boolean veiculoEncontrado = false;
			for(Veiculo vei: BancoVeiculos.veiculos) {
				if (vei.getPlaca().equals(placa)) {
					veiculo = vei;
					veiculoEncontrado = true;
					if(veiculoEncontrado == true) {
						break;
					}
					else {
						System.out.println("Veículo não existe!");
					}
				}
			}
		return veiculo;
	}
	
	public static boolean verificarSeVeiculoExiste(String placa) {
		boolean veiculoExiste = false;
		for(Veiculo vei: BancoVeiculos.veiculos) {
			if (vei.getPlaca().equals(placa)) {
				veiculoExiste = true;
				return veiculoExiste;
			}
		}
		return veiculoExiste;
	}
}

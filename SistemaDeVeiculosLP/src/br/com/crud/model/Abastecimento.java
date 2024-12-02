package br.com.crud.model;

import java.util.ArrayList;

public class Abastecimento {
	
	private Veiculo veiculo;
	private int litrosAbastecidos;
	private String tipoDoCombustivel;
	private int precoDoLitroDoCombustivel;
	
	
	public Abastecimento(Veiculo veiculo, int litrosAbastecidos) {
		this.veiculo = veiculo;
		this.litrosAbastecidos = litrosAbastecidos;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public int getLitrosAbastecidos() {
		return litrosAbastecidos;
	}
	public void setLitrosAbastecidos(int litrosAbastecidos) {
		this.litrosAbastecidos = litrosAbastecidos;
	}
	
	public String getTipoDoCombustivel() {
		return tipoDoCombustivel;
	}
	public void setTipoDoCombustivel(String tipoDoCombustivel) {
		this.tipoDoCombustivel = tipoDoCombustivel;
	}
	
	public int getPrecoDoLitroDoCombustivel() {
		return precoDoLitroDoCombustivel;
	}
	public void setPrecoDoLitroDoCombustivel(int precoDoLitroDoCombustivel) {
		this.precoDoLitroDoCombustivel = precoDoLitroDoCombustivel;
	}
	
	public void mostrarAbastecimento() {
		System.out.printf("Litros abastecidos: " + litrosAbastecidos + "\n");
		if (tipoDoCombustivel != null) {
			System.out.printf("Tipo do combustível: " + tipoDoCombustivel + "\n");
		}
		if (precoDoLitroDoCombustivel > 0) {
			System.out.println("Preço do litro do combustível: " + precoDoLitroDoCombustivel);
		}
	}
	
	public static void cadastrarAbastecimento(String placa, int litrosAbastecidos) {
			Veiculo veiculo = Veiculo.buscarVeiculo(placa);
			Abastecimento abastecimento = new Abastecimento(veiculo, litrosAbastecidos);
			veiculo.abastecimentos.add(abastecimento);
			System.out.printf("Abastecimento cadastrado no veículo de placa " + placa + " Com sucesso!\n");
	}
	public boolean verificarSeAbastecimentoExiste(Veiculo veiculo) {
		boolean veiculoTemAbastecimentos = false;
		if (!veiculo.abastecimentos.isEmpty()) {
			veiculoTemAbastecimentos = true;
			return veiculoTemAbastecimentos;
		}
		else {
			System.out.println("Veículo sem abastecimentos cadastrados!");
		}
	return veiculoTemAbastecimentos;
	}
	public ArrayList<Abastecimento> listarAbastecimentos() {
		ArrayList<Abastecimento> abastecimentosListados = new ArrayList<>();
		if (!veiculo.abastecimentos.isEmpty()) {
			for(Abastecimento abast: veiculo.abastecimentos) {
				abastecimentosListados.add(abast);
			}
			return abastecimentosListados;
		}
		return abastecimentosListados;
	}
}

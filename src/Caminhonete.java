import java.util.Scanner;

public class Caminhonete extends Veiculo{
	private double custoInicial = 3.00;
	private double custoAdicional = 3.50;

	public Caminhonete(String placa,String tipoVeiculo ){
		super(placa, tipoVeiculo);
	}

	public double getCustoInicial() {

		return custoInicial;
	}

	public double getCustoAdicional() {
		return custoAdicional;
	}
}

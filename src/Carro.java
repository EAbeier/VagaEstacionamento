import java.util.Scanner;
import java.util.Scanner;

public class Carro extends Veiculo {
	private double custoInicial = 2.00;
	private double custoAdicional = 2.50;

	public Carro (String placa, Tipo tipoVeiculo) {
		super(placa, tipoVeiculo);
	}

	public double getCustoInicial() {

		return custoInicial;
	}

	public double getCustoAdicional() {
		return custoAdicional;
	}
}
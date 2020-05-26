import java.util.Scanner;

public class Moto extends Veiculo
{
	private double custoInicial = 1.00;
	private double custoAdicional = 1.50;

	public Moto(String placa, Tipo tipoVeiculo)
	{
		super(placa, tipoVeiculo);
	}

	public double getCustoInicial()
	{
		return custoInicial;
	}

	public double getCustoAdicional()
	{
		return custoAdicional;
	}
}
import java.util.Date;

public abstract class Veiculo
{
	private static Tipo tipoVeiculo;
	private int hora;
	private String placa;

	public Veiculo(String placa, Tipo tipoVeiculo)
	{
		tipoVeiculo = tipoVeiculo;
		this.placa = placa;

		Date date = new Date();
		this.hora = date.getHours();

	}
	public static Tipo getTipo()
	{
		return tipoVeiculo;
	}

	public String getPlaca()
	{
		return placa;
	}
	public int getHora()
	{
		return hora;
	}
	public abstract double getCustoInicial();
	public abstract double getCustoAdicional();
	public static Tipo getInstance(){
		return tipoVeiculo;
	}
}





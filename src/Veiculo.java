import java.util.Date;

public abstract class Veiculo {
	private String tipoVeiculo;
	private int hora;
	private String placa;

	public Veiculo(String placa, String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
		this.placa = placa;

		Date date = new Date();
		this.hora = date.getHours();

	}
	public String getTipo(){
		return tipoVeiculo;
	}

	public String getPlaca() {
		return placa;
	}
	public abstract double getCustoInicial();
	public abstract double getCustoAdicional();
}





import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Ticket {
    private static Map<String,Vaga> vaga;
    private static Map<String,Veiculo> veiculo;
    public void listaVagas(){

    }

    public void getTipoVaga() {
        this.vaga = new HashMap();
        this.vaga.put("gestante", new Gestante());
        this.vaga.put("pcd", new PCD());
        this.vaga.put("idoso",new Idoso());
        this.vaga.put("comum", new Comum());
    }

    public void criaTipoVeiculo(){
        this.veiculo = new HashMap();
        this.veiculo.put("carro", new Carro());
        this.veiculo.put("caminhonete", new Caminhonete());
        this.veiculo.put("moto",new Moto());
    }
    public  void setEntrada(){
        //salva no DAO pela placa
    }
    public void setSaida(){
        //salva no DAO pela placa
    }

    public LocalDateTime getEntrada(){
        LocalDateTime data = LocalDateTime.parse("2017-12-25T20:30:50"/* posteriormente sera o daodata*/);
        return (data);
    }
        //função para buscar data pela placa
    public String getEntradaFormatada(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss ");
        return sdf.format(getEntrada());
    }

    public LocalDateTime getSaida(){
        LocalDateTime data = LocalDateTime.parse("2017-12-25T20:30:50"/* posteriormente sera o daodata*/);
        return (data);
    }
    public String getSaidaFormatada(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss ");
        return sdf.format(getSaida());
    }

    public void getValor(String placa, Date entrada, Date saida){
        Pagamento.calculaValor(getEntradaFormatada(),getSaidaFormatada());
    }
}

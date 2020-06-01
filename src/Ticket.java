import java.util.Date;
import java.util.Scanner;

public class Ticket {
    static Scanner scn = new Scanner(System.in);
    protected static Veiculo[] vaga = new Veiculo[60];


    public static boolean setEntrada(String placa, Tipo tipo)
    {
        for(int i=0; i<vaga.length; i++)
        {
            if (tipo.equals(Tipo.Carro))
            {
                Veiculo carro = new Carro(placa, tipo.Carro);
                if (vaga[i] == null)
                {
                    vaga[i] = carro;
                    int qntVeiculos = 1;
                    int qntVeiculosEntrou =1;
                    int qntVeiculosSaiu = 0;
                    Vaga.setQntVeiculo(qntVeiculos,qntVeiculosEntrou,qntVeiculosSaiu);
                    return true;
                }
            }
            if (tipo.equals(tipo.Caminhonete))
            {
                Veiculo caminhonete= new Caminhonete(placa, tipo.Caminhonete);
                if (vaga[i] == null)
                {
                    vaga[i] = caminhonete;
                    int qntVeiculos = 1;
                    int qntVeiculosEntrou =1;
                    int qntVeiculosSaiu = 0;
                    Vaga.setQntVeiculo(qntVeiculos,qntVeiculosEntrou,qntVeiculosSaiu);
                    return true;
                }
            }
            else if (tipo.equals(tipo.Moto))
            {
                Veiculo moto= new Moto(placa, tipo.Moto);
                if (vaga[i] == null)
                {
                    vaga[i] = moto;
                    int qntVeiculos = 1;
                    int qntVeiculosEntrou =1;
                    int qntVeiculosSaiu = 0;
                    Vaga.setQntVeiculo(qntVeiculos,qntVeiculosEntrou,qntVeiculosSaiu);
                    return true;
                }
            }


        }
        return false;
    }
    public static void saiEstacionamento(String placa)
    {

        for (int i=0; i<vaga.length;i++)
        {
            if (vaga[i]!=null)
            {
                if (placa.equals(vaga[i].getPlaca()))
                {
                    System.out.println("Saida de Veículo com placa " + vaga[i].getPlaca() + " registrada");
                    pagar(i);
                    setSaida(i);
                }
                else
                {
                    System.out.println("placa " + placa + " não encontrada.\n" +
                            "digite a placa novamente");
                    placa = scn.next();
                    placa = placa.toLowerCase();
                }
            }
        }
    }
    public static void pagar(int i)
    {
        Date data = new Date();
        if(vaga[i]!= null)
        {
            int horaAtual = data.getHours();
            int tempo = horaAtual - vaga[i].getHora();
            if(tempo <= 1 )
            {
                double valor = Pagamento.getCustoHoraInicial(vaga[i].getCustoInicial(),tempo);
                System.out.println(valor);
            }
            else
            {
                double valorIncial = vaga[i].getCustoInicial();
                double valoradicional = vaga[i].getCustoAdicional();
                double valor = Pagamento.getCustoHoraAdicional(valorIncial,valoradicional,tempo);
                System.out.println("valor a pagar: " + valor);
            }
        }
    }
    public static void setSaida(int i)
    {
        vaga[i]= null;
        int qntVeiculos = 0;
        int qntVeiculosEntrou =0;
        int qntVeiculosSaiu = 1;
        Vaga.setQntVeiculo(qntVeiculos,qntVeiculosEntrou,qntVeiculosSaiu);;
    }
}

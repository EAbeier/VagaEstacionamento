import java.util.Date;

public class Pagamento
{
    public static double getCustoHoraInicial(double valor, int tempo){

        double custo = valor;
        return  custo;
    }
       public static double getCustoHoraAdicional(double custoInical, double custoadicional, int tempo)
       {

            double custo;
              custo = (tempo - 1) * custoadicional + custoInical;
               return custo ;
       }

}

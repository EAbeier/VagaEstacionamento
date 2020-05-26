public class Pagamento
{

       public static double calculaValor(double custoInical, double custoadicional, int tempo)
       {
            double valor = 0.00;
              valor = (tempo - 1) * custoadicional + custoInical;
               return valor ;
       }

}

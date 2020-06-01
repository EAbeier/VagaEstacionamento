public abstract class Vaga
{
    public String tipoVaga;

    private static int qntVeiculos =0;
    private static int qntVeiculosEntrou =0;
    private static int qntVeiculosSaiu = 0;

    public static void setQntVeiculo(int qntVeiculosTicket, int qntVeiculosEntrouTicket, int qntVeiculosSaiuTicket) {
        qntVeiculos = qntVeiculos+qntVeiculosTicket;
        qntVeiculosEntrou = qntVeiculosEntrou+qntVeiculosEntrouTicket;
        qntVeiculosSaiu = qntVeiculosSaiu+qntVeiculosSaiuTicket;
        qntVeiculos = qntVeiculosSaiu - qntVeiculosSaiuTicket;
    }
    public static  int getQntVeiculos()
    {
        return qntVeiculos;
    }

    public static void getfluxo()
    {
        System.out.println("Numeros de entradas: "+qntVeiculosEntrou+"\n" +
                " e o numero de saidas: "+ qntVeiculosSaiu);
    }

}

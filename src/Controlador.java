import org.w3c.dom.ls.LSOutput;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Controlador {
    private Veiculo[] vaga = new Veiculo[60];
    int qntVeiculos =0;
    int qntVeiculosEntrou =0;
    int QntVeiculosSaiu = 0;


    public int getQntVeiculos()
    {
        return qntVeiculos;
    }
    public void getfluxo()
    {
        System.out.println("Numeros de entradas: "+qntVeiculosEntrou+"\n" +
                            " e o numero de saidas: "+ QntVeiculosSaiu);
    }

    public boolean setEntrada(String placa, Tipo tipo)
    {
        for(int i=0; i<vaga.length; i++)
        {
            if (tipo.equals(Tipo.Carro))
            {
                Veiculo carro = new Carro(placa, tipo.Carro);
                if (vaga[i] == null) {
                    this.vaga[i] = carro;
                    qntVeiculos = qntVeiculos + 1;
                    qntVeiculosEntrou =qntVeiculos +1;
                    return true;
                }
            }
            if (tipo.equals(tipo.Caminhonete))
            {
                Veiculo caminhonete= new Caminhonete(placa, tipo.Caminhonete);
                if (vaga[i] == null)
                {
                    this.vaga[i] = caminhonete;
                    qntVeiculos = qntVeiculos + 1;
                    qntVeiculosEntrou =qntVeiculos +1;
                    return true;
                }
            }
            else if (tipo.equals(tipo.Moto))
            {
                Veiculo moto= new Moto(placa, tipo.Moto);
                if (vaga[i] == null)
                {
                    this.vaga[i] = moto;
                    qntVeiculos = qntVeiculos + 1;
                    qntVeiculosEntrou =qntVeiculos +1;
                    return true;
                }
            }


        }
        return false;
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


    public void estaciona(){

    }

    public void saiEstacionamento(){

    }
    public void pagar(){

    }

    public void iniciaEstacionamento() {
        Scanner scn = new Scanner(System.in);
        int escolha = 0;
        while (escolha != 99) {
            System.out.println("---------------------------\n"+
                                "    ESTACIONAMENTO POO\n"+
                                "---------------------------\n" +
                                "Escolha a opção desejada:\n"+
                                " 1 - Cadastrar entrada de Veículo\n"+
                                " 2 - Cadastrar saida de Veículo\n"+
                                " 3 - gerar pagamento\n"+
                                " 4 - relatorio de veiculos estacionados\n"+
                                " 5 - entradas e saidas do dia\n"+
                                " 99 - SAIR\n");
            escolha = scn.nextInt();
            switch (escolha) {
                case 1: {
                    estaciona();
                    break;
                }
                case 2: {
                    saiEstacionamento();
                    break;
                }
                case 3: {
                    pagar();
                    break;
                }
                case 4: {
                    System.out.println(getQntVeiculos());
                    break;
                }
                case 5: {
                    getfluxo();
                    break;
                }
                case 99: {
                    break;
                }
                default: {
                    System.out.println("escolha não cadastrada.");
                    break;

                }

            }
        }


    }
}

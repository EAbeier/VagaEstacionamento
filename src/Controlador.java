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

public class Controlador
{
    Scanner scn = new Scanner(System.in);
    public Veiculo[] vaga = new Veiculo[60];
    int qntVeiculos =0;
    int qntVeiculosEntrou =0;
    int qntVeiculosSaiu = 0;

    public int getQntVeiculos()
    {
        return qntVeiculos;
    }

    public void getfluxo()
    {
        System.out.println("Numeros de entradas: "+qntVeiculosEntrou+"\n" +
                            " e o numero de saidas: "+ qntVeiculosSaiu);
    }

    public boolean setEntrada(String placa, Tipo tipo)
    {
        for(int i=0; i<vaga.length; i++)
        {
            if (tipo.equals(Tipo.Carro))
            {
                Veiculo carro = new Carro(placa, tipo.Carro);
                if (vaga[i] == null)
                {
                    this.vaga[i] = carro;
                    qntVeiculos = qntVeiculos + 1;
                    qntVeiculosEntrou =qntVeiculosEntrou +1;
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

    public void saiEstacionamento(String placa)
    {

        for (int i=0; i<vaga.length;i++)
        {
            if (this.vaga[i]!=null)
            {
                if (placa.equals(this.vaga[i].getPlaca()))
                {
                    System.out.println("Saida de Veículo com placa " + this.vaga[i].getPlaca() + " registrada");
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


    public void setSaida(int i)
    {
        this.vaga[i]= null;
        qntVeiculos = qntVeiculos - 1;
        qntVeiculosSaiu = qntVeiculosSaiu +1;
    }


    public void pagar(int i)
    {
        Date data = new Date();
        if(this.vaga[i]!= null)
        {
            int horaAtual = data.getHours();
            int tempo = horaAtual - this.vaga[i].getHora();
            if(tempo <= 1 )
            {
                double custoHoraInicial = this.vaga[i].getCustoInicial();
                System.out.println("valor a pagar: " + custoHoraInicial);
            }
            else
            {
                double custoHoraAdicional = this.vaga[i].getCustoAdicional();
                double conta = Pagamento.calculaValor(this.vaga[i].getCustoInicial(), custoHoraAdicional, tempo);
                System.out.println("valor a pagar: " + conta);
            }
        }
    }

    public void iniciaEstacionamento()
    {

        int escolha = 0;
        while (escolha != 99)
        {
            System.out.println("---------------------------\n"+
                                "    ESTACIONAMENTO POO\n"+
                                "---------------------------\n" +
                                "Escolha a opção desejada:\n"+
                                " 1 - Cadastrar entrada de Veículo\n"+
                                " 2 - Cadastrar saida de Veículo\n"+
                                " 3 - relatorio de veiculos estacionados\n"+
                                " 4 - entradas e saidas do dia\n"+
                                " 99 - SAIR\n");
            escolha = scn.nextInt();
            switch (escolha)
            {
                case 1:
                {
                    int ret =0;
                    do
                    {
                        System.out.println("entre com: \n (1) para carro; \n (2) para caminhonete \n (3) para moto");
                        int veiculo = scn.nextInt();

                        switch (veiculo)
                        {
                            case 1:
                            {
                                System.out.println("Entre com a placa do veiculo");
                                String placa = scn.next();
                                placa = placa.toLowerCase();
                                Tipo tipo = Tipo.Carro;
                                setEntrada(placa, tipo);
                                System.out.println("entrada registrada");
                                ret = 1;
                                break;
                            }
                            case 2:
                            {
                                System.out.println("Entre com a placa do veiculo");
                                String placa = scn.next();
                                placa = placa.toLowerCase();
                                Tipo tipo = Tipo.Caminhonete;
                                setEntrada(placa, tipo);
                                System.out.println("entrada registrada");
                                ret = 1;
                                break;
                            }
                            case 3:
                            {
                                System.out.println("Entre com a placa do veiculo");
                                String placa = scn.next();
                                Tipo tipo = Tipo.Moto;
                                placa = placa.toLowerCase();
                                setEntrada(placa, tipo);
                                System.out.println("entrada registrada");
                                ret = 1;
                                break;
                            }
                            default:
                            {
                                System.out.println("Tipo de veículo não identificado");
                                ret = 0;
                                break;
                            }
                        }
                    }while(ret!=1);

                    break;
                }
                case 2:
                {
                    System.out.println("Entre com a placa do veículo:");
                    String placa = scn.next();
                    placa = placa.toLowerCase();
                    saiEstacionamento(placa);
                    break;
                }
                case 3:
                {
                    System.out.println(getQntVeiculos());
                    break;
                }
                case 4:
                {
                    getfluxo();
                    break;
                }
                case 99:
                {
                    break;
                }
                default:
                {
                    System.out.println("escolha não cadastrada.");
                    break;

                }

            }
        }


    }
}

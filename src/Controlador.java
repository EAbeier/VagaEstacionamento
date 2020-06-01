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
                                Ticket.setEntrada(placa, tipo);
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
                                Ticket.setEntrada(placa, tipo);
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
                                Ticket.setEntrada(placa, tipo);
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
                    Ticket.saiEstacionamento(placa);
                    break;
                }
                case 3:
                {
                    System.out.println(Vaga.getQntVeiculos());
                    break;
                }
                case 4:
                {
                    Vaga.getfluxo();
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

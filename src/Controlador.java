import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Controlador {


    public void estaciona(){

    }

    public void saiEstacionamento(){

    }
    public void pagar(){

    }
    public void consultaEstacionamento(){

    }
    public void consultaFluxo(){

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
                    consultaEstacionamento();
                    break;
                }
                case 5: {
                    consultaFluxo();
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

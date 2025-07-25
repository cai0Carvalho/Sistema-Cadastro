package menu;

import java.util.Scanner;

import util.AlterarDado;
import util.BuscarInfo;
import util.Cadastro;
import util.DeletarPet;

public class MenuPrincipal {
    public static void inicialMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Menu inicial!");
        System.out.println("Por favor, escolha uma opção:");

        int op = 7;
        try {
            while (op == 7) {
                System.out.println("1.Cadastrar novo pet");
                System.out.println("2.Alterar os dados do pet cadastrado");
                System.out.println("3.Deletar um pet cadastrado");
                System.out.println("4.Listar os pets cadastrados");
                System.out.println("5.Listar pets por algum critério(idade, nome, raça)");
                System.out.println("6.Sair");
                System.out.print("Opção: ");
                op = scanner.nextInt();

                if(op < 1 || op > 6) {
                    System.out.println("Opção inválida! Por favor, escolha uma opção entre 1 e 6.");
                    op = 7;
                } else if (op == 6) {
                    System.out.println("Saindo do menu...");
                    break;
                } else{
                    switch (op) {
                        case 1:
                            System.out.println("1.Cadastrar novo pet");
                            Cadastro.cadastrar();
                            break;
                        case 2:
                            System.out.println("2.Alterar os dados do pet cadastrado");
                            AlterarDado.alterarDados();
                            break;
                        case 3:
                            System.out.println("3.Deletar um pet cadastrado");
                            DeletarPet.deletarPet();
                            break;
                        case 4:
                            System.out.println("4.Listar os pets cadastrados");
                            Cadastro.listarPets();
                            break;
                            case 5:
                            System.out.println("5.Listar pet por critério(idade, nome, raça)");
                            BuscarInfo.inicarBusca();
                            break;
                        case 6:
                            System.out.println("6.Sair");
                            op = 0;
                            break;
                        default:
                            break;
                    }
                }
            }

        }catch (Exception e) {
            System.out.println("erro inesperado: ");
            e.printStackTrace();
        } finally {
            scanner.close();

        }

    }
}

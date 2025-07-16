package menu;

import java.util.Scanner;

import model.FiltroBusca;

public class MenuBusca {
    public static FiltroBusca menuCriterios() {
        System.out.println("-------------------------------------------------------");
        System.out.println("O tipo de animal é obrigatório para a busca. \nQuais criterios a mais você deseja usar para buscar? ");
        System.out.println("1. Buscar por nome ou sobrenome");
        System.out.println("2. Buscar por sexo");
        System.out.println("3. Buscar por idade");
        System.out.println("4. Buscar por peso");
        System.out.println("5. Buscar por raça");
        System.out.println("6. Buscar por endereço");
        System.out.println("7. Buscar por nome e idade");
        System.out.println("8. Buscar por sobrenome e idade");
        System.out.println("9. Buscar por idade e peso");

        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();

        if(op <1 || op > 9) {
            System.out.println("Digite uma opção válida entre 1 e 9.");
            System.exit(0);
        }

        String tipo = "";
        System.out.println("Digite o tipo de pet (Cachorro/Gato):");
        tipo = scanner.next().trim().toLowerCase();

        while(!tipo.equalsIgnoreCase("cachorro") && !tipo.equalsIgnoreCase("gato")){
            System.out.println("Digite uma opção válida");
            System.out.println("Digite o tipo de pet (Cachorro/Gato):");
            tipo = scanner.next().trim().toLowerCase();
        }

        String[] resposta = new String[2];

        switch (op) {
            case 1:
                 scanner.nextLine(); // <-- limpa o buffer do enter anterior
                System.out.println("Digite o nome ou sobrenome do pet:");
                resposta[0] = scanner.nextLine().trim();
                break;
            case 2:
                scanner.nextLine(); // limpa buffer
                System.out.println("Digite o sexo do pet (Macho/Fêmea):");
                resposta[0] = scanner.nextLine().trim();
                break;
            case 3:
                 scanner.nextLine(); // limpa buffer
                System.out.println("Digite a idade do pet:");
                resposta[0] = scanner.nextLine().trim();
                break;
            case 4:
                scanner.nextLine(); // limpa buffer
                System.out.println("Digite o peso do pet:");
                resposta[0] = scanner.nextLine().trim();
                break;
            case 5:
               scanner.nextLine(); // limpa buffer
                System.out.println("Digite a raça do pet:");
                resposta[0] = scanner.nextLine().trim();
                break;
            case 6:
                scanner.nextLine(); // limpa buffer
                System.out.println("Digite o endereço do pet:");
                resposta[0] = scanner.nextLine().trim();
                break;
            case 7:
                scanner.nextLine(); // limpa buffer
                System.out.println("Digite o nome do pet:");
                resposta[0] = scanner.nextLine().trim();
                System.out.println("Digite a idade do pet:");
                resposta[1] = scanner.nextLine().trim();
                break;
            case 8:
                scanner.nextLine(); // limpa buffer
                System.out.println("Digite o sobrenome do pet:");
                resposta[0] = scanner.nextLine().trim();
                System.out.println("Digite a idade do pet:");
                resposta[1] = scanner.nextLine().trim();
                break;
            case 9:
                scanner.nextLine(); // limpa buffer
                System.out.println("Digite a idade do pet:");
                resposta[0] = scanner.nextLine().trim();
                System.out.println("Digite o peso do pet:");
                resposta[1] = scanner.nextLine().trim();
                break;
            default:
                break;
        }

        return new FiltroBusca(tipo, resposta, op);
    }
}

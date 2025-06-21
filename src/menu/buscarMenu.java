package menu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class buscarMenu {
    public static void criterioMenu() {
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

        String tipo = "";
        System.out.println("Digite o tipo de pet (Cachorro/Gato):");
        tipo = scanner.next().trim().toLowerCase();

        if(op <1 || op > 9) {
            System.out.println("Digite uma opção válida entre 1 e 9.");
            return;
        }

        String[] resposta = new String[2];

        switch (op) {
            case 1:
                 scanner.nextLine(); // <-- limpa o buffer do enter anterior
                System.out.println("Digite o nome ou sobrenome do pet:");
                resposta[0] = scanner.nextLine().trim(); // <-- agora lê nomes compostos
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
        scanner.close();
    
        File pasta = new File("src\\lib\\petsCadastrados");
        buscarPets(pasta, tipo, resposta, op);
    }

    private static void buscarPets(File pasta, String tipo, String[] resposta, int op) {
        if(!pasta.isDirectory()){
            System.out.println("A pasta não é um diretório ou não existe.");
            return;
        }
        File[] arquivos = pasta.listFiles();
        if(arquivos == null || arquivos.length == 0) {
            System.out.println("A pasta não contém arquivos.");
            return;
        }

        List<String> petsEncontrados = new java.util.ArrayList<>();

        for (File arquivo : arquivos) {
            try {
                List<String> linhas = Files.readAllLines(arquivo.toPath());

                String textoCompleto = String.join(" ", linhas).toLowerCase();
                String tipoMinusculo = tipo.toLowerCase();
                String criterio1 = resposta[0] != null ? resposta[0].toLowerCase() : "";
                String criterio2 = resposta[1] != null ? resposta[1].toLowerCase() : "";

                boolean condicao = switch (op) {
                    case 1, 2, 3, 4, 5, 6 -> textoCompleto.contains(tipoMinusculo) && textoCompleto.contains(criterio1);
                    case 7, 8, 9 -> textoCompleto.contains(tipoMinusculo) && textoCompleto.contains(criterio1) && textoCompleto.contains(criterio2);
                    default -> false;
                };

                if (condicao) {
                    petsEncontrados.add(String.join("\n", linhas));
                }

            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo " + arquivo.getName() + ": " + e.getMessage());
            }
        }
        if (petsEncontrados.isEmpty()){
            System.out.println("Nenhum pet encontrado com os critérios informados.");
        } else {
            System.out.println("Pets encontrados:");
            for (String pet : petsEncontrados) {
                System.out.println("-------------------------------------------------------------------------");
                System.out.println(pet);
                System.out.println("-------------------------------------------------------------------------");
            }
        }
    }
}

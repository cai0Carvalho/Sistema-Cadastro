package util;

import java.io.File;
import java.util.Scanner;

import model.Pet;
import repository.PetRepository;

public class AlterarDado {
    public static void alterarDados() {
        BuscarInfo.inicarBusca();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Qual o número do pet que você deseja alterar?: ");
        int numeroPet = scanner.nextInt();

        while(numeroPet < 1 || numeroPet > PetRepository.petsEncontrados.size()) {
            System.out.println("Número inválido. Por favor, tente novamente.");
            numeroPet = scanner.nextInt();
        }  

        Pet pet = PetRepository.petsEncontrados.get(numeroPet - 1);
        File arquivoDoPet = BuscarInfo.mapaPetArquivo.get(pet);
        
        if (arquivoDoPet == null) {
            System.out.println("Erro: Arquivo do pet não encontrado.");
            return;
        }

        System.out.println("Qual dado você quer alterar?");
        System.out.println("1. Nome");
        System.out.println("2. Sobrenome");
        System.out.println("3. Raça");
        System.out.println("4. Endereço");
        System.out.println("5. Peso");
        System.out.println("6. Idade");
        System.out.println("0. Cancelar");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        switch(escolha) {
            case 1:
                System.out.println("Digite o novo nome:");
                String novoNome = scanner.nextLine().trim();
                pet.setNome(novoNome);
                break;
            case 2:
                System.out.println("Digite o novo sobrenome:");
                String novoSobrenome = scanner.nextLine().trim();
                pet.setSobrenome(novoSobrenome);
                break;
            case 3:
                System.out.println("Digite a nova raça:");
                String novaRaca = scanner.nextLine().trim();
                pet.setRaca(novaRaca);
                break;
            case 4:
                System.out.println("Digite o novo endereço:");
                String novoEndereco = scanner.nextLine().trim();
                pet.setEndereco(novoEndereco);
                break;
            case 5:
                System.out.println("Digite o novo peso:");
                String novoPeso = scanner.nextLine().trim();
                pet.setPeso(novoPeso);
                break;
            case 6:
                System.out.println("Digite a nova idade:");
                String novaIdade = scanner.nextLine().trim();
                pet.setIdade(novaIdade);
                break;
            case 0:
                System.out.println("Alteração cancelada.");
                return;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        CriarArq.sobrescreverArquivoPet(arquivoDoPet, pet);
        System.out.println("Arquivo do pet atualizado com sucesso!");   
        System.out.println(pet);
    }
}
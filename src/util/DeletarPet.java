package util;

import java.io.File;
import java.util.Scanner;

import model.Pet;
import repository.PetRepository;

public class DeletarPet {

    public static void deletarPet() {
        BuscarInfo.buscarPets(new File("petsCadastrados"), "", new String[]{"", ""}, 0);

        if (PetRepository.petsEncontrados.isEmpty()) {
            System.out.println("Nenhum pet encontrado para deletar.");
            return;
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.print("Qual o número do pet que você deseja deletar?: ");
        int numeroPet = scan.nextInt();

        while (numeroPet < 1 || numeroPet > PetRepository.petsEncontrados.size()) {
            System.out.println("Número inválido. Por favor, tente novamente.");
            System.out.print("Número do pet: ");
            numeroPet = scan.nextInt();
        }

        Pet pet = PetRepository.petsEncontrados.get(numeroPet - 1);
        File arquivoDoPet = BuscarInfo.mapaPetArquivo.get(pet);

        if (arquivoDoPet == null || !arquivoDoPet.exists()) {
            System.out.println("Erro: Arquivo do pet não encontrado.");
            return;
        }

        boolean deletado = arquivoDoPet.delete();

        if (deletado) {
            PetRepository.petsEncontrados.remove(pet);
            BuscarInfo.mapaPetArquivo.remove(pet);
            System.out.println("Pet deletado com sucesso!");
        } else {
            System.out.println("Erro ao tentar deletar o arquivo do pet.");
        }
    }
}

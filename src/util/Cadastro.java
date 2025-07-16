package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;

import menu.LeitorFormulario;
import model.Pet;
import model.Pet.TipoPet;
import model.Pet.TipoSexo;

public class Cadastro {
    public static void cadastrar(){
        Pet pet = new Pet(); //criando o objeto da classe pet

        LeitorFormulario.show(); // mostrando o questionario
        System.out.println("Preencha com os dados do pet:");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("nome:");
            pet.setNome(scanner.nextLine());
            System.out.print("sobrenome:");
            pet.setSobrenome(scanner.nextLine());
            if (pet.getNome().isEmpty() || pet.getSobrenome().isEmpty()) {
                throw new EmptyStackException();
            }
            if (!pet.getNome().matches("[a-zA-Z]+") || !pet.getSobrenome().matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Nome e sobrenome não podem conter caracteres especiais!");
            }
            // TIPO
            System.out.print("tipo de pet 1.Cachorro 2.Gato: ");
            int tipo = scanner.nextInt();
            pet.setTipo(tipo == 1 ? TipoPet.cachorro : TipoPet.gato);

            // SEXO
            System.out.print("sexo 1.Macho 2.Fêmea: ");
            int sexo = scanner.nextInt();
            pet.setSexo(sexo == 1 ? TipoSexo.macho : TipoSexo.femea);
            scanner.nextLine();

            // ENDEREÇO
            System.out.print("Endereço (número): ");
            String numero = scanner.nextLine();

            System.out.print("Endereço (rua): ");
            String rua = scanner.nextLine();

            System.out.print("Endereço (cidade): ");
            String cidade = scanner.nextLine();
            pet.setEndereco(numero, rua, cidade);
            
            // IDADE
            System.out.print("idade (Deixe em branco caso nao saiba): ");
            String idadeStr = scanner.nextLine().replaceAll(",",".");
            double idade = idadeStr.isEmpty() ? -1 : Double.parseDouble(idadeStr);
            if (idade == -1) {
                pet.setIdade("nao informado");
            } else if (idade > 20){
                throw new IllegalArgumentException("idade inválida. O máximo permitido é 20");
            } else if (idade < 1 ){
                pet.setIdade("0." + (int) (idade *10));
            } else {
                pet.setIdade(String.valueOf(idade));
            }

            //PESO
            System.out.print("peso (Kg) (-1/nao sei):");
            String pesoStr = scanner.nextLine().replaceAll(",","." );
            double peso = pesoStr.isEmpty() ? -1 : Double.parseDouble(pesoStr);
            if(peso == -1){
                pet.setPeso("nao informado");
            } else if ( peso < 0.5 || peso > 60){
                 throw new IllegalArgumentException("Peso inválido. Deve ser entre 0.5kg e 60kg.");
            } else {
                pet.setPeso(String.valueOf(peso));
            }

            System.out.print("raca: ");
            String raca = scanner.nextLine().trim();

             if (raca.isEmpty()) {
                pet.setRaca("nao informado");
            } else if (!raca.matches("[a-zA-Z\\s]+")) {
                throw new IllegalArgumentException("Raça inválida. Não pode conter números ou caracteres especiais.");
            } else {
                pet.setRaca(raca);
            }

            System.out.println("Pet cadastrado com sucesso!");
            CriarArq.criarArquivo(pet);; //chamando o metodo para criar o arquivo

        }catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            return;
        }
    }

    //METODO PARA LISTAR OS PETS CADASTRADOS
    public static void listarPets() {
        File pasta = new File("petsCadastrados");
        
        if (!pasta.isDirectory()) {
            System.out.println("A pasta não é um diretório ou não existe.");
            return; // Correção aqui
        }

        File[] arquivos = pasta.listFiles();

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("A pasta não contém arquivos.");
            return;
        }

        System.out.println("Pets cadastrados:");
        int cont = 1;

        for (File arquivo : arquivos) {
            if (arquivo.isFile()) {
                try {
                    List<String> linhas = Files.readAllLines(arquivo.toPath());
                    
                    System.out.println("Pet " + cont + ":");
                    for (String linha : linhas) {
                        System.out.println(linha);
                    }
                    System.out.println("------------------");
                    cont++;
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo: " + e.getMessage());
                }
            }
        }
    }
}

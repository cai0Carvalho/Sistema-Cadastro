package lib.cadastro;

import java.util.EmptyStackException;
import java.util.Scanner;

import DAO.TipoPet;
import DAO.TipoSexo;


public class Cadastro {
    public static void cadastrar(){
        Pet pet = new Pet(); //criando o objeto da classe pet

        Quest.Show(); // mostrando o questionario
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
            
            // ENDEREÇO
            System.out.print("endereço (numero): ");
            String numero = scanner.nextLine();
            
            System.out.print("endereco (rua): ");
            String rua = scanner.nextLine();

            System.out.println("endereco (cidade: )");
            String cidade = scanner.nextLine();

            pet.setEndereco(numero, rua, cidade);

            // IDADE
            System.out.print("idade (0 - nao sei): ");
            String idadeStr = scanner.nextLine().replaceAll(",",".");
            double idade = idadeStr.isEmpty() ? -1 : Double.parseDouble(idadeStr);
            if (idade == -1) {
                pet.setIdade("nao informado");
            } else if (idade > 20){
                throw new IllegalArgumentException("idade inválida. O máximo permitido é 20");
            } else if (idade < 1 ){
                pet.setIdade("0." + (int) (idade *10));
            } else {
                pet.setIdade(String.format("%.1f", idade));
            }

            //PESO
            System.out.print("peso (Kg):");
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

        }catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            return;
        }
    }
}

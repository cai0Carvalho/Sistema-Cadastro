package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import model.Pet;

public class CriarArq {
    public static void criarArquivo(Pet pet) {
        LocalDate hj = LocalDate.now();
        LocalTime hr = LocalTime.now();

           try {
            String diretorio = "C:\\Users\\User\\codiguin\\projetos\\SistemaCadastro\\src\\lib\\petsCadastrados";
            String nomeArquivo = String.format("%s/%d%02d%02dT%02d%02d-%s%s.txt",
                    diretorio,
                    hj.getYear(), hj.getMonthValue(), hj.getDayOfMonth(),
                    hr.getHour(), hr.getMinute(),
                pet.getNome(), pet.getSobrenome());

            File arq = new File(nomeArquivo);
            if(arq.getParentFile() != null && !arq.getParentFile().exists()) {
            boolean pastaCriada = arq.getParentFile().mkdirs(); // Cria o diretório se não existir
                if(pastaCriada) {
                    System.out.println("Pasta criada: " + arq.getParentFile().getAbsolutePath());
                }
            }

            if (arq.createNewFile()) {
                System.out.println("Arquivo criado: " + arq.getName());
            } else {
                System.out.println("Arquivo já existe.");
            }

            String nomeLimpo = pet.getNome().replaceAll("[^a-zA-Z]", "");
            String sobrenomeLimpo = pet.getSobrenome().replaceAll("[^a-zA-Z]", "");

            FileWriter writer = new FileWriter(arq);
            writer.write(nomeLimpo + " " + sobrenomeLimpo + "\n");
            writer.write(pet.getTipo() + "\n");
            writer.write(pet.getSexo() + "\n");
            writer.write(pet.getEndereco() + "\n");
            writer.write(pet.getIdade() + " anos " + "\n");
            writer.write(pet.getPeso() + " Kg" + "\n");
            writer.write(pet.getRaca() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }

    public static void sobrescreverArquivoPet(File arquivo, Pet pet){
        try (FileWriter writer = new FileWriter(arquivo, false)) {
        String nomeLimpo = pet.getNome().replaceAll("[^a-zA-Z]", "");
        String sobrenomeLimpo = pet.getSobrenome().replaceAll("[^a-zA-Z]", "");

        writer.write(nomeLimpo + " " + sobrenomeLimpo + "\n");
        writer.write(pet.getTipo() + "\n");
        writer.write(pet.getSexo() + "\n");
        writer.write(pet.getEndereco() + "\n");
        writer.write(pet.getIdade() + " anos\n");
        writer.write(pet.getPeso() + " Kg\n");
        writer.write(pet.getRaca() + "\n");
        } catch (IOException e) {
        System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
    }
    }
}

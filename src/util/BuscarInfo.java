package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import menu.MenuBusca;
import model.FiltroBusca;
import model.Pet;
import repository.PetRepository;

public class BuscarInfo {

    public static Map<Pet, File> mapaPetArquivo = new HashMap<>();

    // Método que inicara a busca com base nos critérios
    public static void inicarBusca(){
        FiltroBusca filtro = MenuBusca.menuCriterios();
        if(filtro != null){
            File pasta = new File("petsCadastrados");
            buscarPets(pasta, filtro.tipo, filtro.resposta, filtro.op);
        }
    }

    // Método para buscar pets com base nos critérios informados
    protected static void buscarPets(File pasta, String tipo, String[] resposta, int op) {
        PetRepository.petsEncontrados.clear();
        mapaPetArquivo.clear();

        if(!pasta.isDirectory()){
            System.out.println("A pasta não é um diretório ou não existe.");
            return;
        }
        File[] arquivos = pasta.listFiles();
        if(arquivos == null || arquivos.length == 0) {
            System.out.println("A pasta não contém arquivos.");
            return;
        }

        for (File arquivo : arquivos) {
            try {
                List<String> linhas = Files.readAllLines(arquivo.toPath());

                String criterio1 = resposta[0] != null ? resposta[0].toLowerCase() : "";
                String criterio2 = resposta[1] != null ? resposta[1].toLowerCase() : "";

                boolean contemTipo = linhas.get(1).equalsIgnoreCase(tipo);

                boolean condicao = switch (op) {
                    case 0 -> true; // Todos os pets
                    case 1 -> contemTipo && linhas.get(0).toLowerCase().contains(criterio1);
                    case 2 -> contemTipo && linhas.get(2).toLowerCase().contains(criterio1);
                    case 3 -> contemTipo && linhas.get(4).toLowerCase().contains(criterio1);
                    case 4 -> contemTipo && linhas.get(5).toLowerCase().contains(criterio1);
                    case 5 -> contemTipo && linhas.get(6).toLowerCase().contains(criterio1);
                    case 6 -> contemTipo && linhas.get(3).toLowerCase().contains(criterio1);
                    case 7 -> contemTipo && linhas.get(0).toLowerCase().contains(criterio1) && linhas.get(4).toLowerCase().contains(criterio2);
                    case 8 -> contemTipo && linhas.get(0).toLowerCase().contains(criterio1) && linhas.get(4).toLowerCase().contains(criterio2);
                    case 9 -> contemTipo && linhas.get(4).toLowerCase().contains(criterio1) && linhas.get(5).toLowerCase().contains(criterio2);
                    default -> false;
                };

                if (condicao) {

                    Pet pet = new Pet();
                    
                    String[] nomeSobrenome = linhas.get(0).split(" ", 2);
                    pet.setNome(nomeSobrenome[0]);
                    if(nomeSobrenome.length> 1){
                        pet.setSobrenome(nomeSobrenome[1]);
                    }else{
                        pet.setSobrenome("Nao informado");
                    }

                    pet.setTipo(Pet.TipoPet.valueOf(linhas.get(1).toLowerCase())); 
                    pet.setSexo(Pet.TipoSexo.valueOf(linhas.get(2).toLowerCase())); 
                    pet.setEndereco(linhas.get(3), "", "");  
                    pet.setIdade(linhas.get(4).replace(" anos", "").trim());  
                    pet.setPeso(linhas.get(5).replace(" nao informado", "").replace(" Kg", "").trim()); 
                    pet.setRaca(linhas.get(6));

                    PetRepository.petsEncontrados.add(pet);
                    mapaPetArquivo.put(pet, arquivo);
                }

            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo " + arquivo.getName() + ": " + e.getMessage());
            }
        }
            if (PetRepository.petsEncontrados.isEmpty()) {
                System.out.println("Nenhum pet encontrado com os critérios informados.");
                System.exit(0);
            } else {
                System.out.println("Pets encontrados:");
                for (int i = 0; i < PetRepository.petsEncontrados.size(); i++) {
                    System.out.println("------------------------------------------------------");
                    System.out.println("Pet " + (i + 1) + ":");
                    System.out.println(PetRepository.petsEncontrados.get(i));
            }
        }
    }
}

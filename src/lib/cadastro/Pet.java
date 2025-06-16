package lib.cadastro;

public class Pet {
    private String nome;
    private String sobrenome;
    private String raca;
    private String endereco;

    private String peso;
    private String idade;
    private TipoPet tipo;
    private TipoSexo sexo; 

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String numero, String rua, String cidade) {
        if (numero == null || numero.trim().isEmpty()) {
            numero = "nao informado";
        }
        this.endereco = numero + ", " + rua + ", " + cidade;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
    public enum TipoPet {
        cachorro, gato
    }
    public enum TipoSexo {
        macho, femea
    }
    public TipoPet getTipo(){
        return tipo;
    }
    public void setTipo(TipoPet tipo){
        this.tipo = tipo;
    }
    public TipoSexo getSexo(){
        return sexo;
    }
    public void setSexo(TipoSexo sexo){
        this.sexo = sexo;
    }
}

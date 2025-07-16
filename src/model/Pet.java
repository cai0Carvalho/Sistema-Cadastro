package model;

import java.util.Objects;

public class Pet {
    private String nome;
    private String sobrenome;
    private String raca;
    private String endereco;

    private String peso;
    private String idade;
    private TipoPet tipo;
    private TipoSexo sexo; 

    @Override
    public String toString() {
        return nome + "\n" +
            sobrenome + "\n" +
            tipo + "\n" +
            sexo + "\n" +
            endereco + "\n" +
            idade + " anos\n" +
            peso + " Kg\n" +
            raca;
    }

    /**
     * Sobrescrevendo os métodos equals() e hashCode() para garantir que
     * dois objetos Pet sejam considerados iguais quando tiverem os mesmos
     * valores em seus atributos principais. Isso é essencial para que o
     * Pet funcione corretamente como chave em coleções como HashMap.
     */    
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass()!= obj.getClass()) return false;
        
        Pet other = (Pet) obj;
        return Objects.equals(nome, other.nome) &&
            Objects.equals(sobrenome, other.sobrenome) &&
            tipo == other.tipo &&
            sexo == other.sexo &&
            Objects.equals(idade, other.idade) &&
            Objects.equals(peso, other.peso) &&
            Objects.equals(raca, other.raca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome, tipo, sexo, idade, peso, raca);
    }

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

    public void setEndereco(String enderecoCompleto) {
        if (enderecoCompleto == null || enderecoCompleto.trim().isEmpty()) {
            this.endereco = "nao informado";
        } else {
            this.endereco = enderecoCompleto;
        }
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

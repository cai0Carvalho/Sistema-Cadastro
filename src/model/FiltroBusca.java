package model;

public class FiltroBusca{
    public String tipo;
    public String[] resposta;
    public int op; 

    public FiltroBusca(String tipo, String[] resposta, int op){
        this.tipo = tipo;
        this.resposta = resposta;
        this.op = op;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String[] getResposta() {
        return resposta;
    }

    public void setResposta(String[] resposta) {
        this.resposta = resposta;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }
}
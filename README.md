
# Sistema CLI para Cadastro e Gerenciamento de Pets

Este projeto é um sistema de cadastro via linha de comando (CLI), para que futuros adotantes possam manipular dados de pets.  
Funcionalidades incluem cadastro, busca, remoção, listagem e filtragem de pets, aplicando conceitos de Orientação a Objetos em Java.

O usuário do programa será capaz de:

    Cadastrar um novo pet
    Buscar dados do pet cadastrado
    Deletar um pet cadastrado
    Listar todos os pets cadastrados
    Listar pets por algum critério (idade, nome, raça)


## 🧠 Tecnologias e Conceitos Aplicados

- Java com paradigma de **Orientação a Objetos (POO)**
- Manipulação de arquivos com **Java IO**
- Tratamento de **exceções** personalizadas
- Boas práticas de código e estrutura modular

---

## 📂 Estrutura do Projeto

```
SistemaCadastro/
├── petsCadastrados/
│   └── [data-formatada]-[NOMEDOPET].txt
├── src/
│   ├── app/
│   ├── menu/
│   ├── model/
│   └── util/
├── formulario.txt
└── README.md
```

---

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/desafioCadastro.git
cd desafioCadastro
```

2. **Compile o projeto (via terminal):**

```bash
javac -d bin src/**/*.java
```

3. **Execute o programa:**

```bash
java -cp bin main.Main
```

> Certifique-se de que o arquivo `formulario.txt` esteja presente na raiz do projeto.

---

## 🧾 Regras e Validações Importantes

- Nome e raça não podem conter números ou caracteres especiais.
- Idade máxima: 20 anos | Peso máximo: 60kg / mínimo: 0.5kg
- Campos não informados devem ser substituídos por `NÃO INFORMADO`.
- Arquivos de pets são salvos com o padrão:

  ```
  yyyyMMddTHHmm-NOMEDOPET.TXT
  ```

- Exemplo de conteúdo do arquivo de pet:

  ```
  1 - Florzinha da Silva
  2 - Gato
  3 - Fêmea
  4 - Rua 2, 456, Seilandia
  5 - 6 anos
  6 - 5kg
  7 - Siames
  ```

---

## 🧑‍💻 Desenvolvido por

- Caio Carvalho - [@cai0Carvalho](https://github.com/cai0Carvalho)
- Desafio criado por [Lucas Carrilho - @karilho](https://github.com/karilho)

---
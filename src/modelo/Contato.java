
package modelo;


public class Contato {

    private String matricula, nome, email, nomeLogin, senhaLogin;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nome) {
        this.nomeLogin = nome;
    }
    
    public String getSenhaLogin() {
        return senhaLogin;
    }

    public void setSenhaLogin(String senha) {
        this.senhaLogin = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

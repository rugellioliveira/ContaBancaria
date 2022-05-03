/**
 * Classe que representa um cliente que possui conta bancária
 * 
 * @author Rugelli Oliveira 
 * @version 1.0
 */

public class Cliente
{
    //atributos da classe
    private String nome;
    private String cpf;
    
    //construtor (para inicializar os atributos com os dados passados como parâmetros)
    public Cliente(String nomeCliente, String cpfCliente)
    {
        nome = nomeCliente;
        cpf = cpfCliente;
        
    }
    
    //métodos 
    
    //método retorna valor do atributo nome
    public String getNome()
    {
        return nome;
    }
    
    //método retorna valor do atributo cpf
    public String getCPF()
    { 
        return cpf;
    }
}

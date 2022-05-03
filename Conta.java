/**
 * Classe que representa uma conta em um banco.
 * 
 * @author Rugelli Oliveira
 * @version 1.0
 */
public class Conta
{
    //atributos da classe
    private double saldo;
    private static int numeroDaUltimaContaCriada = 1000;
    private int numero;
    private double limite;
    private Cliente cliente;
    
    //construtor (para criação de objeto da classe Conta com atributo saldo sendo zero)
    public Conta(double limiteConta, Cliente novoCliente){
        this(limiteConta, 0, novoCliente);
    }
    
    //construtor (para criação de objeto da classe Conta com atributo saldo recebendo valor passado como parâmetro)
    public Conta(double limiteConta,double saldo, Cliente novoCliente){
        cliente = novoCliente;
        limite = limiteConta;
        this.saldo = saldo;
        this.numero=numeroDaUltimaContaCriada++;
    }
    
    //métodos
    
    //método retorna nome do titular da conta
    public String nomeTitular(){
       return cliente.getNome();
    }
    
    //método que retorna CPF do titular da conta
    public String cpfTitular(){
        return cliente.getCPF();
    }
   
    //método para retornar saldo da conta
    public double getSaldo()
    {       
        return saldo;   
    }
    
    //método para retornar atributo número do objeto da classe Conta
    public int getNumeroConta()
    {
        return numero;
    }
    
    //método para realizar saque, ou seja, decrementar o atributo saldo de acordo com o valor passado como parâmetro do método desde que não ultrapasse o valor do atributo limite
    public boolean saque(double valorSaque)
    {
        if(saldo - valorSaque >= (-limite))
        {
          saldo = saldo - valorSaque;
          return true;
        }
        
        else
        { return false;}
    }
    
    //método para realizar depósito, ou seja, incrementa o atributo saldo de acordo com o valor passado como parâmetro do método
    public void deposito(double valorDeposito)
    {
        saldo = saldo + valorDeposito;
    }
    
    //método para realizar saque no atributo saldo do objeto que está chamando o método e o valor sacado será deposito no atributo saldo do objeto da classe Conta passado como parâmetro 
    public boolean transferencia(double valorTransferencia, Conta contaDestino)
    {
       if(saque(valorTransferencia)){
           contaDestino.deposito(valorTransferencia);
           return true;
        }
       
       else{
           return false;
       }
        
    }

}
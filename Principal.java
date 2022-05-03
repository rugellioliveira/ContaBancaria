//importa a classe Scanner que permite utilizar objeto para capturar a entrada de dados do usuário
import java.util.Scanner;

//importa a classe ArrayList 
import java.util.ArrayList;

//importa a classe Comparator que permite criar comparadores para usar em ordenação
import java.util.Comparator;
/**
 * Classe principal, com menu, permite utilizar objetos das classes Conta e Cliente.
 * 
 * @author Rugelli Oliveira 
 * @version 1.0
 */
public class Principal
{
    public static void main(String[] args)
    {
        System.out.println("Conta Bancária");
        
        //Declaração de ArrayList que armazenará objetos contas criados
        ArrayList<Conta> contas = new ArrayList<Conta>();
        
        //Declaração de variável, que significa reservar um espaço na pilha de execução para uma variável que fará referência a um objeto da classe Conta
        Conta conta = null;
        
        //variável que será utilizada para monitorar a quantidade de contas criadas pelo usuário
        int contador = 0;
        
        //Declaração de variável que fará referência a objetos da classe Cliente 
        Cliente cliente = null;
        
        //Cria objeto da classe Scanner
        Scanner entrada = new Scanner (System.in);
        
        int opcao = 0;
        
        while(opcao!=9)
        {
            //variável "opcao" recebe retorno do método mostrarMenu
            opcao = mostrarMenu(entrada);
            
            //de acordo com o valor armazenado no endeço da variável "opcao" o programa verifica qual a condição satisfeita e executa o código dentro do bloco condicional.
            if (opcao == 1){
         
                //bloco condicional que será executado se a lista de contas estiver vazia
                if(contas.isEmpty())
                {
                  System.out.println("Informe os dados solicitados para criar a conta:");
                  System.out.println("Digite seu nome: ");
                  String nomeUsuario = entrada.nextLine();
                
                  System.out.println("Digite seu CPF: ");
                  String cpfUsuario = entrada.nextLine();
                    
                  cliente = new Cliente(nomeUsuario, cpfUsuario);
                  
                  System.out.println("\n");
                  System.out.println("Escolha o tipo de conta: ");
                  System.out.println("Aperte (1) para criar conta com saldo inicial.");
                  System.out.println("Aperte (2) para criar conta com saldo zero.");
                  
                  //variável para armazenar escolha do usuário quanto ao tipo de conta que deseja criar
                  int tipoEscolhido = Integer.parseInt(entrada.nextLine());
                
                   //blocos condicionais que serão executados de acordo com o tipo de conta escolhida pelo usuário
                   if(tipoEscolhido == 1)
                   {
                    System.out.println("Digite limite para a conta: ");
                    double limConta = Double.parseDouble(entrada.nextLine());
                   
                    System.out.println("Digite um saldo inicial para a conta: ");
                    double saldoInicial = Double.parseDouble(entrada.nextLine());
                   
                    conta = new Conta(limConta,saldoInicial,cliente);
                    contas.add(conta);
                    contador++;                  
                   }
                
                    else{
                    System.out.println("Digite limite para a conta: ");
                    double limConta = Double.parseDouble(entrada.nextLine());
                   
                    conta = new Conta(limConta,cliente);
                    contas.add(conta);
                    contador++;
                   }
                
                  System.out.println("Conta criada com sucesso!");
                  System.out.println("O número da conta é: " + conta.getNumeroConta());
                }
                
                //bloco será executado se na criação de conta já existirem uma ou contas cadastradas no sistema
                else{
                  System.out.println("Informe os dados solicitados para criar a conta:");
                  System.out.println("Digite seu nome: ");
                  String nomeUsuario = entrada.nextLine();
                
                  System.out.println("Digite seu CPF: ");
                  String cpfUsuario = entrada.nextLine();
                  int indice = -1;
                  
                  //verifica se o CPF informado já esta associado a alguma conta
                  for(int i=0;i<contas.size();i++)
                  { 
                    if(contas.get(i).cpfTitular().equals(cpfUsuario)){
                        indice = i;
                   }
                  }
                  
                  
                  if(indice != -1)
                  {
                      System.out.println("O CPF informado já está cadastrado em nosso sistema!");
                  }
                  
                  else{
                      
                    cliente = new Cliente(nomeUsuario, cpfUsuario);  
                    
                    System.out.println("\n");
                    System.out.println("Escolha o tipo de conta: ");
                    System.out.println("Aperte (1) para criar conta com saldo inicial.");
                    System.out.println("Aperte (2) para criar conta com saldo zero.");
                  
                    //variável para armazenar escolha do usuário quanto ao tipo de conta que deseja criar
                    int tipoEscolhido = Integer.parseInt(entrada.nextLine());
                
                    //blocos condicionais que serão executados de acordo com o tipo de conta escolhida pelo usuário
                    if(tipoEscolhido == 1)
                    {
                    System.out.println("Digite limite para a conta: ");
                    double limConta = Double.parseDouble(entrada.nextLine());
                   
                    System.out.println("Digite um saldo inicial para a conta: ");
                    double saldoInicial = Double.parseDouble(entrada.nextLine());
                   
                    conta = new Conta(limConta,saldoInicial,cliente);
                    contas.add(conta);
                    contador++;                  
                   }
                
                    else{
                    
                    System.out.println("Digite limite para a conta: ");
                    double limConta = Double.parseDouble(entrada.nextLine());
                   
                    conta = new Conta(limConta,cliente);
                    contas.add(conta);
                    contador++;
                   }
       
                   System.out.println("Conta criada com sucesso!");
                   System.out.println("O número da conta é: " + conta.getNumeroConta()); 
                  }
                 
                }   
           }
                
            else if (opcao == 2){
                
                //bloco condicional será executado se a lista de contas estiver vazia
                if(contas.isEmpty()){
                    System.out.println("Ainda não existem contas em nosso sistema!");
                }
            
                //bloco condicional será executado se já houver pelo menos uma conta criada
                else{
                    System.out.println("Informe o número da conta para consultar o saldo:");
                    int contaSelecionada = Integer.parseInt(entrada.nextLine());
                    int indice = -1;
                    
                    for(int i = 0; i<contas.size();i++){
                        if(contas.get(i).getNumeroConta()==contaSelecionada)
                        {indice=i;}
                    }
                    
                    if(indice!=-1)
                    {
                        System.out.println("Nome do titular da conta: " + contas.get(indice).nomeTitular() + "\nSaldo: R$ " + contas.get(indice).getSaldo() + " ;  Número da conta: " + contas.get(indice).getNumeroConta());
                    }
                    
                    else
                    {
                       System.out.println("O número de conta informado não está associado a nenhuma conta cadastrada em nosso sistema.");
                       
                    }
               }  
           }
           
            else if (opcao == 3){
                
                //bloco condicional será executado se a lista de contas estiver vazia
                if(contas.isEmpty()){
                    System.out.println("Ainda não existem contas em nosso sistema!");
                }
                
                else{
                    
                 System.out.println("Informe o número da conta para realizar o depósito:");
                 int contaSelecionada = Integer.parseInt(entrada.nextLine());
                 int indice =-1;
                
                //Busca pelo atributo numero da lista de contas de acordo com a "chave" informada pelo usuário 
                 for(int i=0; i<contas.size();i++) {
                  //se algum item corresponder a "chave" informada
                   if(contas.get(i).getNumeroConta()==contaSelecionada) {
                    indice = i;
                   }
                    
                  }
                  
                  if(indice!=-1){
                    System.out.println("Informe o valor que deseja depositar:");
                    double valor = Double.parseDouble(entrada.nextLine());
                    contas.get(indice).deposito(valor);
                    System.out.println("O depósito foi realizado com sucesso!");
                  }
                  
                  //se nenhum item corresponder a "chave" informada
                  else
                  {
                    System.out.println("O número de conta informado não está associado a nenhuma conta cadastrada em nosso sistema."); 
                  }
               }
            }
             
            else if (opcao == 4){
                
                //bloco condicional será executado se a lista de contas estiver vazia
                if(contas.isEmpty()){
                    System.out.println("Ainda não existem contas em nosso sistema!");
                }
                
                else{
                    
                 System.out.println("Informe o número da conta para realizar o saque:");
                 int contaSelecionada = Integer.parseInt(entrada.nextLine());
                 int indice =-1;
                
                 //Busca pelo atributo numero da lista de contas de acordo com a "chave" informada pelo usuário 
                 for(int i=0; i<contas.size();i++) {
                  //se algum item corresponder a "chave" informada
                   if(contas.get(i).getNumeroConta()==contaSelecionada) {
                    indice = i;
                   }
                    
                  }
                  
                  if(indice!=-1){
                    System.out.println("Informe o valor que deseja sacar:");
                    double quantia = Double.parseDouble(entrada.nextLine());
                    
                    //verifica retorno do método saque para saber se a operação foi realizada no atributo saldo do objeto da classe Conta
                       if(contas.get(indice).saque(quantia)){
                        System.out.println("Saque foi realizado com sucesso!");
                       }
                       else{
                        System.out.println("O saque não pode ser realizado, pois o limite da conta foi atingido.");
                        System.out.println("Saldo insuficiente!");
                       }
                  }
                  
                  //se nenhum item corresponder a "chave" informada
                  else
                  {
                    System.out.println("O número de conta informado não está associado a nenhuma conta cadastrada em nosso sistema."); 
                  }
                
                }
            }
                
            
            else if(opcao == 5){
              
                if(contador==0){
                    System.out.println("Ainda não existem contas em nosso sistema!");
                }
                
                else if(contador==1){
                    System.out.println("Não é possível realizar operações de transferência, pois há apenas uma conta cadastrada no sistema.");
                }
                
                else{
                   System.out.println("Informe o número da conta de origem:");
                   int numContaOrigem = Integer.parseInt(entrada.nextLine());
                   int indice = -1;
                   int indice2 = -1;
                   Double valorTransferencia;
                   
                   //Busca pelo atributo numero da lista de contas de acordo com a "chave" informada pelo usuário 
                   for(int i=0; i<contas.size();i++) {
                   //se algum item corresponder a "chave" informada
                     if(contas.get(i).getNumeroConta()==numContaOrigem) {
                       indice = i;
                     }
                    
                 }
                 
                 if(indice!=-1){
                    System.out.println("Informe o valor que deseja transferir:");
                    valorTransferencia = Double.parseDouble(entrada.nextLine());
                
                    System.out.println("Informe o número da conta de destino: (Ele deve ser diferente do número da conta de origem!)");
                    int numContaDestino = Integer.parseInt(entrada.nextLine());
                     
                    for(int i=0; i<contas.size();i++) {
                   //se algum item corresponder a "chave" informada
                     if(contas.get(i).getNumeroConta()==numContaDestino && numContaDestino!=numContaOrigem) {
                       indice2 = i;
                     }
                    
                  }
                  
                   if(indice2!=-1){
                     
                     if(contas.get(indice).transferencia(valorTransferencia, contas.get(indice2)))
                           {
                               System.out.println("Transferência realizada com sucesso!");
                           }
                           else{
                              System.out.println("Transferência não foi concluida.Saldo insuficiente!");
                           }
                   }
                   
                   else{
                   System.out.println("O número de conta informado não está associado a nenhuma conta cadastrada em nosso sistema.");
                   }
                  
                 }
                  
                 else{
                   System.out.println("O número de conta informado não está associado a nenhuma conta cadastrada em nosso sistema.");
                 }
              }
            }
            
            else if (opcao == 6){
                
                if(contador==0)
                { System.out.println("No momento não há nenhuma conta cadastrada no sistema!");}
                
                else{
                    
                    System.out.println("\n");
                    System.out.println("Escolha o tipo de ordenação na qual deseja listar as contas: ");
                    System.out.println("Aperte (1) para ordenar as contas por nome do cliente.");
                    System.out.println("Aperte (2) para ordenar as contas por número da conta.");
                    
                    //variável para armazenar escolha do usuário quanto ao tipo de ordenação das contas
                    int tipoEscolhido = Integer.parseInt(entrada.nextLine());
                    
                    if(tipoEscolhido==1){
                        //Cria um objeto do tipo Comparator que indica como um elemento da lista deve ser comparado com os outros.
                        Comparator<Conta> comparador = new Comparator<>() {
                         @Override
                        public int compare(Conta conta1, Conta conta2) {
                         return conta1.nomeTitular().compareTo(conta2.nomeTitular());
                         }
                        };
                        //O método sort ordena os elementos presentes no ArrayList conta de acordo com as definições do comparador passado por parâmetro
                        contas.sort(comparador);
                        System.out.println("Numero da conta:   /    Nome do cliente:");
                        for (Conta a : contas) {
                                   System.out.println(a.getNumeroConta() + "     -     " + a.nomeTitular());
                        }
                        
                    }
                    else{
                        Comparator<Conta> comparador = new Comparator<>() {
                           @Override
                           public int compare(Conta conta1, Conta conta2) {
                           return conta1.getNumeroConta() - conta2.getNumeroConta();
                            }
                        };
                        
                        contas.sort(comparador);
                        
                        System.out.println("Numero da conta:   /    Nome do cliente:");
                        for (Conta a : contas) {
                                   System.out.println(a.getNumeroConta() + "     -     " + a.nomeTitular());
                        }
                        
                    }
                }
           }
           
           else if (opcao == 7){
               
               if(contas.isEmpty())
                { System.out.println("No momento não há nenhuma conta cadastrada no sistema!");}
                
               else{
                   System.out.println("Informe o número da conta que deseja remover:");
                   int contaSelecionada = Integer.parseInt(entrada.nextLine());
                   int indice = -1;
                   
                   for(int i=0; i<contas.size();i++) {
                   //se algum item corresponder a "chave" informada
                     if(contas.get(i).getNumeroConta()==contaSelecionada) {
                       indice = i;
                     }
                    
                  }
                   
                  if(indice!=-1)
                  {
                      if(contas.get(indice).getSaldo()>0){
                      System.out.println("Não é possível cancelar contas com saldo disponível!");
                      }
                      else if(contas.get(indice).getSaldo()<0){
                      System.out.println("Não é possível cancelar contas em débito!");
                      }
                      else{
                      contas.remove(indice);
                      System.out.println("A conta foi removida com sucesso!");
                      }
                  }
                  
                  else{
                      System.out.println("O número de conta informado não está associado a nenhuma conta cadastrada em nosso sistema.");
                  }
               }
            }
            
           else if (opcao == 8){
               System.out.println("Digite uma palavra para ser o parâmetro do filtro:");
               
               //O método string toLowerCase() toma a string e converte todos os caracteres para minusculo. 
               String palavra = entrada.nextLine().toLowerCase() ;
               
               //ArrayList que armazenará as posições, ou seja, os indices dos elementos que contém a "chave" informada pelo usuario
               ArrayList<Integer> posicoesFiltradas = new ArrayList<>();
               
               for( int i=0; i<contas.size();i++){
                   if (contas.get(i).nomeTitular().toLowerCase().contains(palavra)) {
                       posicoesFiltradas.add(i);   
                   }
               }
               
               if(!posicoesFiltradas.isEmpty()){
                   
                   for( int j =0; j<posicoesFiltradas.size();j++){
                       System.out.println(contas.get(posicoesFiltradas.get(j)).getNumeroConta() + " - " + contas.get(posicoesFiltradas.get(j)).nomeTitular());
                   }
               }
               
               else{
                   System.out.println("Palavra não encontrada!");
               }
               
            }
           
           else if (opcao == 9){
                System.out.println("Saindo...");
                System.out.println("Obrigado por utilizar nosso sistema!");
            }
            
           else{
                System.out.println("Opção: " + opcao + " inválida");
            }
            
           if(opcao!=9)
           {
              esperarEnter(entrada);
            }
        } 
        
    }
    
    //método para apresentar o menu ao usuário e retornar a opção escolhida por ele
    public static int mostrarMenu(Scanner entrada)
    {
         System.out.println("\n");
         System.out.println("**********MENU**********");
         System.out.println("1) Criar conta");
         System.out.println("2) Consultar saldo");
         System.out.println("3) Depositar");
         System.out.println("4) Sacar");
         System.out.println("5) Transferir");
         System.out.println("6) Listar as contas já criadas");
         System.out.println("7) Excluir conta");
         System.out.println("8) Filtrar as contas de acordo com o nome do cliente");
         System.out.println("9) Sair");
         
         int opcaoUsuario = Integer.parseInt(entrada.nextLine());
         return opcaoUsuario;
    }
        
    //método sem retorno que mantém o sistema estático até que o usuário precione a tecla informada
    public static void esperarEnter(Scanner entrada)
    {
        System.out.println("");
        System.out.println("Digite ENTER para continuar...");
        entrada.nextLine();
     }
     
}
package proj.luisfl04.contaBancaria.frontend;
// Importações nescessárias:
import proj.luisfl04.contaBancaria.backend.ContaBancaria;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.Locale;
import java.lang.Thread;



public class InterfaceBanco {
    
    // Método que limpa o console do terminal:
    public static void limpar_terminal(){
        // Implementação que tenta limpar o contéudo do terminal, sempre que o loop está execultando:
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // Método que para a execulção do programa em dois segundos:
    public static void pausar_dois_segundos(){
        // Tentativa de parar a execulção por 2 segundos:
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException exception){
            exception.getMessage();
        }
    }


    public static void main(String[] args) {

        // fazendo instanciação da classe 'Scanner', para pegar os dados do usuário:
        Scanner scanf = new Scanner(System.in).useLocale(Locale.US);

        // Pedindo as informações gerais do cliente:
        // Pedindo nome:
        System.out.println("Ola cliente, insira primeiramente, o seu primeiro nome abaixo(Somente o primeiro nome):");
        ContaBancaria.nome_cliente = scanf.next();

        // Pedindo numero de conta:
        System.out.println("\nAgora, crie um número para sua conta(ele precisa ter 4 digitos)\n*Somente números*\nDigite abaixo:");
        ContaBancaria.numero_da_conta = scanf.nextInt();
        
        // Fazendo tratamento de erro caso o usuário digite um valor maior do que 4 digitos:
        // Fiz essa verificação tranformando o numero em uma string e contando os caracters.
        String string_numero_da_conta = Integer.toString(ContaBancaria.numero_da_conta);
        int quantidade_de_caracteres_numero_da_conta = string_numero_da_conta.length();

        // Enquanto o tamanho do numero for diferente de 4, é pedido novamente.
        while(quantidade_de_caracteres_numero_da_conta != 4){
            // Exibindo mensagem de erro e pedindo novamente.
            System.out.println("\nA quantidade de número que você inseriu é inválida! Insira novamente abaixo:");
            ContaBancaria.numero_da_conta = scanf.nextInt();
            
            // É preciso tranformar o numero em string e verificar o tamanho novamente para a lógica ser válida.
            String numero_da_conta_no_wilhe = Integer.toString(ContaBancaria.numero_da_conta);
            int quantidade_de_caracteres_numero_da_conta_no_wilhe = numero_da_conta_no_wilhe.length();
            quantidade_de_caracteres_numero_da_conta = quantidade_de_caracteres_numero_da_conta_no_wilhe;
        }

        // pedindo a agencia da conta:
        System.out.println("\nCrie agora uma agencia para você(Com 3 digitos)\n*Somente números*\nDigite abaixo:");
        ContaBancaria.agencia_da_conta = scanf.nextInt();

        // fazendo tratamento de erro em relação a quantidade de caracteres:
        String string_agencia_da_conta = Integer.toString(ContaBancaria.agencia_da_conta);
        int quantidade_de_caracteres_agencia_da_conta = string_agencia_da_conta.length();
        
        // Enquanto não for válido, peço novamente:
        while(quantidade_de_caracteres_agencia_da_conta != 3) {
            // Exibindo mensagem de erro:
            System.out.println("\nA quantidade de numeros que você inseriu é inválida! Insira novamente abaixo: ");
            ContaBancaria.agencia_da_conta = scanf.nextInt();

            // Fazendo a mesma lógica para conseguir validar os dados:
            String string_agencia_da_conta_no_while = Integer.toString(ContaBancaria.agencia_da_conta);
            int quantidade_de_caracteres_agencia_da_conta_no_while = string_agencia_da_conta_no_while.length();
            quantidade_de_caracteres_agencia_da_conta = quantidade_de_caracteres_agencia_da_conta_no_while;
        }

        // Pedindo o digito verificador da agencia da conta:
        System.out.println("\nCerto, para completar, insira o dígito verificador da sua agência abaixo(de 0 á 9)\n*Somente numeros*\nDigite abaixo:");
        ContaBancaria.digito_verificador_da_agencia = scanf.nextByte();

        // Verificando se o número digitado é maior que 10 ou menor que 0, para tratar erro:
        while(ContaBancaria.digito_verificador_da_agencia < 0 || ContaBancaria.digito_verificador_da_agencia >= 10){
            // Exibindo mensagem de erro:
            System.out.println("\nVoce digitou um valor inválido! Digite novamente abaixo:");
            ContaBancaria.digito_verificador_da_agencia = scanf.nextByte();
        }

        // Concatenando o numero da agencia com o digite verificador e atribuindo o valor a uma variável:
        
        // Primeiramente, convertendo o digito verificador e o numero da agência em string:
        final String digito_verificador = Byte.toString(ContaBancaria.digito_verificador_da_agencia);   
        final String numero_da_agencia = Integer.toString(ContaBancaria.agencia_da_conta);

        // Concantenando e armazenando:
        final String numero_da_agencia_com_digito =  numero_da_agencia.concat("-").concat(digito_verificador);


        // Criação de menu interativo. Que sempre irá mostrar as informações e as opções de métodos que o usuário pode escolher:

        // Implementando mensagem de boas vindas. Que irá ser mostrada por um tempo determinada, antes que o console seja limpo.
        System.out.println("Olá " + ContaBancaria.nome_cliente + ", seja bem vindo!\n...");
        
        // Pausando a execulção em dois segundos:
        pausar_dois_segundos();
        
        // Criando variável que irá determinar o fluxo do programa:
        int escolha_do_usuario = 100; // Inicializei com este valor para que o programa entre o loop 'while'.

        // Criando loop de execução:
        while(escolha_do_usuario != 0){

            // Limpando terminal:
            limpar_terminal();

            // Implementando impressão das informações do usuário junto com suas informações bancárias:
            System.out.println("--------------------------------------------\nNome -> " + ContaBancaria.nome_cliente + "\nNúmero da conta -> " + ContaBancaria.numero_da_conta + "\nAgência -> " + numero_da_agencia_com_digito);
            // Infos relacionadas ao saldo do usuário:
            System.out.println("\n--------------------------------------------\nSaldo disponível -> R$" + ContaBancaria.saldo_atual + "\nLimite de empréstimo -> R$" + ContaBancaria.valor_de_emprestimo_disponivel + "\nLimite de crédito -> R$" + ContaBancaria.valor_de_crédito_disponivel);
            // Infos relacionadas a valores de faturas de crédito e de empréstimo:
            System.out.println("\n--------------------------------------------\nFatura de crédito atual -> R$" + ContaBancaria.valor_atual_da_fatura + "\nValores de empréstimos a pagar -> R$" + ContaBancaria.valor_de_emprestimo_para_ser_pago);
            
            // Imprimindo escolhas que o usuário pode escolher e pedindo que ele entre com uma escolha:
            System.out.println("\n--------------------------------------------\nEscolha entre umas das opções abaixo(1 á 7):\n(1) - Fazer deposito\n(2) - Realizar saque\n(3) - Tranferenia PIX\n(4) - Pedir empréstimo ao banco\n(5) - Usar crédito disponível\n(6) - Pagar fatura de crédito\n(7) - Pagar valor de empréstimo feito\n(0) - Para fechar o sistema");

            // Local onde usuário entra com uma escolha:
           
            // Pedindo escolha
            System.out.println("\nDigite a opção escolhida.\n*Somente números*\nDigite abaixo:");
            escolha_do_usuario = scanf.nextInt();

            // Fanzendo tratamento de erro caso o usuário digite um valor inválido:
            while(escolha_do_usuario < 0 || escolha_do_usuario > 7){
                // Pendindo valor:
                System.out.println("\nVocê digitou um valor inválido de escolha, digite novamente abaixo:");
                escolha_do_usuario = scanf.nextInt();
            }

            // Implementado uma estrutura 'switch' que chama as funções conforme o usuário escolhe:
            switch (escolha_do_usuario) {
                // Em todos os casos terá uma implementação de limpar o console, para fins de deixar a interação mais limpa.
                
                // Função que encerra o programa:
                case 0:
                    escolha_do_usuario = 0;
                    break;

                // Função de depósito:
                case 1:

                    // Limpando terminal:
                    limpar_terminal();
                    
                    // Printando mensagem, criando variável que armazena e passa o valor como parâmetro, e pedindo valor de depósito:
                    System.out.println("*Depósito*\n--------------------------------------------\nInsira o valor do depósito abaixo:"); 
                    double valor_de_deposito = scanf.nextDouble();

                    // Fazendo tratamento de erro caso o usuário digite um valor negativo ou um valor nulo:
                    while(valor_de_deposito <= 0){
                        System.out.println("\nValores negativos ou nulos não são válido para depósito! Digite um valor válido abaixo:");
                        valor_de_deposito = scanf.nextDouble();
                    }

                    // Chamando o método para adicionar o valor ao saldo:
                    ContaBancaria.depositar_valor(valor_de_deposito);

                    // Printando mensagem temporária de validação de depósito:
                    System.out.println("\nDepósito de R$" + valor_de_deposito + " feito com suscesso!\n...");

                    // Pausando execulção em dois segundos:
                    pausar_dois_segundos();

                    break;
                
                //Função de saque:
                case 2:
                       
                    // Implementação de 'limpeza':
                    limpar_terminal();

                    // Pendindo valor do saque ao usuário:                    
                    System.out.println("\n*Saque*\n--------------------------------------------\nSeu saldo -> R$" + ContaBancaria.saldo_atual + "\n* Digite '0' para encerrar transação *\nInsira o valor de saque escolhido abaixo:"); 
                    double valor_do_saque = scanf.nextDouble();
                    
                    // Primeiramente, verificando se o usuário digitou um valor negativo ou nulo:
                    while(valor_do_saque < 0){
                        System.out.println("\nSeu saldo -> R$" + ContaBancaria.saldo_atual +"\nValores negativos não são válidos para saque! Digite um valor válido abaixo:");
                        valor_do_saque = scanf.nextDouble();
                    }

                    // Fazendo verificação de caso o usuário desejar um valor maior do que o que ele tem na conta:
                    while(valor_do_saque > ContaBancaria.saldo_atual || valor_do_saque < 0){
                        System.out.println("\nSeu saldo -> R$" + ContaBancaria.saldo_atual + "\n* Digite '0' para encerrar a transação *\nVoce esta tentando sacar um valor maior do que o disponível na sua conta, ou está tentando sacar um valor negativo.\nDigite um valor de saque válido abaixo:");
                        valor_do_saque = scanf.nextDouble();
                    }

                    // Se o valor for válido, o saque é feito:
                    ContaBancaria.sacar_valor(valor_do_saque);

                    // Printando mensagem validando o saque:
                    System.out.println("\nSaque de R$" + valor_do_saque + " feito com suscesso!\n...");

                    // Pausando execulção em dois segundos:
                    pausar_dois_segundos();

                    break;

                // Função de tranferencia PIX:
                // Na implementação desta função, é pedido o nome de quem a tranferência será feita, e o seu cpf como 'chave' pix(somente cpf´s serão válidos):
                case 3:

                    // Implementação de limpeza:
                    limpar_terminal();
                    
                    // Pedindo nome e cpf do remetente:
                    System.out.println("\n*Tranferência PIX*\n--------------------------------------------\nPrimeiramente, digite o nome da pessoa a quem você quer destinar o PIX(somente o primeiro nome)\nDigite abaixo:");
                    String nome_detinatario = scanf.next();
                    
                    // Pedindo cpf:
                    System.out.println("\nAgora, insira o cpf de " + nome_detinatario + ".\nSomente cpf é aceito, ou seja, somente um valor com 10 dígitos é aceito.\nDigite abaixo:");
                    long cpf_do_destinatario = scanf.nextLong();

                    // Tranformando o valor em uma string para verificar a quantidade de caracteres do cpf:
                    String string_cpf_do_destinatario = Long.toString(cpf_do_destinatario);
                    int quantidade_de_caracteres_do_cpf = string_cpf_do_destinatario.length();

                    // fazendo verificação do tamanho de caracteres do cpf escolhido:
                    while(quantidade_de_caracteres_do_cpf != 10){
                        
                        System.out.println("\nVocê digitou um valor inválido de cpf! Informe um valor válido.\nDigite novamente abaixo:");
                        long cpf_do_destinatario_no_wilhe = scanf.nextLong();

                        // É nescessário obter o tamanho do cpf inserido novamente:
                        String string_cpf_do_destinatario_no_while = Long.toString(cpf_do_destinatario_no_wilhe);
                        int quantidade_de_caracteres_do_cpf_no_while = string_cpf_do_destinatario_no_while.length();
                        quantidade_de_caracteres_do_cpf = quantidade_de_caracteres_do_cpf_no_while;
                        cpf_do_destinatario = cpf_do_destinatario_no_wilhe;
                    }

                    // Pedindo o valor da tranferência para o usuário:
                    
                    // Limpando a tela,passando as infos do destinatário da tranferência, e pedindo o valor da transferência:
                    limpar_terminal();

                    System.out.println("Destinatário -> " + nome_detinatario + "\nChave -> " + cpf_do_destinatario + "\nInforme o valor da transferência abaixo:");
                    double valor_da_transferencia = scanf.nextDouble();
                    
                    // Fazendo tratamento de erro caso o usuário digite um valor negativo:
                    while(valor_da_transferencia < 0){
                        System.out.println("\nVocê tentou transferir um valor negativo! Insira um valor válido abaixo:");
                        valor_da_transferencia = scanf.nextDouble();
                    }

                    // Se os dados estão certos, a transferência é validada:
                    ContaBancaria.fazer_transferencia(valor_da_transferencia);

                    // Imprimindo mensagem de validação:
                    System.out.println("\nTranferência PIX de R$" + valor_da_transferencia + " para " + nome_detinatario + " validada!\n...");

                    // Pausando execulção em dois segundos:
                    pausar_dois_segundos();

                    break;

                default:
                    break;
            }





            


        }






        

    




        



    }



}

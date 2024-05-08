package proj.luisfl04.contaBancaria.frontend;
// Importações nescessárias:
import proj.luisfl04.contaBancaria.backend.ContaBancaria;
import java.util.Scanner;
import java.util.Locale;
import java.lang.Thread;



public class InterfaceBanco {
    
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
        // Tentativa de parar a execulção por 2 segundos:
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException exception){
            exception.getMessage();
        }

        // Criando variável que irá determinar o fluxo do programa:
        int escolha_do_usuario = 100; // Inicializei com este valor para que o programa entre o loop 'while'.

        // Criando loop de execução:
        while(escolha_do_usuario != 0){

            // Implementação que tenta limpar o contéudo do terminal, sempre que o loop está execultando:
            try{
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            catch(Exception e){
                e.printStackTrace();
            }

            // Implementando impressão das informações do usuário junto com suas informações bancárias:
            System.out.println("--------------------------------------------\nNome -> " + ContaBancaria.nome_cliente + "\nNúmero da conta -> " + ContaBancaria.numero_da_conta + "\nAgência -> " + numero_da_agencia_com_digito);
            // Infos relacionadas ao saldo do usuário:
            System.out.println("\n--------------------------------------------\nSaldo disponível -> R$" + ContaBancaria.saldo_atual + "\nLimite de empréstimo -> R$" + ContaBancaria.valor_de_emprestimo_disponivel + "\nLimite de crédito -> R$" + ContaBancaria.valor_de_crédito_disponivel);
            // Infos relacionadas a valores de faturas de crédito e de empréstimo:
            System.out.println("\n--------------------------------------------\nFatura de crédito atual -> R$" + ContaBancaria.valor_atual_da_fatura + "\nValores de empréstimos a pagar -> R$" + ContaBancaria.valor_de_emprestimo_para_ser_pago);

            

            


        }






        

    




        



    }


}

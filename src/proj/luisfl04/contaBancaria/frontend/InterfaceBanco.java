package proj.luisfl04.contaBancaria.frontend;
// Importações nescessárias:
import proj.luisfl04.contaBancaria.backend.ContaBancaria;
import java.util.Scanner;
import java.util.Locale;


public class InterfaceBanco {
    
    public static void main(String[] args) {

        // fazendo instanciação da classe 'Scanner', para pegar os dados do usuário:
        Scanner scanf = new Scanner(System.in).useLocale(Locale.US);

        // Pedindo as informações gerais do cliente:
        // Pedindo nome:
        System.out.println("Ola cliente, insira primeiramente, o seu primeiro nome abaixo:");
        ContaBancaria.nome_cliente = scanf.next();

        // Pedindo numero de conta:
        System.out.println("\nAgora, crie um número para sua conta(ele precisa ter 4 digitos):");
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
        System.out.println("\nCrie agora uma agencia para você(Com 3 digitos):");
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

        



    }


}

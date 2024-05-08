package proj.luisfl04.contaBancaria.backend;


// Classe principal:
public class ContaBancaria {
    // Criando atributos globais:
    // Foram definidos como 'static' para facilitar o uso neste escopo.
    public static String nome_cliente;
    public static int numero_da_conta;
    public static int agencia_da_conta;
    public static byte digito_verificador_da_agencia;
    public static double saldo_atual = 0;
    public static double valor_de_emprestimo_disponivel = 0;
    public static double valor_de_credito_disponivel = 0;
    public static double valor_atual_da_fatura = 0;
    public static double valor_de_emprestimo_para_ser_pago = 0;

    // Criando métodos do sistema:
    
    // Método de depósito de valor escolhido:
    // Foi adicionado uma lógica que com base no valor de depósito escolhido pelo usuário, os valores de empréstimo e crédito disponíveis aumentam.
    public static double depositar_valor(double valor_de_deposito){
        // Atribuindo valor de depósito ao saldo:
        saldo_atual = saldo_atual + valor_de_deposito;

        // Lógica para crecimento de valores de crédito e empréstimo:
        if(valor_de_deposito <= 10){
            valor_de_credito_disponivel = valor_de_credito_disponivel + 2.50;
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + 2.00;
        }
        else if(valor_de_deposito > 10 && valor_de_deposito <= 100){
            valor_de_credito_disponivel = valor_de_credito_disponivel + 10;
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + 9.25;
        }
        else if(valor_de_deposito > 100 && valor_de_deposito <= 1000){
            valor_de_credito_disponivel = valor_de_credito_disponivel + 100;
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + 95.50;
        }
        else if(valor_de_deposito > 1000 && valor_de_deposito <= 10000){
            valor_de_credito_disponivel = valor_de_credito_disponivel + 1000;
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + 999.40;
        }
        else if(valor_de_deposito > 10000 && valor_de_deposito <= 100000){
            valor_de_credito_disponivel = valor_de_credito_disponivel + 10000;
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + 9999.45;
        }
        else{
            valor_de_credito_disponivel = valor_de_credito_disponivel + 100000;
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + 99999.56;
        }

        // Retornando saldo:
        return saldo_atual;
    }

    // Método de saque de valor escolhido:
    public static double sacar_valor(double valor_de_saque){
        saldo_atual = saldo_atual - valor_de_saque;
        return saldo_atual;
    }

    // Método básico de fazer tranferencia:
    public static double fazer_transferencia(double valor_de_tranferencia){
        saldo_atual = saldo_atual - valor_de_tranferencia;
        return saldo_atual;
    }

    // Método para realizar empréstimo com base no valor de empréstimo disponível:
    public static double fazer_emprestimo(double valor_de_emprestimo){
                
        // Atribuindo o valor a saldo:
        saldo_atual = saldo_atual + valor_de_emprestimo;

        // Diminuindo valor disponível para empréstimo:
        valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel - valor_de_emprestimo;

        // Adicionando o valor escolhido ao valor que precisa ser pago, ou seja, a 'fatura' de empréstimo.:
        valor_de_emprestimo_para_ser_pago = valor_de_emprestimo_para_ser_pago + valor_de_emprestimo;

        return saldo_atual;
    }

    // Método de uso de crédito disponivel:
    public static double usar_credito(double valor_de_uso_do_credito){
                  
        // Decrementando o valor de crédito disponível;
        valor_de_credito_disponivel = valor_de_credito_disponivel - valor_de_uso_do_credito; 
            
        // Adicionando valor na fatura:
        valor_atual_da_fatura = valor_atual_da_fatura + valor_de_uso_do_credito;

        // Atribuindo valor inserido na conta:
        saldo_atual = saldo_atual + valor_de_uso_do_credito;

        // Retornando o saldo atual:
        return saldo_atual;
    }

    // Método para pagar fatura de crédito:
    // Neste caso, o usuário so irá poder pagar a fatura integral:
    public static double pagar_fatura(double valor_da_fatura_inserido){
        // Verificando se o usuário tem saldo disponível para fazer o pagamento:
        if(valor_da_fatura_inserido > saldo_atual){
            System.out.println("\nVocê não tem saldo suficiente para fazer o pagamento!");
        }
        else{
            // Se tem saldo, o valor é descontado do saldo e a fatura é zerada.
            saldo_atual = saldo_atual - valor_da_fatura_inserido;
            valor_atual_da_fatura = 0;

            // Ao ser paga, o valor do limite é incorporado novamente:
            valor_de_credito_disponivel = valor_de_credito_disponivel + valor_da_fatura_inserido;
            
            // Printando mensagem de suscesso:
            System.out.println("\nFatura paga com suscesso!");
        }
    
        return valor_atual_da_fatura;
    }

    // Método que realiza o 'pagamento' integral do valor de empréstimo que o usuário precisa pagar:
    public static double pagar_emprestimo(double valor_de_emprestimo_inserido){
        
        // Verificando se o valor do empréstimo é maior que o saldo:
        if(valor_de_emprestimo_inserido > saldo_atual){
            // printando mensagem:
            System.out.println("\nO seu saldo não é suficiente para realizar o pagamento integral do empréstimo!");
        }
        else{
            
            // Printando mensagem de suscesso:
            System.out.println("\nO pagamento integral da conta de emprestimo foi feito com suscesso!");

            // decrementando o saldo atual:
            saldo_atual = saldo_atual - valor_de_emprestimo_inserido;

            // zerando a conta de empréstimo:
            valor_de_emprestimo_para_ser_pago = 0;

            // Reincorporando o valor da conta ao limite de empréstimo:
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + valor_de_emprestimo_inserido;
        }

        return valor_de_emprestimo_para_ser_pago;
    }

}

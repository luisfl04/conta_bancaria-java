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
    public static double valor_de_crédito_disponivel = 0;
    public static double valor_atual_da_fatura = 0;
    public static double valor_de_emprestimo_para_ser_pago = 0;

    // Criando métodos do sistema:
    
    // Método de depósito de valor escolhido:
    // Foi adicionado uma lógica que com base no valor de depósito escolhido pelo usuário, os valores de empréstimo e crédito disponíveis aumenta.
    public static double depositar_valor(double valor_de_deposito){
        // Atribuindo valor de depósito ao saldo:
        saldo_atual = saldo_atual + valor_de_deposito;

        // Lógica para crecimento de valores de crédito e empréstimo:
        if(valor_de_deposito <= 10){
            valor_de_crédito_disponivel = valor_de_crédito_disponivel + 2.50;
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + 2.00;
        }
        else if(valor_de_deposito > 10 && valor_de_deposito <= 100){
            valor_de_crédito_disponivel = valor_de_crédito_disponivel + 10;
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + 9.25;
        }
        else if(valor_de_deposito > 100 && valor_de_deposito <= 1000){
            valor_de_crédito_disponivel = valor_de_crédito_disponivel + 100;
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + 95.50;
        }
        else if(valor_de_deposito > 1000 && valor_de_deposito <= 10000){
            valor_de_crédito_disponivel = valor_de_crédito_disponivel + 1000;
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + 999.40;
        }
        else if(valor_de_deposito > 10000 && valor_de_deposito <= 100000){
            valor_de_crédito_disponivel = valor_de_crédito_disponivel + 10000;
            valor_de_emprestimo_disponivel = valor_de_emprestimo_disponivel + 9999.45;
        }
        else{
            valor_de_crédito_disponivel = valor_de_crédito_disponivel + 100000;
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
        // Verificando se tem crédito disponível:
        if(valor_de_uso_do_credito <= valor_de_crédito_disponivel){
            valor_de_crédito_disponivel = valor_de_crédito_disponivel - valor_de_uso_do_credito; 
            
            // Adicionando valor na fatura:
            valor_atual_da_fatura = valor_atual_da_fatura + valor_de_uso_do_credito;

            // Atribuindo valor inserido na conta:
            saldo_atual = saldo_atual + valor_de_uso_do_credito;
        }
        else{
            // Se não tem crédito, mensagem de erro exibida:
            System.out.println("\nO valor escolhido para crédito não esta disponível neste momento!");
        }

        // Retornando o saldo atual:
        return saldo_atual;
    }

    // Método para pagar fatura de crédito:
    // Neste caso, o usuário so irá poder pagar a fatura integral:
    public static double pagar_fatura(double valor_da_fatura_inserido){
        // Verificando se o valor é igual:
        if(valor_da_fatura_inserido == valor_atual_da_fatura){
            valor_atual_da_fatura = 0;
        }
        else{
            // Se não for o valor integral, é exibida mensagem de erro.
            System.out.println("\nSó é possível pagar o valor integralmente. Insira o valor -> " + valor_atual_da_fatura + "R$, para que o pagamento seja realizado com suscesso.");
        }
    
        return valor_atual_da_fatura;
    }

    // Método que realiza o 'pagamento' integral do valor de empréstimo que o usuário precisa pagar:
    public static double pagar_emprestimo(double valor_de_emprestimo_inserido){
        // Só irá ser aceito o valor integral do empréstimo(s) feito(s):
        if(valor_de_emprestimo_inserido == valor_de_emprestimo_para_ser_pago){
            valor_de_emprestimo_para_ser_pago = 0;
        }
        else{
            // Exibindo mensagem de erro para usuário:
            System.out.println("\nSó é possivel pagar o valor integral! O valor de pagamento precisa ser -> R$" + valor_de_emprestimo_para_ser_pago + ", para que o pagamento seja aceito.");
        }

        return valor_de_emprestimo_para_ser_pago;
    }



}

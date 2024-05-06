package proj.luisfl04.contaBancaria.backend;
// Importações nescessárias:


// Classe principal:
public class ContaBancaria {
    // Criando atributos globais:
    // Foram definidos como 'static' para facilitar o uso neste escopo.
    static String nome_cliente;
    static int numero_da_conta;
    static String agencia_da_conta;
    static double saldo_atual = 0;
    static double valor_de_emprestimo_disponivel = 0;
    static double valor_de_crédito_disponivel = 0;
    static double valor_atual_da_fatura = 0;
    static double valor_de_emprestimo_para_ser_pago = 0;

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
    




}

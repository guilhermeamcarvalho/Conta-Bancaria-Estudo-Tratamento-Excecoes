import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Map<Integer, Conta> contas = new HashMap<>();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar conta");
            System.out.println("2 - Ver saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Mostrar dados da conta");
            System.out.println("6 - Mostrar todas as contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    try {
                        System.out.println("\n===== CADASTRO DE CONTA =====");
                        System.out.print("Número da conta: ");
                        int numero = sc.nextInt();
                        if (numero <= 0){
                            throw new BusinessException("Número da conta inválido!");
                        }
                        if(contas.containsKey(numero)){
                            throw new BusinessException("Número da conta já cadastrado");
                        }


                        System.out.print("Titular: ");
                        sc.nextLine();
                        String titular = sc.nextLine();

                        System.out.print("Saldo inicial: ");
                        double saldo = sc.nextDouble();
                        if (saldo < 0) {
                            throw new BusinessException("Saldo não pode ser negativo!");
                        }

                        System.out.print("Limite de saque: ");
                        double saqueLimite = sc.nextDouble();
                        if (saqueLimite == 0) {
                            throw new BusinessException("O valor limite para saque não pode ser zero!");
                        }
                        if (saqueLimite < 0){
                            throw new BusinessException("O valor limite para saque não pode ser menor que zero!");
                        }

                        Conta conta = new Conta(numero, titular, saldo, saqueLimite);

                        contas.put(numero, conta);

                        System.out.println("Conta cadastrada com sucesso!");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.println("\n===== SALDO =====");
                        if (contas.isEmpty()){
                            throw new BusinessException("Nenhuma conta encontrada!");
                        }
                        System.out.print("Informe o número da conta: ");
                        int numero = sc.nextInt();

                        if(!contas.containsKey(numero)){
                            throw new BusinessException("Conta não cadastrada!");
                        }

                        System.out.printf("Saldo atual: %.2f%n", contas.get(numero).getSaldo());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("\n===== DEPÓSITO =====");
                        if (contas.isEmpty()){
                            throw new BusinessException("Nenhuma conta encontrada!");
                        }
                        System.out.print("Informe o número da conta: ");
                        int numero = sc.nextInt();

                        if(!contas.containsKey(numero)){
                            throw new BusinessException("Conta não cadastrada!");
                        }

                        System.out.print("Informe o valor do depósito: ");
                        double deposito = sc.nextDouble();
                        contas.get(numero).depositar(deposito);

                        System.out.printf("Novo saldo: %.2f%n", contas.get(numero).getSaldo());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.println("\n===== SAQUE =====");
                        if (contas.isEmpty()){
                            throw new BusinessException("Nenhuma conta encontrada!");
                        }
                        System.out.print("Informe o número da conta: ");
                        int numero = sc.nextInt();

                        if(!contas.containsKey(numero)){
                            throw new BusinessException("Conta não cadastrada!");
                        }

                        System.out.print("Informe o valor do saque: ");
                        double saque = sc.nextDouble();
                        contas.get(numero).sacar(saque);

                        System.out.printf("Novo saldo: %.2f%n", contas.get(numero).getSaldo());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println("\n===== DADOS DA CONTA =====");
                        if (contas.isEmpty()){
                            throw new BusinessException("Nenhuma conta encontrada!");
                        }
                        System.out.print("Informe o número da conta: ");
                        int numero = sc.nextInt();

                        if(!contas.containsKey(numero)){
                            throw new BusinessException("Conta não cadastrada!");
                        }

                        System.out.println(contas.get(numero));

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        System.out.println("\n===== CONTAS CADASTRADAS =====");
                        if (contas.isEmpty()){
                            throw new BusinessException("Nenhuma conta encontrada!");
                        }
                        for (Conta conta : contas.values()) {
                            System.out.println(conta);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
        System.out.print("Saindo...");
        sc.close();
    }
}
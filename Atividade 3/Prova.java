import java.util.Scanner;

class Conta {
    int id;
    String cliente;
    double saldo;
    double limite;
}

class Operacao {
    int id;
    int idConta;
    char tipo;     
    double valor;
}

public class Prova {

    public static final int TAM_CONTAS = 50;
    public static final int TAM_OP = 1000;
    static Scanner sc = new Scanner(System.in);

    public static int buscaId(Conta[] v, int tam, int x) {
        for (int i = 0; i < tam; i++) {
            if (v[i].id == x) {
                return i;
            }
        }
        return -1;
    }

    // ---------- Questão 1 ----------

    public static double lerValorNaoNegativo(String mensagem) {
        double valor;
        do {
            System.out.print(mensagem);
            valor = sc.nextDouble();
            if (valor < 0) {
                System.out.println("Valor não pode ser negativo.");
            }
        } while (valor < 0);
        return valor;
    }

    public static int cadastrarConta(Conta[] v, int tam) {
        if (tam >= TAM_CONTAS) {
            System.out.println("Vetor de contas cheio.");
            return tam;
        }

        Conta c = new Conta();

        System.out.print("ID: ");
        c.id = sc.nextInt();
        sc.nextLine();

        if (buscaId(v, tam, c.id) != -1) {
            System.out.println("ID já cadastrado.");
            return tam;
        }

        System.out.print("Cliente: ");
        c.cliente = sc.nextLine();

        c.saldo = lerValorNaoNegativo("Saldo: ");
        c.limite = lerValorNaoNegativo("Limite: ");

        v[tam] = c;
        return tam + 1;
    }

    // ---------- Questão 2 ----------

    public static int buscaBinariaCliente(Conta[] v, int tam, String x) {
        int ini = 0;
        int fim = tam - 1;

        while (ini <= fim) {
            int meio = (ini + fim) / 2;
            int cmp = v[meio].cliente.compareTo(x);

            if (cmp == 0) {
                return meio;
            } else if (cmp < 0) {
                ini = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    // ---------- Questão 3 ----------

    public static int insertionSortCliente(Conta[] v, int tam) {
        for (int i = 1; i < tam; i++) {
            Conta chave = v[i];
            int j = i - 1;

            while (j >= 0 && v[j].cliente.compareTo(chave.cliente) > 0) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
        return tam;
    }

    // ---------- Questão 4 ----------

    public static int filtraOperacoes(Operacao[] vOp, int tamOp, Operacao[] vOpFiltrado, int x) {
        int tam = 0;

        for (int i = 0; i < tamOp; i++) {
            if (vOp[i].idConta == x) {
                vOpFiltrado[tam] = vOp[i];
                tam++;
            }
        }
        return tam;
    }

    // ---------- Questão 5 ----------

    public static String descricaoTipo(char tipo) {
        if (tipo == 'D') {
            return "Depósito";
        } else if (tipo == 'S') {
            return "Saque";
        }
        return "Transferência";
    }

    public static String formataValor(double v) {
        String letra = "C";
        if (v < 0) {
            letra = "D";
            v = -v;
        }
        return v + letra;
    }

    public static void extrato(Conta[] vContas, int tamConta, Operacao[] vOp, int tamOp) {
        System.out.print("ID da conta: ");
        int id = sc.nextInt();

        int pos = buscaId(vContas, tamConta, id);
        if (pos == -1) {
            System.out.println("Conta não encontrada.");
            return;
        }

        Operacao[] vOpFiltrado = new Operacao[TAM_OP];
        int tamFiltrado = filtraOperacoes(vOp, tamOp, vOpFiltrado, id);

        int inicio = tamFiltrado - 5;
        if (inicio < 0) {
            inicio = 0;
        }

        double saldo = 0;
        for (int i = 0; i < inicio; i++) {
            saldo += vOpFiltrado[i].valor;
        }

        System.out.println("CONTA Nº " + id);
        System.out.println("CLIENTE: " + vContas[pos].cliente);
        System.out.println("ID | OPERAÇÃO | VALOR | SALDO");
        System.out.println("Saldo Anterior: " + formataValor(saldo));

        for (int i = inicio; i < tamFiltrado; i++) {
            saldo += vOpFiltrado[i].valor;
            System.out.println(vOpFiltrado[i].id + " | "
                    + descricaoTipo(vOpFiltrado[i].tipo) + " | "
                    + formataValor(vOpFiltrado[i].valor) + " | "
                    + formataValor(saldo));
        }

        System.out.println("Saldo Atual: " + formataValor(saldo));
    }


    public static void main(String[] args) {
        Conta[] contas = new Conta[TAM_CONTAS];
        int tamContas = 0;

        Operacao[] ops = new Operacao[TAM_OP];
        int tamOp = 0;

        contas[0] = new Conta();
        contas[0].id = 1;
        contas[0].cliente = "Maria José Santos";
        contas[0].saldo = 0;
        contas[0].limite = 500;

        contas[1] = new Conta();
        contas[1].id = 2;
        contas[1].cliente = "Ana Lima";
        contas[1].saldo = 0;
        contas[1].limite = 300;
        tamContas = 2;

        int[] idContas = {1, 1, 2, 1, 1, 1, 2, 1, 1};
        char[] tipos = {'D', 'D', 'D', 'S', 'D', 'T', 'S', 'T', 'D'};
        double[] valores = {1000, 237.5, 300, -250, 150, -4000, -100, 1000, 75.5};

        for (int i = 0; i < 9; i++) {
            ops[i] = new Operacao();
            ops[i].id = i + 1;
            ops[i].idConta = idContas[i];
            ops[i].tipo = tipos[i];
            ops[i].valor = valores[i];
        }
        tamOp = 9;

        int opcao;
        do {
            System.out.println();
            System.out.println("1 - Cadastrar conta");
            System.out.println("2 - Ordenar contas por cliente");
            System.out.println("3 - Buscar cliente (busca binária)");
            System.out.println("4 - Filtrar operações de uma conta");
            System.out.println("5 - Extrato");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                tamContas = cadastrarConta(contas, tamContas);
            } else if (opcao == 2) {
                insertionSortCliente(contas, tamContas);
                System.out.println("Contas ordenadas.");
            } else if (opcao == 3) {
                System.out.print("Cliente: ");
                String nome = sc.nextLine();
                int pos = buscaBinariaCliente(contas, tamContas, nome);
                if (pos == -1) {
                    System.out.println("Cliente não encontrado.");
                } else {
                    System.out.println("Encontrado na posição " + pos);
                }
            } else if (opcao == 4) {
                System.out.print("ID da conta: ");
                int id = sc.nextInt();
                Operacao[] filtradas = new Operacao[TAM_OP];
                int tamFiltradas = filtraOperacoes(ops, tamOp, filtradas, id);
                System.out.println(tamFiltradas + " operação(ões):");
                for (int i = 0; i < tamFiltradas; i++) {
                    System.out.println(filtradas[i].id + " | " + filtradas[i].valor);
                }
            } else if (opcao == 5) {
                extrato(contas, tamContas, ops, tamOp);
            }
        } while (opcao != 0);
    }
}
public class Prova {

    // ---------- FUNÇÕES AUXILIARES ----------

    // Verifica se x já existe nas primeiras 'tam' posições de v
    public static boolean contem(int[] v, int tam, int x) {
        for (int i = 0; i < tam; i++) {
            if (v[i] == x) {
                return true;
            }
        }
        return false;
    }

    // Copia de 'origem' para 'destino' apenas os elementos que ainda não estão
    // em 'destino'. Recebe o tamanho atual de destino e devolve o novo tamanho.
    public static int adicionarSemRepetir(int[] origem, int tamOrigem, int[] destino, int tamDestino) {
        for (int i = 0; i < tamOrigem; i++) {
            if (!contem(destino, tamDestino, origem[i])) {
                destino[tamDestino] = origem[i];
                tamDestino++;
            }
        }
        return tamDestino;
    }

    // Inverte os elementos de v entre as posições ini e fim (inclusive)
    public static void inverter(int[] v, int ini, int fim) {
        int qtdTrocas = (fim - ini + 1) / 2;
        for (int i = 0; i < qtdTrocas; i++) {
            int temp = v[ini + i];
            v[ini + i] = v[fim - i];
            v[fim - i] = temp;
        }
    }

    public static void imprimir(int[] v, int tam) {
        System.out.print("{ ");
        for (int i = 0; i < tam; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("}");
    }

    // ---------- QUESTÕES ----------

    // a) União sem repetição
    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
        int tamU = 0;
        tamU = adicionarSemRepetir(a, tamA, u, tamU);
        tamU = adicionarSemRepetir(b, tamB, u, tamU);
        return tamU;
    }

    // b) Insertion sort
    public static void ordenar(int[] v, int n) {
        for (int i = 1; i < n; i++) {
            int chave = v[i];
            int j;
            for (j = i - 1; j >= 0 && v[j] > chave; j--) {
                v[j + 1] = v[j];
            }
            v[j + 1] = chave;
        }
    }

    // c) Vetor sem repetição, mantendo a ordem original
    public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
        return adicionarSemRepetir(v, tamV, vsr, 0);
    }

    // d) Rotação in-place (esquerda para k > 0, direita para k < 0)
    public static void rotacionar(int[] v, int tam, int k) {
        if (tam <= 1) {
            return;
        }
        k = k % tam;
        if (k < 0) {
            k = k + tam; // rotação à direita de x = rotação à esquerda de (tam - x)
        }
        if (k == 0) {
            return;
        }
        inverter(v, 0, k - 1);
        inverter(v, k, tam - 1);
        inverter(v, 0, tam - 1);
    }

    // ---------- TESTES ----------
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3};
        int[] b = {3, 4, 2, 5};
        int[] u = new int[a.length + b.length];
        int tamU = uniao(a, a.length, b, b.length, u);
        System.out.print("União: ");
        imprimir(u, tamU);

        int[] c = {5, 2, 8, 1, 9, 3};
        ordenar(c, c.length);
        System.out.print("Ordenado: ");
        imprimir(c, c.length);

        int[] v = {5, 2, 5, 3, 3, 8, 3, 8, 2};
        int[] vsr = new int[v.length];
        int tamVsr = gerarVetorSemRepeticao(v, v.length, vsr);
        System.out.print("Sem repetição: ");
        imprimir(vsr, tamVsr);

        int[] r1 = {1, 2, 3, 4, 5};
        rotacionar(r1, r1.length, 2);
        System.out.print("Rotação k=2: ");
        imprimir(r1, r1.length);

        int[] r2 = {1, 2, 3, 4, 5};
        rotacionar(r2, r2.length, -1);
        System.out.print("Rotação k=-1: ");
        imprimir(r2, r2.length);
    }
}

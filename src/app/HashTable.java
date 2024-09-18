package app;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<String>[] tabela;
    private int m;
	private int a;
    private int margem;
    private int elementos;

    @SuppressWarnings("unchecked")
	public HashTable(int n, int margem, int a) {
        this.a = a;
        this.margem = margem;
        this.m = n / a;
        this.elementos = 0;
        this.tabela = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int hash(String str) {
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            k = 41 * k + str.charAt(i);
        }
        return valorAbsoluto(k) % m;
    }

    public void insere(String str) {
    	if (str == null) {
            System.out.println("Não possível inserir null");
            return;
        }
        int indice = hash(str);
        if (!tabela[indice].contains(str)) {
            tabela[indice].add(str);
            elementos++;
            if (elementos > (margem * a * m / 100)) {
            	redimensionar();
            }
        }
    }

    public boolean busca(String str) {
    	if (str == null) {
            return false;
        }
        int indice = hash(str);
        return tabela[indice].contains(str);
    }

    public void remove(String str) {
        int indice = hash(str);
        if (tabela[indice].remove(str)) {
            elementos--;
        }
    }

    @SuppressWarnings("unchecked")
    private void redimensionar() {
        int novoTamanho = m * 2;
        LinkedList<String>[] novaTabela = new LinkedList[novoTamanho];
        for (int i = 0; i < novoTamanho; i++) {
            novaTabela[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            for (String str : tabela[i]) {
                int newIndice = valorAbsoluto(str.hashCode()) % novoTamanho;
                novaTabela[newIndice].add(str);
            }
        }

        this.m = novoTamanho;
        this.tabela = novaTabela;
    }
    
    public static int valorAbsoluto(int numero) {
        return (numero < 0) ? -numero : numero;
    }
}

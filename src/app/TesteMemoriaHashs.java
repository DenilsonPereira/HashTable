package app;

import java.util.Hashtable;

public class TesteMemoriaHashs {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        runtime.gc();

        long memoriaAntesHashtableJava = runtime.totalMemory() - runtime.freeMemory();
        
        Hashtable<Integer, String> hashtableJava = new Hashtable<>();
        for (int i = 0; i < 100000; i++) {
            hashtableJava.put(i, "Valor " + i);
        }
        
        runtime.gc();
        long memoriaDepoisHashtableJava = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsadaHashtableJava = memoriaDepoisHashtableJava - memoriaAntesHashtableJava;

        hashtableJava.clear();
        runtime.gc();

        long memoriaAntesMinhaHashtable = runtime.totalMemory() - runtime.freeMemory();
        
        HashTable minhaHashTable = new HashTable(100000, 70, 1);
        for (int i = 0; i < 100000; i++) {
            minhaHashTable.insere("Valor " + i);
        }

        runtime.gc();
        long memoriaDepoisMinhaHashtable = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsadaMinhaHashtable = memoriaDepoisMinhaHashtable - memoriaAntesMinhaHashtable;

        System.out.println("Memória usada pela Hashtable Java: " + memoriaUsadaHashtableJava + " bytes");
        System.out.println("Memória usada pela minha HashTable: " + memoriaUsadaMinhaHashtable + " bytes");
    }
}

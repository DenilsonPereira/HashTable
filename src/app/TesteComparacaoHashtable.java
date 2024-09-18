package app;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;


class TesteComparacaoHashtable {

	public static final int TAMANHOTESTE = 15;
	
	public static void main(String[] args) {
		System.out.println("Testando a inserção");
		insertTeste();
		System.out.println("Inicio do tesde de pesquisa");
		pesquisaTeste();
		System.out.println("Inicio do teste de remoção");
		remocaoTeste();
	}
	
	public static void insertTeste() {
		double[] hashtableJavaTempo = new double[TAMANHOTESTE];
		double[] hashtableMinhaTempo = new double[TAMANHOTESTE];
		
		for(int i = 0; i < TAMANHOTESTE; i++) {
			String str = gerarString();
	
			long inicioInsertTime = System.nanoTime();
			Hashtable<String, String> javaH = new Hashtable<>();
			
			javaH.put(str, str);
			
			long finalInsertTime = System.nanoTime();
			
			long tempoTotal = finalInsertTime - inicioInsertTime;
			
			hashtableJavaTempo[i] = tempoTotal / 1_000_000_000.0;
						
			inicioInsertTime = System.nanoTime();
			HashTable nossaH = new HashTable(20, 50, 2); 
			nossaH.insere(str);
			
			finalInsertTime = System.nanoTime();
			
			tempoTotal = finalInsertTime - inicioInsertTime;
			
			hashtableMinhaTempo[i] = tempoTotal / 1_000_000_000.0;
		}
		
		System.out.println("Media Hashtable Java: "+ Arrays.stream(hashtableJavaTempo).sum()/15);
		System.out.println("Media minha Hastable: "+ Arrays.stream(hashtableMinhaTempo).sum()/15);
	}
	
	public static void pesquisaTeste() {
		double[] hashtableJavaTempo = new double[TAMANHOTESTE];
		double[] hashtableMinhaTempo = new double[TAMANHOTESTE];
		
		for(int i = 0; i < TAMANHOTESTE; i++) {
			String str1 = gerarString();
			String str2 = gerarString();
			String str3 = gerarString();
			
			Hashtable<String, String> javaH = new Hashtable<>();
			
			javaH.put(str1, str1);
			javaH.put(str2, str2);
			javaH.put(str3, str3);
			
			long inicioInsertTime = System.nanoTime();

			javaH.get(str2);
			
			long finalInsertTime = System.nanoTime();
			
			long tempoTotal = finalInsertTime - inicioInsertTime;
			
			hashtableJavaTempo[i] = tempoTotal / 1_000_000_000.0;
			
			
			HashTable nossaH = new HashTable(20, 50, 2);
			
			nossaH.insere(str1);
			nossaH.insere(str2);
			nossaH.insere(str3);
			
			inicioInsertTime = System.nanoTime();

			nossaH.busca(str2);
			
			finalInsertTime = System.nanoTime();
			
			tempoTotal = finalInsertTime - inicioInsertTime;
			
			hashtableMinhaTempo[i] = tempoTotal / 1_000_000_000.0;

		}
		
		System.out.println("Media Hashtable Java: "+ Arrays.stream(hashtableJavaTempo).sum()/15);
		System.out.println("Media minha Hastable: "+ Arrays.stream(hashtableMinhaTempo).sum()/15);
	}
	
	public static void remocaoTeste() {
		double[] hashtableJavaTempo = new double[TAMANHOTESTE];
		double[] hashtableMinhaTempo = new double[TAMANHOTESTE];
		
		for(int i = 0; i < TAMANHOTESTE; i++) {
			String str1 = gerarString();
			String str2 = gerarString();
			String str3 = gerarString();
			
			Hashtable<String, String> javaH = new Hashtable<>();
			
			javaH.put(str1, str1);
			javaH.put(str2, str2);
			javaH.put(str3, str3);
			
			long inicioInsertTime = System.nanoTime();

			javaH.remove(str2);
			
			long finalInsertTime = System.nanoTime();
			
			long tempoTotal = finalInsertTime - inicioInsertTime;
			
			hashtableJavaTempo[i] = tempoTotal / 1_000_000_000.0;

			
			HashTable nossaH = new HashTable(20, 50, 2);
			
			nossaH.insere(str1);
			nossaH.insere(str2);
			nossaH.insere(str3);
			
			inicioInsertTime = System.nanoTime();

			nossaH.remove(str2);
			
			finalInsertTime = System.nanoTime();
			
			tempoTotal = finalInsertTime - inicioInsertTime;
			
			hashtableMinhaTempo[i] = tempoTotal / 1_000_000_000.0;
		}
		
		System.out.println("Media Hashtable Java: "+ Arrays.stream(hashtableJavaTempo).sum()/15);
		System.out.println("Media minha Hastable: "+ Arrays.stream(hashtableMinhaTempo).sum()/15);
	}
	
	public static String gerarString() {
		char[] str = new char[5];
		Random r = new Random();
		for(int i = 0; i < str.length; i++) {
			str[i] = (char)r.nextInt(30, 128);
		}
		
		return String.copyValueOf(str);
	}
}
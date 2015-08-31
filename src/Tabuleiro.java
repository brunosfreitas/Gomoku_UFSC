import java.util.*;
/*
public class Tabuleiro {
	
 char[][] tabuleiro;
	
  
	  public Tabuleiro(){
		  this.tabuleiro = new char[15][15];		 
		  for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					this.tabuleiro[i][j] = '.';
				}
			}		  
	  } 
	  
	    /*
	  char[][] printTabuleiro(){
		  	System.out.print("    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15");
		  	System.out.print("\n");		  	
			for (int i = 0; i < 15; i++) {
				if(i < 9){
					System.out.print(i+1+"   ");
				}else{
					System.out.print(i+1+"  ");
				}
			    for (int j = 0; j < 15; j++) {
			        System.out.print(this.tabuleiro[i][j] + "  ");
			    }
			    System.out.print("\n");
			}
			return this.tabuleiro;
	  }
	  
	  char marcaJogadaX(int i,int j){
		  printTabuleiro(); // Retirar(somente para teste)
		  System.out.print("----------------------------------"+"\n");
		  return this.tabuleiro[i-1][j-1] = 'x';
	  }
	  
	  char marcaJogadaO(int i,int j){
		  printTabuleiro(); // Retirar(somente para teste)
		  System.out.print("----------------------------------"+"\n");
		  return this.tabuleiro[i-1][j-1] = 'o';
	  }
	  
	  boolean fimDeJogo(){
		  if(verifica5Verticall() || verifica5Horizontal() || verifica5DiagonalSentido1()){
			  return true;
		  }
		  return false;
	  }
	  
	  boolean verifica5Verticall(){		  
		  String cincoEmLinhaString = "";
		  ArrayList<Character> cincoEmLinha = new ArrayList<Character>();
		  for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					cincoEmLinha.add(tabuleiro[j][i]);
				}
				System.out.print("Contagem: ");
			    int n = cincoEmLinha.size();
				for (int k=0; k<n; k++) {
					System.out.print(cincoEmLinha.get(k));					
				   
				   cincoEmLinhaString = cincoEmLinhaString + Character.toString(cincoEmLinha.get(k));
				   if(cincoEmLinha.get(k) == '.'){
					   cincoEmLinhaString = "";
				   }
				   if(cincoEmLinhaString.equals("xxxxx") ||  cincoEmLinhaString.equals("ooooo")){
				   System.out.print("Final de jogo");
					  System.exit(0);
				   }
			    }				
				System.out.print("\n");
				cincoEmLinha.clear();				
			}
		    
		  return true;
	  }
	  
	  boolean verifica5Horizontal(){		  
		  String cincoEmLinhaString = "";
		  ArrayList<Character> cincoEmLinha = new ArrayList<Character>();
		  for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					cincoEmLinha.add(tabuleiro[i][j]);
				}
				System.out.print("Contagem: ");
			    int n = cincoEmLinha.size();
				for (int k=0; k<n; k++) {
					System.out.print(cincoEmLinha.get(k));					
				   
				   cincoEmLinhaString = cincoEmLinhaString + Character.toString(cincoEmLinha.get(k));
				   if(cincoEmLinha.get(k) == '.'){
					   cincoEmLinhaString = "";
				   }
				   if(cincoEmLinhaString.equals("xxxxx") ||  cincoEmLinhaString.equals("ooooo")){
				   System.out.print("Final de jogo");
					  System.exit(0);
				   }
			    }				
				System.out.print("\n");
				cincoEmLinha.clear();				
			}
		    
		  return true;
	  }
	  
	  /*Super incompleto */
	  /*
	  boolean verifica5DiagonalSentido1(){	  
		  for (int i = 0; i < 15; i++) {
			   int k = i;
				for (int j = 14; j < 15; j++) {
					System.out.print(tabuleiro[i][j]);
					j--;
				}
				
				System.out.print("\n");
				i = k;
			}
		    
		  return true;
	  }
	  
	  
	  
}*/

import java.util.*;

public class Tabuleiro {
	
	private final Map<Integer, Map<Integer, Character>> tabuleiro = new HashMap<Integer, Map<Integer, Character>>();
	
	
	public Tabuleiro(){		
		  preencheTabuleiro();
	}	
	 
	 public void set(int linha, int coluna, Character elemento) {  
	        Map<Integer, Character> colunas = getColunas(linha);  
	        Integer chave = Integer.valueOf(coluna);  
	        if (elemento != null) {  
	            colunas.put(chave, elemento);  
	        } else {  
	            colunas.remove(chave);  
	        }  
	    }
	  
	  public Character get(int linha, int coluna) {  
	        Map<Integer, Character> colunas = getColunas(linha);  
	        Integer chave = Integer.valueOf(coluna);  
	        Character elemento = colunas.get(chave);  
	        return elemento;  
	    }  
	  
	    private Map<Integer, Character> getColunas(int linha) {  
	        int chave = Integer.valueOf(linha);  
	        Map<Integer, Character> colunas = tabuleiro.get(chave);  
	        if (colunas == null) {  
	            colunas = new HashMap<Integer, Character>();  
	            tabuleiro.put(chave, colunas);  
	        }  
	        return colunas;  
	    }
	    
	    public void printTabuleiro(){
	    	for (int i = 0; i < tabuleiro.size(); i++) {
	    		
	    			System.out.print(tabuleiro.get(i));
	    			System.out.print("\n");
				
	    		
			}
	    	
	    }
	    public void preencheTabuleiro(){
	    	for (int i = 0; i < 15; i++){
	    		for (int j = 0; j < 15; j++) {
	    			set(i,j,'.');	    			
				}			
			}
	    }
}
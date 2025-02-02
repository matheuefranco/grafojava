package grafos;

import java.io.*;
import java.util.*;



public class Graph {
     private HashMap<Integer, LinkedList<Aresta>> meuGrafo;
     ArrayList visitados;
    public Graph() {
        this.meuGrafo = new HashMap<>();
    } 





    // Método para imprimir o grafo
    public void imprimirGrafo(boolean caractere) {
        if(caractere){
            for (Map.Entry<Integer, LinkedList<Aresta>> registro : meuGrafo.entrySet()) {
                int idvertice = registro.getKey()+64;
                LinkedList<Aresta> vizinhos = registro.getValue();
                System.out.print((char)idvertice + " -> ");
                for (Aresta vizinho : vizinhos) {
                    System.out.print((char)(vizinho.vertice+64)+"["+vizinho.peso+"]" + " ");
                }
                System.out.println();
            }
        }// fim if
        else{
             for (Map.Entry<Integer, LinkedList<Aresta>> registro : meuGrafo.entrySet()) {
                int idvertice = registro.getKey();
                LinkedList<Aresta> vizinhos = registro.getValue();
                System.out.print(idvertice + " -> ");
                for (Aresta vizinho : vizinhos) {
                    System.out.print(vizinho.vertice+"["+vizinho.peso+"]" + " ");
                }
                System.out.println();
            }
        }
        
    }
    
    public void salvarGrafo(String arquivo) {
       try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo, false))) {
            for (Map.Entry<Integer, LinkedList<Aresta>> entry : meuGrafo.entrySet()) {
                int vertice = entry.getKey();
                LinkedList<Aresta> vizinhos = entry.getValue();
                for (Aresta vizinho : vizinhos) {
                    writer.println(vertice + " " + vizinho.vertice + " " + vizinho.peso);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar os dados do grafo de um arquivo texto
    public void carregarGrafo(String arquivo) {
        try (Scanner scanner = new Scanner(new File(arquivo))) {
            while (scanner.hasNext()) {
                int origem = scanner.nextInt();
                int destino = scanner.nextInt();
                int peso = scanner.nextInt();

                //adicionarVertice(origem);
                //adicionarVertice(destino);
                //adicionarAresta(origem, destino, peso);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
   
    
}



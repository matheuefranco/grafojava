//2024-2025 
package grafos;
import java.io.*;
import java.util.*;

public class Graph {
     private HashMap<Integer, LinkedList<Aresta>> meuGrafo;
     ArrayList visitados;
    public Graph() {
        this.meuGrafo = new HashMap<>();
    } 
    public void adicionarVertice(int vertice){
        if(!meuGrafo.containsKey(vertice))
            meuGrafo.put(vertice, new LinkedList<>());
    }
    public void adicionarAresta(int ori, int dest, int peso){
        if(meuGrafo.containsKey(ori) 
                && meuGrafo.containsKey(dest))
            meuGrafo.get(ori).add(new Aresta(dest, peso));
    }
    
    public boolean alcance(int origem, int destino) {
        visitados = new ArrayList<>();
        return existeCaminho(origem, destino, visitados);
    }

    private boolean existeCaminho(int verticeAtual, int destino, ArrayList visitados) {
    	if (verticeAtual == destino) // caso base
        	return true;
    	visitados.add(verticeAtual);
        System.out.println("Visitados:"+visitados);
        System.out.println("Vertice atual:"+verticeAtual + " Adjacencias:");
    	LinkedList<Aresta> vizinhos = meuGrafo.get(verticeAtual);
        for (Aresta vizinho : vizinhos)
            System.out.print("["+vizinho.vertice+"]");
        System.out.println("");
    	if (vizinhos != null)
        	for (Aresta vizinho : vizinhos)
            	if (!visitados.contains(vizinho.vertice) && existeCaminho(vizinho.vertice, destino, visitados))
                    return true;
    	return false;
	}
    
    public List<Integer> buscaEmProfundidade(int verticeInicial) {
        visitados = new ArrayList();
        explorarDFS(verticeInicial);
        return visitados;
    }
    
    private void explorarDFS(int verticeAtual) {
        visitados.add(verticeAtual);
        LinkedList<Aresta> vizinhos = meuGrafo.get(verticeAtual);
        if (vizinhos != null) 
            for (Aresta vizinho : vizinhos) 
                if (!visitados.contains(vizinho.vertice)) 
                    explorarDFS(vizinho.vertice);
    }
    
    
    public List<Integer> exploracaoEmLargura(int verticeInicial) {
        Queue<Integer> fila = new LinkedList<>();
        visitados = new ArrayList();
        fila.add(verticeInicial);
        while (!fila.isEmpty()) {
            int verticeAtual = fila.poll();
            visitados.add(verticeAtual);
            List<Aresta> vizinhos = meuGrafo.get(verticeAtual);
            if (vizinhos != null) 
                for (Aresta vizinho : vizinhos) 
                    if (!visitados.contains(vizinho.vertice) 
                            && !fila.contains(vizinho.vertice))
                        fila.add(vizinho.vertice);
        }// fim while

        return visitados;
    }// fim funcao BFS


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

                 adicionarVertice(origem);
                 adicionarVertice(destino);
                 adicionarAresta(origem, destino, peso);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
   
    
}



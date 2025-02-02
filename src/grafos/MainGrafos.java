
package grafos;

import java.util.*;


public class MainGrafos {
    
    
        static int menu(){
        Scanner scanner = new Scanner(System.in);
        int op;
        System.out.println("1-Adicionar Vertice");
        System.out.println("2-Adicionar Aresta");
        System.out.println("3-Imprime Grafo");
        System.out.println("4-Alcance Grafo");
        System.out.println("5-Busca em Profundidade [DFS]");
        System.out.println("6-Busca em Largura [BFS]");
        System.out.println("7-Menor distancia [Dijkstra]");
        System.out.println("0-Sair");
        op = scanner.nextInt();
        return op;
    }

    public static void main(String[] args) {
        Graph grafo = new Graph();
        Scanner scanner = new Scanner(System.in);
        int op=0;
        String nomeArquivo = "grafo.txt"; 
        grafo.carregarGrafo(nomeArquivo);
        do{
        op = menu();
        switch(op){
            case 1: System.out.println("Vertice:");
                    int valor=scanner.nextInt();
                    //grafo.adicionarVertice(valor);
            break;
            case 2: System.out.println("Adjacencias:");
                    int origem=scanner.nextInt();
                    int destino=scanner.nextInt();
                    System.out.println("Peso:");
                    int peso = scanner.nextInt();
                    //grafo.adicionarAresta(origem, destino, peso);
                    
            break;
            case 3:
                    grafo.imprimirGrafo(false);
            break;
            case 4: System.out.println("Origem e destino:");
                    origem=scanner.nextInt();
                    destino=scanner.nextInt();
                    /*if (grafo.alcance(origem, destino)) 
                    System.out.println("Existe um caminho entre " + origem + " e " + destino);
                     else 
                        System.out.println("Não existe um caminho entre " + origem + " e " + destino);*/
            break;
            case 5: System.out.println("Vertice de Origem:");
                    origem=scanner.nextInt();
                    //List<Integer> verticesVisitados = grafo.buscaEmProfundidade(origem);
                    //System.out.println("Vertices visitados em uma busca em profundidade a partir de " + origem + ": " + verticesVisitados);
            break;
            case 6: System.out.println("Vertice de Origem:");
                    origem=scanner.nextInt();
                    //verticesVisitados = grafo.exploracaoEmLargura(origem);
                    //System.out.println("Vertices visitados em uma busca em largura a partir de " + origem + ": " + verticesVisitados);
            break;
             case 7: //
            break;
            case 0: System.out.println("Saindo");
                    grafo.salvarGrafo(nomeArquivo);
            break;
        }// fim switch
        }while(op!=0);

    
    }
    
}

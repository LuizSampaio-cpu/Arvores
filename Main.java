/*
  Author: Luiz Sampaio Horta- 20202bsi0390
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BinaryTree<Aluno> treeById = new BinaryTree<Aluno>(new ComparatorAlunoporMat());
        BinaryTree<Aluno> treeByName = new BinaryTree<Aluno>(new ComparatorAlunoporNome());
        //caminho do arquivo
        String path = "C:\\Users\\luizh\\OneDrive\\Documentos\\TPA (java)\\Listas\\src\\entradaOrdenada5000.txt";

        Scanner s = new Scanner(System.in);
        int qtd = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            //Leitura da quantidade de elementos da lista
            String line = br.readLine();
            qtd = Integer.parseInt(line);
            //Leitura do primeiro aluno da lista
            line = br.readLine();
            //for (int i = 0; i <10; i++){
            while (line != null){
                String data[] = line.split(";");
                Aluno student = new Aluno(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
                treeById.insertion(student);
                treeByName.insertion(student);
                line = br.readLine();
            }
        }catch (IOException e){
            System.out.println("Error: "+ e.getMessage());
        }

        // Menu interativo
        System.out.println("*****MENU*****\n");
        System.out.println("\nO QUE DESEJA FAZER?\n");
        System.out.println("1.CADASTRAR ALUNO\n");
        System.out.println("2.REMOVER ALUNO\n");
        System.out.println("3.CONSULTAR POR NOME\n");
        System.out.println("4.CONSULTAR POR MATRICULA\n");
        System.out.println("5.ESTATÍSTICAS POR NOME\n");
        System.out.println("6.ESTATÍSTICAS POR MATRÍCULA\n");
        System.out.println("7.SAIR");


        int answer = s.nextInt();
        s.nextLine();
        while(answer != 7){ 
            if(answer == 1){
           
            System.out.println("Matricula do aluno: ");
            String matricula = s.nextLine();
            System.out.println("Nome do aluno: ");
            String nome = s.nextLine();
            System.out.println("Nota do aluno: ");
            String nota = s.nextLine();
            Aluno aluno1 = new Aluno(Integer.parseInt(matricula), nome, Integer.parseInt(nota));
            treeByName.insertion(aluno1);
            treeById.insertion(aluno1);
            qtd += 1;
            System.out.println("O que fazer a seguir?");
            answer = s.nextInt();
        }
        else if(answer == 2){
           
            System.out.println("Matricula do aluno: ");
            Integer matricula = Integer.parseInt(s.nextLine());
            No<Aluno> alunoR = treeById.removeNo(new Aluno(matricula));
            qtd =- 1;
            if(alunoR == null)
            {
                System.out.println("Removido");
            }
            
            System.out.println("O que fazer a seguir?");
            answer = s.nextInt();
        }
        else if(answer == 3)
        {
            
            System.out.println("Nome do aluno: ");
            String nome = s.nextLine();
            treeByName.search(new Aluno(nome));
            System.out.println("O que fazer a seguir?");
            answer = s.nextInt();
        }
        else if(answer == 4)
        {
           
            System.out.println("Matricula do aluno: ");
            Integer matricula = Integer.parseInt(s.nextLine());
            System.out.println("resposta: " + treeById.search(new Aluno(matricula)));
            System.out.println("O que fazer a seguir?");
            answer = s.nextInt();
        }
        else if(answer == 5)
        {
            System.out.print("Quantidade: " + qtd);
            System.out.print("Altura da árvore: "+ treeByName.Height());
            System.out.print("Primeiro Aluno: "+ treeByName.Smallest());
            System.out.print("Último aluno: " + treeByName.Biggest());
            System.out.println("O que fazer a seguir?");
            answer = s.nextInt();

        }
        else if(answer == 6)
        {
           
            System.out.print("Quantidade: " + qtd);
            System.out.print("Altura da árvore: "+ treeById.Height());
            System.out.print("Primeiro Aluno: "+ treeById.Smallest());
            System.out.print("Último aluno: " + treeById.Biggest());
            System.out.println("O que fazer a seguir?");
            answer = s.nextInt();

        }

    }s.close();
       
        
}

}
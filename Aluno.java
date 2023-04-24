public class Aluno implements Comparable<Aluno> {
    private String nome;
    private int matricula;
    private int nota;

    public Aluno(int matricula, String nome,  int nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }
    public Aluno(int matricula){
        this.matricula = matricula;
    }
    public Aluno(String nome){
        this.nome = nome;
    }
    //getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object a)
    {
        if(a instanceof Aluno){
            return this.matricula==((Aluno)a).matricula;
        }
        else{
            return false;
        }
    }

    @Override
    public int compareTo(Aluno a)
    {
        return Integer.compare(this.matricula, a.matricula);
        //return this.nome.compareTo(a.nome);
    }

    public String toString() {
        return "Matricula: " + matricula + "\nNome: " + nome + "\nNota: "+ nota;
    }
}
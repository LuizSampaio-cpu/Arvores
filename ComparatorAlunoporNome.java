import java.util.Comparator;


public class ComparatorAlunoporNome implements Comparator<Aluno> {
    @Override
    public int compare(Aluno arg0, Aluno arg1)
    {
        return arg0.getNome().compareTo(arg1.getNome());
    }
    
}

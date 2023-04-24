import java.util.Comparator;

public class ComparatorAlunoporMat implements Comparator<Aluno>{
    @Override
    public int compare(Aluno arg0, Aluno arg1)
    {
        return Integer.compare(arg0.getMatricula(), arg1.getMatricula());
    }
}
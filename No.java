
public class No <T> {
    private T valor;
    private No<T> left, right;


    public No(T valor)
    {
        this.valor = valor;
        this.left = this.right = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getLeft() {
        return left;
    }

    public No<T> getRight() {
        return right;
    }
    public void setLeft(No<T> left) {
        this.left = left;
    }
    public void setRight(No<T> right) {
        this.right = right;
    }
    
    public String ToString() {
        return "Valor: "+ this.valor;
    }
}
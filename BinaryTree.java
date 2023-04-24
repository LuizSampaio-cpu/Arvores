import java.util.Comparator;

public class BinaryTree<T extends Comparable<T>> {
    private No<T> root;
    private int quantNode;
    private Comparator<T> comparator;


    public BinaryTree(Comparator<T> comp){
        
        this.comparator = comp;
    }

    public void insertion (T elem)
    {
        T item = elem;
        insert(root, item);
    }
    
    private void insert(No<T> root, T item){
        
        No<T> novo = new No<T>(item);
        No<T> current;
        
        // empty tree, new node becomes the new root
        if(this.root == null)
        {
           // System.out.println(root);
            this.root = novo;
            
        }// not empty, compares to the leaves
        else {
            current = root;
            // if item is smaller than current, goes to the left
            if (current.getValor() != null && comparator.compare(item, current.getValor()) < 0)
            {
                //no leaf on the left, new becomes the leaf
                if(current.getLeft() == null)
                    current.setLeft(novo);
                else {
                    insert(current.getLeft(), item);
                }
            }
            // if item is bigger, goes to the right
            else if(current.getValor() != null && comparator.compare(item,current.getValor()) > 0)
            {
                //no leaf on the right, new becomes the leaf
                if(current.getRight() == null)
                    current.setRight(novo);
                else {
                    insert(current.getRight(), item);
                }
            }
           
        }quantNode++;
    }

    public T search(T elem)
    {
        No<T> current = this.root;
        while (current != null && comparator.compare(elem, current.getValor()) != 0){
            // if the item searched is bigger, then go right
            if(comparator.compare(elem, current.getValor()) > 0)
            {
                current = current.getRight();
            }
            else { //if smaller, go left
                current = current.getLeft();
            }
        }
        if (current == null)
        {
            return null;
        } else
            return current.getValor();
    }

    public No<T> removeNo(T elem)
    {
        No<T> removivel = new No<T>(elem);
        return remove(removivel, root);
    }

    private No<T> remove(No<T> elem, No<T> root)
    {
        //No<T> prev = this.root;
        No<T> current = this.root;

        // If the tree is empty, do nothing
        if (current == null)
            return null;
        // if the item is bigger, go right
        else if (comparator.compare(elem.getValor(), current.getValor()) > 0){
            current = current.getRight();
        }
        // if smaller, go left
        else if (comparator.compare(elem.getValor(), current.getValor()) < 0){
            current = current.getLeft();
        }
        //if the node does not have leaves, just remove it
        if (current.getLeft() == null && current.getRight() == null){
            current = null;
            return null;
        }
        // if it has only the right leaf, makes the root point to the right leaf
        if(current.getLeft() == null){
           return root.getRight();

        }
        // if it has only the left leaf, makes the previous one point to the left leaf
        if(current.getRight() == null){
            return root.getLeft();
        }
        //if it has both, find the biggest element in the smaller left tree, change it for the root's value and remove the leaf
        else {
            T sucessor = sucessor(root.getRight());
            root.setValor(sucessor);
            return root;
        }

    }

    private T sucessor(No<T> root)
    {
        T sucessor = root.getValor();
        // while the current has a leaf to the left, walks to the left
        while (root.getLeft() != null)
        {
            sucessor = root.getLeft().getValor();
            root = root.getLeft();
        }
        return sucessor;
    }

    //getters & setters
    public No<T> getRoot() {
        return root;
    }

    public void setRoot(No<T> root) {
        this.root = root;
    }

    public int getQuantNode() {
        return quantNode;
    }

    public void setQuantNode(int quantNode) {
        this.quantNode = quantNode;
    }
    
    public void exibirEmOrdem()
    {
        exibirEmOrdem(root);
    }

    private void exibirEmOrdem(No<T> r)
    {
        if(r != null){
            //prints the left leaf, then the node itself, then the right leaf
            exibirEmOrdem(r.getLeft());
            System.out.println(r.getValor());
            exibirEmOrdem(r.getRight());
        }
    }  

    public int Height() {
        return Height(root);
    }

    private int Height(No<T> root)
    {
        // if there are no nodes or if there is only the root, the height is 0
        if (root == null)
        {
            return 0;
        }
        else if(root.getLeft() == null && root.getRight() == null) {
            return 0;
        }
        // compares the heights of the smaller trees, and increases them each time the method is called recursively 
        else {
            int hd = Height(root.getRight());
            int he = Height(root.getLeft());
            if (hd > he)
            {
                return 1 + hd;
            }
            else 
                return 1 + he;
        }
    }

    public T Smallest(){
        return SmallestElem(root);
    }

    private T SmallestElem(No<T> root)
    {
        No<T> current = root;
        //while there are left leaves in the tree, goes to the left
        while (current.getLeft() != null)
        {
            current = current.getLeft();
        }
        return current.getValor();
    }

    public T Biggest(){
        return BiggestElem(root);
    }

    private T BiggestElem(No<T> root)
    {
        No<T> current = root;
        //while there are right leaves in the three, goes to the right
        while (current.getRight() != null)
        {
            current = current.getRight();
        }
        return current.getValor();

    }


}
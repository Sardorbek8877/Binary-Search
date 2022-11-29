public class CharacterSearchTree {

    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree(){
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public HuffmanTriple getCotent(){
        if ( !isEmpty() ){
            return content;
        }
        else {
            throw new IllegalStateException();
        }
    }

    public boolean isEmpty(){
        return content == null;
    }

    public boolean isLeaf(){
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void add( char t ){
        if ( isEmpty() ){
            content = new HuffmanTriple( t );
            leftChild = new CharacterSearchTree();
            rightChild = new CharacterSearchTree();
        }
        else {
            if ( content.getToken() > t ){
                leftChild.add(t);
            }
            else if ( content.getToken() < t ){
                rightChild.add( t );
            }
            else {
                content.incrementQuantity();
            }
        }
    }

    public int size(){
        if( isEmpty() ){
            return 0;
        }
        else {
            return leftChild.size() + rightChild.size() + 1;
        }
    }
}

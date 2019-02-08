package trees.video;

public class Test
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(60);
        bst.add(41);
        bst.add(53);
        bst.add(16);
        bst.add(46);
        bst.add(42);
        bst.add(55);

        System.out.println("contains(60)" + bst.contains(60));
        System.out.println("contains(0)" + bst.contains(0));

        //bst.remove(60);
        System.out.println(bst.contains(60));

        //test for node depth
        System.out.println("Depth(55): " + bst.depth(55));
        System.out.println("Depth(60): " + bst.depth(60));
        System.out.println("Depth(53): " + bst.depth(53));
    }

}

class Tester {

    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        String[] austen = {"it", "is", "a", "truth", "universally",  "universally", "universally", "universally", "universally", "acknowledged", "that", "a", "single", "man",
                          "in", "possession", "of", "a", "good", "fortune", "must", "be", "in", "want", "of", "a", "wife"};

        String feynmann = "western civilization, it seems to me, stands by two great heritages. one is the scientific spirit of adventure — the adventure into the unknown, an unknown which must be recognized as being unknown in order to be explored the demand that the unanswerable mysteries of the universe remain unanswered the attitude that all is uncertain to summarize it — the humility of the intellect. The other great heritage is Christian ethics — the basis of action";
                            // on love, the brotherhood of all men, the value of the individual — the humility of the spirit. These two heritages
                            // are logically, thoroughly consistent. But logic is not all one needs one's heart to follow an idea. If people are
                            // going back to religion, what are they going back to? Is the modern church a place to give comfort to a man who
                            // doubts God — more, one who disbelieves in God? Is the modern church a place to give comfort and encouragement to
                            // the value of such doubts? So far, have we not drawn strength and comfort to maintain the one or the other of these
                            // consistent heritages in a way which attacks the values of the other? Is this unavoidable? How can we draw
                            // inspiration to support these two pillars of western civilization so that they may stand together in full vigor,
                            // mutually unafraid? Is this not the central problem of our time";
        String[] feynarray = feynmann.split(" ");

        String[] letters = {"d", "b", "g", "f","f","a","f", "e", "d", "b", "c", "h", "b", "b", "b", "h"};
        for (String s : feynarray)
            tree.add(s);
        // tree.traverse();
        // tree.remove("it");
        // tree.remove("is");
        // tree.remove("a");
        // tree.remove("truth");
        // tree.remove("fortune");
        // tree.remove("universally");
        // System.out.println();

        tree.traverse();

        // tree.remove("a");
        // tree.remove("b");
        // tree.remove("c");
        // tree.remove("d");
        // tree.remove("f");
        // tree.remove("q");
        //
        // tree.traverse();
        // System.out.println();

        tree.prune(2);

        tree.traverse();
    }
}

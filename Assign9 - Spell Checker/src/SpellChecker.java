import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Character.isLetter;

public class SpellChecker {
    public static void main(String[] args) throws FileNotFoundException {

        // Step 1: Demonstrate tree capabilities
        testTree();

        // Step 2: Read the dictionary and report the tree statistics
        BinarySearchTree<String> dictionary = readDictionary();
        String[] wordArray = new String[235886];
        int count = 0;

        // create an array consisting of words from Dictionary.txt
        File file = new File("Dictionary.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String word = input.nextLine();
                wordArray[count++] = word;
            }
        }
        catch (java.io.IOException ex) {
            System.out.println("An error occurred trying to read the file: + ex");
        }

        // shuffle collection of words
        List<String> wordList = Arrays.asList(wordArray);
        java.util.Collections.shuffle(wordList, new java.util.Random(System.currentTimeMillis()));

        // add to dictionary
        for (String word: wordList) {
            dictionary.insert(word);
        }
        reportTreeStats(dictionary);

        // Step 3: Perform spell checking
        ArrayList<String> arrayList = new ArrayList<String>();
        File file1 = new File("Letter.txt");
        ArrayList<String> wordList1 = new ArrayList<String>();

        // reads file line by line
        try (Scanner input1 = new Scanner(file1)) {
            while (input1.hasNextLine()) {
                // set line to lower case
                String line = input1.nextLine();
                String lowerLine = line.toLowerCase();

                // creates list of each line parsed by space
                String[] docArray = lowerLine.split(" ");

                // loops through each word, cutting symbols
                for (String word: docArray) {
                    char[] charArray = word.trim().toCharArray();

                    // loops through each character
                    StringBuilder holder = new StringBuilder();
                    for (char c : charArray) {
                            if (Character.isLetter(c)) {
                                holder.append(c);
//                                charList.add(c);
//                                System.out.print(c);
                            }
                        }
                    wordList1.add(holder.toString());
                    }
                }
            }

        catch (java.io.IOException ex) {
            System.out.println("An error occurred trying to read the file: + ex");
        }
        // check if each word is in the dictionary
        for (String word: wordList1) {
            if (!dictionary.search(word.trim())) {
                System.out.print(word + " ");
            }
        }
    }

    /**
     * This method is used to help develop the BST, also for the grader to
     * evaluate if the BST is performing correctly.
     */
    public static void testTree() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();

        //
        // Add a bunch of values to the tree
        tree.insert("Olga");
        tree.insert("Tomeka");
        tree.insert("Benjamin");
        tree.insert("Ulysses");
        tree.insert("Tanesha");
        tree.insert("Judie");
        tree.insert("Tisa");
        tree.insert("Santiago");
        tree.insert("Chia");
        tree.insert("Arden");

        //
        // Make sure it displays in sorted order
        tree.display("--- Initial Tree State ---");
        reportTreeStats(tree);

        //
        // Try to add a duplicate
        if (tree.insert("Tomeka")) {
            System.out.println("oops, shouldn't have returned true from the insert");
        }
        tree.display("--- After Adding Duplicate ---");
        reportTreeStats(tree);

        //
        // Remove some existing values from the tree
        tree.remove("Olga");    // Root node
        tree.remove("Arden");   // a leaf node
        tree.display("--- Removing Existing Values ---");
        reportTreeStats(tree);

        //
        // Remove a value that was never in the tree, hope it doesn't crash!
        tree.remove("Karl");
        tree.display("--- Removing A Non-Existent Value ---");
        reportTreeStats(tree);
    }

    /**
     * This method is used to report on some stats about the BST
     */
    public static void reportTreeStats(BinarySearchTree<String> tree) {
        System.out.println("-- Tree Stats --");
        System.out.printf("Total Nodes : %d\n", tree.numberNodes());
        System.out.printf("Leaf Nodes  : %d\n", tree.numberLeafNodes());
        System.out.printf("Tree Height : %d\n", tree.height());
    }

    /**
     * This method reads the dictionary and constructs the BST to be
     * used for the spell checking.
     */
    public static BinarySearchTree<String> readDictionary() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();


        return tree;
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public int compareTo(HuffmanNode node) {
        return frequency - node.frequency;
    }
}

public class HuffmanCoding {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the string to compress:");
            String inputString = sc.nextLine();
            System.out.println("Enter the output file path:");
            String outputPath = sc.nextLine();
            int[] frequencies = new int[256];

            for (char c : inputString.toCharArray()) {
                frequencies[c]++;
            }

            PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();

            for (int i = 0; i < frequencies.length; i++) {
                if (frequencies[i] > 0) {
                    priorityQueue.offer(new HuffmanNode((char) i, frequencies[i]));
                }
            }

            while (priorityQueue.size() > 1) {
                HuffmanNode left = priorityQueue.poll();
                HuffmanNode right = priorityQueue.poll();
                HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
                parent.left = left;
                parent.right = right;
                priorityQueue.offer(parent);
            }

            HuffmanNode root = priorityQueue.peek();
            String[] codes = new String[256];
            generateCodes(root, "", codes);

            StringBuilder compressedString = new StringBuilder();
            for (char c : inputString.toCharArray()) {
                compressedString.append(codes[c]);
            }

            System.out.println("Original String: " + inputString);
            System.out.println("Compressed String: " + compressedString.toString());

            try (PrintWriter writer = new PrintWriter(new File(outputPath))) {
                writer.print(compressedString.toString());
            } catch (FileNotFoundException e) {
                System.err.println("Error: Output file not found!");
            }
        }
    }

    private static void generateCodes(HuffmanNode node, String code, String[] codes) {
        if (node.left == null && node.right == null) {
            codes[node.data] = code;
        } else {
            generateCodes(node.left, code + "0", codes);
            generateCodes(node.right, code + "1", codes);
        }
    }
}

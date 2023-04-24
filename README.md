# Huffman Data Compressor

This is a Java program that implements Huffman Coding Algorithm to compress input data.

## Usage

1. Clone the repository or download the `HuffmanCoding.java` file.
2. Compile the code using `javac HuffmanCoding.java`.
3. Run the code using `java HuffmanCoding`.
4. Enter the string to compress when prompted.
5. Enter the output file path to store the compressed string when prompted.

The compressed data will be stored in the specified output file path.

## How it works

1. The program prompts the user to input a string to compress and the output file path to store the compressed string.
2. The program counts the frequency of each character in the input string.
3. The program creates a Huffman tree based on the character frequencies.
4. The program generates binary codes for each character using the Huffman tree.
5. The program compresses the input string using the binary codes.
6. The program outputs the original string and the compressed string to the console.
7. The program stores the compressed string in the specified output file path.

## Internal Working

The program works by first counting the frequency of each character in the input string and creating a priority queue of Huffman nodes for each character with non-zero frequency. Then, the program repeatedly removes the two lowest frequency nodes from the queue, combines them to create a new parent node, and adds the parent node to the queue. This process continues until only one node remains in the queue, which is the root of the Huffman tree.

Next, the program traverses the Huffman tree to generate a Huffman code for each character. A Huffman code is a binary code assigned to each character such that no code is a prefix of another code. The Huffman code for a character is simply the sequence of binary digits representing the path from the root to the leaf node containing that character.

Finally, the program compresses the input string by replacing each character with its Huffman code, resulting in a compressed string that uses fewer bits than the original string. The compressed string is then saved to a file specified by the user.


## Example

```
Enter the string to compress:
hello world
Enter the output file path:
compressed.txt
Original String: hello world
Compressed String: 0100101111110111010011011010111001111
```

## References
Huffman coding - Wikipedia: https://en.wikipedia.org/wiki/Huffman_coding<br>
PriorityQueue - Oracle Java Documentation: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/PriorityQueue.html<br>
Scanner - Oracle Java Documentation: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html<br>
PrintWriter - Oracle Java Documentation: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/PrintWriter.html<br>
Geeks4Geeks- https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/

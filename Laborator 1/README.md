1. Compulsory (1p)
   
Write a Java application that implements the following operations:
Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)
Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
Generate a random integer n: int n = (int) (Math.random() * 1_000_000);
Compute the result obtained after performing the following calculations:
  multiply n by 3;
  add the binary number 10101 to the result;
  add the hexadecimal number FF to the result;
  multiply the result by 6;
Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.
Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].

2. Homework (2p)

Let n be an integer given as a command line argument. Validate the argument!
Create a n x n Latin Square as a matrix, having as symbols numbers from 1 to n.
For each line, and each column of the matrix, create and display on the screen String objects representing the concatenation of the symbols in the respective line or column.
For larger n display ONLY the running time of the application in nanoseconds or milliseconds. Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.
Launch the application from the command line, for example: java Lab1 9.

3. Bonus (2p)
Create the adjacency matrix A of a cycle graph Cn and compute the powers A2, A3, .... An. Give an interpretation of the result.
Create the adjacency matrix of a regular graph. The number of vertices and the vertex degree are given as arguments.

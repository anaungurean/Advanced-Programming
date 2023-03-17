import static java.lang.Math.floor;
public class Main {
    static boolean checkIntegerArgument (double a)
    {
        return floor(a) == a;
    }
    static boolean checkNumberOfArguments(String[] args)
    {
        return args.length >= 1;
    }
    static void checkArgument(String[] args)
    {
        if (checkNumberOfArguments(args)) {
            double a = Double.parseDouble(args[0]);
            if (!checkIntegerArgument(a)) {
                System.out.println("Invalid integer argument!");
                System.exit(-1);
            }}
        else
        {       System.out.println("Not enough arguments!");
                System.exit(-1);
        }

     }
    static void createLatinSquare(int [][] matrix, int size)
    {
          for(int i=0;i<size;i++) {
              for (int j = 0; j < size; j++) {
                  matrix[i][j] = (i+j) % size +1;
              }
          }
    }
    static void displayStringConcatenationForEachLine(int [][] matrix, int size, boolean toBeDisplayed)
    {
        for(int i=0;i<size;i++) {
            StringBuilder concatenationOfSymbols = new StringBuilder();
            for (int j = 0; j < size; j++) {
                String symbol = Integer.toString(matrix[i][j]);
                concatenationOfSymbols.append(symbol);
            }
            if(toBeDisplayed)
                 System.out.printf("Line %d %S \n", i, concatenationOfSymbols);
        }
    }

    static void displayStringConcatenationForEachColumn(int [][] matrix, int size, boolean toBeDisplayed)
    {
        for(int j=0;j<size;j++) {
             StringBuilder concatenationOfSymbols = new StringBuilder();
            for (int i = 0; i < size; i++) {
                concatenationOfSymbols.append(matrix[i][j]);
            }
            if(toBeDisplayed)
                System.out.printf("Column %d %S \n",j, concatenationOfSymbols);
        }
    }

    static void displayStringConcatenation(int [][] matrix, int size, boolean toBeDisplayed)
    {

        displayStringConcatenationForEachLine(matrix,size, toBeDisplayed);
        displayStringConcatenationForEachColumn(matrix,size, toBeDisplayed);

    }

    public static void main (String[] args)
    {
            long startTime = System.nanoTime();
            checkArgument(args);
            int size= Integer.parseInt(args[0]);
            int [][] matrix = new int[size][size];
            createLatinSquare(matrix,size);
            if(size < 30000)
            displayStringConcatenation(matrix,size,true);
            else{
            displayStringConcatenation(matrix,size,false);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("The running time of the application:  " + duration + " nanoseconds");}

        }

    }

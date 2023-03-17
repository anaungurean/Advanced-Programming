public class Main {
   public static int numVertices;
   public static int[][] adjacencyMatrix;
   public static int[][] powerMatrix;
   public static int [][] previousPowerMatrix;

    static void createAdjacencyMatrix()
  {
      adjacencyMatrix = new int[numVertices][numVertices];
      for (int i=0;i<numVertices;i++)
          for(int j=0;j<numVertices;j++)
          { if(j== (i+1) % numVertices ||  j == (i+numVertices-1) % numVertices )
              adjacencyMatrix[i][j]=1;
             else
                 adjacencyMatrix[i][j]=0;
           }
  }


  static void matrixMultiply()
  {
      powerMatrix = new int[numVertices][numVertices];
      for(int i=0;i<numVertices;i++)
          for(int j=0;j<numVertices;j++)
              powerMatrix[i][j]=0;

        for(int i=0; i<numVertices;i++)
            for(int j=0 ; j<numVertices;j++)
                for(int k=0; k<numVertices;k++)
                    powerMatrix[i][j] += adjacencyMatrix[i][k]*previousPowerMatrix[k][j];

  }
  static void displayAdjacencyMatrix()
  {
      for (int i=0;i<numVertices;i++)
      { for(int j=0;j<numVertices;j++)
              System.out.printf("%d ", adjacencyMatrix[i][j]);
          System.out.print("\n");

      }

  }
    static void displayPowerMatrix()
    {
        for (int i=0;i<numVertices;i++)
        { for(int j=0;j<numVertices;j++)
            System.out.printf("%d ", powerMatrix[i][j]);
            System.out.print("\n");
        }

    }

    static void copyMatrix(int[][] a, int [][] b)
    {
        for(int i=0; i< a.length;i++)
            for(int j=0; j<a.length;j++)
                a[i][j]=b[i][j];
    }
  static void computeThePowers() {

      previousPowerMatrix = new int [numVertices][numVertices];
      copyMatrix(previousPowerMatrix,adjacencyMatrix);

      for (int i = 2; i <= numVertices; i++)
      {
          matrixMultiply();
          System.out.printf("Power: %d \n", i);
          displayPowerMatrix();
          copyMatrix(previousPowerMatrix,powerMatrix);

      }
  }
    public static void main(String[] args) {

        numVertices = Integer.parseInt(args[0]);
        createAdjacencyMatrix();
        displayAdjacencyMatrix();
        computeThePowers();
    }
}

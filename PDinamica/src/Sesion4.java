public class Sesion4 {
    public static int coste(int[] adn1, int[] adn2, int a, int b, int[][] m){ // sin optimizar
        if (adn1.length < adn2.length){
            int[][] minCost = new int[adn2.length+1][adn1.length+1];
            for (int i = 0; i <= adn1.length; i++) minCost[0][i] = i*a;
            for (int i = 1; i <= adn2.length; i++) minCost[i][0] = i*b;
            for (int i = 1; i <= adn2.length; i++){
                for (int j = 1; j <= adn1.length; j++){

                }
            }
        }




        int[][] minCost = new int[adn1.length][adn2.length+1];
        minCost[0][0] = a;
        for (int i = 1; i <= adn2.length; i++){
            if (adn1[0] == adn2[i-1]) minCost[0][i] = 0;
            else minCost[0][i] = minCost[0][i-1] + Math.min(a,Math.min(b,m[adn1[0]][adn2[i-1]]));
        }
        for (int i = 1; i < adn1.length; i++) minCost[i][0] = a;
        for (int i = 1; i < adn1.length; i++){
            for (int j = 1; j <= adn2.length; j++){
                if (adn1[i] == adn2[j-1]) minCost[i][j] = minCost[i-1][j-1];
                else minCost[i][j] = Math.min(a,Math.min(b,m[adn1[i]][adn2[j-1]])) +
                        Math.min(minCost[i][j-1],Math.min(minCost[i-1][j-1],minCost[i-1][j]));
            }
        }

        for (int i = 0; i < minCost.length; i++){
            for (int j = 0; j < minCost[i].length; j++){
                System.out.print(minCost[i][j] + "("+j+")\t");
            }
            System.out.println();
        }

        return minCost[adn1.length-1][adn2.length];
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {0,1,2,2},
                {2,0,1,2},
                {2,1,0,3},
                {3,1,2,0}
        };
        int[] adn1 = new int[]{0,1,2,1,3,1,2,1,0};
        int[] adn2 = new int[]{0,1,1,1,3,1,2,0};
        System.out.println(coste(adn1,adn2,1,2,m));
    }
}

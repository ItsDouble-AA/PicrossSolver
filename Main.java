import java.util.Arrays;
import java.util.*;
public class Main{
    static int[][] grid;
    static int width;
    static int[][] rowNums;
    static int[][] colNums;
    public static void main(String[] args){
        System.out.println("PICROSS SOLVER");
        PicrossRowSolver prs = new PicrossRowSolver();
        Scanner sc = new Scanner(System.in);
        println("WIDTH");
        width = sc.nextInt();
        grid = new int[width][width];
        println("ENTER ROWS");
        rowNums = new int[width][width];
        colNums = new int[width][width];
        for(int i = 0;i<width;i++){
            String ans = sc.nextLine();
            rowNums[width] = Arrays.stream(ans.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        println("ENTER COLUMNS");      
        for(int i = 0;i<width;i++){
            String ans = sc.nextLine();
            colNums[width] = Arrays.stream(ans.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        

        /*
         *         int[] intArray = Arrays.stream(stringArray)
                               .mapToInt(Integer::parseInt)
                               .toArray();
         * 
         * 
         */
        
    }
    public static int[] getRow(int i){
        return grid[i];
    }
    public static void setRow(int index, int[] row){
        for(int i = 0;i<width;i++){

            grid[index][i]=row[i];
            
            
        }
    }
    public static int[] getCol(int index){
        int[] col = new int[width];
        for(int i = 0;i<width;i++){
            col[i]=grid[i][index];
        }
        return col;
    }
    public static void setCol(int index, int[] col){
        for(int i = 0;i<width;i++){

            grid[i][index]=col[i];
            
        }
    }
    public static void println(String s){
        System.out.println(s);
    }
}

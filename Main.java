import java.util.*;
public class Main{

    static int width;
    static int[][] rowNums;
    static int[][] colNums;
    public static void main(String[] args){
        System.out.println("PICROSS SOLVER");
        PicrossRowSolver prs = new PicrossRowSolver();
        Scanner sc = new Scanner(System.in);
        println("WIDTH");
        width = sc.nextInt();
        int[][]grid = new int[width][width];
        for(int i = 0;i<width;i++){
            for(int j = 0;j<width;j++){
                grid[i][j]=-1;
            }
        }
        //printPicross(grid);
        println("ENTER ROWS");
        rowNums = new int[width][width];
        colNums = new int[width][width];
        sc.nextLine();
        for(int i = 0;i<width;i++){
            String ans = sc.nextLine();
            rowNums[i] = Arrays.stream(ans.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        println("ENTER COLUMNS");      
        for(int i = 0;i<width;i++){
            String ans = sc.nextLine();
            colNums[i] = Arrays.stream(ans.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        println("ROWS");
        printGrid(rowNums);
        println("COLUMNS");
        printGrid(colNums);
        for(int loop = 0;loop<100;loop++){
            for(int i = 0;i<rowNums.length;i++){
                int[] rowTemp = prs.solveRow(rowNums[i], getRow(i,grid), width);
                setRow(i,rowTemp,grid);
            }
            for(int i = 0;i<colNums.length;i++){
                int[] colTemp = prs.solveRow(colNums[i], getCol(i,grid), width);
                setCol(i,colTemp,grid);
            }
            if(isSolved(grid)){
                break;
            }
        }
        System.out.println();
        printPicross(grid);
        System.out.println();
        
        /*
         *         int[] intArray = Arrays.stream(stringArray)
                               .mapToInt(Integer::parseInt)
                               .toArray();
         * 
         * 
         */
        sc.close();
    }
    public static boolean isSolved(int[][] grid){
        for(int[] row : grid){
            for(int i : row){
                if(i==-1){
                    return false;
                }
            }
        }
        return true;
    }
    public static void printGrid(int[][] grid){
        for(int[] row : grid){
            printArray(row);
        }
        System.out.println();
    }
    public static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i+", ");
        }
        System.out.println();
    }
    public static void printPicross(int[][] grid){
        for(int[] row : grid){
            printRow(row);
        }
    }
    public static  void printRow(int[] row){
        for(int i : row){
            if(i == 0){
                System.out.print(ConsoleColors.WHITE_BACKGROUND+"■");
            }
            if(i == 1){
                System.out.print(ConsoleColors.GREEN_BACKGROUND+"■");
            }
            if(i == -1){
                System.out.print(ConsoleColors.RED_BACKGROUND+"■");
            }
            
        }
        System.out.println(ConsoleColors.RESET);
    }
    public static int[] getRow(int i,int[][] grid){
        return grid[i];
    }
    public static void setRow(int index, int[] row,int[][] grid){
        for(int i = 0;i<width;i++){

            grid[index][i]=row[i];
            
            
        }
    }
    public static int[] getCol(int index,int[][] grid){
        int[] col = new int[width];
        for(int i = 0;i<width;i++){
            col[i]=grid[i][index];
        }
        return col;
    }
    public static void setCol(int index, int[] col,int[][] grid){
        for(int i = 0;i<width;i++){

            grid[i][index]=col[i];
            
        }
    }
    public static void println(String s){
        System.out.println(s);
    }
}

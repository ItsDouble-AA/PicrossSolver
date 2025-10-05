
import java.util.*;
public class Main{
    static int[][] grid;
    static int width;
    public static void main(String[] args){
        System.out.println("PICROSS SOLVER");
        PicrossRowSolver prs = new PicrossRowSolver();
        Scanner sc = new Scanner(System.in);
        println("WIDTH");
        width = sc.nextInt();
        grid = new int[width][width];
        println("ENTER ROWS");
        
    }
    public static int[] getRow(int i){
        return grid[i];
    }
    public static void println(String s){
        System.out.println(s);
    }
}

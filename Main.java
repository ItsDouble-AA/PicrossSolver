public class Main{
    public static void main(String[] args){
        System.out.println("PICROSS SOLVER");
        PicrossRowSolver prs = new PicrossRowSolver();
        prs.solveRow(new int[]{2,1,1},new int[]{-1,-1,-1,1,-1,-1,-1,-1,-1,-1});
    }
}

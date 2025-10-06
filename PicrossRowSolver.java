import java.util.*;
public class PicrossRowSolver{
    public PicrossRowSolver(){

    }
    public int[] solveRow(int[] numArr, int[] match,int width){
        if(numArr.length==1 && numArr[0]==0){
            return new int[width];
        }
        if(isMatchFull(match)){
            return match;
        }
        int[] answer = ListToArray(getConsistent(removeUnMatched(removeDuplicates(fillRows(getMinimum(numArr), width)), match)));
        //printRow(answer);
        return answer;

    }
    private boolean isMatchFull(int[] match){
        for(int i : match){
            if(i==-1){
                return false;
            }
        }
        return true;
    }
    private ArrayList<ArrayList<Integer>> removeUnMatched(ArrayList<ArrayList<Integer>> rows, int[] match){
        for(int i = rows.size()-1;i>=0;i--){
            if(!isMatch(rows.get(i), match)){
                rows.remove(i);
            }
        }
        return rows;
    }
    private boolean isMatch(ArrayList<Integer> row, int[] match){
        for(int i = 0;i<match.length;i++){
            if(match[i]==-1){

            }else
            if(match[i]!=row.get(i)){
                return false;
            }
        }
        return true;
    }
    private ArrayList<Integer> getConsistent(ArrayList<ArrayList<Integer>> rows){
        int[] arr = new int[rows.get(0).size()];
        for(int i = 0;i<rows.get(0).size();i++){
            int check = rows.get(0).get(i);
            for(int row = 0;row<rows.size();row++){
                if(check==rows.get(row).get(i)){

                }else{
                    arr[i]=-1;
                }
            }
            if(arr[i]!=-1){
                arr[i]=check;
            }
        }
        return ArrayToList(arr);
    }
    private ArrayList<ArrayList<Integer>> fillRows(ArrayList<Integer> row, int maxLength){
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        if(row.size()>=maxLength){
            rows.add(row);
            return rows;
        }
        for(int i = 0;i<=row.size();i++){
            ArrayList<Integer> rowTemp = new ArrayList<>();
            for(int j : row){
                rowTemp.add(j);
            }
            if(i==0&&row.get(i)==1){
                rowTemp.add(0,0);
                rows.addAll(fillRows(rowTemp, maxLength));
            }else
            if(i==row.size()){
                rowTemp.add(i,0);
                rows.addAll(fillRows(rowTemp, maxLength));
            }else
            if(row.get(i)==1 && row.get(i-1)==0){
                rowTemp.add(i,0);
                rows.addAll(fillRows(rowTemp, maxLength));
            }
        }
        return rows;
    }
    private ArrayList<ArrayList<Integer>> removeDuplicates(ArrayList<ArrayList<Integer>> list) {
        Set<String> seen = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for (ArrayList<Integer> subList : list) {
            String key = subList.toString();  // Convert list to string to use it as key in HashSet
            if (!seen.contains(key)) {
                result.add(new ArrayList<>(subList));  // Add to result if not seen
                seen.add(key);  // Mark this list as seen
            }
        }
        
        return result;  // Return the new ArrayList without duplicates
    }
    private ArrayList<Integer> mergeLists(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> c = new ArrayList<>();
        for(int i : a){
            c.add(i);
        }
        for(int i : b){
            c.add(i);
        }
        return c;
    }
    private ArrayList<Integer> getMinimum(int[] numArr){
        ArrayList<Integer> row = new ArrayList<>();
        for(int i : numArr){
            for(int k = 0;k<i;k++){
                row.add(1);
            }
            row.add(0);
        }
        row.remove(row.size()-1);
        return row;
    }
    private void printRows(ArrayList<ArrayList<Integer>> rows){
        for(ArrayList a : rows){
            printRow(a);
        }
    }
    private void printRow(ArrayList<Integer> list){
        printRow(ListToArray(list));
    }
    private void printRow(int[] row){
        for(int i : row){
            if(i == 0){
                System.out.print(ConsoleColors.WHITE_BACKGROUND+i);
            }
            if(i == 1){
                System.out.print(ConsoleColors.GREEN_BACKGROUND+i);
            }
            if(i == -1){
                System.out.print(ConsoleColors.RED_BACKGROUND+i);
            }
            
        }
        System.out.println(ConsoleColors.RESET);
    }
    private ArrayList<Integer> ArrayToList(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr){
            list.add(i);
        }
        return list;
    }
    private int[] ListToArray(ArrayList<Integer> list){
        int[] arr = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}
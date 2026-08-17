public class Main2b {
    public static void main(String[] args){
        int[] marks = {80, 90, 70};

        for(int i=0;i<=marks.length;i++){ // This line causes the exception to trigger | Corrected Code:- for(int i=0;i<marks.length;i++){ 
            System.out.println(marks[i]);
        }
    }
}

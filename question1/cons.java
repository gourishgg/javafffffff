public class cons {
    int[][] marks;
    public cons(int[][] marks) {
        this.marks = marks;
      
    }
    public void displaymarks(){
for (int[] studentMarks : marks) {
    for (int mark : studentMarks) {
        System.out.print(mark + " ");
    }
    System.out.println();
}
}
    public void calculatetotal(int studentindex){
   int total = 0;
   for(int j=0;j<marks[studentindex].length;j++){
       total += marks[studentindex][j];
   }
    System.out.println("Total marks for student " + studentindex + ": " + total);
}
    public void findToper(){
    int max = 0;
    int toper = 0;
    for(int i=0;i<marks.length;i++){
        int total = 0;
        for(int j=0;j<marks[i].length;j++){
            total += marks[i][j];
        }
        if(total > max){
            max = total;
            toper = i+1; // Assuming student index starts from 1 for display purposes
        }
    }
    System.out.println("Topper is student " + toper + " with total marks: " + max); 
    }
}

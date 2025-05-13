import java.util.ArrayList;

public class SpecialIndex {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> pfEven = new ArrayList<Integer>();

        pfEven.add(A.get(0));
        for(int i = 1; i < n; i++){
            if(i % 2 == 0){
                pfEven.add(pfEven.get(i - 1) + A.get(i));
            } else {
                pfEven.add(pfEven.get(i - 1));
            }
        }
        ArrayList<Integer> pfOdd = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                pfOdd.add(0);
            } else if (i % 2 != 0) {
                pfOdd.add(pfOdd.get(i - 1) + A.get(i));
            } else {
                pfOdd.add(pfOdd.get(i - 1));
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            int EvenSum = 0;
            int OddSum = 0;

            if(i == 0){
                EvenSum = pfOdd.get(n - 1) - pfOdd.get(i);
                OddSum = pfEven.get(n - 1) - pfOdd.get(i);
            } else {
                EvenSum = pfEven.get(i - 1) + pfOdd.get(n - 1) -pfOdd.get(i);
                OddSum = pfOdd.get(i - 1) + pfEven.get(n - 1) - pfEven.get(i);
            }
            if(EvenSum == OddSum){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
    }
}

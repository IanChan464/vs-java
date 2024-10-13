import java.util.*;

public class cuttingout {
    static Scanner in;
    
    public static void main(String[] args) {
        in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] list = new int[200001];
        int[] ref = new int[200001];
        int c = 0;

        for (int i = 0; i < n; i++) {
            c = in.nextInt();
            list[c]++;
            ref[c]++;
        }

        int[] sol = new int[k];
        int val = 0;

        for (int j = 0; j < k; j++) {

            int max = 0;
            for (int i = 1; i < 200001; i++) {
                if (max < list[i]) {
                    max = list[i];
                    val = i;
                }

            }
            
            sol[j] = val;
            list[val] = ref[val]/((ref[val]/list[val]) + 1);
            

        }
        for (int i = 0; i < sol.length; i++) {
            System.out.print(sol[i] + " ");
        }
    }
}

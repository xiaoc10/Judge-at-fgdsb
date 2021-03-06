package tests;
import java.util.*;
import java.lang.*;
import java.io.*;
import judge.*;
import datastruct.*;

public class tree_vertical_traversal {
    public static int num_test = 120;
    public static TreeNode[] in_0;
    public static TreeNode[] in_org_0;
    public static int[][][] out;


    public static void load_test() {
        File fil = new File("judge/tests/tree-vertical-traversal.txt");
        FileReader inputFil = null;
        try {
            inputFil = new FileReader(fil);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(inputFil);
        try {
            in_0 = common.read_tree_array(in);
            in_org_0 = test_common.copy(in_0);
            out = common.read_int_matrix_arr(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void judge() {
        load_test();
        common.capture_stdout();
        Solution s = new Solution();

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < num_test; ++i) {
            System.out.printf("Testing case #%d\n", i+1);
            List<Integer> answer = s.vertical_traversal(in_0[i]);
            if(!common.compare_arr_arraylist(out[i], answer)) {
                common.release_stdout();
                System.out.printf("%d / %d;", i+1, num_test);
                String outs = common.to_string(tree_vertical_traversal.in_org_0[i]);
                System.out.print(outs + ";");
                System.out.print(common.to_string(answer) + ";");
                System.out.println(common.to_string(out[i]));
                return;
            }
        }

        common.release_stdout();
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Accepted;");
        System.out.println(estimatedTime);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // List<List<Integer>> answers = new ArrayList<>();
        // Set<List<Integer>> ansSet = new HashSet<>();
        // for(int i = 0;i < nums.length;i++){
        //     if(i == 0 || nums[i] > nums[i-1]){
        //         for(int j = i+1;j < nums.length;j++){
        //             for(int k = nums.length-1;k > j ;k--){
        //                 if(nums[i] + nums[j]==-nums[k]){
        //                     // Collections.sort(ans);
        //                     ansSet.add(Arrays.asList(nums[i],nums[j],nums[k]));
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(ansSet);

        final List<List<Integer>> answers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (left < right) {

                    final int a = nums[i];
                    final int b = nums[left];
                    final int c = nums[right];

                    if (a + b == -c) {
                        answers.add(Arrays.asList(b, a, c));
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        right--;
                    } else if (b + c < -a) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

        }
        return answers;
    }
}

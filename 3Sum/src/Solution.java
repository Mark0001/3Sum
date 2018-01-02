import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        long time1, time2;
        time1 = System.currentTimeMillis();
        Arrays.sort(nums);
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
        time2 = System.currentTimeMillis();
        System.out.println("執行時間：" + (time2 - time1) / 1000 + "秒");
        return answers;
    }

    public List<List<Integer>> threeSumO3(int[] nums) {
        long time1, time2;
        time1 = System.currentTimeMillis();
        Arrays.sort(nums);
        final Set<List<Integer>> ansSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = nums.length - 1; k > j; k--) {
                        if (nums[i] + nums[j] == -nums[k]) {
                            ansSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            break;
                        }
                    }
                }
            }
        }
        time2 = System.currentTimeMillis();
        System.out.println("執行時間：" + (time2 - time1) / 1000 + "秒");
        return new ArrayList<>(ansSet);
    }
}

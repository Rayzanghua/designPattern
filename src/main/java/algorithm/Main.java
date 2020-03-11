package algorithm;

import java.math.BigDecimal;
import java.util.*;

public class Main {


    public static void main(String[] args) {

//        System.out.println(getResult(100));
//        System.out.println(getResult1(3, 2));



        int[] arr={1,2,5,2};

        System.out.println(findRepeatNumber(arr));
    }

        public static int findRepeatNumber(int[] nums) {
            int result=nums.length+1;
            for(int i=0;i<nums.length;i++){
                int item=result^nums[i];
                if(item==result && i>0){
                    return nums[i];
                }
            }
            return 0;
        }

    private static int getMinChargeIml(int totalMoney, int[] moneyArr) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<moneyArr.length;i++){
            list.add(moneyArr[i]);
        }
        Collections.sort(list);
        return getMinCharge(totalMoney, list);
    }

    /**
     * 最少换钱数
     * moneyArr 排好序的
     */
    private static int getMinCharge(int totalMoney, List<Integer> moneyArr) {
        if (moneyArr.size() == 1) {
            return totalMoney % moneyArr.get(0) == 0 ? totalMoney / moneyArr.get(0) : -1;
        }
        for (int i = 0; i * moneyArr.get(0) < totalMoney; i++) {
            int minCharge = getMinCharge(totalMoney - i * moneyArr.get(0), moneyArr.subList(1, moneyArr.size()));
            if (minCharge != -1) {
                return minCharge + i;
            }
        }
        return -1;
    }

    private static Map<String, BigDecimal> wdMap = new HashMap<>();

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     * f(w,d)=f(w-1,d)+f(w,d-1) f(1,d)=1 f(w,1)=1
     *
     * @Param width 宽度
     * @Param deep 深度
     * @Return 路径总数
     */
    private static BigDecimal getResult1(int width, int deep) {
        if (width == 1 || deep == 1) {
            return BigDecimal.ONE;
        }
        String key = width + "&" + deep;
        if (wdMap.containsKey(key)) {
            return wdMap.get(key);
        }
        BigDecimal result = getResult1(width - 1, deep).add(getResult1(width, deep - 1));
        wdMap.put(key, result);
        return result;
    }

    private static Map<Integer, BigDecimal> levelMap = new HashMap<>();

    /**
     * 青蛙跳台阶
     * 问题描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * f(n)=f(n-1)+f(n-2)
     * f(0)=1 f(1)=1 f(2)=2 ...
     *
     * @Param level 台阶数
     * @Return 跳法
     */
    private static BigDecimal getResult(int level) {
        if (level <= 1) {
            return BigDecimal.ONE;
        }
        if (levelMap.containsKey(level)) {
            return levelMap.get(level);
        }
        BigDecimal result = getResult(level - 1).add(getResult(level - 2));
        levelMap.put(level, result);
        return result;
    }
}

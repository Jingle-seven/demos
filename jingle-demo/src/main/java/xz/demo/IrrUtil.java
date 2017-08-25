package xz.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinhua on 2017/8/24 14:19.
 * 实现金融irr算法,实际效果有待检验
 */
public class IrrUtil {
    
    /**
     * @param cashFlow 资金流
     * @return 收益率
     * @desc 使用方法参考main方法
     */
    public static double irr1(List<Double> cashFlow) {
        /**迭代次数*/
        int loopNum = 1000;
        /**最小差异*/
        final double minDif = 0.00000001;
        double flowOut = cashFlow.get(0);
        double minValue = 0d;
        double maxValue = 1d;
        double testValue = 0d;
        while (loopNum > 0) {
            testValue = (minValue + maxValue) / 2;
            double npv = npv1(cashFlow, testValue);
            if (Math.abs(flowOut + npv) < minDif) {
                break;
            } else if (Math.abs(flowOut) > npv) {
                maxValue = testValue;
            } else {
                minValue = testValue;
            }
            loopNum--;
        }
        return testValue;
    }
    
    public static double npv1(List<Double> flowInArr, double rate) {
        double npv = 0;
        for (int i = 1; i < flowInArr.size(); i++) {
            npv += flowInArr.get(i) / Math.pow(1 + rate, i);
        }
        return npv;
    }
    
    public static void main(String[] args) {
        double flowOut = -5144;
        List<Double> flowInArr = new ArrayList<>();
        flowInArr.add(flowOut);
        for (int i = 0; i < 10; i++) {
            flowInArr.add(560d);
        }
        System.out.println(flowInArr.size());
        System.out.println(IrrUtil.irr1(flowInArr) * 100);
    }
}

package xz.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinhua on 2017/8/24 14:19.
 * 实现金融irr算法,实际效果有待检验
 */
public class IrrUtil {
    
    /**
     * @desc 使用方法参考main方法
     * @param cashFlow  资金流
     * @return 收益率
     */
    public static double irr1(List<Double> cashFlow){
        /**迭代次数*/
        int LOOPNUM=1000;
        /**最小差异*/
        final double MINDIF=0.00000001;
        double flowOut=cashFlow.get(0);
        double minValue=0d;
        double maxValue=1d;
        double testValue=0d;
        while(LOOPNUM>0){
            testValue=(minValue+maxValue)/2;
            double npv= npv1(cashFlow,testValue);
            if(Math.abs(flowOut+npv)<MINDIF){
                break;
            }else if(Math.abs(flowOut)>npv){
                maxValue=testValue;
            }else{
                minValue=testValue;
            }
            LOOPNUM--;
        }
        return testValue;
    }
    
    public static double npv1(List<Double> flowInArr, double rate){
        double npv=0;
        for(int i=1;i<flowInArr.size();i++){
            npv+=flowInArr.get(i)/Math.pow(1+rate, i);
        }
        return npv;
    }
    
    public static void main(String[] args) {
        double flowOut=-5144;
        List<Double> flowInArr=new ArrayList<>();
        flowInArr.add(flowOut);
        for (int i = 0; i < 10; i++) {
            flowInArr.add(560d);
        }
        
        System.out.println(IrrUtil.irr1(flowInArr)*100);
    }
}

package Utils;

import entity.KNNLength;
import entity.KNNModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * KNN 算法的实现
 */
public class CalKNN {

    public  String calKNN(List<KNNModel> knnModels, KNNModel knnModel,Integer num) throws Exception {
        System.out.println("计算距离");
        List<KNNLength> lengths = calDistince(knnModels, knnModel);
        System.out.println("距离排序");
        List<KNNLength> lengths1 = sortList(lengths);
        System.out.println("输入评判标准");
        String result = getResult(lengths1, num);
        return result;
    }
    /**
     * 计算距离
     *
     * @param knnModelList
     * @param knnModel
     */
    private static List<KNNLength> calDistince(List<KNNModel> knnModelList, KNNModel knnModel) {
       List<KNNLength> lengths = new ArrayList<>();
        for (KNNModel model : knnModelList) {
            KNNLength knnLength = new KNNLength();
            List<Double> list = model.getList();
            List<Double> knnModelOfList = knnModel.getList();
            Double flag = 0d;
            new KNNLength();
            for(int i = 0;i<knnModelOfList.size();i++){
                flag += (list.get(i)-knnModelOfList.get(i))*(list.get(i)-knnModelOfList.get(i));
            }
            knnLength.setType(model.getType());
            knnLength.setLength(Math.sqrt(flag));
            lengths.add(knnLength);
        }
        return lengths;
    }

    /**
     * 距离排序(采用简单冒泡排序 可变)
     */
    private static List<KNNLength> sortList(List<KNNLength> knnLengths){
        for(int i=0;i<knnLengths.size();i++){
            for(int j=0;j<knnLengths.size()-i-1;j++){
                KNNLength kl = new KNNLength();
                if(knnLengths.get(i).getLength()>knnLengths.get(j).getLength()){
                    kl=knnLengths.get(i);
                    knnLengths.set(i,knnLengths.get(j));
                    knnLengths.set(j,kl);
                }
            }
        }
        return knnLengths;
    }

    /**
     * 根据评判数统计结果
     */
    private static String getResult(List<KNNLength> knnLengths,Integer num) throws Exception {
        //假设类型为A,B,C三种
        if(knnLengths.size()<num) throw new Exception("基本数据不足！");
        int a =0;
        int b=0;
        int c=0;
        for(int i = 0;i<num;i++){
            switch (knnLengths.get(i).getType()){
                case "A":
                    a++;break;
                case"B":
                    b++;break;
                case "C":
                    c++;break;
            }
        }
        if(a>b&&a>c){
            return "A";
        }else if(b>a&&b>c){
            return "B";
        }else return "C";
    }
}

import Utils.CalKNN;
import entity.KNNModel;

import java.util.ArrayList;
import java.util.List;

public class KNN {
    public static void main(String[] args) throws Exception {
        //输入已存在数据
        List<KNNModel> knnModels = new ArrayList<>();
        //输入判断数据
        KNNModel knnModel = new KNNModel();
        //取多少值判断
        int num = 3;
        String s = new CalKNN().calKNN(knnModels, knnModel, num);
        System.out.println("该数值可能为： "+ s);
    }
}

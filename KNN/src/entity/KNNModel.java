package entity;

import java.util.List;

/**
 * 模型对象
 * list 对象属性
 * type 对象类型
 */
public class KNNModel {
    private List<Double> list;
    private String type;

    public List<Double> getList() {
        return list;
    }

    public void setList(List<Double> list) {
        this.list = list;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

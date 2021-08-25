package top.xinsin.list;

import top.xinsin.util.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * 创建学生类集合
 */
public class StudentName implements Serializable {
    private static final long serialVersionUID = 5955141326133509608L;
    public static final ArrayList<Student> List = new ArrayList<>();
    private final Random random = new Random();

    public StudentName() {

    }

    /**
     * 遍历集合中的元素
     */
    public void get(){
        for(Object obj:List){
            System.out.println(obj);
        }
    }

    /**
     * 提供随机方法
     * @return 返回被随机到的元素
     */
    public String call(){
        try {
            int value = random.nextInt(List.size());
            Object studentName = List.get(value);
            String str = ((Student) studentName).getName();
            List.remove(value);
            return str;
        }catch (IllegalArgumentException e){
            return "null";
        }
    }
}

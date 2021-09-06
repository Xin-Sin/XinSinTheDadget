package top.xinsin.util;

import top.xinsin.util.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * 创建学生类集合
 */
public class StudentName implements Serializable {
    private static final long serialVersionUID = 5955141326133509608L;
    public final ArrayList<Student> list = new ArrayList<>();
    private final Random random = new Random();
    private static StudentName studentName;
    private StringBuilder stringBuilder = new StringBuilder();

    private StudentName() {

    }

    public static StudentName getInstance(){
        if (studentName == null){
            studentName = new StudentName();
        }
        return studentName;
    }
    /**
     * 遍历集合中的元素
     */
    public StringBuilder get(){
        stringBuilder.setLength(0);
        for(Student obj:list){
            stringBuilder.append(obj + "\n");
        }
        return stringBuilder;
    }

    /**
     * 提供随机方法
     * @return 返回被随机到的元素
     */
    public String call(){
        try {
            int value = random.nextInt(list.size());
            Object studentName = list.get(value);
            String str = ((Student) studentName).getName();
            list.remove(value);
            return str;
        }catch (IllegalArgumentException e){
            return "null";
        }
    }

    @Override
    public String toString() {
        return "StudentName{" +
                "list=" + list +
                ", random=" + random +
                ", stringBuilder=" + stringBuilder +
                '}';
    }
}

package cn.webliu.sort;

public class Student implements Comparable<Student> {

    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    // 定义compareTo方法，调用年龄比较
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }
}

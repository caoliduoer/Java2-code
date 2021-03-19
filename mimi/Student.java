package Try.mimi;

public class Student {
    private String name;//学生姓名
    private int grade;//年级
    private Course[] selectCourse;//选课数组
    public  Student(String name,int grade,Course[] selectCourse){//构造方法
        this.grade=grade;
        this.name=name;
        this.selectCourse=selectCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Course[] getSelectCourse() {
        return selectCourse;
    }

    public void setSelectCourse(Course[] selectCourse) {
        this.selectCourse = selectCourse;
    }

    public  void showMessage(){
        System.out.println("学生姓名："+this.name);
        System.out.println("年   级："+this.grade);

         System.out.println("所选课程 ");
        for(int i=0;i<this.selectCourse.length;i++){
            System.out.println("课程："+selectCourse[i].name+"      学分"+selectCourse[i].score);

        }
        System.out.println("总学分："+getHours());
    }
    public int getHours(){
        int sumScore=0;//总学分
        for(int i=0;i<this.selectCourse.length;i++){
            sumScore+=selectCourse[i].score;
        }
        return sumScore;
    }
}

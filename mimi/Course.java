package Try.mimi;

public class Course {
    String name;//课程名
    int score;//学分

    public Course(String name, int score) {//构造方法
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}

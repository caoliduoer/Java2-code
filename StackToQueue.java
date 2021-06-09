import java.util.Stack;

public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        if(stack2.isEmpty()){


            while(!stack1.isEmpty()){
                int temp=stack1.pop();
                stack2.push(temp);
            }

        }
        int a=stack2.pop();
        return a;
    }

    public static void main(String[] args) {

    }
}

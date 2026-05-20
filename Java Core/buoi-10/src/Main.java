import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //ngăn xếp
        Stack<String> stack = new Stack<>();
        stack.push("c");
        stack.push("b");
        stack.push("a");

        stack.pop();// xóa phần tử trên cùng
        for(String s:stack){
            System.out.println(s);
        }
    }
}
import java.util.*;

public class Test2{
  
  public static void main(String[] args){
    StringTokenizer st = FileTokenizer.read("prog0.txt");
    //MAKE SURE YOU HAVE THIS FILE SAVED TO THE APPROPRIATE LOCATION^^^
    SimpleFunction func = new SimpleFunction(st);
    
    StackADT<Integer> stack = new LinkedStack<Integer>();
    stack.push(56);
    stack.push(34);
    stack.push(12);
    func.eval(stack);
    System.out.println(stack.pop());
  }

}
import java.util.ArrayDeque;

class Solution {



    public static void main(String[] args)
    {
        MyStack s = new MyStack();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
    }

    private static class MyStack {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Integer minimumElement;

        public void push(int data) {
            if(stack.isEmpty()) {
                stack.push(data);
                minimumElement = data;
            } else if(data < minimumElement){
                stack.push((data<< 1) - minimumElement);
                minimumElement = data;
            }else{
                stack.push(data);
            }
        }
        public void peek(){
            if(stack.isEmpty()){
                System.out.println("Stack is empty");
                return;
            }

            Integer currentElement = stack.peek();
            if(currentElement < minimumElement){
                System.out.println("Minimum element:"+ minimumElement);
            }else{
                System.out.println("Minimum element:"+ currentElement);
            }
        }

        public void getMin(){
            if(stack.isEmpty()){
                System.out.println("Stack is empty, no minimum element");
            }
            else{
                System.out.println("Minimum element:"+ minimumElement);
            };
        }
        public void pop(){
            if(stack.isEmpty()){
                System.out.println("No element present");
                return;
            }
            Integer currentElement = stack.pop();
            if(currentElement < minimumElement){
                System.out.println(minimumElement);
                minimumElement = (minimumElement << 1) - currentElement;
            } else{
                System.out.println(currentElement);
            }
        }
    }
}

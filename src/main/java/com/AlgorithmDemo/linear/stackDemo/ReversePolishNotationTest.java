package com.AlgorithmDemo.linear.stackDemo;
/*逆波兰表达式*/
public class ReversePolishNotationTest {
    public static void main(String[] args) {

        //中缀表达式 3*（17-15）+18/6 的逆波兰表达式如下 6+3=9
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = caculate(notation);
        System.out.println("逆波兰表达式的结果为：" + result);
    }

    public static int caculate(String[] notation){
        Stack<Integer> oprands = new Stack<>();
        for (int i = 0; i < notation.length; i++) {
            String current = notation[i];
            Integer o1;
            Integer o2;
            Integer result;
            switch (current){
                case "+":
                    o1= oprands.pop();;
                    o2=oprands.pop();
                    result = o2+o1;
                    oprands.push(result);
                    break;
                case "-":
                    o1= oprands.pop();;
                    o2=oprands.pop();
                    result = o2-o1;
                    oprands.push(result);
                    break;
                case "*":
                    o1= oprands.pop();;
                    o2=oprands.pop();
                    result = o2*o1;
                    oprands.push(result);
                    break;
                case "/":
                    o1= oprands.pop();;
                    o2=oprands.pop();
                    result = o2/o1;
                    oprands.push(result);
                    break;
                default:
                    oprands.push(Integer.parseInt(current));
                    break;
            }
        }
        int result = oprands.pop();
        return  result;
    }

}

package com.AlgorithmDemo.linear.stackDemo;

public class BracketsMatchTest {
    public static void main(String[] args) {
        String str = "上海((长安)())";
        boolean match = isMatch(str);
        System.out.println(str+"中的括号是否匹配："+match);
    }

    public static boolean isMatch(String string){
        /*1.创建栈对象用来存储左括号，2、将左括号加入到栈中
        * 3.如果出现右括号则将栈内左括号排出
        * 4.最后检查栈内还有没有剩余的左括号*/
        Stack<String> chars = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            String curentStr = string.charAt(i)+ "";
            if (curentStr.equals("(")) {
                chars.push(curentStr);
            } else if (curentStr.equals(")")) {
                String pop = chars.pop();
                if (pop == null){
                    return false;
                }
            }

        }

        if (chars.size()==0){
            return true;
        }else{
            return false;
        }
    }
}

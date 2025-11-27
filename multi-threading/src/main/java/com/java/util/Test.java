package com.java.util;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String i = "{{{[{[[]]]}}}";
        Stack<Character> stack = new Stack<>();
        for(Character c:i.toCharArray()) {
            if(c.equals('{') || c.equals('[') || c.equals('(')) {
                stack.push(c);
            } else {
                if(c.equals('}') || c.equals(')') || c.equals(']')) {
                    Character temp = stack.peek();
                    if((c.equals('}') && !temp.equals('{')) || (c.equals(')') && !temp.equals('('))
                    || (c.equals(']') && !temp.equals('['))) {
                        System.out.println("Not balanced");
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                System.out.println("balanced");
            }
        }

    }
}

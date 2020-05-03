package com.hfm.collection.list.vector.stack;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        // 入栈
		stack.push("String");
		stack.push("String");
		stack.push("String");
		stack.push("String");
		stack.push("String");
		stack.push("String");
		stack.push("String");
		stack.push("String");
		System.out.println(stack);

		// 获取栈顶 元素
		Object peek = stack.peek();
		System.out.println(peek);
		System.out.println(stack);

		// 出栈
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);

		stack.empty();
		System.out.println(stack);
    }

    public void testPush() throws Exception {
        LinkedListStack stack = new LinkedListStack();
        System.out.println("栈是否为空: " + stack.isEmpty());
        stack.push("shixin");
        stack.push("好帅");
        stack.push("技巧一流");
        stack.push("haha");
        System.out.println("栈中元素: " + stack);
        System.out.println("获取顶端元素 peek :" + stack.peek());
        System.out.println("顶端元素出栈 pop :" + stack.pop());
        System.out.println("出栈后栈内元素:" + stack);
        System.out.println("search(好帅) 的位置:" + stack.search("好帅"));
    }
}

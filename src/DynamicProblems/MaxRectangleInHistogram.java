package DynamicProblems;

import java.util.Arrays;
import java.util.Stack;

public class MaxRectangleInHistogram {

    public static void main(String args[]) {
        String inputStr = "1 2 1 0 1 1 1 0 2 1 2 1";
        int[] histogram = Arrays.stream(inputStr.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("The maximum area in histogram is: " + maxRectArea(histogram));
    }

    public static int maxRectArea(int[] histogram) {
        final Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;
        int top;
        while (index < histogram.length) {
            if (stack.isEmpty() || histogram[stack.peek()] <= histogram[index]) {
                stack.push(index++);
            } else {
                top = stack.pop();
                int newArea;
                if (stack.empty()) {
                    newArea = histogram[top] * (index);
                } else {
                    newArea = histogram[top] * (index - stack.peek() - 1);
                }
                maxArea = (newArea >= maxArea) ? newArea : maxArea;
            }
        }
        while (!stack.isEmpty()) {
            top = stack.pop();
            int newArea;
            if (stack.empty()) {
                newArea = histogram[top] * (index);
            } else {
                newArea = histogram[top] * (index - stack.peek() - 1);
            }
            maxArea = (newArea >= maxArea) ? newArea : maxArea;
        }
        return maxArea;
    }
}


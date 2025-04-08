
import java.util.Stack;

//Leetcode-735;
public class AsteroidCollegion {

    public static void main(String[] args) {
        int asteroid[] = {10, 2, -5, 4, -10, 20, 30, -40, 40};
        int ans[] = asteroidCollision(asteroid);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            //if stack is empty or a positive value arrives then perform blind insertions
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    if (top < 0) {
                        stack.push(asteroids[i]);
                        break;
                    }
                    int modval = Math.abs(asteroids[i]);
                    if (modval == top) {
                        stack.pop();
                        break;
                    } else if (modval < top) {
                        break;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }

        int len = stack.size();
        int ansarray[] = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            ansarray[i] = stack.pop();
        }
        return ansarray;
    }
}

// We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.
// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
// Example 1:
// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

// Leetcode 42: 接雨水

// 方法：单调栈（内部递减）

// 思路：单调栈是一个stack，这个stack里面会呈现一种顺序，要么递增，要么递减，这个时候就要判断下一个值是否打破了这个规律，
//      如果是的话，就用while把stack中比这个值大或者小的数pop出来，直到while循环失效。

//      在这道题目里面，我们用单调栈接雨水，我们要保证单调栈的内部递减，一旦遇到一个比之前高的block，以及stack里面至少有两个高度的时候，就可以判断这边形成了一个可以接雨水的坑，中间的那个高度
//      就是stack的pop出来的值，假如这个时候stack里面是空的就说明里面的形成不了坑，这个高度是那个坑，然后这个坑左边的这个值left，是stack.peek()的值，然后雨水的深度取决于height[i]和left
//      这个值中比较矮的那个。坑的长度就是当前循环的i的值减去top下标值再减1。面积就是Math.min(height[i],height[left])-height[top],所以面积就是长乘宽。

class Solution {
    public int trap(int[] height) {
        Stack<Integer>contain = new Stack();
        int sum = 0;
        int last_height = 0;
        for(int i = 0; i < height.length; i++){
            //System.out.println("height[i]: "+height[i]);
            while(!contain.isEmpty() && height[i]>height[contain.peek()]){
                int top = contain.pop();
                if(contain.isEmpty()){
                    break;
                }
                int left = contain.peek();
                int length = i - left - 1;
                sum += length * (Math.min(height[i],height[left])-height[top]);
                //System.out.println("sum: "+sum);
            }
            contain.push(i);
            //last_height = contain.peek();
        }
        return sum;
    }
}

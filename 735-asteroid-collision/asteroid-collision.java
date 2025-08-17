class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        boolean isSameSize = false;
        for(int i = 0; i < n; i++){
            isSameSize = false;
            while(!stack.isEmpty() && (stack.peek() > 0 && asteroids[i] < 0)){
                if(Math.abs(asteroids[i]) > stack.peek()){
                    stack.pop();
                    continue;
                }else if(Math.abs(asteroids[i]) == stack.peek()){
                    stack.pop();
                }
                isSameSize = true;
                break;
            }
            if(!isSameSize){
                stack.push(asteroids[i]);
            } 
        }
        int[] result = new int[stack.size()];
        for(int i = stack.size()-1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
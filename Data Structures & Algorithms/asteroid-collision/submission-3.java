class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int ast:asteroids){
            boolean alive =true;

            while(!stack.isEmpty() && ast<0 && stack.peek()>0){
                if(Math.abs(ast)>stack.peek()){
                    stack.pop();
                    continue;
                }else if(Math.abs(ast)==stack.peek()){
                    stack.pop();
                }
                alive=false;
                break;
            }
            if(alive){
                stack.push(ast);
            }
        }
        int[] res = new int[stack.size()];
        for(int i=res.length-1;i>=0;i--){
            res[i]=stack.pop();
        }
        return res;
    }
}
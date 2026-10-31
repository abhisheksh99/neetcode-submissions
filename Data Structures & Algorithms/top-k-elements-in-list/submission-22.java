class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        Queue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));

        for(int n:map.keySet()){
            queue.add(n);
            if(queue.size()>k){
                queue.poll();
            }
        }

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=queue.poll();
        }

        return ans;
        
    }
}

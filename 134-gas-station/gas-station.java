class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalFuel = 0;
        int currFuel = 0;
        int startIndex = 0;

        for(int i = 0; i < n; i++){
            int diff = gas[i] - cost[i];
            totalFuel = totalFuel + diff;
            currFuel = currFuel + diff;
            if(currFuel < 0){
                startIndex = i + 1;
                currFuel = 0;
            }
        }
        return totalFuel >= 0 ? startIndex : -1;
    }
}
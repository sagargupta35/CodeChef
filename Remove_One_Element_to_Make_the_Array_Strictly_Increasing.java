class Solution {
    public boolean canBeIncreasing(int[] arr) {
        int i = 1, j, n = arr.length;
        while(i < n && arr[i] > arr[i-1]) i++;
        if(i >= n-1) return true;
        j = i-1;
        // checking if jth element is wrong
        boolean flag1 = false, flag2 = false;
        if((j > 0 && arr[i] > arr[j-1]) || j == 0){
            flag1 = true;
            for(int k = i+1; k<n; k++){
                if(arr[k] <= arr[k-1]){
                    flag1 = false;
                    break;
                }
            }
        }
        //checking if ith element is wrong
        if(arr[j] < arr[i+1]){
            flag2 = true;
            for(int k = i+1; k<n; k++){
                if(arr[k] <= arr[k-1]){
                    flag2 = false;
                    break;
                }
            }
        }
        return flag1 || flag2;
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        int temp1 = 0;
        int temp2 = 0;
        temp1 = x;
        
        while(temp1>0){
            int rem = temp1%10; 
            temp2 = (temp2*10)+rem;
            temp1/=10;
        }

        if(temp2 == x){
            return true;
        }
        else{
            return false;
        }
    }
}
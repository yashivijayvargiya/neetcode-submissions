class Solution {
    public int calPoints(String[] operations) {
        int totalResult = 0;
        Stack<Integer> st = new Stack<>();
        for(int index=0; index<operations.length;index++){
            String number = operations[index];
            if(number.equals("+")){
                int var1 = st.pop();
                int var2 = st.pop();
                int sum = var1+var2;
                st.push(var2);
                st.push(var1);
                st.push(sum); 

            }else if (number.equals("C")){
                st.pop();

            }else if (number.equals("D")){
                st.push(2*st.peek());
                
            }
            else{
                st.push(Integer.parseInt(number));
            }
        }
        while(st.size()>0){
            totalResult+=st.pop();
        }
        return totalResult;
    }
}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, top = 0;
        int right = m - 1, down = n - 1;
        List<Integer> list = new ArrayList<>();
        
        while(top <= down && left <= right){
            for(int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= down; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(top <= down){
                for(int i = right; i >= left; i--){
                    list.add(matrix[down][i]);
                }
                down--;
            }
            if(left <= right){
                for(int i = down; i >= top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
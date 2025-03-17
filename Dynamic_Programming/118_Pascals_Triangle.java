class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                list.add(1);
            }
            for(int j = 1; j < i; j++){
                list.set(j, ls.get(i - 1).get(j) + ls.get(i - 1).get(j - 1));
            }
            ls.add(list);
        }
        return ls;
    }
}
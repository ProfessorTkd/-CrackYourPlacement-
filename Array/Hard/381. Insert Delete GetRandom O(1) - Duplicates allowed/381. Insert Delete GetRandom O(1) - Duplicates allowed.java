// # Same like Leetcode 380, just that ki ab duplicates hai to hume hashmap ke andar ek
// # list maintain karni padegi same value ke indexes ki.

// The order of statements must be as below in the remove function:

// 1. Removing the delete index.
// 2. Then adding the new index of the swapped value.
// 3. Removing the old index of the swapped value.

// If not, the following test case will fail :

// # Test case where when removing 4, the val and last value is 4.
// # For first iteration, the value of didx will be 0. Now dry run.
// ["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","remove"]
// [[],[4],[3],[4],[2],[4],[4],[3],[4],[4]]

// # Test case where 0 is the last value, 0 is the value, 0 is the last index
// # and 0 is the delete index.
// ["RandomizedCollection","insert","remove","insert","remove","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom"]
// [[],[0],[0],[-1],[0],[],[],[],[],[],[],[],[],[],[]]

// // didx is the removed or delete index.

// map.get(val).remove(didx);
// map.get(lastValue).add(didx);
// map.get(lastValue).remove(lidx);

// Time complexity : O(N) 
// with NNN being the number of operations. 
// All of our operations are O(1)O(1)O(1), giving N∗O(1)=O(N)N * O(1) = O(N)N∗O(1)=O(N).

// // Space complexity : O(N)
//   with NNN being the number of operations. 
//   The worst case scenario is if we get NNN add operations, in which case our ArrayList and our HashMap grow to size NNN.


    class RandomizedCollection {
        private ArrayList<Integer> list;
        private HashMap<Integer, HashSet<Integer>> map;
        private Random rand;
        public RandomizedCollection() {
            list = new ArrayList<>();
            map = new HashMap<>();
            rand = new Random();
        }
        public boolean insert(int val) {
            list.add(val);
            if (!map.containsKey(val))
                map.put(val, new HashSet<>());
            map.get(val).add(list.size() - 1);
            return map.get(val).size() == 1;
        }
        public boolean remove(int val) {
            if (!map.containsKey(val) || map.get(val).size() == 0) {
                return false;
            }
            int lidx = list.size() - 1; // last index
            int didx = map.get(val).iterator().next(); // delete index
            map.get(val).remove(didx);
            int lastValue = list.get(lidx);
            list.set(didx, lastValue);
            // The order of adding first and then removing should be as mentioned below due
            // to the 0 test case mentioned above.
            map.get(lastValue).add(didx);
            map.get(lastValue).remove(lidx);
            list.remove(lidx);
            return true;
        }
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }

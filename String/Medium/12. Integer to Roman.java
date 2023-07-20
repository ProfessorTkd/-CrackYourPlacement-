class Solution {

    public String intToRoman(int num) {

        TreeMap<Integer, String> intToRoman = new TreeMap<>();

        intToRoman.put(1, "I");
        intToRoman.put(4, "IV");
        intToRoman.put(5, "V");
        intToRoman.put(9, "IX");
        intToRoman.put(10, "X");
        intToRoman.put(40, "XL");
        intToRoman.put(50, "L");
        intToRoman.put(90, "XC");
        intToRoman.put(100, "C");
        intToRoman.put(400, "CD");
        intToRoman.put(500, "D");
        intToRoman.put(900, "CM");
        intToRoman.put(1000, "M");

        String str = "";
        while(num > 0){
            Integer passKey =  intToRoman.floorKey(num); // O(1)
            str += intToRoman.get(passKey);
            num = num - passKey;
        }
        return str;

    }
}

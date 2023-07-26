// I found the similar template solution on these three 3 problems:
// Basic Calculator : The expression string may contain open ( and closing parentheses ), the + , - operators, non-negative integers and empty spaces .
// Basic Calculator II : The expression string contains only non-negative integers, +, -, *, / operators
// Basic Calculator III : The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces

// Solution for Basic Calculator
class Solution {
    // Time O(N) Space O(N) for recursive or stack
    int i = 0;
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int tmp = 0, sign = 1, result = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                tmp = tmp * 10 + c - '0';
            } else if (c == '(') {
                tmp = calculate(s);
            } else if (c == ')') {
                break;
            } else if (c == '+' || c == '-') {
                result += sign * tmp;
                tmp = 0;
                sign = (c == '+')? 1 : -1;
            }
        }
        result += sign * tmp;
        return result;
    }
}
  
// Solution for Basic Calculator II
class Solution {        // 3 + 2 * 5
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int num = 0, tmp = 0, res = 0;
        char op = '+';
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                tmp = tmp*10 + c - '0';
            } else if (c != ' ') {
	//process the numerical value of string so far; based on what 'op' we have before it
                num = cal(num, tmp, op);
                if (c == '+' || c == '-') {
                    res += num;
                    num = 0;
                }
				// reset
                tmp = 0;
                op = c;
            }
        }
        return res + cal(num, tmp, op);
    }
    private int cal(int num, int tmp, char op) {
        if (op == '+') return num + tmp;
        else if (op == '-') return num - tmp;
        else if (op == '*') return num * tmp;
        else    return num / tmp;
    }
}


// Solution for Basic Calculator III
class Solution {
    // recursive Time and Space O(N)
    int i = 0;
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int result = 0, tmp = 0, num = 0;
        char op = '+';
        
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                tmp = tmp * 10 + c - '0';
            } else if (c == '(') {
                tmp = calculate(s);     // string parse index is tracked by i
            } else if (c == ')') {
                break;
            } else if (c != ' ') {
 //process the numerical value of string so far; based on what 'op' we have before it
                num = cal(num, tmp, op);
                if (c == '+' || c == '-') {
                    result += num;
                    num = 0;
                }
                //reset 'tmp' and op for next character  processing
                tmp = 0;
                op = c;
            }
        }
        return result + cal(num, tmp, op);
    }
    private int cal(int num, int tmp, char op) {
        if (op == '+') return num + tmp;
        else if (op == '-') return num - tmp;
        else if (op == '*') return num * tmp;
        else return num / tmp;
    }
}

public class Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s.toLowerCase()));
        boolean status = recursivePalindrome(0, s.length() - 1, s.toLowerCase());
        System.out.println(status);
    }

    private static boolean recursivePalindrome(int left, int right, String s) {
        if(left >= right) {
            return true;
        }
        char l = s.charAt(left);
        char r = s.charAt(right);

        if(!isAlphaNumeric(l)) {
            left++;
        } else if (!isAlphaNumeric(r)) {
            right--;
        } else {
            if(l != r) {
                return false;
            }
            left++;
            right--;
        }
        return recursivePalindrome(left, right, s);
    }

    private static boolean isAlphaNumeric(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9';
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if(!isAlphaNumeric(l)) left++;
            else if(!isAlphaNumeric(r)) right--;
            else {
                if(l != r) return false;
                left++;
                right--;
            }
        }
        return true;
    }
}

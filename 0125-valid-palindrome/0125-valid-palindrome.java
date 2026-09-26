class Solution {
    public boolean isPalindrome(String s) {
      s = s.trim().toLowerCase().replaceAll("[^a-z0-9]", "");   // ^ = Not Symbol

        String original = s;
        String reverse = "";

        for(int i = original.length() - 1; i >= 0; i--) {

            char ch = original.charAt(i);

            reverse = reverse + ch;
        }

        if(original.equals(reverse)) {
            return true;
        }

        return false;
    }
    }

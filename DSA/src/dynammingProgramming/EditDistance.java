package dynammingProgramming;



public class EditDistance {

    public static int editDistance(String s1, String s2) {
        if (s1.length() == 0) {
            return s2.length();
        }
        if (s2.length() == 0) {
            return s1.length();
        }

        int ans1 = 1 + editDistance(s1.substring(1), s2);
        int ans2 = 1 + editDistance(s1, s2.substring(1));
        int ans3 = (s1.charAt(0) == s2.charAt(0)) ? editDistance(s1.substring(1), s2.substring(1)) : 1 + editDistance(s1.substring(1), s2.substring(1));

        return Math.min(ans1, Math.min(ans2, ans3));
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "llo";
        System.out.println(editDistance(s1, s2));
    }
}


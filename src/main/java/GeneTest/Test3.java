package GeneTest;

public class Test3 {
    //输入字符串a,b,c,d,a,b
    //输出任意字符子串
    public static void main(String[] args) {
         lengthOfLongestSubstring("asdfasdfsd");
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            System.out.println(item);
        }
        return 0;
    }
}

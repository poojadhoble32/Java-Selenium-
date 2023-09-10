package main;

public class Test {

	public static void main(String[] args) {
		String main ="abcabcbb";
		int high = 0;
        String temp = "";

        for (int i = 0; i < main.length(); i++)
        {
            char c = main.charAt(i);
            System.out.println("i: "+i+" "+c);
                if (temp.contains(String.valueOf(c)))
                {
                    high = Math.max(high , temp.length());
                    int index = temp.indexOf(c);
                    temp = temp.substring(index+1);
                    System.out.println("in if: "+temp);
                }
                temp += c;
                System.out.println("after if: "+temp);
                System.out.println("----------------------------------------");
        }
            high = Math.max(high , temp.length());
            System.out.println("temp: "+temp);
	}
}
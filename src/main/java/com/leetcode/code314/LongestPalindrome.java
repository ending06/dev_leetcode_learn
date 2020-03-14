package com.leetcode.code314;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-13<p>
// -------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

/*    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        List<Character> finalList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            List<Character> tempList = new ArrayList<>();
            tempList.add(s.charAt(i));

            boolean isFind = isPalindRome(tempList);

            if (isFind && tempList.size() > finalList.size()) {
                finalList.clear();
                finalList.addAll(tempList);
            }
            for (int j = i + 1; j < s.length(); j++) {

                tempList.add(s.charAt(j));
                boolean isSubFind = isPalindRome(tempList);

                if (isSubFind && tempList.size() > finalList.size()) {
                    finalList.clear();
                    finalList.addAll(tempList);
                }
            }

        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : finalList) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }*/

    private static String longestPalindrome(String s) {
        String finalResult = "";
        int max = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String tempString = s.substring(i,j);
                boolean isFind = isPalindRome(tempString);
                if(isFind&&tempString.length()>max){
                    finalResult = tempString;
                    max = tempString.length();
                }
            }
        }

        return finalResult;
    }

    private static boolean isPalindRome(String tempString) {

        for (int i = 0; i <tempString.length()/2; i++) {
            if (tempString.charAt(i)!=(tempString.charAt(tempString.length() - i - 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //String aa = "babad";
        String aa = "ac";
        // String aa = "abb";
        // String aa =
        // "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
        // String aa =
        // "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa";
        String result = longestPalindrome(aa);
        System.out.println("===>" + result);
    }
}
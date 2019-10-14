package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.CharUtils.unicodeEscaped;

public class RegexTest1 {

    public static void main(String[] args) {

        //String value = convertToUnicodeChars("()");
        //System.out.println(value);
        //findMatch(" ) ");
        String columnValue = "[]{}";
        System.out.println(convertToUnicodeChars__(columnValue));

        //String str = "-32.768";
        //System.out.println(isNumeric(str));
    }

    private static boolean isNumeric(String str) {

        return str.contains("[^0-9]");
       //return NumberUtils.isNumber(str);
    }


    static String convertToUnicodeChars__(String columnVal) {
        if (columnVal != null && !columnVal.isEmpty()) {
            Pattern p = Pattern.compile("[^a-zA-Z0-9]");
            Matcher m = p.matcher(columnVal);
            while (m.find()) {
                String s = m.group();
                columnVal = columnVal.replace(s,unicodeEscaped(s.charAt(0)));
            }
        }
        return columnVal;
    }

    private static String convertToUnicodeChars_(String columnVal) {

        if(columnVal!=null && !columnVal.isEmpty()) {
            Pattern p = Pattern.compile("[\\{\\}\\,]");
            Matcher m = p.matcher(columnVal);
            while (m.find()) {
                String s = m.group();
                columnVal = columnVal.replace(s, unicodeEscaped(s.charAt(0)));
            }
        }
        return columnVal;
    }




    private static void findMatch(String str) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        Matcher m = p.matcher(str);

        if(m.find()){
            System.out.println("Able to find match");
        }
    }



    static String convertToUnicodeChars(String b){
        StringBuilder sb=new StringBuilder();
        if(b!=null && !b.isEmpty()) {
            Pattern p = Pattern.compile("[^a-zA-Z0-9]");
            if(p.matcher(b).find())
            {
                for (char c : b.toCharArray()) {
                    if(p.matcher(String.valueOf(c)).find()) {
                        sb.append(unicodeEscaped(c));
                    }
                    else {
                        sb.append(c);
                    }
                }
            }
            else{
                sb.append(b);
            }
        }
        b=sb.toString();
        return b;
    }
}

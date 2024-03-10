import java.util.*;
import java.util.stream.IntStream;

public class odev {
    public static void main(String[] args) {

        // 1) Java Program to Find the First Non-repeated Character in a String

        String s = "asafosman";
        String tekrarsiz = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch)==s.lastIndexOf(ch)){
                tekrarsiz+= ch;
            }
        }
        System.out.println(tekrarsiz.charAt(0));

        System.out.println("-*-*-*-**--*-*-**-*-*-*-*--*-**-*--*-*-*-*-*-*");

        /*2)  Java Program to Check Palindrome String
        Verilen String ifadenin palindrome olup olmadığını kontrol eden kod yazınız
        */
        // String s = "asafosman";
        String reversed = ""; // ters cevrilmis olani bunun icinde saklayacagiz

        int n = s.length() - 1; // son index'i alip n degiskenine yükledik

        while (n >= 0) {  // n > -1 de olur
            reversed = reversed + s.charAt(n);
            n--;

        }
        System.out.println(reversed); //namsofasa
        if (reversed==s){
            System.out.println("Palindorme dir");
        }else {
            System.out.println("Palindorme degildir");
        }
        System.out.println("-*-*-*-**--*-*-**-*-*-*-*--*-**-*--*-*-*-*-*-*");


        /*  3)  Java Program to Find Duplicate Characters in a String
             Verilen String içinde tekrar eden karakterleri ve tekrer sayısını veren bir kod yazınız*/
        String[] harfler = s.split("");
        HashMap<String , Integer> myMap = new HashMap<>();
        for (String w : harfler){

            Integer harf = myMap.get(w);
            if (harf == null){
                myMap.put(w,1);
            }else {
                myMap.put(w,harf+1);
            }
        }
        System.out.println(myMap);

        System.out.println("-*-*-*-**--*-*-**-*-*-*-*--*-**-*--*-*-*-*-*-*");



        /*  4- Java Program to Find Duplicate Words in a String
         Verilen bir string cümle içinde tekrar eden kelimeleri ve bu kelimelerin sayısını veren kod yazınız*/
        String cumle = "Asaf Osman Dilmac 100 :)";
        String[] kelimeler = cumle.replaceAll("\\p{Punct}","").replaceAll("\\d","").split(" ");
        HashMap<String , Integer> kelimeMap= new HashMap<>();
        for (String w : kelimeler){
            Integer kelime = kelimeMap.get(w);
            if (kelime==null){
                kelimeMap.put(w,1);
            }else {
                kelimeMap.put(w,kelime+1);
            }
        }
        System.out.println(kelimeMap);

        System.out.println("-*-*-*-**--*-*-**-*-*-*-*--*-**-*--*-*-*-*-*-*");

        //  5) Java Program to Find All the Permutations of a String
        //  Girilen String bir ifadenin harfleri yer değiştirilerek
        //  oluşturulabilecek anlamlı anlamsız bütün kelimeleri alt alta gösteren bir program yazınız

        //ChatGPT

        String str = "asaf";
        System.out.println("String ifadenin tüm permütasyonları:");
        Set<String> permutations = getPermutations(str);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
    public static Set<String> getPermutations(String str) {
        Set<String> permutations = new HashSet<>();
        if (str == null || str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char firstChar = str.charAt(0);
        String remainder = str.substring(1);
        Set<String> words = getPermutations(remainder);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                permutations.add(prefix + firstChar + suffix);
            }
        }
        return permutations;
    }
}



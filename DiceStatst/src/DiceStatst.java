import java.util.Scanner;

public class DiceStatst {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("input a String!");
        String word = input.next();
        int countVowels = 0;
        int countCon = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == 'a' || word.charAt(i) == 'A' || word.charAt(i) == 'e'
                    || word.charAt(i) == 'E' || word.charAt(i) == 'i' || word.charAt(i) == 'I' ||
            word.charAt(i) == 'o' || word.charAt(i) == 'O' || word.charAt(i) == 'u' || word.charAt(i) == 'U'){
                countVowels++;
            }
            else if((word.charAt(i) >= 'a' && word.charAt(i) <= 'z') ||word.charAt(i) >= 'A' &&
                    word.charAt(i) <= 'Z'){
                countCon++;
            }
        }
        int characters = (word.length() - ( countCon + countVowels));
        System.out.println("characters count: " + characters);
        System.out.println("Vowels count: " + countVowels);
        System.out.println("consonants count: " + countCon);


    }
}




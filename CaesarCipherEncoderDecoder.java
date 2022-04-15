package CaesarCipher;

import java.util.*;

public class CaesarCipherEncoderDecoder{
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final List<Character> alphabetList = new LinkedList<>();
    private static final Character[] uniques = new Character[]
            {',', '.', ' ', ':', ';', '?', '!', '(', ')', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '\'', '\"', '-',
             '$', '#', '@', '*', '_', '>', '<', '^', '&', '+', '/', '\\', '%', '№', '`', '~'};
    private static final List<Character> uniquesList = Arrays.asList(uniques);
    private static boolean isRepeat;

    public static void main(String[] args){
        fillAlphabetList();

        while(true){
            List<String> options = new LinkedList<>();
            options.add("encoder");
            options.add("decoder");

            if(! isRepeat)
                System.out.print("Enter the option: Encoder/Decoder: ");

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            if(! options.contains(option.toLowerCase())){
                System.out.print("Undefined option. Type option again: ");
                isRepeat = true;
                continue;
            }
            work(option);
        }
    }

    public static void work(String option){
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        System.out.print("Enter the index: ");
        int index = scanner.nextInt();

        System.out.println("Enter the text: ");
        Scanner scanner1 = new Scanner(System.in);
        String text = scanner1.nextLine();
        char[] textToCharArray = text.toCharArray();

        for(char c : textToCharArray){
            if(uniquesList.contains(c)){
                stringBuilder.append(c);
                continue;
            }

            boolean isUpperCased = ! alphabetList.contains(c);

            int futureIndex;
            if(option.equalsIgnoreCase("encoder")){
                futureIndex = alphabetList.indexOf(Character.toLowerCase(c))+index;
                if(futureIndex > 25)
                    futureIndex -= 25;
            }else{
                futureIndex = alphabetList.indexOf(Character.toLowerCase(c))-index;
                if(futureIndex < 0)
                    futureIndex += 25;
            }

            if(isUpperCased){
                stringBuilder.append(String.valueOf(alphabetList.get(futureIndex)).toUpperCase());
            }else{
                stringBuilder.append(alphabetList.get(futureIndex));
            }
        }
        System.out.println("Translation: "+stringBuilder+"\n");
        isRepeat = false;
    }

    public static void fillAlphabetList(){
        for(char c : alphabet){
            alphabetList.add(c);
        }
    }
}

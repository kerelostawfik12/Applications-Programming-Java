public class NumberToWords {
    public static void main(String[] args) {
        String[] numbers = { "zero" , "one" , "two" , "three" , "four" , "five" , "six" , "seven", "eight" , "nine" , "ten" ,
                "eleven" , "twelve" , "thirteen" , "fourteen" , "fifteen" , "sixteen" , "seventeen" , "eighteen" , "nineteen"};
        String[] tens = {"", "", "twenty" , "thirty" , "forty" , "fifty" , "sixty" , "seventy" , "eighty" , "ninety"};
        System.out.print("Number: ");
        int x = In.nextInt();
        while (x != -1){
            if (x < 100 && x >= 20) { // for x between 0 and 99 and above 19 so you don't get that "twenty zero" error
                if (x % 10 != 0) {
                    System.out.println(tens[x / 10] + " " +  numbers[x % 10]);
                }
                else {
                    if (x % 10 == 0)
                        System.out.println(tens[x / 10]);
                }
            }
            else {
                if(x < 20)
                    System.out.println(numbers[x]);
            }
            if(x>=100 && x%10 != 0 && x/10%10 != 0 && x %10 != 0) { // if x is greater than or equal to 100 and if the last number is not equal to 0
                System.out.println(numbers[x / 100] + " hundred and " + tens [x/10 % 10] + " " + numbers[x % 10]);
            }

            else {
                if (x>=100 && x%10 ==  0 && x/10%10 == 0) // if x is greater than or equal to 100 and if the last number is equal to 0 and the middle number = 0
                    System.out.println(numbers[x/100] + " hundred");
            }
            if (x>= 100 && x%10 == 0 && x/10%10 != 0) //220 case
                System.out.println(numbers[x/100] + " hundred and " + tens[x/10 % 10]);
            if (x>= 100 && x%10 != 0 && x/10%10 == 0) //203
                System.out.println(numbers[x/100] + " hundred and " + numbers[x%10]);
            //make statement for cases such as 220
            // make statement for cases such as 203

            System.out.print("Number: "); // next number, separate them from loop brackets
            x = In.nextInt();

        }
    }

}



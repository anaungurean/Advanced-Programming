public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] languages =  {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"} ;
        int n = (int) (Math.random() * 1_000_000);
        int result=0;
        System.out.println(n);
        result = (n * 3 + 0b10101 + 0XFF) * 6 ;
        System.out.println(result);

        while(result>9)
        {
            int sum=0;
            while(result>0)
            {
                sum+=result%10;
                result/=10;
            }
            result=sum;
        }
        System.out.println(result);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);

    }

}
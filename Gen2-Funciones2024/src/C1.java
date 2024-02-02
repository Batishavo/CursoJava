public class C1 {
    public static void main(String[] args) {
        System.out.println(suma(6,9));
        System.out.println(resta(6,9));
        System.out.println(mul(6,9));
        System.out.println(div(6,9));
    }
    static int suma(int a,int b){
        return a + b;
    }
    static  int resta(int a,int b){
        return a-b;
    }
    static  int mul(int a,int b){
        return a*b;
    }
    static int div(int a,int b){
        return a/b;
    }
}

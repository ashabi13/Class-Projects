public class findPI{
    public static void main(String[] args){
        int PI = 0;
        for(d=1; d<14; d+=2){
            PI+=(1/d);
        }
        PI*=4;
        System.out.println(PI);
    }
}
public class findPI{
    public static void main(String[] args){
        double PI = 0;
        boolean add = true;
        for(int d=1; d<14; d+=2){
            if(add){
                PI+=(1.0/d);
                add=false;
            }
            else{
                PI-=(1.0/d);
                add=true;
            }
        }
        PI*=4;
        System.out.println(PI);
    }
}
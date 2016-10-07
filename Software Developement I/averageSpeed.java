public class averageSpeed{
    public static void main(String[] args){
        //runnersMPH or miles per hour was calculated based on the question posed
       	double miles = 24;
       	double hours = 1;
        double minutes = 40;
        double seconds = 35;
        double runnersMPH = miles/(hours + (minutes/60)+(seconds/360));
        double runnersKPH = runnersMPH*1.6;
        System.out.println(runnersKPH);
        
    }
}
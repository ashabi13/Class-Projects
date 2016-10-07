public class averageSpeed{
    public static void main(String[] args){
        //runnersMPH or miles per hour was calculated based on the question posed
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("How many miles did the runner run?");
        	double miles = f.nextDouble();
        System.out.println("How many hours did the runner run?");
        	double hours = f.nextDouble();
        System.out.println("How many minutes did the runner run?");
        	double minutes = f.nextDouble();
        System.out.println("How many seconds did the runner run?");
        	double seconds = f.nextDouble();
        double runnersMPH = miles*(hours + (minutes/60)+(seconds/360));
        double runnersKPH = runnersMPH*1.6;
        System.out.println(runnersKPH);
        
    }
}
public class Desktop extends Computer{
    private String monitorBrand = "";
    private boolean mouse = false;
    private boolean keyboard = false;
    private String OS ="";
    private double OSV = 1.0;

    Desktop(){

    }
    Desktop(double p, String b, double d,String mB, boolean m, boolean k, String os, double oSV){
        this.setPrice(p);
        this.setBrand(b);
        this.setDiscount(d);
        monitorBrand = mB; 
        mouse = m;
        keyboard = k;
        OS = os;
        OSV = oSV;

    }

    public void updateOSV(){
        if((OSV%((int)OSV))>.9){
            OSV=(double)((int)OSV+1);
        }
        else{
            OSV+=.11;
        }
    }

    public double getOSV(){
        return OSV;
    }
        
}
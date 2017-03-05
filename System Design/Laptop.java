public class Laptop extends Computer{
    private String monitorQuality = "";
    private double screenSize =0.0;
    private boolean touchscreen = false;
    private String OS ="";
    private double OSV = 1.0;
    //private boolean mQSet = false;
    //private boolean sSSet = false;
    //private boolean tSSet = false;
    //private boolean oSSet = false;

    Laptop(){

    }
    Laptop(double p, String b, double d, String mQ, double sS, boolean tS, String os, double oSV){
        this.setPrice(p);
        this.setBrand(b);
        this.setDiscount(d);
        monitorQuality = mQ; 
        screenSize = sS;
        touchscreen = tS;
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
    /*public String toString(){
        return
        "Price: " + price + "\n" +
        "Brand: " + brand + "\n" +
        "Discount: " + super().discount + "\n" + 
        "Monitor Quality: " + monitorQuality + "\n" +
        "Screen Size: " + screenSize + "\n" +
        "Touchscreen: " + touchscreen + "\n" +
        "OS"+ OS + "\n";

    }*/


}
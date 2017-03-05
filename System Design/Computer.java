public class Computer{
    protected double price = 500.0;
    protected String brand = "GenericPCs";
    protected double discount = 0.1;

    public Computer(){

    }
    public Computer(double p, String b, double d){
        price = p;
        brand = b;
        discount = d;
    }

    protected void setPrice(double pR){
        price = pR;
    }

    protected void setBrand(String bR){
        brand = bR;
    }

    protected void setDiscount(double dis){
        discount = dis;
    }

    public double getDiscountPrice(){
        double clearance=price*(1-discount);
        return clearance;
    }
        //this.x = x;
    //}

    public double getDiscountPrice(Computer c){
        double clearance=c.price*(1-c.discount);
        return clearance;
    }

    public String toString(){
        return "price: " + price +
            "brand: " + brand +
            "discount: " + discount;
    }

}
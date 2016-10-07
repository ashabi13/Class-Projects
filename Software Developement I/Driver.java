public class Driver{
    public static void main(String[] args) {
        System.out.println("Computer c :");
        
        double price = 159.99;
        String brand = "Mac";
        double discount = 0.10;

        Computer c = new Computer(price, brand, discount);
        
        Laptop MBP = new Laptop(1499.99, brand, discount, "Retina", 13.2, false, "Machintosh", 10.9);

        Desktop WinD = new Desktop(price, "HP", discount, "Dell", true, true, "Windows", 10.1);

        System.out.println("MBP OS Version: "+ MBP.getOSV());
        System.out.println("UPDATE MBP OS......");
        MBP.updateOSV();
        System.out.println("MBP OS Version: "+ MBP.getOSV());
        System.out.println("MBP Discount: "+ c.getDiscountPrice(MBP));

        System.out.println("WinD OS Version: "+ WinD.getOSV());
        System.out.println("UPDATE WinD OS...");
        WinD.updateOSV();
        System.out.println("WinD OS Version: "+ WinD.getOSV());
        System.out.println("WinD Discount: "+ c.getDiscountPrice(WinD));

        /*
        Computer c = new Computer(price, brand, discount);

        System.out.println("Computer price = $"+ price);

        System.out.println("Computer brand = "+ brand);

        System.out.println("Computer discount = "+ (int)(discount*100) +"%");

        System.out.println("Discounted price of Computer c = " + c.getDiscountPrice());
        */
    }
}
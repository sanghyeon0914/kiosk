public class MenuItem {
    private final String name; //final 를 사용하여 캡술화
    private final int price;
    private  String comment;

    public MenuItem(String name, int price, String comment){
        this.name = name;
        this.price = price;
        this.comment = comment;

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getComment() {
        return comment;
    }

    public void display() { //toString
        System.out.println(name + " - " + price + "원");
        System.out.println("설명: " + comment);
        System.out.println("----------------------------\n");
    }
}


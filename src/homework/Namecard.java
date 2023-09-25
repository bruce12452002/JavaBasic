package homework;

public class Namecard {
    private String name;
    private String address;
    private Phone data;

    public void show() {
        System.out.println(this.name + " " + this.address);
        Phone p = this.data;
        System.out.println(p.company + " " + p.cell);
    }

    public Namecard(String name, String address, String company, String cell) {
        this.name = name;
        this.address = address;
        Phone p = new Phone(company, cell);
        this.data = p;
    }

    public void xxx() {

    }


    public static void main(String[] args) {
        Namecard n = new Namecard("Andy", "123City", "2345-6789", "0911-336600");
        n.show();
    }

    class Phone {
        private String company;
        private String cell;

        public Phone(String s1, String s2) {
            this.company = s1;
            this.cell = s2;
        }
    }
}

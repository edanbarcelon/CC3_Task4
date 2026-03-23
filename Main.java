import java.util.List;

public class Main {
    public static void main(String[] args) {
        HardwareRepository repository = new HardwareRepository();
        List<Hardware> hardwareList = repository.getAllHardware();

        int laptop16 = 0;
        int laptop32 = 0;
        int phone50 = 0;

        for (Hardware h : hardwareList) {
            if (h instanceof Laptop) {
                if (h.getSpec() == 16) laptop16++;
                else if (h.getSpec() == 32) laptop32++;
            } else if (h instanceof Phone) {
                if (h.getSpec() == 50) phone50++;
            }
        }

        System.out.println("Total number of 16GB Laptops: " + laptop16);
        System.out.println("Total number of 32GB Laptops: " + laptop32);
        System.out.println("Total number of 50MP Phones: " + phone50);

        System.out.println("\nAll hardware items:");
        for (Hardware h : hardwareList) {
            System.out.println(h);
        }
    }
}
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HardwareRepository {

    private static final String DB_URL = "jdbc:sqlite:hardware.db"; 

    public List<Hardware> getAllHardware() {
        List<Hardware> list = new ArrayList<>();
        String sql = "SELECT id, brand, model, type, spec FROM hardware";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String type = rs.getString("type");
                int spec = rs.getInt("spec");

                Hardware h;
                if ("Laptop".equalsIgnoreCase(type)) {
                    h = new Laptop.Builder()
                            .id(id)
                            .brand(brand)
                            .model(model)
                            .spec(spec)
                            .build();
                } else if ("Phone".equalsIgnoreCase(type)) {
                    h = new Phone.Builder()
                            .id(id)
                            .brand(brand)
                            .model(model)
                            .spec(spec)
                            .build();
                } else {
                    continue;
                }
                list.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
public class Hardware {
    protected final int id;
    protected final String brand;
    protected final String model;
    protected final int spec;  


    protected Hardware(Builder<?, ?> builder) {
        this.id = builder.id;
        this.brand = builder.brand;
        this.model = builder.model;
        this.spec = builder.spec;
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getSpec() { return spec; }

    
    public String getSpecDescription() {
        return spec + " units";
    }

    @Override
    public String toString() {
        return brand + " " + model + " - " + getSpecDescription();
    }


    public abstract static class Builder<T extends Hardware, B extends Builder<T, B>> {
        private int id;
        private String brand;
        private String model;
        private int spec;

        public B id(int id) { this.id = id; return self(); }
        public B brand(String brand) { this.brand = brand; return self(); }
        public B model(String model) { this.model = model; return self(); }
        public B spec(int spec) { this.spec = spec; return self(); }

        protected abstract B self();
        public abstract T build();
    }
}
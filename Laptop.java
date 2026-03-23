public class Laptop extends Hardware {

    private Laptop(Builder builder) {
        super(builder);
    }

    @Override
    public String getSpecDescription() {
        return spec + "GB RAM";
    }

    public static class Builder extends Hardware.Builder<Laptop, Builder> {
        @Override
        protected Builder self() { return this; }

        @Override
        public Laptop build() {
            return new Laptop(this);
        }
    }
}
public class Phone extends Hardware {

    private Phone(Builder builder) {
        super(builder);
    }

    @Override
    public String getSpecDescription() {
        return spec + " Megapixels";
    }

    public static class Builder extends Hardware.Builder<Phone, Builder> {
        @Override
        protected Builder self() { return this; }

        @Override
        public Phone build() {
            return new Phone(this);
        }
    }
}
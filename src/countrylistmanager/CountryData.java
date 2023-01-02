package countrylistmanager;

public class CountryData {
    private String code;
    private String name;
    private int population;
    private double area;
    private double gdp;

    public static class CountryDataBuilder {
        private String code;
        private String name;
        private int population;
        private double area;
        private double gdp;

        public CountryDataBuilder(String code) {
            this.code = code;
        }

        public CountryDataBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CountryDataBuilder setPopulation(int population) {
            this.population = population;
            return this;
        }

        public CountryDataBuilder setArea(double area) {
            this.area = area;
            return this;
        }

        public CountryDataBuilder setGdp(double gdp) {
            this.gdp = gdp;
            return this;
        }

        public CountryData build() {
            return new CountryData(this);
        }
    }

    // Constructor
    private CountryData(CountryDataBuilder builder) {
        this.code = builder.code;
        this.name = builder.name;
        this.population = builder.population;
        this.area = builder.area;
        this.gdp = builder.gdp;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }

    public double getArea() {
        return this.area;
    }

    public double getGdp() {
        return this.gdp;
    }

    @Override
    public String toString() {
        return "CountryData[" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", gdp=" + gdp +
                ']';
    }
}

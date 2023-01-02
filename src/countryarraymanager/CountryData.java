package countryarraymanager;

public class CountryData {
    private String code;
    private String name;
    private int population;
    private double area;
    private double gdp;
    private String continent;

    // Constructor
    public CountryData(String code) {
        this.code = code;
    }

    public CountryData setName(String name) {
        this.name = name;
        return this;
    }

    public CountryData setPopulation(int population) {
        this.population = population;
        return this;
    }

    public CountryData setArea(double area) {
        this.area = area;
        return this;
    }

    public CountryData setGdp(double gdp) {
        this.gdp = gdp;
        return this;
    }

    public CountryData setContinent(String continent) {
        this.continent = continent;
        return this;
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

    public String getContinent() {
        return this.continent;
    }

    @Override
    public String toString() {
        return "CountryData[" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", gdp=" + gdp +
                ", continent='" + continent + '\'' +
                ']';
    }
}

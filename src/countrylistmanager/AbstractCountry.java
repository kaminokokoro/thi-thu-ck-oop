package countrylistmanager;

public abstract class AbstractCountry {

    public abstract String getCode();
    public abstract String getName();
    public abstract int getPopulation();
    public abstract double getArea();
    public abstract double getGdp();

    @Override
    public String toString() {
        return "Country[" +
                "code='" + this.getCode() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", population=" + this.getPopulation() +
                ", area=" + this.getArea() +
                ", gdp=" + this.getGdp() +
                ']';
    }
}

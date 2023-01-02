package countrylistmanager;

public class OceaniaCountry extends AbstractCountry {
    CountryData data;

    public OceaniaCountry(CountryData data) {
        this.data = data;
    }

    /* TODO */
    @Override
    public String getCode() {
        return data.getCode();
    }

    @Override
    public String getName() {
        return data.getName();
    }

    @Override
    public int getPopulation() {
        return data.getPopulation();
    }

    @Override
    public double getArea() {
        return data.getArea();
    }

    @Override
    public double getGdp() {
        return data.getGdp();
    }
}

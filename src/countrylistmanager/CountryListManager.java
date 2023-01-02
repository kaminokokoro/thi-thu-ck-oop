package countrylistmanager;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CountryListManager {

    // Singleton pattern
    private static CountryListManager instance;

    private List<AbstractCountry> countryList;

    private CountryListManager() {
        countryList = new LinkedList<>();
    }

    public static CountryListManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new CountryListManager();
        }
        return instance;
    }

    public List<AbstractCountry> getCountryList() {
        return this.countryList;
    }

    public void append(AbstractCountry country) {
        /* TODO */
        countryList.add(country);
    }

    public void add(AbstractCountry country, int index) {
        /* TODO */
        countryList.add(index,country);
    }

    public void remove(int index) {
        /* TODO */
        countryList.remove(index);
    }

    public void remove(AbstractCountry country) {
        /* TODO */
        countryList.remove(country);
    }

    public AbstractCountry countryAt(int index) {
        /* TODO */
        return countryList.get(index);
    }

    public List<AbstractCountry> sortIncreasingByPopulation() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return left.getPopulation() - right.getPopulation();
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortDecreasingByPopulation() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return right.getPopulation() - left.getPopulation();
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortIncreasingByArea() {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return left.getArea() > right.getArea() ? 1:-1 ;
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortDecreasingByArea() {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return left.getArea() < right.getArea() ? 1:-1 ;
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortIncreasingByGdp() {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return left.getGdp() > right.getGdp() ? 1:-1 ;
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortDecreasingByGdp() {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return left.getGdp() < right.getGdp() ? 1:-1 ;
            }
        });
        return newList;
    }

    public List<AbstractCountry> filterContinent(String continent) {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>();
        for (int i =0;i<this.countryList.size();i++){
            if (countryList.get(i).getClass().getName().equals(continent)){
                newList.add(countryList.get(i));
            }
        }
        return newList;
    }

    public List<AbstractCountry> filterMostPopulousCountries(int howMany) {
        /* TODO */
        List<AbstractCountry> sorted = sortDecreasingByPopulation();
        List<AbstractCountry> newList = new LinkedList<>();
        for (int i =0;i<howMany;i++){
            newList.add(sorted.get(i));
        }
        return newList;

    }

    public List<AbstractCountry> filterLeastPopulousCountries(int howMany) {
        /* TODO */
        List<AbstractCountry> sorted = sortIncreasingByPopulation();
        List<AbstractCountry> newList = new LinkedList<>();
        for (int i =0;i<howMany;i++){
            newList.add(sorted.get(i));
        }
        return newList;
    }

    public List<AbstractCountry> filterLargestAreaCountries(int howMany) {
        /* TODO */
        List<AbstractCountry> sorted = sortDecreasingByArea();
        List<AbstractCountry> newList = new LinkedList<>();
        for (int i =0;i<howMany;i++){
            newList.add(sorted.get(i));
        }
        return newList;
    }

    public List<AbstractCountry> filterSmallestAreaCountries(int howMany) {
        /* TODO */
        List<AbstractCountry> sorted = sortIncreasingByArea();
        List<AbstractCountry> newList = new LinkedList<>();
        for (int i =0;i<howMany;i++){
            newList.add(sorted.get(i));
        }
        return newList;
    }

    public List<AbstractCountry> filterHighestGdpCountries(int howMany) {
        /* TODO */
        List<AbstractCountry> sorted = sortDecreasingByGdp();
        List<AbstractCountry> newList = new LinkedList<>();
        for (int i =0;i<howMany;i++){
            newList.add(sorted.get(i));
        }
        return newList;
    }

    public List<AbstractCountry> filterLowestGdpCountries(int howMany) {
        /* TODO */
        List<AbstractCountry> sorted = sortIncreasingByGdp();
        List<AbstractCountry> newList = new LinkedList<>();
        for (int i =0;i<howMany;i++){
            newList.add(sorted.get(i));
        }
        return newList;
    }

    public static String codeOfCountriesToString(List<AbstractCountry> countryList) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (AbstractCountry country : countryList) {
            codeOfCountries.append(country.getCode()).append(" ");
        }
        return codeOfCountries.toString().trim() + "]";
    }

    public static void print(List<AbstractCountry> countryList) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (AbstractCountry country : countryList) {
            countriesString.append(country.toString()).append("\n");
        }
        System.out.print(countriesString.toString().trim() + "]");
    }
}

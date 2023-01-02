package countryarraymanager;

import java.util.*;

public class CountryArrayManager {
    private CountryData[] countryDataArray; // Dữ liệu của các nước
    private int length;                     // Độ dài mảng có dữ liệu, những index lớn hơn hoặc bằng length là null
    private int increment;                  // Mỗi lần thêm dữ liệu, nếu không đủ chỗ thì cấp phát thêm increment phần tử cho mảng

    // Hàm dựng
    // increment là lượng mỗi lần cấp phát thêm, mặc định bằng 10
    // Khi chưa có dữ liệu, length = 0
    public CountryArrayManager() {
        this.increment = 10;
        countryDataArray = new CountryData[this.increment];
        this.length = 0;
    }

    // Hàm dựng
    // Cấp phát cho mảng capacity phần tử
    // Mảng chưa có dữ liệu nên length = 0
    public CountryArrayManager(int maxLength) {
        this.increment = 10;
        countryDataArray = new CountryData[maxLength];
        this.length = 0;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public CountryData[] getCountryDataArray() {
        return this.countryDataArray;
    }

    // Hàm correct dùng để chuẩn hóa dữ liệu lưu trong mảng
    // Khi mảng có phần tử là null thì tất cả những phần tử sau đó phải là null
    // Mảng chỉ chứa dữ liệu từ chỉ số 0 đến chỉ số length - 1
    private void correct() {
        int nullFirstIndex = 0;
        for (int i = 0; i < this.countryDataArray.length; i++) {
            if (this.countryDataArray[i] == null) {
                nullFirstIndex = i;
                break;
            }
        }

        if (nullFirstIndex > 0) {
            this.length = nullFirstIndex + 1;
            for (int i = nullFirstIndex; i < this.countryDataArray.length; i++) {
                this.countryDataArray[i] = null;
            }
        }
    }

    // Hàm dùng để cấp phát thêm phần tử cho mảng khi cần thiết.
    // Giả sử khi muốn thêm phần tử vào mảng, nhưng mảng đã hết chỗ, ta cần phải cấp phát thêm phần tử cho mảng.
    // Vì mảng có độ dài cố định, nên cần phải cấp phát lại mảng khác có độ dài lớn hơn, sau đó copy dữ liệu từ mảng cũ sang mảng mới.
    private void allocateMore() {
        CountryData[] newArray = new CountryData[this.length + this.increment];
        System.arraycopy(this.countryDataArray, 0, newArray, 0, this.countryDataArray.length);
        this.countryDataArray = newArray;
    }

    // Thêm dữ liệu vào vị trí cuối.
    // Vì Manager quản lý mảng chỉ có length phần tử đầu chứa dữ liệu, các phần còn lại là null, nên vị trí thêm vào chính là vị trí có chỉ số length.
    // Trước khi thêm cần phải kiểm tra xem mảng có còn chỗ để thêm hay không.
    // Nếu còn thì thêm vào ở vị trí length, nếu không còn thì phải cấp phát thêm phần tử cho mảng bằng cách gọi hàm allocateMore(),
    // sau đó thêm dữ liệu vào, tăng length lên 1 đơn vị.
    public void append(CountryData countryData) {
        if (this.length >= this.countryDataArray.length) {
            allocateMore();
        }

        this.countryDataArray[this.length] = countryData;
        this.length++;
    }

    // Thêm dữ liệu vào vị trí index.
    // Trước khi thêm cần phải kiểm tra xem mảng có còn chỗ để thêm hay không.
    // Nếu còn thì thêm dữ liệu vào ở vị trí index, nếu không còn thì phải cấp phát thêm phần tử cho mảng bằng cách gọi hàm allocateMore(),
    // sau đó thêm dữ liệu vào, tăng length lên 1 đơn vị.
    // Vì cấu trúc mảng sau khi được cấp phát là cố định, nên thêm phần tử vào vị trí index có nghĩa là dịch chuyển dữ liệu sau vị trí index sang 
    // phải 1 đơn vị, sau đó đặt dữ liệu mới vào vị trí index.
    public void add(CountryData countryData, int index) {
        /* TODO */
        if (this.length>=this.countryDataArray.length){
            allocateMore();
        }
        CountryData[] newArray = new CountryData[this.length];
        System.arraycopy(this.countryDataArray, 0, newArray, 0, this.length);
        for(int i =0;i<index;i++){
            this.countryDataArray[i]=newArray[i];
        }
        countryDataArray[index]=countryData;
        length++;
        for (int i = index+1;i<length;i++){
            countryDataArray[i]=newArray[i-1];
        }

    }

    // Xóa dữ liệu ở vị trí index.
    // Vì cấu trúc mảng sau khi cấp phát là cố định, nên xóa phần tử ở vị trí index có nghĩa là dịch chuyển những dữ liệu sau vị trí index 
    // sang trái 1 đơn vị, gán cho dữ liệu ở vị trí length bằng null, độ dài length giảm đi 1 đơn vị.
    public void remove(int index) {
        /* TODO */
        CountryData[] newArray = new CountryData[this.length];
        System.arraycopy(this.countryDataArray, 0, newArray, 0, this.length);
        for(int i =0;i<index;i++){
            this.countryDataArray[i]=newArray[i];
        }
        length--;
        for (int i = index;i<length;i++){
            countryDataArray[i]=newArray[i+1];
        }
    }

    public CountryData countryDataAt(int index) {
        /* TODO */
        return countryDataArray[index];
    }

    // Sắp xếp dữ liệu theo thứ tự dân số (population) tăng dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort,
    // hoặc dùng Comparable, Comparator của Java.
    public CountryData[] sortIncreasingByPopulation() {
        CountryData[] newArray = new CountryData[this.length];
        System.arraycopy(this.countryDataArray, 0, newArray, 0, this.length);
        Arrays.sort(newArray, new Comparator<CountryData>() {
            @Override
            public int compare(CountryData left, CountryData right) {
                return left.getPopulation() - right.getPopulation();
            }
        });
        return newArray;
    }

    // Sắp xếp dữ liệu theo thứ tự dân số (population) giảm dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort,
    // hoặc dùng Comparable, Comparator của Java.
    public CountryData[] sortDecreasingByPopulation() {
        /* TODO */
        CountryData[] newArray = new CountryData[this.length];
        System.arraycopy(this.countryDataArray, 0, newArray, 0, this.length);
        Arrays.sort(newArray, new Comparator<CountryData>() {
            @Override
            public int compare(CountryData left, CountryData right) {
                return -(left.getPopulation() - right.getPopulation());
            }
        });
        return newArray;
    }

    // Sắp xếp dữ liệu theo thứ tự diện tích (area) tăng dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort,
    // hoặc dùng Comparable, Comparator của Java.
    public CountryData[] sortIncreasingByArea() {
        /* TODO */
        CountryData[] newArray = new CountryData[this.length];
        System.arraycopy(this.countryDataArray, 0, newArray, 0, this.length);
        Arrays.sort(newArray, new Comparator<CountryData>() {
            @Override
            public int compare(CountryData left, CountryData right) {
                return left.getArea() > right.getArea() ? 1: -1;
            }
        });
        return newArray;
    }

    // Sắp xếp dữ liệu theo thứ tự diện tích (area) giảm dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort,
    // hoặc dùng Comparable, Comparator của Java.
    public CountryData[] sortDecreasingByArea() {
        /* TODO */
        CountryData[] newArray = new CountryData[this.length];
        System.arraycopy(this.countryDataArray, 0, newArray, 0, this.length);
        Arrays.sort(newArray, new Comparator<CountryData>() {
            @Override
            public int compare(CountryData left, CountryData right) {
                return left.getArea() < right.getArea() ? 1: -1;
            }
        });
        return newArray;
    }

    // Sắp xếp dữ liệu theo thứ tự gdp tăng dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort,
    // hoặc dùng Comparable, Comparator của Java.
    public CountryData[] sortIncreasingByGdp() {
        /* TODO */
        CountryData[] newArray = new CountryData[this.length];
        System.arraycopy(this.countryDataArray, 0, newArray, 0, this.length);
        Arrays.sort(newArray, new Comparator<CountryData>() {
            @Override
            public int compare(CountryData left, CountryData right) {
                return left.getGdp() > right.getGdp() ? 1: -1;
            }
        });
        return newArray;
    }

    // Sắp xếp dữ liệu theo thứ tự gdp giảm dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort,
    // hoặc dùng Comparable, Comparator của Java.
    public CountryData[] sortDecreasingByGdp() {
        /* TODO */
        CountryData[] newArray = new CountryData[this.length];
        System.arraycopy(this.countryDataArray, 0, newArray, 0, this.length);
        Arrays.sort(newArray, new Comparator<CountryData>() {
            @Override
            public int compare(CountryData left, CountryData right) {
                return left.getGdp() < right.getGdp() ? 1: -1;
            }
        });
        return newArray;
    }

    // Lọc ra những nước ở vùng continent (ví dụ, Châu Á).
    // Duyện từ đầu mảng đến cuối mảng, xác định xem có bao nhiêu nước thuộc vùng continent,
    // cấp phát một mảng đủ để chứa dữ liệu, sau đó duyệt lại qua mảng để thêm những nước trong vùng continent 
    // vào mảng mới vừa cấp phát. (Có thể làm theo cách khác).
    public CountryData[] filterContinent(String continent) {
        /* TODO */
        int count=0;
        for (int i =0;i<length;i++){
            if (this.countryDataArray[i].getContinent().equals(continent)){
                count++;
            }
        }
        int count1=0;
        CountryData[] newArray = new CountryData[count];
        for (int i =0;i<length;i++){
            if (this.countryDataArray[i].getContinent().equals(continent)){
                newArray[count1]=countryDataArray[i];
                count1++;
            }
        }
        return newArray;
    }

    // Lọc ra những nước (howMany nước) có dân số đông nhất
    // Có thể làm như sau.
    // Sắp xếp dữ liệu theo thứ tự dân số giảm dần. Cấp phát mảng mới có howMany phần tử,
    // copy howMany dữ liệu từ mảng đã sắp xếp vào mảng mới vừa cấp phát.
    // Trả ra mảng mới vừa copy.
    public CountryData[] filterMostPopulousCountries(int howMany) {
        /* TODO */
        CountryData[] sorted = this.sortDecreasingByPopulation();
        CountryData[] newArray = new CountryData[howMany];
        System.arraycopy(sorted, 0, newArray, 0, howMany);
        return newArray;
    }

    // Lọc ra howMany nước có dân số ít nhất.
    public CountryData[] filterLeastPopulousCountries(int howMany) {
        /* TODO */
        CountryData[] sorted = this.sortIncreasingByPopulation();
        CountryData[] newArray = new CountryData[howMany];
        System.arraycopy(sorted, 0, newArray, 0, howMany);
        return newArray;
    }

    // Lọc ra howMany nước có diện tích lớn nhất.
    public CountryData[] filterLargestAreaCountries(int howMany) {
        /* TODO */
        CountryData[] sorted = this.sortDecreasingByArea();
        CountryData[] newArray = new CountryData[howMany];
        System.arraycopy(sorted, 0, newArray, 0, howMany);
        return newArray;
    }

    // Lọc ra howMany nước có diện tích nhỏ nhất.
    public CountryData[] filterSmallestAreaCountries(int howMany) {
        /* TODO */
        CountryData[] sorted = this.sortIncreasingByArea();
        CountryData[] newArray = new CountryData[howMany];
        System.arraycopy(sorted, 0, newArray, 0, howMany);
        return newArray;
    }

    // Lọc ra howMany nước có GDP cao nhất.
    public CountryData[] filterHighestGdpCountries(int howMany) {
        /* TODO */
        CountryData[] sorted = this.sortDecreasingByGdp();
        CountryData[] newArray = new CountryData[howMany];
        System.arraycopy(sorted, 0, newArray, 0, howMany);
        return newArray;
    }

    // Lọc ra howMany nước có GDP thấp nhất.
    public CountryData[] filterLowestGdpCountries(int howMany) {
        /* TODO */
        CountryData[] sorted = this.sortIncreasingByGdp();
        CountryData[] newArray = new CountryData[howMany];
        System.arraycopy(sorted, 0, newArray, 0, howMany);
        return newArray;
    }

    // Hàm lấy danh sách các nước theo code, là String có format dạng, ví dụ [USA VNM].
    public static String codeOfCountriesToString(CountryData[] countryDataArray, int length) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (int i = 0; i < length; i++) {
            CountryData countryData = countryDataArray[i];
            codeOfCountries.append(countryData.getCode()).append(" ");
        }
        return codeOfCountries.toString().trim() + "]";
    }

    // In đầy đủ thông tin các nước trong một mảng, mỗi mảng in trên 1 dòng.
    // Ví dụ:
    // [CountryData[code='IND', name='India', population=1405888536, area=3287590.0, gdp=1927.7, continent='Asia']
    //  CountryData[code='PAK', name='Pakistan', population=229248330, area=881912.0, gdp=1188.9, continent='Asia']]
    // Chú ý chỉ in length phần tử đầu của mảng chứa dữ liệu, các phần tử sau có thể là null.
    public static void print(CountryData[] countryDataArray, int length) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (int i = 0; i < length; i++) {
            CountryData country = countryDataArray[i];
            countriesString.append(country.toString()).append("\n");
        }
        System.out.print(countriesString.toString().trim() + "]");
    }
}

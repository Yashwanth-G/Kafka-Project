package tu.cit.examples.kafkaapi.schemas;

import com.opencsv.bean.CsvBindByName;
public class Products {
    @CsvBindByName
    public String pogId;

    @CsvBindByName
    public int Supc;

    @CsvBindByName
    public String brand;

    @CsvBindByName
    public String description;

    @CsvBindByName
    public String size;

    @CsvBindByName
    public String category;

    @CsvBindByName
    public String sub_category;

    @CsvBindByName
    public int price;

    @CsvBindByName
    public int quantity;

    @CsvBindByName
    public String country;

    @CsvBindByName
    public int seller_code;

    @CsvBindByName
    public String creation_time;

    @CsvBindByName
    public int stock;

    public String getPogId() {
        return pogId;
    }
    public void setPogId(String pogId) {
        this.pogId = pogId;
    }
    public int getSupc() {
        return Supc;
    }
    public void setSupc(int supc) {
        Supc = supc;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSub_category() {
        return sub_category;
    }
    public void setSub_category(String sub_category) {
        this.sub_category = sub_category;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getSeller_code() {
        return seller_code;
    }
    public void setSeller_code(int seller_code) {
        this.seller_code = seller_code;
    }
    public String getCreation_time() {
        return creation_time;
    }
    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

}

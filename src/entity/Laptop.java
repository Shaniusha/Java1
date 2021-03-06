package entity;

import java.time.LocalDate;
import java.util.Objects;

public class Laptop extends Goods{//class Laptop наследуется от класса Goods,кот-ый реализует интерфейс Comparable
    private String model;         //значит нужно написать метод compareTo
    private Integer year;

    public Laptop(String model, Integer year, String name, Float price, LocalDate date) {
        super("Laptop",name,price,date);//родительский конструктор
        this.model = model;
        this.year = year;

    }
    public Integer getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    //передаем обЪект и сравниваем его с текущим

    public int compareTo(Goods another) {
        try {
            Laptop o = (Laptop) another;
            if (year == o.getYear()) {
                return 0; // это равно
            }
            if (year < o.getYear()) {
                return -1; // это если меньше   //можно поменять на 1
            }
            return 1; //это если больше //можно поменять на -1
        }
        catch (Exception e){
            return -1;
        }

        //все что в методе  public int compareTo(Goods another) можно записать одной строкой
        // public int compareTo(Goods another){
        // try {
        //      Laptop o = (Laptop) another;
        //         return this.year - o.year;
        // }
        // catch (Exception e){
        //      return -1;
        // }
    }
    @Override
    public String toString() {
        String partner = super.toString();//вызываем метод родителя
        return "model: " + model + " , " +
                "year: " + year + " : " + partner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(getModel(), laptop.getModel()) && Objects.equals(getYear(), laptop.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getModel(), getYear());
    }
}

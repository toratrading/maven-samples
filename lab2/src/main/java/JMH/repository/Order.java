package JMH.repository;

import java.util.Objects;

/**
 * Created by sebi on 10/17/2017.
 */
public class Order implements Comparable<Order> {
    private int id,price,quantity;

    public Order(int value){this(value,value,value);}
    public Order(int id, int price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, price, quantity);
    }

    @Override
    public String toString() {
        return "JMH.repository.Order{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return id == order.id && price == order.price && quantity == order.quantity;
    }

    @Override
    public int compareTo(Order o) {
        return this.getPrice() > o.getPrice() ? 1 : -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}

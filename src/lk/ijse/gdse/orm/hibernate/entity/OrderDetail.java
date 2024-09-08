package lk.ijse.gdse.orm.hibernate.entity;

import lk.ijse.gdse.orm.hibernate.embedded.OrderDetailPK;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailPK orderDetailPK;
    @Column(name = "order_quantity")
    private int qty;
    @Column(name = "order_price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id",
               insertable = false,
               updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id",
                insertable = false,
                 updatable = false)
    private Item item;

    public OrderDetail() {
    }

    public OrderDetail(int qty, double price, Order order, Item item) {
        this.qty = qty;
        this.price = price;
        this.order = order;
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "qty=" + qty +
                ", price=" + price +
                ", order=" + order +
                ", item=" + item +
                '}';
    }
}

package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment = new Date();
	private OrderStatus status;
	private Client client;
	private List<OrderItem> orderListItem = new ArrayList<>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public Client getClient() {
		return client;
	}

	public void addOrderItem(OrderItem orderItem) {
		orderListItem.add(orderItem);
	}

	public void removeOrderItem(OrderItem orderItem) {
		orderListItem.remove(orderItem);
	}

	public double total() {
		double sum = 0;
		for (OrderItem o : orderListItem) {
			sum += o.subTotal();
		}

		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order Moment: " + sdf.format(moment) + "\n");
		sb.append("Order Status: " + status + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order items: \n");
		double total = total();
		for (OrderItem o : orderListItem) {
			sb.append(o + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f%n", total));

		return sb.toString();
	}

}

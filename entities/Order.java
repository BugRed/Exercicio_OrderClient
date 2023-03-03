package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment = new Date();
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	

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

	public void addOrderItem(OrderItem item) {
		items.add(item);
	}

	public void removeOrderItem(OrderItem item) {
		items.remove(item);
	}

	public double total() {
		double sum = 0;
		for (OrderItem it : items) {
			sum += it.subTotal();
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
		for (OrderItem it: items) {
			sb.append(it + "\n");
		}
		sb.append("Total price: $"); 
		sb.append(String.format("%.2f", total()));

		return sb.toString();
	}

}

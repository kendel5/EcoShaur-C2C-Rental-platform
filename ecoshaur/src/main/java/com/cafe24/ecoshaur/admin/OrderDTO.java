package com.cafe24.ecoshaur.admin;

public class OrderDTO {

		private int order_no;
		private int payment_price;
		private String id;
		private String recipient;
		private String delivery_method;
		private String address;
		private String address_R;
		private String tel;
		
		
		public int getOrder_no() {
			return order_no;
		}
		public void setOrder_no(int order_no) {
			this.order_no = order_no;
		}
		public int getPayment_price() {
			return payment_price;
		}
		public void setPayment_price(int payment_price) {
			this.payment_price = payment_price;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getRecipient() {
			return recipient;
		}
		public void setRecipient(String recipient) {
			this.recipient = recipient;
		}
		public String getDelivery_method() {
			return delivery_method;
		}
		public void setDelivery_method(String delivery_method) {
			this.delivery_method = delivery_method;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getAddress_R() {
			return address_R;
		}
		public void setAddress_R(String address_R) {
			this.address_R = address_R;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		
		@Override
		public String toString() {
			return "OrderDTO [order_no=" + order_no + ", payment_price=" + payment_price + ", id=" + id + ", recipient="
					+ recipient + ", delivery_method=" + delivery_method + ", address=" + address + ", address_R="
					+ address_R + ", tel=" + tel + "]";
		}
		
}

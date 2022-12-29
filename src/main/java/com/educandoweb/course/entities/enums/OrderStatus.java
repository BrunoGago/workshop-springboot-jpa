package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT (1),
	PAID (2),
	SHIPED (3),
	DELIVERED (4),
	CANCELED (5);
	
	private int code;
	
	//Construtor ENUM utiliza o private
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		//percorre todos os valores possíveis do tipo enum
		for(OrderStatus value : OrderStatus.values()) {
			//caso o código seja igual, será retornado o número do código
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
}

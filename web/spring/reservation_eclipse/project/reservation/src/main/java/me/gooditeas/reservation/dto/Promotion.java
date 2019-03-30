package me.gooditeas.reservation.dto;

public class Promotion {

	private Integer id;
	private Integer productId;
	private String productImageUrl;

	public Promotion() {
		super();
	}

	public Promotion(Integer id, Integer productId, String productImageUrl) {
		super();
		this.id = id;
		this.productId = productId;
		this.productImageUrl = productImageUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Promotion [id=");
		builder.append(id);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", productImageUrl=");
		builder.append(productImageUrl);
		builder.append("]");
		return builder.toString();
	}

}

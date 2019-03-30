package me.gooditeas.reservation.dto;

public class Product {

	private Integer displayInfoId;
	private String placeName;
	private String productContent;
	private String productDescription;
	private Integer productId;
	private String productImageUrl;

	public Product() {
		super();
	}

	public Product(Integer displayInfoId, String placeName, String productContent, String productDescription,
			Integer productId, String productImageUrl) {
		super();
		this.displayInfoId = displayInfoId;
		this.placeName = placeName;
		this.productContent = productContent;
		this.productDescription = productDescription;
		this.productId = productId;
		this.productImageUrl = productImageUrl;
	}

	public Integer getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(Integer displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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
		builder.append("ProductDto [displayInfoId=");
		builder.append(displayInfoId);
		builder.append(", placeName=");
		builder.append(placeName);
		builder.append(", productContent=");
		builder.append(productContent);
		builder.append(", productDescription=");
		builder.append(productDescription);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", productImageUrl=");
		builder.append(productImageUrl);
		builder.append("]");
		return builder.toString();
	}

}
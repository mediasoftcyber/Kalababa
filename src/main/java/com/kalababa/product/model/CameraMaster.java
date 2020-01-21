package com.kalababa.product.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kalababa.product.entity.ProductImageEntity;


public class CameraMaster implements Serializable{

	private Integer prodId;
	private String custId;
	private Integer hsnCode;
	private String title;
	private String brand;
	private String itemModelNumber;
	private String itemWeight;
	private String productDimensions;
	private String opticalSensorResolution;
	private String opticalZoom;
	private String videoCaptureResolution;
	private String minFocalLength;
	private String connectorType;
	private String additionalFeatures;
	private String includedComponents;
	private Double mrp;
	private Double price;
	private Double sellingPrice;
	private Double purchagingPrice;
	private Integer quantity;
	private Boolean active = true;
	private Integer categoryId;
	private Integer warrantyPeriod;
	private String warrantyStatus;
	private Date warrantyStartDate;
	private Date sellingDate;
	private Boolean sold = false;
	private Date createDate;
	private Date updateDate;
	private String createdBy;
	private String updatedBy;
	private MultipartFile[] images;
	private List<ProductImageEntity> prodImgs;

	public List<ProductImageEntity> getProdImgs() {
		return prodImgs;
	}

	public void setProdImgs(List<ProductImageEntity> prodImgs) {
		this.prodImgs = prodImgs;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Integer getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(Integer hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOpticalSensorResolution() {
		return opticalSensorResolution;
	}

	public void setOpticalSensorResolution(String opticalSensorResolution) {
		this.opticalSensorResolution = opticalSensorResolution;
	}

	public String getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(String itemWeight) {
		this.itemWeight = itemWeight;
	}

	public String getProductDimensions() {
		return productDimensions;
	}

	public void setProductDimensions(String productDimensions) {
		this.productDimensions = productDimensions;
	}

	public String getItemModelNumber() {
		return itemModelNumber;
	}

	public void setItemModelNumber(String itemModelNumber) {
		this.itemModelNumber = itemModelNumber;
	}

	public String getOpticalZoom() {
		return opticalZoom;
	}

	public void setOpticalZoom(String opticalZoom) {
		this.opticalZoom = opticalZoom;
	}

	public String getVideoCaptureResolution() {
		return videoCaptureResolution;
	}

	public void setVideoCaptureResolution(String videoCaptureResolution) {
		this.videoCaptureResolution = videoCaptureResolution;
	}

	public String getConnectorType() {
		return connectorType;
	}

	public void setConnectorType(String connectorType) {
		this.connectorType = connectorType;
	}

	public String getMinFocalLength() {
		return minFocalLength;
	}

	public void setMinFocalLength(String minFocalLength) {
		this.minFocalLength = minFocalLength;
	}

	public String getAdditionalFeatures() {
		return additionalFeatures;
	}

	public void setAdditionalFeatures(String additionalFeatures) {
		this.additionalFeatures = additionalFeatures;
	}

	public String getIncludedComponents() {
		return includedComponents;
	}

	public void setIncludedComponents(String includedComponents) {
		this.includedComponents = includedComponents;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Double getPurchagingPrice() {
		return purchagingPrice;
	}

	public void setPurchagingPrice(Double purchagingPrice) {
		this.purchagingPrice = purchagingPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(Integer warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public String getWarrantyStatus() {
		return warrantyStatus;
	}

	public void setWarrantyStatus(String warrantyStatus) {
		this.warrantyStatus = warrantyStatus;
	}

	public Date getWarrantyStartDate() {
		return warrantyStartDate;
	}

	public void setWarrantyStartDate(Date warrantyStartDate) {
		this.warrantyStartDate = warrantyStartDate;
	}

	public Date getSellingDate() {
		return sellingDate;
	}

	public void setSellingDate(Date sellingDate) {
		this.sellingDate = sellingDate;
	}

	public Boolean getSold() {
		return sold;
	}

	public void setSold(Boolean sold) {
		this.sold = sold;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public MultipartFile[] getImages() {
		return images;
	}

	public void setImages(MultipartFile[] images) {
		this.images = images;
	}

}

package com.kalababa.product.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "CAMERA_MASTER")
public class CameraMasterEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROD_ID")
	private Integer prodId;

	@Column(name = "CUST_ID")
	private String custId;

	@Column(name = "HSN_CODE")
	private Integer hsnCode;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "BRAND")
	private String brand;

	@Column(name = "OPTICAL_SENSOR_RESOLUTION")
	private String opticalSensorResolution;

	@Column(name = "ITEM_WEIGHT")
	private String itemWeight;

	@Column(name = "PRODUCT_DIMENSIONS")
	private String productDimensions;

	@Column(name = "ITEM_MODEL_NUMBER")
	private String itemModelNumber;

	@Column(name = "OPTICAL_ZOOM")
	private String opticalZoom;

	@Column(name = "VIDEO_CAPTURE_RESOLUTION")
	private String videoCaptureResolution;

	@Column(name = "CONNECTOR_TYPE")
	private String connectorType;

	@Column(name = "MIN_FOCAL_LENGTH")
	private String minFocalLength;

	@Column(name = "ADDITIONAL_FEATURES")
	private String additionalFeatures;

	@Column(name = "includedComponents")
	private String includedComponents;

	@Column(name = "MRP")
	private Double mrp;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "SELLING_PRICE")
	private Double sellingPrice;

	@Column(name = "PURCHAGING_PRICE")
	private Double purchagingPrice;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@Column(name = "ACTIVE")
	private Boolean active;

	@Column(name = "CATEGORY_ID")
	private Integer categoryId;

	@Column(name = "WARRANTY_PERIOD")
	private Integer warrantyPeriod;

	@Column(name = "WARRANTY_STATUS")
	private String warrantyStatus;

	@Column(name = "WARRANTY_START_DATE")
	private Date warrantyStartDate;

	@Column(name = "SELLING_DATE")
	private Date sellingDate;

	@Column(name = "SOLD")
	private Boolean sold;

	@CreationTimestamp
	@Column(name = "CREATE_DT")
	private Date createDate;

	@UpdateTimestamp
	@Column(name = "UPDATE_DT")
	private Date updateDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

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

}

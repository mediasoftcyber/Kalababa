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
@Table(name = "TV_MASTER")
public class TVMasterEntity implements Serializable {

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
	
	@Column(name = "COLOUR")
	private String colour;
	
	@Column(name = "ITEM_HEIGHT")
	private String itemHeight;
	
	@Column(name = "ITEM_WIDTH")
	private String itemWidth;
	
	@Column(name = "SCREEN_SIZE")
	private String screenSize;
	
	@Column(name = "MAXIMUM_DISPLAY_RESOLUTION")
	private String maximumDisplayResolution;
	
	@Column(name = "ITEM_WEIGHT")
	private String itemWeight;
	
	@Column(name = "PRODUCT_DIMENSIONS")
	private String productDimensions;
	
	@Column(name = "ITEM_MODEL_NUMBER")
	private String itemModelNumber;
	
	@Column(name = "VOLTAGE")
	private String volatage;
	
	@Column(name = "WATTAGE")
	private String wattage;
	
	@Column(name = "VIEWING_ANGLE")
	private String viewingAngle;
	
	@Column(name = "SPEAKER_DESCRIPTION")
	private String speakerDescription;
	
	@Column(name = "CONNECTIVITY_TYPE")
	private String connectivityType;
	
	@Column(name = "ANDRIOD")
	private Boolean andriod;
	
	@Column(name = "NUMBER_OF_PORTS")
	private String numberOfUSBPorts;
	
	@Column(name = "NUMBER_OF_HDMI_PORTS")
	private String numberOfHDMIPorts;
	
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
	
	@Column(name="REPL_WARRANTY_PERIOD")
	private Integer replWarrantyPeriod;
	
	@Column(name="SERV_WARRANTY_PERIOD")
	private Integer servWarrantyPeriod;
	
	@Column(name = "REPL_WARRANTY_STATUS")
	private String replWarrantyStatus;
	
	@Column(name = "SERV_WARRANTY_STATUS")
	private String servWarrantyStatus;
	
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

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(String itemHeight) {
		this.itemHeight = itemHeight;
	}

	public String getItemWidth() {
		return itemWidth;
	}

	public void setItemWidth(String itemWidth) {
		this.itemWidth = itemWidth;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getMaximumDisplayResolution() {
		return maximumDisplayResolution;
	}

	public void setMaximumDisplayResolution(String maximumDisplayResolution) {
		this.maximumDisplayResolution = maximumDisplayResolution;
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

	public String getVolatage() {
		return volatage;
	}

	public void setVolatage(String volatage) {
		this.volatage = volatage;
	}

	public String getWattage() {
		return wattage;
	}

	public void setWattage(String wattage) {
		this.wattage = wattage;
	}

	public String getViewingAngle() {
		return viewingAngle;
	}

	public void setViewingAngle(String viewingAngle) {
		this.viewingAngle = viewingAngle;
	}

	public String getSpeakerDescription() {
		return speakerDescription;
	}

	public void setSpeakerDescription(String speakerDescription) {
		this.speakerDescription = speakerDescription;
	}

	public String getConnectivityType() {
		return connectivityType;
	}

	public void setConnectivityType(String connectivityType) {
		this.connectivityType = connectivityType;
	}

	public Boolean getAndriod() {
		return andriod;
	}

	public void setAndriod(Boolean andriod) {
		this.andriod = andriod;
	}

	public String getNumberOfUSBPorts() {
		return numberOfUSBPorts;
	}

	public void setNumberOfUSBPorts(String numberOfUSBPorts) {
		this.numberOfUSBPorts = numberOfUSBPorts;
	}

	public String getNumberOfHDMIPorts() {
		return numberOfHDMIPorts;
	}

	public void setNumberOfHDMIPorts(String numberOfHDMIPorts) {
		this.numberOfHDMIPorts = numberOfHDMIPorts;
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

	public Integer getReplWarrantyPeriod() {
		return replWarrantyPeriod;
	}

	public void setReplWarrantyPeriod(Integer replWarrantyPeriod) {
		this.replWarrantyPeriod = replWarrantyPeriod;
	}

	public Integer getServWarrantyPeriod() {
		return servWarrantyPeriod;
	}

	public void setServWarrantyPeriod(Integer servWarrantyPeriod) {
		this.servWarrantyPeriod = servWarrantyPeriod;
	}

	public String getReplWarrantyStatus() {
		return replWarrantyStatus;
	}

	public void setReplWarrantyStatus(String replWarrantyStatus) {
		this.replWarrantyStatus = replWarrantyStatus;
	}

	public String getServWarrantyStatus() {
		return servWarrantyStatus;
	}

	public void setServWarrantyStatus(String servWarrantyStatus) {
		this.servWarrantyStatus = servWarrantyStatus;
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

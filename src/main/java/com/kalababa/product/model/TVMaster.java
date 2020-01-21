package com.kalababa.product.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kalababa.product.entity.ProductImageEntity;


public class TVMaster implements Serializable{

	private Integer prodId;
	private String custId;
	private Integer hsnCode ;
	private String title;
	private String brand;
	private String colour;
	private String itemModelNumber;
	private String itemHeight;
	private String itemWidth;
	private String screenSize;
	private String maximumDisplayResolution;
	private String itemWeight;
	private String productDimensions;
	private String volatage;
	private String wattage;
	private String viewingAngle;
	private String speakerDescription;
	private String connectivityType;
	private Boolean andriod = false;
	private String numberOfUSBPorts;
	private String numberOfHDMIPorts;
	private String includedComponents;
	private Double mrp;
	private Double price;
	private Double sellingPrice;
	private Double purchagingPrice;
	private Integer quantity;
	private Boolean active = true;
	private Integer categoryId;
	private Integer replWarrantyPeriod;
	private Integer servWarrantyPeriod;
	private String replWarrantyStatus;
	private String servWarrantyStatus;
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

	public MultipartFile[] getImages() {
		return images;
	}

	public void setImages(MultipartFile[] images) {
		this.images = images;
	}

	

}

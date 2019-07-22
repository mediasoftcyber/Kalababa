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
@Table(name = "LAPTOP_MASTER")
public class LaptopMasterEntity implements Serializable {

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
	
	@Column(name = "SERIES")
	private String series;
	
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
	
	@Column(name = "BATTERIES")
	private String batteries;
	
	@Column(name = "ITEM_MODEL_NUMBER")
	private String itemModelNumber;
	
	@Column(name = "PROCESSOR_BRAND")
	private String processorBrand;
	
	@Column(name = "PROCESSOR_TYPE")
	private String processorType;
	
	@Column(name = "RAM_SIZE")
	private String ramSize;
	
	@Column(name = "MEMORY_TECHNOLOGY")
	private String memoryTechnology;
	
	@Column(name = "MAXIMUM_MEMORY_SUPPORTED")
	private String maximumMemorySupported;
	
	@Column(name = "HARD_DRIVE_SIZE")
	private String hardDriveSize;
	
	@Column(name = "HARDDISK_TECHNOLOGY")
	private String hardDiskTechnology;
	
	@Column(name = "AUDIO_DETAILS")
	private String audioDetails;
	
	@Column(name = "SPEAKER_DESCRIPTION")
	private String speakerDescription;
	
	@Column(name = "GRAPHICS_COPROCESSOR")
	private String graphicsCoprocessor;
	
	@Column(name = "CONNECTIVITY_TYPE")
	private String connectivityType;
	
	@Column(name = "WIRELESS_TYPE")
	private String wirelessType;
	
	@Column(name = "NUMBER_OF_USB2_0_PORTS")
	private String numberOfUSB2_0Ports;
	
	@Column(name = "NUMBER_OF_USB3_0_PORTS")
	private String numberOfUSB3_0Ports;
	
	@Column(name = "NUMBER_OF_HDMI_PORTS")
	private String numberOfHDMIPorts;
	
	@Column(name = "NUMBER_OF_AUDIOOUT_PORTS")
	private String numberOfAudioOutPorts;
	
	@Column(name = "NUMBER_OF_ETHERNET_PORTS")
	private String numberOfEthernetPorts;
	
	@Column(name = "NUMBER_OF_MICROPHONE_PORTS")
	private String numberOfMicrophonePorts;
	
	@Column(name = "OPTICAL_DRIVE_TYPE")
	private String opticalDriveType;
	
	@Column(name = "OPERATING_SYSTEM")
	private String operatingSystem;
	
	@Column(name="HARDWARE_PLATFORM")
	private String hardwarePlatform;
	
	@Column(name = "AVERAGE_BATTERY_LIFE")
	private String averageBatteryLife;
	
	@Column(name = "LITHIUM_BATTERY_ENERGY_CONTENT")
	private String lithiumBatteryEnergyContent;
	
	@Column(name = "NUMBER_OF_LITHIUM_ION_CELLS")
	private String numberOfLithiumIonCells;
	
	@Column(name = "includedComponents")
	private String includedComponents;
	
	@Column(name = "TOUCH_SCREEN")
	private Boolean touchScreen;
	
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

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
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

	public String getBatteries() {
		return batteries;
	}

	public void setBatteries(String batteries) {
		this.batteries = batteries;
	}

	public String getItemModelNumber() {
		return itemModelNumber;
	}

	public void setItemModelNumber(String itemModelNumber) {
		this.itemModelNumber = itemModelNumber;
	}

	public String getProcessorBrand() {
		return processorBrand;
	}

	public void setProcessorBrand(String processorBrand) {
		this.processorBrand = processorBrand;
	}

	public String getProcessorType() {
		return processorType;
	}

	public void setProcessorType(String processorType) {
		this.processorType = processorType;
	}

	public String getRamSize() {
		return ramSize;
	}

	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}

	public String getMemoryTechnology() {
		return memoryTechnology;
	}

	public void setMemoryTechnology(String memoryTechnology) {
		this.memoryTechnology = memoryTechnology;
	}

	public String getMaximumMemorySupported() {
		return maximumMemorySupported;
	}

	public void setMaximumMemorySupported(String maximumMemorySupported) {
		this.maximumMemorySupported = maximumMemorySupported;
	}

	public String getHardDriveSize() {
		return hardDriveSize;
	}

	public void setHardDriveSize(String hardDriveSize) {
		this.hardDriveSize = hardDriveSize;
	}

	public String getHardDiskTechnology() {
		return hardDiskTechnology;
	}

	public void setHardDiskTechnology(String hardDiskTechnology) {
		this.hardDiskTechnology = hardDiskTechnology;
	}

	public String getAudioDetails() {
		return audioDetails;
	}

	public void setAudioDetails(String audioDetails) {
		this.audioDetails = audioDetails;
	}

	public String getSpeakerDescription() {
		return speakerDescription;
	}

	public void setSpeakerDescription(String speakerDescription) {
		this.speakerDescription = speakerDescription;
	}

	public String getGraphicsCoprocessor() {
		return graphicsCoprocessor;
	}

	public void setGraphicsCoprocessor(String graphicsCoprocessor) {
		this.graphicsCoprocessor = graphicsCoprocessor;
	}

	public String getConnectivityType() {
		return connectivityType;
	}

	public void setConnectivityType(String connectivityType) {
		this.connectivityType = connectivityType;
	}

	public String getWirelessType() {
		return wirelessType;
	}

	public void setWirelessType(String wirelessType) {
		this.wirelessType = wirelessType;
	}

	public String getNumberOfUSB2_0Ports() {
		return numberOfUSB2_0Ports;
	}

	public void setNumberOfUSB2_0Ports(String numberOfUSB2_0Ports) {
		this.numberOfUSB2_0Ports = numberOfUSB2_0Ports;
	}

	public String getNumberOfUSB3_0Ports() {
		return numberOfUSB3_0Ports;
	}

	public void setNumberOfUSB3_0Ports(String numberOfUSB3_0Ports) {
		this.numberOfUSB3_0Ports = numberOfUSB3_0Ports;
	}

	public String getNumberOfHDMIPorts() {
		return numberOfHDMIPorts;
	}

	public void setNumberOfHDMIPorts(String numberOfHDMIPorts) {
		this.numberOfHDMIPorts = numberOfHDMIPorts;
	}

	public String getNumberOfAudioOutPorts() {
		return numberOfAudioOutPorts;
	}

	public void setNumberOfAudioOutPorts(String numberOfAudioOutPorts) {
		this.numberOfAudioOutPorts = numberOfAudioOutPorts;
	}

	public String getNumberOfEthernetPorts() {
		return numberOfEthernetPorts;
	}

	public void setNumberOfEthernetPorts(String numberOfEthernetPorts) {
		this.numberOfEthernetPorts = numberOfEthernetPorts;
	}

	public String getNumberOfMicrophonePorts() {
		return numberOfMicrophonePorts;
	}

	public void setNumberOfMicrophonePorts(String numberOfMicrophonePorts) {
		this.numberOfMicrophonePorts = numberOfMicrophonePorts;
	}

	public String getOpticalDriveType() {
		return opticalDriveType;
	}

	public void setOpticalDriveType(String opticalDriveType) {
		this.opticalDriveType = opticalDriveType;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getHardwarePlatform() {
		return hardwarePlatform;
	}

	public void setHardwarePlatform(String hardwarePlatform) {
		this.hardwarePlatform = hardwarePlatform;
	}

	public String getAverageBatteryLife() {
		return averageBatteryLife;
	}

	public void setAverageBatteryLife(String averageBatteryLife) {
		this.averageBatteryLife = averageBatteryLife;
	}

	public String getLithiumBatteryEnergyContent() {
		return lithiumBatteryEnergyContent;
	}

	public void setLithiumBatteryEnergyContent(String lithiumBatteryEnergyContent) {
		this.lithiumBatteryEnergyContent = lithiumBatteryEnergyContent;
	}

	public String getNumberOfLithiumIonCells() {
		return numberOfLithiumIonCells;
	}

	public void setNumberOfLithiumIonCells(String numberOfLithiumIonCells) {
		this.numberOfLithiumIonCells = numberOfLithiumIonCells;
	}

	public String getIncludedComponents() {
		return includedComponents;
	}

	public void setIncludedComponents(String includedComponents) {
		this.includedComponents = includedComponents;
	}

	public Boolean getTouchScreen() {
		return touchScreen;
	}

	public void setTouchScreen(Boolean touchScreen) {
		this.touchScreen = touchScreen;
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

/**
 * 
 */
package com.j2ee.java.model.dto;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/**
 * @author John Tran
 *
 */
@Component
@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name="ProductID")
	private int productID;
	
	@Column(name="ProductName")
	private String productName;
	
    @ManyToOne
    @JoinColumn(name = "TypeID")  
	private ProductType typeID;
	
    @ManyToOne
    @JoinColumn(name = "ProviderID")
	private Provider providerID;
	
    @ManyToOne
    @JoinColumn(name = "ManufacturerID")
	private Manufacture manufactureID;
	
    @ManyToOne
    @JoinColumn(name = "UnitID")
	private ProductUnit unitID;
	
	@Column(name="SalePrice")
	private BigDecimal salePrice;
	
	@Column(name="OrgPrice")
	private BigDecimal orgPrice;
	
	@Column(name="Description")
	private String description;

	@Column(name="MinStock")
	private int minStock;
	
	@Column(name="MaxStock")
	private int maxStock;

	@Column(name="Photo")
	@Lob
	private Blob photo;
	
	@OneToMany(mappedBy = "componentID")
	private transient Set<ProductComponent> productIDProductComponent = new HashSet<ProductComponent>();
	
	@OneToMany(mappedBy = "productID")
	private transient Set<ProductComponent> componentIDProductComponent = new HashSet<ProductComponent>();
	
	@OneToMany(mappedBy = "productID")
	private transient Set<StockInventory> productStockInventory = new HashSet<StockInventory>();
	
	@OneToMany(mappedBy = "productID")
	private transient Set<StockInwardDetail> productStockInwardDetail = new HashSet<StockInwardDetail>();
	
	@OneToMany(mappedBy = "productID")
	private transient Set<StockOutwardDetail> productStockOutwardDetail = new HashSet<StockOutwardDetail>();
	
	@OneToMany(mappedBy = "productID")
	private transient Set<StockTransfer> productStockTransfer = new HashSet<StockTransfer>();
	/**
	 * 
	 */
	public Product() {
		super();
	}
	/**
	 * @param productID
	 * @param productName
	 * @param typeID
	 * @param providerID
	 * @param manufactureID
	 * @param unitID
	 * @param salePrice
	 * @param orgPrice
	 * @param description
	 * @param minStock
	 * @param maxStock
	 * @param photo
	 */
	public Product(String productName, ProductType typeID,
			Provider providerID, Manufacture manufactureID, ProductUnit unitID, BigDecimal salePrice,
			BigDecimal orgPrice, String description, int minStock, int maxStock,
			Blob photo) {
		super();
		this.productName = productName;
		this.typeID = typeID;
		this.providerID = providerID;
		this.manufactureID = manufactureID;
		this.unitID = unitID;
		this.salePrice = salePrice;
		this.orgPrice = orgPrice;
		this.description = description;
		this.minStock = minStock;
		this.maxStock = maxStock;
		this.photo = photo;
	}
	
	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the typeID
	 */
	public ProductType getTypeID() {
		return typeID;
	}
	/**
	 * @param typeID the typeID to set
	 */
	public void setTypeID(ProductType typeID) {
		this.typeID = typeID;
	}
	/**
	 * @return the providerID
	 */
	public Provider getProviderID() {
		return providerID;
	}
	/**
	 * @param providerID the providerID to set
	 */
	public void setProviderID(Provider providerID) {
		this.providerID = providerID;
	}
	/**
	 * @return the manufactureID
	 */
	public Manufacture getManufactureID() {
		return manufactureID;
	}
	/**
	 * @param manufactureID the manufactureID to set
	 */
	public void setManufactureID(Manufacture manufactureID) {
		this.manufactureID = manufactureID;
	}
	/**
	 * @return the unitID
	 */
	public ProductUnit getUnitID() {
		return unitID;
	}
	/**
	 * @param unitID the unitID to set
	 */
	public void setUnitID(ProductUnit unitID) {
		this.unitID = unitID;
	}
	/**
	 * @return the salePrice
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * @return the orgPrice
	 */
	public BigDecimal getOrgPrice() {
		return orgPrice;
	}
	/**
	 * @param orgPrice the orgPrice to set
	 */
	public void setOrgPrice(BigDecimal orgPrice) {
		this.orgPrice = orgPrice;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the minStock
	 */
	public int getMinStock() {
		return minStock;
	}
	/**
	 * @param minStock the minStock to set
	 */
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	/**
	 * @return the maxStock
	 */
	public int getMaxStock() {
		return maxStock;
	}
	/**
	 * @param maxStock the maxStock to set
	 */
	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}
	
	public Set<ProductComponent> getProductIDProductComponent() {
		return productIDProductComponent;
	}
	
	public void setProductIDProductComponent(
			Set<ProductComponent> productIDProductComponent) {
		this.productIDProductComponent = productIDProductComponent;
	}
	
	public Set<ProductComponent> getComponentIDProductComponent() {
		return componentIDProductComponent;
	}
	
	public void setComponentIDProductComponent(
			Set<ProductComponent> componentIDProductComponent) {
		this.componentIDProductComponent = componentIDProductComponent;
	}
	
	
	public Set<StockInventory> getProductStockInventory() {
		return productStockInventory;
	}
	
	public void setProductStockInventory(Set<StockInventory> productStockInventory) {
		this.productStockInventory = productStockInventory;
	}
	
	public Set<StockInwardDetail> getProductStockInwardDetail() {
		return productStockInwardDetail;
	}
	
	public void setProductStockInwardDetail(
			Set<StockInwardDetail> productStockInwardDetail) {
		this.productStockInwardDetail = productStockInwardDetail;
	}
	
	public Set<StockOutwardDetail> getProductStockOutwardDetail() {
		return productStockOutwardDetail;
	}
	
	public void setProductStockOutwardDetail(
			Set<StockOutwardDetail> productStockOutwardDetail) {
		this.productStockOutwardDetail = productStockOutwardDetail;
	}
	/**
	 * @return the productStockTransfer
	 */
	public Set<StockTransfer> getProductStockTransfer() {
		return productStockTransfer;
	}
	/**
	 * @param productStockTransfer the productStockTransfer to set
	 */
	public void setProductStockTransfer(Set<StockTransfer> productStockTransfer) {
		this.productStockTransfer = productStockTransfer;
	}
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((manufactureID == null) ? 0 : manufactureID.hashCode());
		result = prime * result + maxStock;
		result = prime * result + minStock;
		result = prime * result
				+ ((orgPrice == null) ? 0 : orgPrice.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + productID;
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result
				+ ((providerID == null) ? 0 : providerID.hashCode());
		result = prime * result
				+ ((salePrice == null) ? 0 : salePrice.hashCode());
		result = prime * result + ((typeID == null) ? 0 : typeID.hashCode());
		result = prime * result + ((unitID == null) ? 0 : unitID.hashCode());
		return result;
	}*/
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (manufactureID == null) {
			if (other.manufactureID != null)
				return false;
		} else if (!manufactureID.equals(other.manufactureID))
			return false;
		if (maxStock != other.maxStock)
			return false;
		if (minStock != other.minStock)
			return false;
		if (orgPrice == null) {
			if (other.orgPrice != null)
				return false;
		} else if (!orgPrice.equals(other.orgPrice))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (productID != other.productID)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (providerID == null) {
			if (other.providerID != null)
				return false;
		} else if (!providerID.equals(other.providerID))
			return false;
		if (salePrice == null) {
			if (other.salePrice != null)
				return false;
		} else if (!salePrice.equals(other.salePrice))
			return false;
		if (typeID == null) {
			if (other.typeID != null)
				return false;
		} else if (!typeID.equals(other.typeID))
			return false;
		if (unitID == null) {
			if (other.unitID != null)
				return false;
		} else if (!unitID.equals(other.unitID))
			return false;
		return true;
	}*/
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

}

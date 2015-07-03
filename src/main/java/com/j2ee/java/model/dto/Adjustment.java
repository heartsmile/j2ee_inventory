
package com.j2ee.java.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

/**
 * @author John Tran
 *
 */
@Component
@Entity
@Table(name="adjustment")
public class Adjustment {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="AdjustID")
	private String adjustID;
	
	@Column(name="RefType")
	private int refType;
	
    @ManyToOne
    @JoinColumn(name = "StockID")
    private Stock stockID;
	
	@Column(name="TotalDiffAmount")
	private BigDecimal TotalDiffAmount;

    @ManyToOne
    @JoinColumn(name = "StaffID")
	private Staff staffID;
	
	@Column(name="Accept")
	private boolean accept;
	
	@Column(name="Active")
	private boolean active;
	/**
	 * 
	 */
	public Adjustment() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param date
	 * @param adjustID
	 * @param refType
	 * @param stock
	 * @param totalDiffAmount
	 * @param staffID
	 * @param accept
	 * @param active
	 */
	public Adjustment(int id, Date date, String adjustID, int refType,
			Stock stock, BigDecimal totalDiffAmount, Staff staff,
			boolean accept, boolean active) {
		super();
		this.id = id;
		this.date = date;
		this.adjustID = adjustID;
		this.refType = refType;
		this.stockID = stock;
		this.TotalDiffAmount = totalDiffAmount;
		this.staffID = staff;
		this.accept = accept;
		this.active = active;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the adjustID
	 */
	public String getAdjustID() {
		return adjustID;
	}
	/**
	 * @param adjustID the adjustID to set
	 */
	public void setAdjustID(String adjustID) {
		this.adjustID = adjustID;
	}
	/**
	 * @return the refType
	 */
	public int getRefType() {
		return refType;
	}
	/**
	 * @param refType the refType to set
	 */
	public void setRefType(int refType) {
		this.refType = refType;
	}

	/**
	 * @return the totalDiffAmount
	 */
	public BigDecimal getTotalDiffAmount() {
		return TotalDiffAmount;
	}
	/**
	 * @param totalDiffAmount the totalDiffAmount to set
	 */
	public void setTotalDiffAmount(BigDecimal totalDiffAmount) {
		TotalDiffAmount = totalDiffAmount;
	}
	/**
	 * @return the staffID
	 */
	public Staff getStaffID() {
		return staffID;
	}
	/**
	 * @param staffID the staffID to set
	 */
	public void setStaffID(Staff staff) {
		this.staffID = staff;
	}
	/**
	 * @return the accept
	 */
	public boolean isAccept() {
		return accept;
	}
	/**
	 * @param accept the accept to set
	 */
	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Stock getStock() {
		return stockID;
	}
	public void setStock(Stock stock) {
		this.stockID = stock;
	}
}

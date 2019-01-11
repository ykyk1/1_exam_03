package com.hqyj.pojo;

import java.io.Serializable;

public class SysUserLog implements Serializable{
	
	private String sysUserLogId;
	private String sysUsername;
	private String sysUserLoginDate;
	private String sysUserAddress;
	public String getSysUserLogId() {
		return sysUserLogId;
	}
	public void setSysUserLogId(String sysUserLogId) {
		this.sysUserLogId = sysUserLogId;
	}
	public String getSysUsername() {
		return sysUsername;
	}
	public void setSysUsername(String sysUsername) {
		this.sysUsername = sysUsername;
	}
	public String getSysUserLoginDate() {
		return sysUserLoginDate;
	}
	public void setSysUserLoginDate(String sysUserLoginDate) {
		this.sysUserLoginDate = sysUserLoginDate;
	}
	public String getSysUserAddress() {
		return sysUserAddress;
	}
	public void setSysUserAddress(String sysUserAddress) {
		this.sysUserAddress = sysUserAddress;
	}
	@Override
	public String toString() {
		return "SysUserLog [sysUserLogId=" + sysUserLogId + ", sysUsername=" + sysUsername + ", sysUserLoginDate="
				+ sysUserLoginDate + ", sysUserAddress=" + sysUserAddress + "]";
	}
	public SysUserLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sysUserAddress == null) ? 0 : sysUserAddress.hashCode());
		result = prime * result + ((sysUserLogId == null) ? 0 : sysUserLogId.hashCode());
		result = prime * result + ((sysUserLoginDate == null) ? 0 : sysUserLoginDate.hashCode());
		result = prime * result + ((sysUsername == null) ? 0 : sysUsername.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysUserLog other = (SysUserLog) obj;
		if (sysUserAddress == null) {
			if (other.sysUserAddress != null)
				return false;
		} else if (!sysUserAddress.equals(other.sysUserAddress))
			return false;
		if (sysUserLogId == null) {
			if (other.sysUserLogId != null)
				return false;
		} else if (!sysUserLogId.equals(other.sysUserLogId))
			return false;
		if (sysUserLoginDate == null) {
			if (other.sysUserLoginDate != null)
				return false;
		} else if (!sysUserLoginDate.equals(other.sysUserLoginDate))
			return false;
		if (sysUsername == null) {
			if (other.sysUsername != null)
				return false;
		} else if (!sysUsername.equals(other.sysUsername))
			return false;
		return true;
	}
	
}

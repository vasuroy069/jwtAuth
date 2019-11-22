package com.BharatPays.jwtAuth;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.JoinColumn;

@Entity
@DynamicUpdate
@Table(name="userMaster")
public class UserMaster {
	
	 @Id
	 @Column(name="userId")
	 @GeneratedValue
	 private Long userId;
	 
	 @Column(name="password")
	 private String password;
	 
	 @Column(name="accountNonExpired")
	 private Boolean accountNonExpired ;
	 
	 @Column(name="accountNonLocked")
	 private Boolean accountNonLocked;
	 
	 @Column(name="createdBy")
	 private Long createdBy;
	 
	 @Column(name="createdOn")
	 @CreationTimestamp
	 private Timestamp  createdOn;
	 
	 @Column(name="credentialsNonExpired")
	  private Boolean credentialsNonExpired;
	
	 @Column(name="enabled")
	 private Boolean enabled;
	
	     @Column(name="updatedBy")
		 private Long updatedBy ;
		 
		 @Column(name="updatedOn")
		 @UpdateTimestamp
	     private Timestamp updatedOn ;
		 
		 @Column(name="userName")
		 private String  userName;
		 
		 @Column(name="parentId")
	     private Long parentId;
		 
		 @Column(name="lastLogin")
		 private Timestamp lastLogin;
		 
		 
		public UserMaster() {
			
			// TODO Auto-generated constructor stub
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public Boolean getAccountNonExpired() {
			return accountNonExpired;
		}

		public void setAccountNonExpired(Boolean accountNonExpired) {
			this.accountNonExpired = accountNonExpired;
		}

		public Boolean getAccountNonLocked() {
			return accountNonLocked;
		}

		public void setAccountNonLocked(Boolean accountNonLocked) {
			this.accountNonLocked = accountNonLocked;
		}

		public Long getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(Long createdBy) {
			this.createdBy = createdBy;
		}

		public Timestamp getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(Timestamp createdOn) {
			this.createdOn = createdOn;
		}

		public Boolean getCredentialsNonExpired() {
			return credentialsNonExpired;
		}

		public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
			this.credentialsNonExpired = credentialsNonExpired;
		}

		public Boolean getEnabled() {
			return enabled;
		}

		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}

		public Long getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(Long updatedBy) {
			this.updatedBy = updatedBy;
		}

		public Timestamp getUpdatedOn() {
			return updatedOn;
		}

		public void setUpdatedOn(Timestamp updatedOn) {
			this.updatedOn = updatedOn;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Long getParentId() {
			return parentId;
		}

		public void setParentId(Long parentId) {
			this.parentId = parentId;
		}
		
		
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Timestamp getLastLogin() {
			return lastLogin;
		}

		public void setLastLogin(Timestamp lastLogin) {
			this.lastLogin = lastLogin;
		}

		@Override
		public String toString() {
			return "UserMaster [userId=" + userId + ", password=" + password + ", enabled=" + enabled + "]";
		}


		 
		 

}

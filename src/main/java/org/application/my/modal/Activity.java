package org.application.my.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activity")
public class Activity {

	public Activity() {

	}

	@Id
	private int activityid;
	public int getActivityid() {
		return activityid;
	}
	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}
	public String getActivityname() {
		return activityname;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	public String getActivityby() {
		return activityby;
	}
	public void setActivityby(String activityby) {
		this.activityby = activityby;
	}
	public String getActivitystatus() {
		return activitystatus;
	}
	public Activity(String activityname, String activityby, String activitystatus) {
		super();
		this.activityname = activityname;
		this.activityby = activityby;
		this.activitystatus = activitystatus;
	}
	@Override
	public String toString() {
		return "Activity [activityid=" + activityid + ", activityname=" + activityname + ", activityby=" + activityby
				+ ", activitystatus=" + activitystatus + "]";
	}
	public void setActivitystatus(String activitystatus) {
		this.activitystatus = activitystatus;
	}

	private String activityname;
	private String activityby;
	private String activitystatus;

}


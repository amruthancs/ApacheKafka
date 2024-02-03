package com.amruthan.kafka.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="wikimedia_change")
public class WikimediaEntity {
	
	
	public long getiD() {
		return iD;
	}

	public String getWikimediaMessage() {
		return wikimediaMessage;
	}

	public void setiD(long iD) {
		this.iD = iD;
	}

	public void setWikimediaMessage(String wikimediaMessage) {
		this.wikimediaMessage = wikimediaMessage;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long iD;
	
	@Column(columnDefinition="TEXT")
	private String wikimediaMessage;

}

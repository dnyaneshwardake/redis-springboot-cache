package com.dnyanesh.cache.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -2160142087821232178L;
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Long salary;

}

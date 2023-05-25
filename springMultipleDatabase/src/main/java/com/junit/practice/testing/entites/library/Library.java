package com.junit.practice.testing.entites.library;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="library",schema = "microserviceone",catalog ="microserviceone" )
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long libraryId;
	private String libraryName;
	private boolean isAvailableBooks;
	private int totalBooks;

}

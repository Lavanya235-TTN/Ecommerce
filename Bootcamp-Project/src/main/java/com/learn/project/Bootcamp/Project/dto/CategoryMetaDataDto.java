package com.learn.project.Bootcamp.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryMetaDataDto {
    private Long id;
    private String name;
	public String getName() {
		return this.name;
	}
}

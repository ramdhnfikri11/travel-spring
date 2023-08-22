// package com.example.demo;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.example.demo.entities.Region;
// import com.example.demo.services.RegionService;



// @SpringBootTest
// class RegionTest {

// 	private RegionService regionService;

// 	@Autowired
// 	public RegionTest(RegionService regionService) {
// 		this.regionService = regionService;
// 	}

// 	@Test
// 	void insert() {
// 		// Arrange
// 		Region region = new Region();
// 		region.setName("Amerika Utara");

// 		// Act
// 		Boolean result = regionService.Save(region);

// 		// Assert
// 		Assertions.assertThat(result).isEqualTo(true);
// 	}

// 	@Test
// 	void update() {
// 		// Arrange
// 		Region region = new Region();
// 		region.setRegion_id(1);
// 		region.setName("Amerika");

// 		// Act
// 		Boolean result = regionService.Save(region);

// 		// Assert
// 		Assertions.assertThat(result).isEqualTo(true);
// 	}

// 	@Test
// 	void delete() {
// 		// Arrange
// 		Integer id = 1;

// 		// Act
// 		Boolean result = regionService.Delete(id);

// 		// Assert
// 		Assertions.assertThat(result).isEqualTo(true);
// 	}
// }
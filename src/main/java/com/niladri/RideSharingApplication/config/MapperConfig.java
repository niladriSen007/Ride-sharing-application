package com.niladri.RideSharingApplication.config;

import com.niladri.RideSharingApplication.dto.point.PointDto;
import com.niladri.RideSharingApplication.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		// Mapping PointDto to Point
		modelMapper.typeMap(PointDto.class, Point.class).setConverter(context->{
			PointDto pointDto = context.getSource();
			return GeometryUtil.createPoint(pointDto);
		});

		// Mapping Point to PointDto
		modelMapper.typeMap(Point.class, PointDto.class).setConverter(context->{
			Point point = context.getSource();
			Double[] coOrdinates = {
					point.getX(),
					point.getY()
			};
			return new PointDto(coOrdinates);
		});

		return modelMapper;
	}
}

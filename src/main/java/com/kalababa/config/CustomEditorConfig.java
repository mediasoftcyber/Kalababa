package com.kalababa.config;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Configuration;

import com.kalababa.custompropertyeditor.CustomDateEditorRegistrar;

@Configuration
public class CustomEditorConfig extends CustomEditorConfigurer {
	
	@Override
	public void setPropertyEditorRegistrars(PropertyEditorRegistrar[] propertyEditorRegistrars) {
		System.out.println("CustomEditorConfig.setPropertyEditorRegistrars()");
		propertyEditorRegistrars[0] = new CustomDateEditorRegistrar();
	}
}

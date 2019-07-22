package com.kalababa.custompropertyeditor;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomDateEditorRegistrar implements PropertyEditorRegistrar
{
    public void registerCustomEditors(PropertyEditorRegistry registry)
    {
    	System.out.println("CustomDateEditorRegistrar.registerCustomEditors()");
        registry.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), false));
    }
}

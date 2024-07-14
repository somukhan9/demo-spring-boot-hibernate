package com.sam.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;

public class BeanUtil extends BeanUtilsBean {
	@Override
	public void copyProperty(Object dest, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {
		if (value == null)
			return;
		super.copyProperty(dest, name, value);
	}

	public static void copy(Object target, Object source) throws IllegalAccessException, InvocationTargetException {
		BeanUtilsBean n = new BeanUtil();
		n.copyProperties(target, source);
	}

}
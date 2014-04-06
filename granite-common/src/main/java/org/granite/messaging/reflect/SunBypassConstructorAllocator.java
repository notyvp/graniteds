/**
 *   GRANITE DATA SERVICES
 *   Copyright (C) 2006-2014 GRANITE DATA SERVICES S.A.S.
 *
 *   This file is part of the Granite Data Services Platform.
 *
 *   Granite Data Services is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or (at your option) any later version.
 *
 *   Granite Data Services is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 *   General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the Free Software
 *   Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,
 *   USA, or see <http://www.gnu.org/licenses/>.
 */
package org.granite.messaging.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Franck WOLFF
 */
public class SunBypassConstructorAllocator implements BypassConstructorAllocator {
	
	private final Object reflectionFactory;
	private final Method newConstructorForSerialization;
	private final Constructor<?> objectConstructor;
	
	public SunBypassConstructorAllocator()
		throws ClassNotFoundException, NoSuchMethodException, SecurityException,
		IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<?> reflectionFactoryClass = Thread.currentThread().getContextClassLoader().loadClass("sun.reflect.ReflectionFactory");
		reflectionFactory = reflectionFactoryClass.getDeclaredMethod("getReflectionFactory").invoke(null);
		newConstructorForSerialization = reflectionFactoryClass.getDeclaredMethod("newConstructorForSerialization", Class.class, Constructor.class);
		objectConstructor = Object.class.getDeclaredConstructor();
	}
	
	public Instantiator newInstantiator(Class<?> cls) throws IllegalAccessException, InvocationTargetException {
    	Constructor<?> constructor = (Constructor<?>)newConstructorForSerialization.invoke(reflectionFactory, cls, objectConstructor);
        constructor.setAccessible(true);
        return new ConstructorInstantiator(constructor);
	}
}
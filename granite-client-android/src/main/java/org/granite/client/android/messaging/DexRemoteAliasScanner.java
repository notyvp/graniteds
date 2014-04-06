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
package org.granite.client.android.messaging;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import org.granite.client.messaging.RemoteAlias;
import org.granite.client.messaging.RemoteAliasScanner;
import org.granite.logging.Logger;

import dalvik.system.DexFile;

import android.content.Context;

/**
 * @author Franck WOLFF
 */
public class DexRemoteAliasScanner implements RemoteAliasScanner {

	private static final Logger log = Logger.getLogger(DexRemoteAliasScanner.class);
	
	private final Context context;
	
	public DexRemoteAliasScanner(Context context) {
		this.context = context;
	}

	@Override
	public Set<Class<?>> scan(Set<String> packageNames) {
		String[] packageNamesDot = new String[packageNames.size()];
		int i = 0;
		for (String packageName : packageNames)
			packageNamesDot[i++] = packageName + '.';
		
		Set<Class<?>> classes = new HashSet<Class<?>>();
		
		try {
			DexFile dex = new DexFile(context.getApplicationInfo().sourceDir);
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		    Enumeration<String> entries = dex.entries();
		    while (entries.hasMoreElements()) {
		        String entry = entries.nextElement();
		        
		        for (String packageName : packageNamesDot) {
			        if (entry.startsWith(packageName)) {
			        	try {
			        		Class<?> cls = classLoader.loadClass(entry);
			        		if (cls.isAnnotationPresent(RemoteAlias.class))
			        			classes.add(classLoader.loadClass(entry));
						}
			        	catch (Throwable t) {
			    			log.error(t, "Could not scan class: %s", entry);
						}
			            break;
			        }
		        }
		    }
		}
		catch (IOException e) {
			log.error(e, "Could not scan classes for @RemoteAlias anotations");
		}
		
		return classes;
	}
}

/*
  GRANITE DATA SERVICES
  Copyright (C) 2013 GRANITE DATA SERVICES S.A.S.

  This file is part of Granite Data Services.

  Granite Data Services is free software; you can redistribute it and/or modify
  it under the terms of the GNU Library General Public License as published by
  the Free Software Foundation; either version 2 of the License, or (at your
  option) any later version.

  Granite Data Services is distributed in the hope that it will be useful, but
  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
  FITNESS FOR A PARTICULAR PURPOSE. See the GNU Library General Public License
  for more details.

  You should have received a copy of the GNU Library General Public License
  along with this library; if not, see <http://www.gnu.org/licenses/>.
*/

package org.granite.hibernate.jmf;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.TreeMap;

import org.granite.messaging.jmf.ExtendedObjectInput;
import org.granite.messaging.jmf.persistence.PersistentCollectionSnapshot;
import org.hibernate.collection.PersistentSortedMap;

/**
 * @author Franck WOLFF
 */
public class PersistentSortedMapCodec extends AbstractPersistentCollectionCodec<PersistentSortedMap> {

	public PersistentSortedMapCodec() {
		super(PersistentSortedMap.class);
	}

	public PersistentSortedMap newInstance(ExtendedObjectInput in, Class<?> cls)
			throws IOException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, InvocationTargetException,
			SecurityException, NoSuchMethodException {
		
		PersistentCollectionSnapshot snapshot = new PersistentCollectionSnapshot(true);
		snapshot.readInitializationData(in);
		
		if (!snapshot.isInitialized())
			return new PersistentSortedMap(null);
		
		Comparator<? super Object> comparator = snapshot.newComparator(in.getClassLoader());
		return new PersistentSortedMap(null, new TreeMap<Object, Object>(comparator));
	}
}

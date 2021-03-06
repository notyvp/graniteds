/**
 *   GRANITE DATA SERVICES
 *   Copyright (C) 2006-2015 GRANITE DATA SERVICES S.A.S.
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
package org.granite.client.javafx.persistence.collection;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.Set;

import org.granite.client.persistence.Loader;
import org.granite.client.persistence.collection.PersistentCollection;
import org.granite.client.persistence.collection.PersistentSet;
import org.granite.client.persistence.collection.UnsafePersistentCollection;

import com.sun.javafx.collections.ObservableSetWrapper;

/**
 * @author Franck WOLFF
 */
public class ObservablePersistentSet<E> extends ObservableSetWrapper<E> implements UnsafePersistentCollection<Set<E>> {
	
    private static final long serialVersionUID = 1L;
	
	private final PersistentSet<E> persistentSet;

	public ObservablePersistentSet(PersistentSet<E> persistentSet) {
		super(persistentSet);
		
		this.persistentSet = persistentSet;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> iterator() {
		return super.iterator();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		persistentSet.writeExternal(out);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		persistentSet.readExternal(in);
	}

	@Override
	public boolean wasInitialized() {
		return persistentSet.wasInitialized();
	}

	@Override
	public void uninitialize() {
		persistentSet.uninitialize();
	}

	@Override
	public void initialize(Set<E> set, Initializer<Set<E>> initializer) {
		persistentSet.initialize(set, initializer != null ? initializer : new Initializer<Set<E>>() {
			@Override
			public void initialize(Set<E> set) {
				addAll(set);
			}
		});
	}

	@Override
	public void initializing() {
		persistentSet.initializing();
	}

	@Override
	public PersistentCollection<Set<E>> clone(boolean uninitialize) {
		return persistentSet.clone(uninitialize);
	}

	@Override
	public Loader<Set<E>> getLoader() {
		return persistentSet.getLoader();
	}

	@Override
	public void setLoader(Loader<Set<E>> loader) {
		persistentSet.setLoader(loader);
	}

	@Override
	public boolean isDirty() {
		return persistentSet.isDirty();
	}

	@Override
	public void dirty() {
		persistentSet.dirty();
	}

	@Override
	public void clearDirty() {
		persistentSet.clearDirty();
	}

    @Override
    public void addListener(ChangeListener<Set<E>> listener) {
        persistentSet.addListener(listener);
    }

    @Override
    public void removeListener(ChangeListener<Set<E>> listener) {
        persistentSet.removeListener(listener);
    }

    @Override
    public void addListener(InitializationListener<Set<E>> listener) {
        persistentSet.addListener(listener);
    }

    @Override
    public void removeListener(InitializationListener<Set<E>> listener) {
        persistentSet.removeListener(listener);
    }

	@Override
	public void withInitialized(InitializationCallback<Set<E>> callback) {
		persistentSet.withInitialized(callback);
	}
	
	@Override
	public PersistentSet<E> internalPersistentCollection() {
		return persistentSet;
	}
	
	@Override
	public String toString() {
		return persistentSet.toString();
	}
	
	@Override
	public int hashCode() {
		return System.identityHashCode(persistentSet);
	}
	
	@Override
	public boolean equals(Object object) {
		return object instanceof UnsafePersistentCollection 
				&& ((UnsafePersistentCollection<?>)object).internalPersistentCollection() == persistentSet;
	}
}
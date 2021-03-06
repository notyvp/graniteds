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
package org.granite.client.test.javafx.jmf;

import java.io.Serializable;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.granite.client.messaging.RemoteAlias;
import org.granite.client.persistence.Entity;
import org.granite.client.persistence.Id;
import org.granite.client.persistence.Uid;
import org.granite.client.persistence.Version;

@Entity
@RemoteAlias("org.granite.client.test.javafx.jmf.ServerCollectionEntity")
public class ClientFXCollectionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private boolean __initialized__ = true;
	@SuppressWarnings("unused")
	private String __detachedState__ = null;
	
	@Id
	private ReadOnlyObjectWrapper<Integer> id = new ReadOnlyObjectWrapper<Integer>(this, "id", 0);
	
	@Uid
	private StringProperty uid = new SimpleStringProperty(this, "uid", null);
	
	@Version
	private ReadOnlyObjectWrapper<Integer> version = new ReadOnlyObjectWrapper<Integer>(this, "version", 0);

	private StringProperty name = new SimpleStringProperty(this, "name", null);
	
	private ObjectProperty<ClientFXEntity> entity = new SimpleObjectProperty<ClientFXEntity>(this, "entity", null);

	public ClientFXCollectionEntity() {
	}

	public ClientFXCollectionEntity(Integer id, Integer version) {
		this.id.set(id);
		this.version.set(version);
	}

	public ReadOnlyObjectProperty<Integer> idProperty() {
		return id.getReadOnlyProperty();
	}
	public Integer getId() {
		return id.get();
	}

	public StringProperty uidProperty() {
		return uid;
	}
	public String getUid() {
		return uid.get();
	}
	public void setUid(String uid) {
		this.uid.set(uid);
	}

	public ReadOnlyObjectProperty<Integer> versionProperty() {
		return version.getReadOnlyProperty();
	}
	public Integer getVersion() {
		return version.get();
	}

	public StringProperty nameProperty() {
		return uid;
	}
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	
	public ObjectProperty<ClientFXEntity> entityProperty() {
		return entity;
	}
	public ClientFXEntity getEntity() {
		return entity.get();
	}
	public void setEntity(ClientFXEntity entity) {
		this.entity.set(entity);
	}
}

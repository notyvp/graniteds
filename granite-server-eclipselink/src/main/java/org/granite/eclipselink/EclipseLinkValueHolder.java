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
package org.granite.eclipselink;

import org.eclipse.persistence.indirection.WeavedAttributeValueHolderInterface;


/**
 * @author William DRAI
 */
public class EclipseLinkValueHolder implements WeavedAttributeValueHolderInterface {

    private Object value = null;
    
    
    public EclipseLinkValueHolder() {
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
    public Object getValue() {
        return value;
    }

    public boolean isInstantiated() {
        return false;
    }

    public boolean isCoordinatedWithProperty() {
        return false;
    }

    public boolean isNewlyWeavedValueHolder() {
        return false;
    }

	public boolean shouldAllowInstantiationDeferral() {
		return true;
	}

    public void setIsCoordinatedWithProperty(boolean value) {
    }

    public void setIsNewlyWeavedValueHolder(boolean value) {
    }
    
    
    @Override
    public Object clone() {
        EclipseLinkValueHolder vh = new EclipseLinkValueHolder();
        vh.setValue(value);
        return vh;
    }
}
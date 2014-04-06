/**
 *   GRANITE DATA SERVICES
 *   Copyright (C) 2006-2014 GRANITE DATA SERVICES S.A.S.
 *
 *   This file is part of the Granite Data Services Platform.
 *
 *                               ***
 *
 *   Community License: GPL 3.0
 *
 *   This file is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published
 *   by the Free Software Foundation, either version 3 of the License,
 *   or (at your option) any later version.
 *
 *   This file is distributed in the hope that it will be useful, but
 *   WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 *                               ***
 *
 *   Available Commercial License: GraniteDS SLA 1.0
 *
 *   This is the appropriate option if you are creating proprietary
 *   applications and you are not prepared to distribute and share the
 *   source code of your application under the GPL v3 license.
 *
 *   Please visit http://www.granitedataservices.com/license for more
 *   details.
 */
package org.granite.client.messaging.events;

import java.util.Map;

import org.granite.client.messaging.messages.RequestMessage;
import org.granite.client.messaging.messages.responses.FaultMessage;
import org.granite.client.messaging.messages.responses.FaultMessage.Code;

/**
 * @author Franck WOLFF
 */
public class FaultEvent extends AbstractResponseEvent<FaultMessage> implements IssueEvent {

	public FaultEvent(RequestMessage request, FaultMessage response) {
		super(request, response);
	}

	@Override
	public Type getType() {
		return Type.FAULT;
	}
	
	public Code getCode() {
		return response.getCode();
	}

	public String getDescription() {
		return response.getDescription();
	}

	public String getDetails() {
		return response.getDetails();
	}

	public Object getCause() {
		return response.getCause();
	}

	public Map<String, Object> getExtended() {
		return response.getExtended();
	}

	public String getUnknownCode() {
		return response.getUnknownCode();
	}

	@Override
	public String toString() {
		return getClass().getName() + "{code=" + getCode() +
			", description=" + getDescription() +
			", details=" + getDetails() +
			", cause=" + getCause() +
			", extended=" + getExtended() +
			", unknownCode=" + getUnknownCode() +
		"}";
	}
}

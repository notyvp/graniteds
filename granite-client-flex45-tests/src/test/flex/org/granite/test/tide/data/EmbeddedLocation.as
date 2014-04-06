/*
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
/**
 * Generated by Gas3 v2.1.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (EmbAddress.as).
 */

package org.granite.test.tide.data {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;

    [Bindable]
	[RemoteClass(alias="org.granite.tide.test.EmbeddedLocation")]
    public class EmbeddedLocation implements IExternalizable {

        private var _city:String;
        private var _zipcode:String;

        public function set city(value:String):void {
            _city = value;
        }
        public function get city():String {
            return _city;
        }

        public function set zipcode(value:String):void {
            _zipcode = value;
        }
        public function get zipcode():String {
            return _zipcode;
        }

        public function readExternal(input:IDataInput):void {
            _city = input.readObject() as String;
            _zipcode = input.readObject() as String;
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject(_city);
            output.writeObject(_zipcode);
        }
    }
}
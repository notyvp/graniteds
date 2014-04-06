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
 * Generated by Gas3 v1.1.0 (Granite Data Services) on Sat Jul 26 17:58:20 CEST 2008.
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERRIDDEN EACH TIME YOU USE
 * THE GENERATOR. CHANGE INSTEAD THE INHERITED CLASS (Person.as).
 */

package org.granite.test.tide.data {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    
    import mx.collections.ListCollectionView;
    
    import org.granite.meta;
    import org.granite.ns.tide;
    import org.granite.test.tide.AbstractEntity;
    import org.granite.tide.IEntityManager;
    import org.granite.tide.IPropertyHolder;

    use namespace meta;
    use namespace tide;

    [Managed]
    [RemoteClass(alias="org.granite.test.tide.data.User")]
    public class User2 extends AbstractEntity {

        private var _meetings:ListCollectionView;
        private var _firstName:String;
        private var _lastName:String;
       
        
	public function User2(id:Number = NaN, version:Number = NaN, firstName:String = null, lastName:String = null):void {
		this.id = id;
		if (!isNaN(id))
			this.uid = "P" + id;
		this.version = version;
		this.firstName = firstName;
		this.lastName = lastName;
	}
		
        public function set meetings(value:ListCollectionView):void {
            _meetings = value;
        }
        [Lazy]
        public function get meetings():ListCollectionView {
            return _meetings;
        }

        public function set firstName(value:String):void {
            _firstName = value;
        }
        public function get firstName():String {
            return _firstName;
        }

        public function set lastName(value:String):void {
            _lastName = value;
        }
        public function get lastName():String {
            return _lastName;
        }

        override meta function merge(em:IEntityManager, obj:*):void {
            var src:User2 = User2(obj);
            super.meta::merge(em, obj);
            if (meta::isInitialized()) {
                em.meta_mergeExternal(src._firstName, _firstName, null, this, 'firstName', function setter(o:*):void{_firstName = o as String}) as String;
                em.meta_mergeExternal(src._lastName, _lastName, null, this, 'lastName', function setter(o:*):void{_lastName = o as String}) as String;
				em.meta_mergeExternal(src._meetings, _meetings, null, this, 'meetings', function setter(o:*):void{_meetings = o as ListCollectionView}) as ListCollectionView;
            }
        }

        override public function readExternal(input:IDataInput):void {
            super.readExternal(input);
            if (meta::isInitialized()) {
                _firstName = input.readObject() as String;
                _lastName = input.readObject() as String;
				_meetings = input.readObject() as ListCollectionView;
            }
        }

        override public function writeExternal(output:IDataOutput):void {
            super.writeExternal(output);
            if (meta::isInitialized()) {
                output.writeObject((_firstName is IPropertyHolder) ? IPropertyHolder(_firstName).object : _firstName);
                output.writeObject((_lastName is IPropertyHolder) ? IPropertyHolder(_lastName).object : _lastName);
				output.writeObject((_meetings is IPropertyHolder) ? IPropertyHolder(_meetings).object : _meetings);
            }
        }
    }
}

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

    import flash.utils.ByteArray;
    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    
    import mx.collections.ListCollectionView;
    import mx.controls.List;
    
    import org.granite.meta;
    import org.granite.test.tide.AbstractEntity;
    import org.granite.tide.IEntityManager;
    import org.granite.tide.IPropertyHolder;
    import org.granite.util.Enum;

    use namespace meta;

    [Managed]
    [RemoteClass(alias="org.granite.test.tide.Patient4c")]
    public class Patient4c extends AbstractEntity {

		private var _diagnosis:ListCollectionView;
		private var _diagnosisAssessed:Boolean;
		private var _visits:ListCollectionView;
        private var _name:String;
        
        
        public function set diagnosis(value:ListCollectionView):void {
			_diagnosis = value;
        }
		[Lazy]
        public function get diagnosis():ListCollectionView {
            return _diagnosis;
        }
		
		public function set diagnosisAssessed(value:Boolean):void {
			_diagnosisAssessed = value;
		}
		
		public function get diagnosisAssessed():Boolean {
			return _diagnosisAssessed;
		}
		
		public function set visits(value:ListCollectionView):void {
			_visits = value;
		}
		[Lazy]
		public function get visits():ListCollectionView {
			return _visits;
		}

        public function set name(value:String):void {
            _name = value;
        }
        public function get name():String {
            return _name;
        }

        override meta function merge(em:IEntityManager, obj:*):void {
            var src:Patient4c = Patient4c(obj);
            super.meta::merge(em, obj);
            if (meta::isInitialized()) {
				em.meta_mergeExternal(src._diagnosis, _diagnosis, null, this, 'diagnosis', function setter(o:*):void{_diagnosis = o as ListCollectionView}) as ListCollectionView;
				em.meta_mergeExternal(src._diagnosisAssessed, _diagnosisAssessed, null, this, 'diagnosisAssessed', function setter(o:*):void{_diagnosisAssessed = o as Boolean}) as Boolean;
                em.meta_mergeExternal(src._name, _name, null, this, 'name', function setter(o:*):void{_name = o as String}) as String;
				em.meta_mergeExternal(src._visits, _visits, null, this, 'visits', function setter(o:*):void{_visits = o as ListCollectionView}) as ListCollectionView;
            }
        }

        override public function readExternal(input:IDataInput):void {
            super.readExternal(input);
            if (meta::isInitialized()) {
				_diagnosis = input.readObject() as ListCollectionView;
				_diagnosisAssessed = input.readObject() as Boolean;
                _name = input.readObject() as String;
				_visits = input.readObject() as ListCollectionView;
            }
        }

        override public function writeExternal(output:IDataOutput):void {
            super.writeExternal(output);
            if (meta::isInitialized()) {
				output.writeObject((_diagnosis is IPropertyHolder) ? IPropertyHolder(_diagnosis).object : _diagnosis);
				output.writeObject((_diagnosisAssessed is IPropertyHolder) ? IPropertyHolder(_diagnosisAssessed).object : _diagnosisAssessed);
                output.writeObject((_name is IPropertyHolder) ? IPropertyHolder(_name).object : _name);
				output.writeObject((_visits is IPropertyHolder) ? IPropertyHolder(_visits).object : _diagnosis);
            }
        }
    }
}

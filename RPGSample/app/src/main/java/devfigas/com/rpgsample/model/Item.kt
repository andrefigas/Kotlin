package devfigas.com.kotlinstudy.rpg
/*Copyright 2017 Andre Figas

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */
public abstract class Item<T>( ) {
    var name : String = ""

    public fun initAttributes(initAttributes: (T) -> Unit) {
        val attributes = newInstance()
        initAttributes(attributes as T)
        if(attributes is Item<*>){
            name = attributes.name //populate common attribute
        }
        composeAttributes(attributes)//call particular implementation from Potion, Item or Weapon on populate instance
    }

    //provide populate attributtes using: >,<,>=,<=
    public operator fun compareTo(initAttributes: (T) -> Unit): Int{
        initAttributes(initAttributes)
        return 0
    }

    fun name(nameGenerator: () -> String) { name = nameGenerator()}//lambda setter

    //provide populate attributtes using: +
    operator fun plus(other: Int): Int{plusValue(other);return other}

    //provide populate attributtes using: -
    operator fun minus(other: Int): Int{minusValue(-other);return -other}

    //call custom behavior from Potion, Item or Weapon on use plus (+) feature
    open fun plusValue(value : Int){}

    //call custom behavior from Potion, Item or Weapon on use minus (-) feature
    open fun minusValue(value : Int){}

    //call custom behavior from Potion, Item or Weapon for complete populate attributes
    protected abstract fun composeAttributes(args : T)

    //create new instance of Potion, Item or Weapon
    protected abstract fun  newInstance() : T
}

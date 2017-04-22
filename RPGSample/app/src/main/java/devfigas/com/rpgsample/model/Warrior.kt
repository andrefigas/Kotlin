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
data class Warrior(var name : String = "", var life : Int = 0,var itens : MutableList<Item<*>> = mutableListOf()) {

    //provide populate attributtes using: >,<,>=,<=
    public operator fun compareTo(initAttributes: (Warrior) -> Unit): Int{initAttributes(this); return 0}

    fun name(nameGenerator: () -> String) {name = nameGenerator()}//lambda setter
    fun life(lifeGenerator: () -> Int) {life = lifeGenerator()}//lambda setter
    fun itens(itensGenerator: () -> List<Item<*>>){itens.addAll(itensGenerator())}//lambda setter
    fun itens(vararg  itensArgs : Item<*>){itens.addAll(itensArgs)}//common setter

}

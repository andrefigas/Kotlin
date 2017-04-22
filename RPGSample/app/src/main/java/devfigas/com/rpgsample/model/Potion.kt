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
data class Potion( var heal : Int = 0): Item<Potion>(){

    override fun newInstance() = Potion()

    override fun composeAttributes(args: Potion) {heal =args.heal}//complete attributes populate

    fun heal(healGenerator: () -> Int) {heal = Math.abs(healGenerator())}//labda setter

    override fun plusValue(value: Int) {heal = value}//custom implementation os plus (+) future from Item
}
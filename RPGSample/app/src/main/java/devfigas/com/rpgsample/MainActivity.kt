package devfigas.com.rpgsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import devfigas.com.kotlinstudy.rpg.Potion
import devfigas.com.kotlinstudy.rpg.Shield
import devfigas.com.kotlinstudy.rpg.Warrior
import devfigas.com.kotlinstudy.rpg.Weapon
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
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val warrior = Warrior()
        warrior > {
            it.name { "andre" }//set name
            it.life { 100 }//set life

            val potion = Potion()
            potion > {it+10; it.name { "Golden Axe" }}//set heal and name

            val shield = Shield()
            shield > {it-20; it.name { "Magic Shield" }}//set defense and name

            val weapon = Weapon()
            weapon > {it+30; it.name{ "Silver Axe" }}//set demage and name

            it.itens(potion,shield,weapon)//set itens
        }
        println(warrior)
    }
}

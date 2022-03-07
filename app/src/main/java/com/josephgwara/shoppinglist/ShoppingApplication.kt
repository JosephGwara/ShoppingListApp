package com.josephgwara.shoppinglist

import android.app.Application
import com.josephgwara.shoppinglist.data.db.ShoppingDatabase
import com.josephgwara.shoppinglist.data.repositories.ShoppingRepository
import com.josephgwara.shoppinglist.ui.shoppingList.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import org.kodein.di.generic.provider

class ShoppingApplication:Application(),KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind()from singleton { ShoppingDatabase(instance()) }
        bind()from singleton { ShoppingRepository(instance()) }
        bind()from provider {
            ShoppingViewModelFactory(instance())}
        }
    }


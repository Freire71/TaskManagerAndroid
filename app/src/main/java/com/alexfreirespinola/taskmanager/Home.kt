package com.alexfreirespinola.taskmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    private lateinit var mDrawer: Drawer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var headerResult = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.color.primary)
            .addProfiles(
                ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(R.mipmap.ic_launcher)
            ).build()
        mDrawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolbar)
            .addDrawerItems(
                PrimaryDrawerItem().withName("Home"),
                PrimaryDrawerItem().withName("Tarefas concluídas")
            ).withOnDrawerItemClickListener { _, position, _ ->
                println("navigate")
                navigateFunction(position)
                true
            }.withAccountHeader(headerResult)
            .build()
        navigateFunction(0)
//        mDrawer.openDrawer(GravityCompat.START)
    }

    private fun navigateFunction(position: Int) {
        var fragM = supportFragmentManager.beginTransaction()
        var id = frameLayout.id
        when (position) {
            0 -> fragM.replace(id, AllTasksFragment())
            1 -> fragM.replace(id, DoneTasksFragment())
        }
        fragM.commit()
        mDrawer.closeDrawer()
    }
}

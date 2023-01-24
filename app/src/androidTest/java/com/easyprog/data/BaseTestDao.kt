package com.easyprog.data

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.easyprog.data.storage.RoomDatabaseApp
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
open class BaseTestDao {

    val db: RoomDatabaseApp = Room.inMemoryDatabaseBuilder(
        InstrumentationRegistry.getInstrumentation().targetContext,
        RoomDatabaseApp::class.java
    ).build()

    @Before
    fun createDb() {
        db
    }

    @After
    @Throws(IOException::class)
    fun closeDB() {
        db.close()
    }
}
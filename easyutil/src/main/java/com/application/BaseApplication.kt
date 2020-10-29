package com.application

import android.app.Activity
import android.app.Application
import java.util.ArrayList

/**
 *@author：李佳模
 *ON：2020/10/15
 *description:
 */
object BaseApplication: Application() {
    var allActivitys: MutableList<Activity> = ArrayList()
}
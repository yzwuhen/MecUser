package com.example.mechanicalapp.ui.adapter

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter
import com.example.mechanicalapp.ui.data.CityData

class CityWheelAdapter (private var mList:List<CityData>):ArrayWheelAdapter<CityData>(mList){

    override fun getItem(index: Int): Any {
        return if (index >= 0 && index < mList.size) {
            mList[index].name
        } else ""
    }
}
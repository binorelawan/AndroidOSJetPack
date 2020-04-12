package relawan.androidosjetpack.utils

import android.content.Context
import android.util.Log
import relawan.androidosjetpack.R
import relawan.androidosjetpack.model.AndroidOs
import java.util.*

object AndroidOsData {

    var dataInt = arrayOf(
        intArrayOf(R.string.cupcake, R.string.oscupkake, R.drawable.androidcupcake, R.string.detailcupcake),
        intArrayOf(R.string.donut, R.string.osdonut, R.drawable.androiddonut, R.string.detaildonut),
        intArrayOf(R.string.eclair, R.string.oseclair, R.drawable.androideclair, R.string.detaileclair),
        intArrayOf(R.string.froyo, R.string.osfroyo, R.drawable.androidfroyo, R.string.detailfroyo),
        intArrayOf(R.string.gingerbread, R.string.osgingerbread, R.drawable.androidgingerbread, R.string.detailgingerbread),
        intArrayOf(R.string.honeycomb, R.string.oshoneycomb, R.drawable.androidhoneycomb, R.string.detailhoneycomb),
        intArrayOf(R.string.icecreamsandwich, R.string.osicecreamsandwich, R.drawable.androidicecreamsandwich, R.string.detailicecreamsandwich),
        intArrayOf(R.string.jellybean, R.string.osjellybean, R.drawable.androidjellybean, R.string.detailjellybean),
        intArrayOf(R.string.kitkat, R.string.oskitkat, R.drawable.androidkitkat, R.string.detailkitkat),
        intArrayOf(R.string.lollipop, R.string.oslollipop, R.drawable.androidlolipop, R.string.detaillollipop),
        intArrayOf(R.string.marshmallow, R.string.osmarshmallow, R.drawable.androidmarshmellow, R.string.detailmarshmallow),
        intArrayOf(R.string.nougat, R.string.osnougat, R.drawable.androidnougat, R.string.detailnougat),
        intArrayOf(R.string.oreo, R.string.osoreo, R.drawable.androidoreo, R.string.detailoreo),
        intArrayOf(R.string.pie, R.string.ospie, R.drawable.androidpie, R.string.detailpie)
    )

    fun getListData(): ArrayList<AndroidOs> {
        var androidOs: AndroidOs
        val list: ArrayList<AndroidOs> = ArrayList<AndroidOs>()
        for (aData in dataInt) {
            androidOs = AndroidOs()
            androidOs.name = aData[0]
            androidOs.remarks = aData[1]
            androidOs.photo = aData[2]
            androidOs.detail = aData[3]
            list.add(androidOs)

        }
        return list
    }



}

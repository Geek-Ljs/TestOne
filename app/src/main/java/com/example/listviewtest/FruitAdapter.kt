package com.example.listviewtest

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FruitAdapter(activity: Activity, val resourceId:Int, data:List<Fruit>):
    ArrayAdapter<Fruit>(activity, resourceId, data) {

    //2020-10-22 22:48 ViewHolder进行性能优化
    inner class ViewHolder(val fruitImage:ImageView, val fruitName:TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        return super.getView(position, convertView, parent)

        //2020-10-22 9:07
//        val view = LayoutInflater.from(context).inflate(resourceId, parent, false)

        //2020-10-20 21：22 convertView参数，这个参数用于加载好的布局进行缓存
//        val view:View
//        if (convertView == null){
//            val view = LayoutInflater.from(context).inflate(resourceId, parent, false)
//        }
//        else{
//            view = convertView
//        }

        //2020-10-22 22:47 ViewHolder来对性能进行优化
        val view:View
        val viewHolder:ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId,parent,false)
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
            viewHolder = ViewHolder(fruitImage, fruitName)
            view.tag = viewHolder
        }
        else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val fruit = getItem(position)
//        if (fruit != null){
//            fruitImage.setImageResource(fruit.imageId)
//            fruitName.text = fruit.name
//        }
        if (fruit != null){
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }
        return view
    }
}
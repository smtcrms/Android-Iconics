/*
 * Copyright (c) 2019 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikepenz.iconics.sample.item

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.items.AbstractItem
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.sample.R
import com.mikepenz.iconics.view.IconicsImageView

/**
 * Created by mikepenz on 26.07.16.
 */

class IconItem(icon: String) : AbstractItem<IconItem, IconItem.ViewHolder>() {
    var icon: String? = null
        private set

    fun withIcon(icon: String): IconItem {
        this.icon = icon
        return this
    }

    init {
        this.icon = icon
    }

    override fun getType(): Int {
        return R.id.item_row_icon
    }

    override fun getLayoutRes(): Int {
        return R.layout.row_icon
    }

    override fun bindView(holder: ViewHolder, payloads: List<*>?) {
        super.bindView(holder, payloads)

        holder.image.icon = IconicsDrawable(holder.image.context, icon!!)
        holder.name.text = icon

        holder.image.icon!!
                .color(IconicsColor.colorInt(Color.BLACK))
                .padding(IconicsSize.dp(0f))
                .contourWidth(IconicsSize.dp(0f))
                .contourColor(IconicsColor.colorInt(Color.TRANSPARENT))
        holder.image.setBackgroundColor(Color.TRANSPARENT)

        //as we want to respect the bounds of the original font in the icon list
        holder.image.icon!!.respectFontBounds(true)
    }

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var image: IconicsImageView


        init {
            name = itemView.findViewById(R.id.name)
            image = itemView.findViewById(R.id.icon)
        }
    }
}
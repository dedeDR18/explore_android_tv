package com.example.mytrainingtv.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.RowHeaderPresenter
import com.example.mytrainingtv.R
import com.example.mytrainingtv.ui.catalog.CatalogFragment.Companion.HEADER_ID_ACCOUNT
import com.example.mytrainingtv.ui.catalog.CatalogFragment.Companion.HEADER_ID_FAVORITE
import com.example.mytrainingtv.ui.catalog.CatalogFragment.Companion.HEADER_ID_HOME
import com.example.mytrainingtv.ui.catalog.CatalogFragment.Companion.HEADER_ID_LIVE_EVENT
import com.example.mytrainingtv.ui.catalog.CatalogFragment.Companion.HEADER_ID_LIVE_TV


class IconHeaderItemPresenter : RowHeaderPresenter() {
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val view = LayoutInflater.from(parent?.context).run {
            inflate(R.layout.header_item, null)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder?, item: Any?) {
        //super.onBindViewHolder(viewHolder, item)
        val headerItem = (item as ListRow).headerItem
        val rootView = viewHolder?.view

        val iconHeader = when (item.id){
            HEADER_ID_HOME -> R.drawable.ic_home_24
            HEADER_ID_LIVE_EVENT -> R.drawable.ic_cast
            HEADER_ID_LIVE_TV -> R.drawable.ic_live_tv
            HEADER_ID_FAVORITE -> R.drawable.ic_favorite_24
            HEADER_ID_ACCOUNT -> R.drawable.ic_account_24
            else -> R.drawable.ic_arrow_24
        }

        rootView?.findViewById<ImageView>(R.id.header_icon).apply {
            rootView?.resources?.getDrawable(iconHeader, null).also { icon ->
                this?.setImageDrawable(icon)
            }
        }

        rootView?.findViewById<TextView>(R.id.headel_label).apply {
            this?.text = headerItem.name
        }

    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder?) {
        super.onUnbindViewHolder(viewHolder)
    }

}
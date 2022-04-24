package com.example.mytrainingtv.ui.catalog

import android.graphics.drawable.Drawable
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.example.mytrainingtv.R
import com.example.mytrainingtv.model.VideoItem
import com.example.mytrainingtv.util.loadBitmapIntoImageView

class CatalogCardPresenter : Presenter(){

    private var defaultCardImage: Drawable? = null
    private var selectedBackgroundColor: Int = 0
    private var defaultBackgroundColor: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        parent?.context?.let { context ->
            defaultBackgroundColor = ContextCompat.getColor(context, R.color.default_background)
            selectedBackgroundColor = ContextCompat.getColor(context, R.color.selected_background)
            defaultCardImage = ContextCompat.getDrawable(context, R.drawable.movie)
        }

        val cardView = object : ImageCardView(parent?.context){
            override fun setSelected(selected: Boolean) {
                updateCardBackgroundColor(this ,selected)
                super.setSelected(selected)
            }
        }

        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true
        updateCardBackgroundColor(cardView, false)
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        val videoItem = item as VideoItem
        val video = videoItem.video

        val cardView = viewHolder?.view as ImageCardView
        cardView.titleText = video.title
        cardView.contentText = video.channel
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT)

        loadBitmapIntoImageView(cardView.context, video.cardImageUrl, R.drawable.movie, cardView.mainImageView)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
        val cardView = viewHolder?.view as ImageCardView
        cardView.badgeImage = null
        cardView.mainImage = null
    }

    private fun updateCardBackgroundColor(view:ImageCardView, selected: Boolean){
        val color = if (selected) selectedBackgroundColor else defaultBackgroundColor
        view.setBackgroundColor(color)
        view.setInfoAreaBackgroundColor(color)
    }

    companion object{
        private const val CARD_WIDTH = 313
        private const val CARD_HEIGHT = 176
    }
}
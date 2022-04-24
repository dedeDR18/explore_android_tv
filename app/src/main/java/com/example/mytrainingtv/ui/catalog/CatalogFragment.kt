package com.example.mytrainingtv.ui.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.example.mytrainingtv.R
import com.example.mytrainingtv.presenter.IconHeaderItemPresenter


class CatalogFragment : BrowseSupportFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpTitleAndHeader()
        loadAndShowPlaylist()
    }


    private fun setUpTitleAndHeader() {
        title = "Browse Title"

        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        brandColor = ContextCompat.getColor(requireContext(), R.color.fastlane_background)
        setHeaderPresenterSelector(object : PresenterSelector(){
            override fun getPresenter(item: Any?): Presenter {
                return IconHeaderItemPresenter()
            }
        })
    }

    private fun loadAndShowPlaylist() {
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        val header1 = HeaderItem(1, "Aku")
        val header2 = HeaderItem(2, "Sayang")
        val header3 = HeaderItem(3, "Banget")
        val header4 = HeaderItem(4, "Sama")
        val header5 = HeaderItem(5, "Kamu")
        val listRowAdapter = ArrayObjectAdapter()

        rowsAdapter.add(ListRow(header1, listRowAdapter))
        rowsAdapter.add(ListRow(header2, listRowAdapter))
        rowsAdapter.add(ListRow(header3, listRowAdapter))
        rowsAdapter.add(ListRow(header4, listRowAdapter))
        rowsAdapter.add(ListRow(header5, listRowAdapter))

        adapter = rowsAdapter
    }

    companion object {
        const val HEADER_ID_HOME: Long = 1
        const val HEADER_ID_LIVE_EVENT: Long = 2
        const val HEADER_ID_LIVE_TV: Long = 3
        const val HEADER_ID_FAVORITE: Long = 4
        const val HEADER_ID_ACCOUNT: Long = 5
    }


}
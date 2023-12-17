package com.paba.projectpaba

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.paba.projectpaba.DeleteVideoButtonDialog.Companion.TAG


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private var videoArrayList: ArrayList<Video> = arrayListOf()
    private lateinit var _videoRecyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _videoRecyclerView = view.findViewById(R.id.video_recycler_view)
        addData()

        val addVideoButton = view.findViewById<ImageView>(R.id.add_video_button)
        addVideoButton.setOnClickListener {
            this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddVideoActivity())
        }
    }

    private fun addData() {
        MainActivity.videoArrayList.clear()
        videoArrayList.clear()
        MainActivity.db.collection("tbVideo").get().addOnSuccessListener { result ->
            for (document in result) {
                val hasil = Video (
                    document.data.get("title").toString(),
                    document.data.get("image").toString(),
                    document.data.get("description").toString(),
                    document.data.get("id").toString()
                )
                MainActivity.videoArrayList.add(hasil)
                videoArrayList.add(hasil)
            }
            showData()
        }
    }

    private fun showData() {
        _videoRecyclerView.layoutManager = LinearLayoutManager(context)
        val videoAdapter = VideoAdapter(videoArrayList)
        _videoRecyclerView.adapter = videoAdapter

        videoAdapter.setOnItemClickCallback(object : VideoAdapter.OnItemClickCallback {
            override fun openVideo(pos: Int, id: String) {
                val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
                val webIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/watch?v=$id")
                )
                try {
                    context!!.startActivity(appIntent)
                } catch (ex: ActivityNotFoundException) {
                    context!!.startActivity(webIntent)
                }
            }

            override fun deleteVideo(pos: Int) {
                val deleteVideoButtonDialog = DeleteVideoButtonDialog(pos)
                deleteVideoButtonDialog.show(childFragmentManager, TAG)
            }
        })
        videoAdapter.notifyDataSetChanged()
    }
}
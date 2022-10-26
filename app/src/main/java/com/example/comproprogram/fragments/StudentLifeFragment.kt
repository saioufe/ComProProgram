package com.example.comproprogram.fragments


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comproprogram.ui.MainActivity
import com.example.comproprogram.R
import com.example.comproprogram.adaptors.StudentLifeImagesAdaptor


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class StudentLifeFragment(mainActivity: MainActivity) : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    val images: MutableList<String> = ArrayList()
    var videoUrl =
        "https://firebasestorage.googleapis.com/v0/b/baghdad-apparel.appspot.com/o/videoplayback.mp4?alt=media&token=98dbbe86-b916-4897-986f-50ef68f7e94e"

    var context = mainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        images.add("https://firebasestorage.googleapis.com/v0/b/baghdad-apparel.appspot.com/o/DSC01112-7-1030x626.webp?alt=media&token=454a6f54-fb50-44f8-8827-0835b4e87ddf")
        images.add("https://firebasestorage.googleapis.com/v0/b/baghdad-apparel.appspot.com/o/Phyo-Medhi-enjoying-a-trail-walk.webp?alt=media&token=55c48ef4-0406-4fd8-aa65-f980a74ffd70")
        images.add("https://firebasestorage.googleapis.com/v0/b/baghdad-apparel.appspot.com/o/Student-Family-photo-1-1011x1030.webp?alt=media&token=aa9bff10-f9b6-4f78-af8d-6473e08541f6")
        images.add("https://firebasestorage.googleapis.com/v0/b/baghdad-apparel.appspot.com/o/argiro-Student-Center-lobby-Maharishi-University.webp?alt=media&token=59f50f1c-822e-41ce-b4a9-f3796100ef4e")
        images.add("https://firebasestorage.googleapis.com/v0/b/baghdad-apparel.appspot.com/o/compro-program-graduates-throwing-hats-1030x649.webp?alt=media&token=baaf162a-9223-4f1b-baf7-07ac3aeb88c9")
        images.add("https://firebasestorage.googleapis.com/v0/b/baghdad-apparel.appspot.com/o/golden-domes-miu-campus-1030x772.webp?alt=media&token=f37f08b1-7fa0-4743-89b0-d3d6fb1af111")
        images.add("https://firebasestorage.googleapis.com/v0/b/baghdad-apparel.appspot.com/o/mum-compro-formal-clips-b.00_14_47_18.Still055-1-1030x654.webp?alt=media&token=57a4e523-2599-4d07-ad90-e7d98dd92a87")
        images.add("https://firebasestorage.googleapis.com/v0/b/baghdad-apparel.appspot.com/o/mumcampus1-1.webp?alt=media&token=923c580f-7774-4951-ba93-d9252a940d02")
        images.add("https://firebasestorage.googleapis.com/v0/b/baghdad-apparel.appspot.com/o/phoca_thumb_l_happy_canoers_600.webp?alt=media&token=404d5a80-e775-4355-84e4-9d9b41df11af")
        images.add("https://firebasestorage.googleapis.com/v0/b/baghdad-apparel.appspot.com/o/walking-through-lieb-park-from-south-1030x773.webp?alt=media&token=a107f2e3-1669-4645-a9e9-c094349415bb")


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_student_life, container, false)


        val studentImagesRecycler = v.findViewById<View>(R.id.studentlife_images) as RecyclerView
        studentImagesRecycler.setNestedScrollingEnabled(false);

        // Create adapter passing in the sample user data
        val adapter = StudentLifeImagesAdaptor(context,images)
        // Attach the adapter to the recyclerview to populate items
        studentImagesRecycler.adapter = adapter
        // Set layout manager to position the items
        studentImagesRecycler.layoutManager = GridLayoutManager(context , 2)



        val videoView: VideoView = v.findViewById(R.id.videoView)


        val uri: Uri = Uri.parse(videoUrl)


        videoView.setVideoURI(uri)

        val mediaController = MediaController(context)

        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)
        videoView.setZOrderOnTop(true)


        videoView.start()
        return v
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FinancesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FinancesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
package com.paba.projectpaba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlayerVsPlayerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayerVsPlayerFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_player_vs_player, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlayerVsPlayerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlayerVsPlayerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private lateinit var editTextPlayer1: EditText
    private lateinit var editTextPlayer2: EditText
    private lateinit var buttonShowWinner: Button
    private lateinit var recyclerViewPlayers: RecyclerView
    private lateinit var playerAdapter: PlayerAdapter

    private val playerList = mutableListOf<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextPlayer1 = view.findViewById(R.id.editTextPlayer1)
        editTextPlayer2 = view.findViewById(R.id.editTextPlayer2)
        buttonShowWinner = view.findViewById(R.id.buttonShowWinner)
        recyclerViewPlayers = view.findViewById(R.id.recyclerViewPlayers)

        playerAdapter = PlayerAdapter(playerList, requireContext())
        recyclerViewPlayers.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewPlayers.adapter = playerAdapter

        buttonShowWinner.setOnClickListener {
            showWinner()
        }
    }

    private fun showWinner() {
        val player1 = editTextPlayer1.text.toString()
        val player2 = editTextPlayer2.text.toString()

        if (player1.isNotEmpty() && player2.isNotEmpty()) {
            val winner = if (Random.nextBoolean()) player1 else player2
            playerList.add("$player1 vs $player2 - Winner: $winner")
            playerAdapter.notifyDataSetChanged()
            editTextPlayer1.text.clear()
            editTextPlayer2.text.clear()
        }
    }
}
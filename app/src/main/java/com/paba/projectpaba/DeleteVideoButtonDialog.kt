package com.paba.projectpaba

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController

class DeleteVideoButtonDialog(val pos: Int) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext()).setTitle("HAPUS DATA")
            .setMessage("Apakah benar data " + MainActivity.videoArrayList[pos].title + " akan dihapus ?")
            .setPositiveButton("HAPUS") { _, _ ->
                Toast.makeText(context, "DATA ${MainActivity.videoArrayList[pos].title} BERHASIL DIHAPUS", Toast.LENGTH_SHORT).show()
                MainActivity.db.collection("tbVideo").document(MainActivity.videoArrayList[pos].id).delete()
                MainActivity.videoArrayList.removeAt(pos)
                this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentSelf())
            }
            .setNegativeButton("BATAL") { _, _ ->
                Toast.makeText(context, "DATA BATAL HAPUS", Toast.LENGTH_SHORT).show()
            }.create()

    companion object {
        const val TAG = "deleteVideoButton"
    }
}

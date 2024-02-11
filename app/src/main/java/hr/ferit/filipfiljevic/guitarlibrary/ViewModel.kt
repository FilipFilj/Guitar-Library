package hr.ferit.filipfiljevic.guitarlibrary

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class SongViewModel: ViewModel() {
    private val db = Firebase.firestore
    var songs = mutableStateListOf<MySong>()


    // val bands = listOf<Band>()
    //val ChordKList = listOf<ChordK>()

    init {
        fetchDatabaseData()
    }

    private fun fetchDatabaseData() {
        db.collection("Song")
            .get()
            .addOnSuccessListener { result ->
                for (data in result.documents) {
                    val song = data.toObject(MySong::class.java)
                    if (song != null) {
                        song.songid = data.id
                        songs.add(song)
                    }
                }
            }
    }

    fun updateSong(songId: String, fave: Boolean) {
        val songtoupdate = db.collection("Song").document(songId)

        songtoupdate.update("favorite", fave)
            .addOnSuccessListener {
            }
    }
}


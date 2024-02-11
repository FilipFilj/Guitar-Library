package hr.ferit.filipfiljevic.guitarlibrary

import androidx.annotation.DrawableRes


data class MySong (
    var songid: String = "",
    var artist: String = "",
    var songName: String = "",
    var chordsUsed: String = "",
    var songtext: String = "",
    var rythm: String= "",
    var bandId: String = "",
    var favorite: Boolean = false
)
{

}


class chordNames (
    @DrawableRes val chordPhoto: Int,
    val keyid: String = "",
    val NameOfChord: String = ""
) {

}


class Band (
    @DrawableRes val wallpaper: Int,
    val name : String,
    val genreId: Int,
    var BandId: String,
    val members: String,
    val bestSongs: List<String>,
    val album: List<Album>
){

}

class Album(
    @DrawableRes val wallpaper: Int,
){}

class ChordK (
    val whichK: String = "",
    var k: String = "",
    val chordList: List<chordNames>
)
{

}

/*
var songs = mutableListOf<Song>(
    Song("Bijelo Dugme", "A i ti me iznevjeri", "Am, E7, G, F", "Am \n" +
            "Ti nisi ti vise \n" +
            "i sto mi je najbolnije \n" +
            "F#m \n" +
            "Nikom na svijetu kao meni nije \n" +
            "Liju mi teske novembarske kise \n" +
            "  G       Am  E7      F \n" +
            "A ti ne pitas kako mi je \n" +
            "    Am \n" +
            "jer ti nisi ti vise \n" +
            " \n" +
            "Kazu da me varas \n" +
            "kazu da me ostavljas \n" +
            "kazu mi da si zavoljela drugog \n" +
            "i da ti nista moje drago nije \n" +
            "A ti ne pitas kako mi je \n" +
            " \n" +
            "Ref: \n" +
            "Am  C \n" +
            "Godine prolaze \n" +
            "E7            Am \n" +
            "Laste ni ne dolaze \n" +
            "F  G         E7   Am \n" +
            "Ne mirisu mi zumbuli \n" +
            "C G E7        Am   C G E7 Am   C G E7 Am \n" +
            "A i ti me iznevjeri \n" +
            "C G E7        Am   C G E7 Am \n" +
            "A i ti me iznevjeri \n", "bijelodugme"
    ),
    Song("Parni valjak", "Zastave", "Am, E7, G, F", "Am \n" +
            "Intro:\n" +
            "\n" +
            "Am C G F G Am C G (Trudite se da ne svirate akorde na prvu, \n" +
            "nego zicu po zicu kao u pesme kad je intro!\n" +
            "\n" +
            "Am          C\n" +
            "Nogom pred nogu tiho\n" +
            "G             F\n" +
            "ja po vodi hodam\n" +
            "Am        C       F\n" +
            "svojim putem uspravno.\n" +
            "\n" +
            "Am          C\n" +
            "Pljuga na pljugu\n" +
            "G           F\n" +
            "jedno na drugu slazem\n" +
            "Am     C     G\n" +
            "sate,dane,godine.\n" +
            "\n" +
            "Dm      Am         G\n" +
            "I teku bitke teku porazi\n" +
            "Dm        Am      F      G\n" +
            "kad nije film da pravda pobjedi.\n" +
            "\n" +
            "Sjeti se...\n" +
            "\n" +
            "Am       C        \n" +
            "Kako smo mastat znali\n" +
            "G        F\n" +
            "i Bogu dane krali\n" +
            "Am       C      G\n" +
            "ispred zvecke satima\n" +
            "Am       C       G     F\n" +
            "kovali planove kuzili istine\n" +
            "Am      C       G\n" +
            "svak sa svojeg oblaka.\n" +
            "\n" +
            "Dm         Am        G\n" +
            "Kad krenu bitke dodu porazi\n" +
            "Dm         Am        F    G\n" +
            "ti znas da nije lako isti ostati\n" +
            "\n" +
            "Ref.\n" +
            "     C   G\n" +
            "Moje zastave\n" +
            "F         G\n" +
            "uvijek su iste boje\n" +
            "C         G       F\n" +
            "nad njima ljubav caruje.\n" +
            "     C    G\n" +
            "Moje zastave\n" +
            "F        G\n" +
            "nikad na pola koplja\n" +
            "C       G    F\n" +
            "ljubav se ne predaje.\n" +
            "\n" +
            "Nogom pred nogu tiho\n" +
            "ja na zici plesem\n" +
            "zatvorenih ociju.\n" +
            "\n" +
            "Pljuga na pljugu\n" +
            "jedno na drugu slazem\n" +
            "sate,dane,godine.\n" +
            "\n" +
            "Sad neki novi klinci dolaze\n" +
            "a, sve se teze\n" +
            "prave rijeci nalaze\n" +
            "\n" +
            "Ref. x2\n" +
            "Moje zastave\n" +
            "uvijek su iste boje\n" +
            "nad njima ljubav caruje.\n" +
            "Moje zastave\n" +
            "nikad na pola koplja\n" +
            "ljubav se ne predaje.\n" +
            "\n" +
            "Moje zastave\n" +
            "uvijek su iste boje\n" +
            "nad njima ljubav caruje.\n" +
            "Moje zastave\n" +
            "nikad na pola koplja\n" +
            "ljubav se ne predaje.\n" +
            "\n" +
            "\n" +
            "SOLO ", "parnivaljak"
    ),
    Song("Parni Valjak", "A ja bi sa vragom", "aaa", "aaa", "parnivaljak"),
    Song("Parni Valjak", "Dodji", "aaa", "aaa", "parnivaljak"),
    Song("Parni Valjak", "Dok si pored mene", "aaa", "aaa", "parnivaljak"),
    Song("Parni Valjak", "Jesen u meni", "aaa", "aaa", "parnivaljak"),
    Song("Parni Valjak", "Ljubavna", "aaa", "aaa", "parnivaljak"),
    Song("Parni Valjak", "Lutka za bal", "A, E, D",
        "A                D \n" +
                "hajde mala dodji u moju sobu \n" +
                "A                E \n" +
                "imacemo privatan bal \n" +
                "A                D \n" +
                "steta bi bilo da propadne stvar \n" +
                "          E                 A (E) \n" +
                "kad kazes da smo tako dobar par. \n" +
                "\n" +
                "A                           D \n" +
                "sreo sam je prvi put u diskoteci \n" +
                "A                                  E \n" +
                "dolje u Ljubljani dok trajao je Bum festival \n" +
                "A                        D \n" +
                "bacila je ruke oko moga vrata \n" +
                "  A               E               A ( E) \n" +
                "i rekla aki zar nismo dobar par. \n" +
                "\n" +
                "ref.\n" +
                " \n" +
                "hej sta ti mislis  \n" +
                "da sam ja macka samo za jednu noc\n" +
                "ne al' ja sam samo jos danas ovdje \n" +
                "i 'ko zna kad opet moci cu doc'. ", "parnivaljak"),
)



*/



val bands = listOf<Band>(
    Band(R.drawable.parniv,"Parni valjak", 1, "parnivaljak", "Igor Drvenkar, Husein Hasanefendić-Hus, Marijan Brkić - Brk," +
            "Zorislav Preksavec - Prexi Dalibor Marinković - Dado, Berislav Blažević - Bero, Ana Kabalin", listOf("Dođi", "Jesen u meni" , "Sve još miriše na nju", "Lutka za bal"),
        listOf(
            Album(R.drawable.andjeli),
            Album(R.drawable.glavnomulicom),
            Album(R.drawable.uhvatiritam),
            Album(R.drawable.sjaj)
            )
    ),
    Band(R.drawable.prljavokazaliste,"Prljavo kazalište", 1, "prljavokazaliste", "Jasenko Houra, Mladen Bodalec, Marijan Brkić" , listOf("Mojoj Majci", "Heroj ulice", "Tu noć kad si se udavala", "Kiše jesenje"),
    listOf(
        Album(R.drawable.lupipetama),
        Album(R.drawable.heroj),
    )),
    Band(R.drawable.dugme,"Bijelo Dugme", 1, "bijelodugme", "Goran Bregović, Alen Islamović, Željko Bebek, Vlado Pravdić, Tifa",
        listOf("Lipe cvatu", "Hajdemo u planine" , "Ako ima boga", "Za Esmu"),
        listOf(
            Album(R.drawable.bitanga),
            Album(R.drawable.dugmealbum),
        )),
    Band(R.drawable.metallica,"Metallica", 2, "metallica", "James Hetfield, Lars Ulrich" +
            "Kirk Hammett, Robert Trujillo", listOf("One", "Nothing else matters" , "Enter sandman", "Master of puppets"),
        listOf(
            Album(R.drawable.masterof),
            Album(R.drawable.justice),
        ))
)






val ChordKList = listOf<ChordK>(
    ChordK(
        "Key of C Major",
        "cmaj",
        listOf(
            chordNames(
                R.drawable.aminor,
                "cmaj",
                "A Minor"
            ),
            chordNames(
                R.drawable.bdim,
                "cmaj",
                "B Dim"
            ),
            chordNames(
                R.drawable.cmajor,
                "cmaj",
                "C Major"
            ),
            chordNames(
                R.drawable.dminor,
                "cmaj",
                "D Minor"
            ),
            chordNames(
                R.drawable.eminor,
                "cmaj",
                "E Minor"
            ),
            chordNames(
                R.drawable.fmajor,
                "cmaj",
                "F Major"
            ),
            chordNames(
                R.drawable.gmajor,
                "cmaj",
                "G Major"
            )
        )
    ),
    ChordK(
        "Key of G Major",
        "gmaj",
        listOf(
            chordNames(
                R.drawable.aminor,
                "cmaj",
                "GGGG"
            ),
            chordNames(
                R.drawable.bdim,
                "cmaj",
                "GGG"
            ),
            chordNames(
                R.drawable.cmajor,
                "cmaj",
                "C Major"
            ),
            chordNames(
                R.drawable.dminor,
                "cmaj",
                "D Minor"
            ),
            chordNames(
                R.drawable.eminor,
                "cmaj",
                "E Minor"
            ),
            chordNames(
                R.drawable.fmajor,
                "cmaj",
                "F Major"
            ),
            chordNames(
                R.drawable.gmajor,
                "cmaj",
                "G Major"
            ))),
    ChordK(
        "Key of F Major",
        "cmaj",
        listOf(
            chordNames(
                R.drawable.aminor,
                "cmaj",
                "A Minor"
            ),
            chordNames(
                R.drawable.bdim,
                "cmaj",
                "B Dim"
            ),
            chordNames(
                R.drawable.cmajor,
                "cmaj",
                "C Major"
            ),
            chordNames(
                R.drawable.dminor,
                "cmaj",
                "D Minor"
            ),
            chordNames(
                R.drawable.eminor,
                "cmaj",
                "E Minor"
            ),
            chordNames(
                R.drawable.fmajor,
                "cmaj",
                "F Major"
            ),
            chordNames(
                R.drawable.gmajor,
                "cmaj",
                "G Major"
            )
        )
    ))



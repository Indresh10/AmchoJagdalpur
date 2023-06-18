package com.example.amchojagdalpur.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.amchojagdalpur.R

data class Place(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val bigImage: Int,
    @DrawableRes val smallImage: Int,
    val address :String,
    val category: Category
)

object PlaceRepo {
    val places: List<Place> = listOf(
        Place(
            R.string.resort1,
            R.string.resdesc1,
            R.drawable.tak_big,
            R.drawable.tak_small,
            "Takshshila Park And Resorts, NH30, Madhin Chowk, Jagdalpur, Chhattisgarh 494001",
            category = CatRepo.categories[0]
        ),
        Place(
            R.string.resort2,
            R.string.resdesc2,
            R.drawable.naman_big,
            R.drawable.naman_small,
            "Naman Bastar, Chitrakote Rd, Jagdalpur, Chhattisgarh 494005",
            category = CatRepo.categories[0]
        ),
        Place(
            R.string.resort3,
            R.string.resdesc3,
            R.drawable.gan_big,
            R.drawable.gan_small,
            "Ganpati Resort, National Highway - 6, Dhurkoda Road, Jagdalpur, Chhattisgarh 494001",
            category = CatRepo.categories[0]
        ),
        Place(
            R.string.resort4,
            R.string.resdesc4,
            R.drawable.bastar_big,
            R.drawable.bastar_small,
            "Ganpati Resort, National Highway - 6, Dhurkoda Road, Jagdalpur, Chhattisgarh 494001",
            category = CatRepo.categories[0]
        ),
        Place(
            R.string.resort5,
            R.string.resdesc5,
            R.drawable.river_big,
            R.drawable.river_small,
            "The River Park Resort, Ghat Lohanga, Chhattisgarh 494223",
            category = CatRepo.categories[0]
        ),
        Place(
            R.string.resort6,
            R.string.resdesc6,
            R.drawable.champa_big,
            R.drawable.champa_small,
            "Champa Baag Restaurant, MAA BHAWANI CHOWK, KUMHARPARA, Jagdalpur, Chhattisgarh 494001",
            category = CatRepo.categories[0]
        ),
        Place(
            R.string.rest1,
            R.string.restdesc1,
            R.drawable.devansh_big,
            R.drawable.devansh_small,
            "Hotel Devansh Residency, Kasturba Marg, Chandni Chowk, Distt. Bastar, Jagdalpur, Chhattisgarh 494001",
            category = CatRepo.categories[1]
        ),
        Place(
            R.string.rest2,
            R.string.restdesc2,
            R.drawable.avi_big,
            R.drawable.avi_small,
            "Hotel Avinash International, Chitrakote Rd, Housing Board Colony, Motitalab Para, Jagdalpur, Chhattisgarh 494001",
            category = CatRepo.categories[1]
        ),
        Place(
            R.string.rest3,
            R.string.restdesc3,
            R.drawable.bin_big,
            R.drawable.bin_small,
            "Binaka Heritage, Chitrakoot Road, near Balaji Mandir, Dalpat Sagar Ward, Dharampura, Jagdalpur, Chhattisgarh 494001",
            category = CatRepo.categories[1]
        ),
        Place(
            R.string.rest4,
            R.string.restdesc4,
            R.drawable.urban_big,
            R.drawable.urban_small,
            "Urban Affairs, SECOND FLOOR, Varghese Wings Dharampura No. 1, Jagdalpur, Chhattisgarh 494001",
            category = CatRepo.categories[1]
        ),
        Place(
            R.string.tou1,
            R.string.toudesc1,
            R.drawable.chi_big,
            R.drawable.chi_small,
            "Chitrakote Waterfalls, Tiratha, Chhattisgarh 494010",
            category = CatRepo.categories[2]
        ),
        Place(
            R.string.tou2,
            R.string.toudesc2,
            R.drawable.tirath_big,
            R.drawable.tirath_small,
            "Tirathgarh Waterfall, Kanger Valley National Park, Tirathgar, Chhattisgarh 494442",
            category = CatRepo.categories[2]
        ),
        Place(
            R.string.tou3,
            R.string.toudesc3,
            R.drawable.bas_pal_big,
            R.drawable.bas_pal_small,
            "Bastar Palace, Civil Line, Chhattisgarh 494001",
            category = CatRepo.categories[2]
        ),
        Place(
            R.string.tou4,
            R.string.toudesc4,
            R.drawable.dhara_big,
            R.drawable.dhara_small,
            "Chitradhara Waterfall Tandapal, 494005,, Potanar, Chhattisgarh",
            category = CatRepo.categories[2]
        ),
        Place(
            R.string.tou5,
            R.string.toudesc5,
            R.drawable.kai_big,
            R.drawable.kai_small,
            "Kailash caves, Chhattisgarh 494001",
            category = CatRepo.categories[2]
        ),
        Place(
            R.string.tou6,
            R.string.toudesc6,
            R.drawable.tam_big,
            R.drawable.tam_small,
            "Tamdaghumar Waterfall Jagdalpur, Mardum, Chhattisgarh 494010",
            category = CatRepo.categories[2]
        ),
        Place(
            R.string.park1,
            R.string.parkdesc1,
            R.drawable.lal_big,
            R.drawable.lal_small,
            "Lalbagh Park, Jagdalpur, Chhattisgarh 494001",
            category = CatRepo.categories[3]
        ),
        Place(
            R.string.park2,
            R.string.parkdesc2,
            R.drawable.shahid_big,
            R.drawable.shahid_small,
            "Shahid Park Nehru Bal Udyan, Sun City, Chhattisgarh 494001",
            category = CatRepo.categories[3]
        ),
        Place(
            R.string.park3,
            R.string.parkdesc3,
            R.drawable.lamni_big,
            R.drawable.lamni_small,
            "Lamni Park, Jagdalpur, Chhattisgarh 494001",
            category = CatRepo.categories[3]
        ),
        Place(
            R.string.park4,
            R.string.parkdesc4,
            R.drawable.dal_big,
            R.drawable.dal_small,
            "DalpatSagar, Jagdalpur, Chhattisgarh 494001",
            category = CatRepo.categories[3]
        )
    )
}

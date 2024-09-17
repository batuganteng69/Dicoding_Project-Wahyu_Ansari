package id.wahyu_ansari.dicoding_project.utils

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import kotlin.math.min

class DataLoader(private val context: Context) {
    // Dummy data, simulating data fetch from API or database
    fun loadHistoricalPlaces(): List<HistoricalPlace> {
        val places = listOf(
            HistoricalPlace(
                "Great Wall of China", "China",
                load("great_wall-china.jpg"),
                1368,
                1644,
                "China",
                "Great Wall of China: The Great Wall of China, an ancient series of " +
                        "walls and fortifications, stretches over 13,000 miles in northern " +
                        "China. Originally conceived by Emperor Qin Shi Huang in the third " +
                        "century B.C., it aimed to prevent incursions from barbarian nomads. " +
                        "The best-known section was built during the Ming dynasty " +
                        "(14th–17th centuries A.D.). Though it didn't effectively prevent " +
                        "invasions, the Great Wall symbolizes Chinese civilization’s enduring " +
                        "strength. It’s a testament to human ambition and engineering prowess, " +
                        "with sections made of earth, stone, and even sand and reed in " +
                        "desert regions."
            ),
            HistoricalPlace(
                "The Colosseum", "Italy", load("colosseum-italy.jpg"),
                70,
                80,
                "Italy",
                "Colosseum (Flavian Amphitheatre) in Italy: The Colosseum, stands " +
                        "as the largest Roman theater " +
                        "ever built. Completed around 80 CE, it hosted gladiator games, plays, " +
                        "and public executions. Made of travertine stone and volcanic tufa, " +
                        "the Colosseum’s three stories feature arcades framed by engaged " +
                        "columns in Doric, Ionic, and Corinthian orders. It’s a testament " +
                        "to ancient engineering and remains an iconic symbol of Rome."
            ),
            HistoricalPlace(
                "The Great Pyramid of Giza", "Egypt",
                load("great_pyramid_giza-egypt.jpg"),
                -2600,
                -2570,
                "Egypt",
                "Great Pyramid of Giza: The Great Pyramid, commissioned by " +
                        "Pharaoh Khufu (also known as Cheops), is the oldest of the " +
                        "Seven Wonders of the Ancient World. Built around 2600 BC, " +
                        "it stands on the Giza Plateau near Cairo, Egypt. Constructed " +
                        "primarily of limestone, granite, and mortar, it once stood " +
                        "at 146.6 meters (481 feet) but now reaches 138.5 meters (454 feet). " +
                        "Its precise alignment and massive scale continue to awe visitors, " +
                        "and it remains a testament to ancient Egyptian ingenuity and devotion."
            ),
            HistoricalPlace(
                "The Taj Mahal", "India", load("taj_mahal-india.jpg"),
                1632,
                1648,
                "India",
                "Taj Mahal in India: The Taj Mahal, an ivory-white marble mausoleum, " +
                        "was built in Agra by Mughal Emperor Shah Jahan in memory of his " +
                        "wife, Mumtaz Mahal. Completed in 1653, it is a masterpiece of " +
                        "Indo-Islamic and Mughal architecture. Its symmetrical design, " +
                        "intricate calligraphy, and inlaid gemstones make it a jewel of " +
                        "Muslim art in India. The Taj Mahal’s beauty lies not only in its " +
                        "structure but also in the love story that inspired it78."
            ),
            HistoricalPlace(
                "The Eiffel Tower", "France",
                load("eiffel_tower-france.jpg"),
                1887,
                1889,
                "France",
                "Eiffel Tower in France: Designed by Gustave Eiffel, the Eiffel Tower " +
                        "stands as an iconic wrought-iron lattice structure in Paris. " +
                        "Completed in 1889 for the International Exposition, it was initially " +
                        "met with skepticism due to its unprecedented height " +
                        "(330 meters or 1,083 feet). Yet, it became a technological marvel, " +
                        "defying traditional architectural norms. Today, it remains a symbol " +
                        "of Paris and human creativity."
            ),
            HistoricalPlace(
                "Pompeii", "Italy",
                load("pompeii-italy.jpg"),
                -900,
                -800,
                "Italy",
                "Pompeii in Italy: Pompeii, located near Naples, was famously buried by " +
                        "the eruption of Mount Vesuvius in 79 AD. The volcanic ash and " +
                        "debris preserved the city remarkably well, freezing it in time. " +
                        "As you walk through its streets, you’ll encounter ancient " +
                        "architecture, graffiti, and everyday objects—a vivid glimpse into " +
                        "daily life during ancient Rome. Pompeii is a UNESCO World Heritage " +
                        "Site and a must-visit for history enthusiasts."
            ),
            HistoricalPlace(
                "Tikal", "Guatemala",
                load("tikal-guatemala.jpg"),
                -300,
                300,
                "Guatemala",
                "Tikal in Guatemala: Hidden deep within the Guatemalan jungle, Tikal was " +
                        "once a thriving Mayan city. Its towering temples and pyramids rise " +
                        "above the dense canopy, offering breathtaking views. Tikal’s history " +
                        "spans centuries, and exploring its ruins feels like stepping into an " +
                        "adventure movie. Climb the steep steps, listen to the howler monkeys, " +
                        "and imagine the vibrant civilization that once thrived here."
            ),
            HistoricalPlace(
                "Stonehenge", "England",
                load("stonehenge-england.jpg"),
                -3100,
                -2400,
                "England",
                "Stonehenge in England: Stonehenge, a prehistoric monument on Salisbury " +
                        "Plain, continues to intrigue us. Its massive standing stones arranged " +
                        "in a circular pattern raise questions about ancient rituals, " +
                        "astronomy, and human ingenuity. Visit during sunrise or sunset to " +
                        "witness the magic of this enigmatic site."
            ),
            HistoricalPlace(
                "Parthenon", "Greece",
                load("parthenon-greece.jpg"),
                -447,
                -432,
                "Greece",
                "Pantheon in Greece: Perched atop the Acropolis in Athens, the Parthenon " +
                        "is an architectural marvel. Dedicated to the goddess Athena, it " +
                        "exemplifies classical Greek design. The Doric columns, intricate " +
                        "friezes, and timeless symmetry make it a symbol of ancient wisdom " +
                        "and artistic excellence."
            ),
            HistoricalPlace(
                "Machu Picchu", "Peru",
                load("machu_pichu-peru.jpg"),
                1450,
                1530,
                "Peru",
                "Machu Picchu in Peru: High in the Andes, Machu Picchu stands as the " +
                        "“Lost City of the Incas.” This ancient Incan citadel boasts terraces, " +
                        "temples, and panoramic views. The mist-shrouded peaks and stone " +
                        "structures evoke a sense of wonder and mystery. Hike the Inca Trail " +
                        "to reach this awe-inspiring site."
            ),
            HistoricalPlace(
                "Petra", "Jordan",
                load("petra-jordan.jpg"),
                -900,
                -800,
                "Jordan",
                "Petra in Jordan: Petra, a famous archaeological site in Amman, Jordan. " +
                        "Carved into rose-red cliffs, Petra was the capital of the Nabatean " +
                        "Kingdom. Its iconic Treasury (Al-Khazneh) is instantly recognizable " +
                        "from movies like “Indiana Jones.” Explore the narrow Siq, marvel at " +
                        "the rock-cut tombs, and imagine the bustling trade hub it once was."
            ),
            HistoricalPlace(
                "Angkor Wat", "Cambodia",
                load("angkor_wat-cambodia.jpg"),
                1122,
                1150,
                "Cambodia",
                "Angkor Wat in Cambodia: Angkor Wat, nestled in the Cambodian jungle, " +
                        "is a vast temple complex dedicated to the Hindu god Vishnu " +
                        "(later converted to Buddhism). Its intricate bas-reliefs, lotus-shaped " +
                        "towers, and vast moats evoke a sense of spiritual grandeur."
            )
        )

        return places
    }

    fun getPlace(id:Int): HistoricalPlace {
        val places = loadHistoricalPlaces()
        return places[id]
    }

    fun load(fileName: String): ByteArray {
        val inputStream = context.assets.open("images/$fileName")
        return inputStream.readBytes()
    }

    companion object {
        fun ByteArray.toBitmap(): Bitmap = BitmapFactory.decodeByteArray(
            this, 0, this.size
        )

        fun saveBitmapAndGetUri(bitmap: Bitmap, context: Context): Uri? {
            val contentValues = ContentValues().apply {
                put(MediaStore.Images.Media.DISPLAY_NAME, "image.jpg")
                put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                put(MediaStore.Images.Media.IS_PENDING, 1)
            }

            val collection = MediaStore.Images.Media
                .getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
            val imageUri = context.contentResolver.insert(collection, contentValues)

            imageUri?.let {
                context.contentResolver.openOutputStream(it).use { outputStream ->
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream!!)
                }

                contentValues.clear()
                contentValues.put(MediaStore.Images.Media.IS_PENDING, 0)
                context.contentResolver.update(it, contentValues, null, null)
            }

            return imageUri
        }

        fun Bitmap.resize(ratio: Float): Bitmap {
            val width = (this.width * ratio).toInt()
            val height = (this.height * ratio).toInt()
            return Bitmap.createScaledBitmap(this, width, height, false)
        }

        fun Bitmap.centerCrop(): Bitmap {
            val size = min(this.width, this.height)
            val originalWidth = this.width
            val originalHeight = this.height

            val x = (originalWidth - size) / 2
            val y = (originalHeight - size) / 2

            return Bitmap.createBitmap(this, x, y, size, size)
        }

        data class HistoricalPlace(
            val title: String, val description: String, val icon: ByteArray, val build: Int,
            val complete: Int, val country: String, val details: String
        ) {
            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as HistoricalPlace

                if (title != other.title) return false
                if (description != other.description) return false
                if (!icon.contentEquals(other.icon)) return false

                return true
            }

            override fun hashCode(): Int {
                var result = title.hashCode()
                result = 31 * result + description.hashCode()
                result = 31 * result + icon.contentHashCode()
                return result
            }
        }
    }
}
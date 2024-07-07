package presentation.models

import kotlinx.serialization.Serializable

/**
 * Created by "Mohamad Abuzaid" on 07/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Serializable
data class ActorDisplay(
    val name: String,
    val role: String,
    val photo: String
)
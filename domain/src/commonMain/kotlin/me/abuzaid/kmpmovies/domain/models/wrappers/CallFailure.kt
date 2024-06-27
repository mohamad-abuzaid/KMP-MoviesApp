package me.abuzaid.kmpmovies.domain.models.wrappers

/**
 * Created by "Mohamad Abuzaid" on 26/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
open class CallFailure(val errorModel: ErrorModel) : Throwable()
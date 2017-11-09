package android.erick.domain.interactor

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

/**
 * Created by ericktijero on 11/8/17.
 */
open class BaseSingleObserver<T> : SingleObserver<T> {

    override fun onSubscribe(d: Disposable) { }

    override fun onSuccess(t: T) { }

    override fun onError(exception: Throwable) { }

}
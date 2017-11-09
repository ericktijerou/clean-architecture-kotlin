package android.erick.domain.interactor.main

import android.erick.domain.executor.PostExecutionThread
import android.erick.domain.executor.ThreadExecutor
import android.erick.domain.interactor.SingleUseCase
import android.erick.domain.model.User
import android.erick.domain.repository.RandomRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
open class GetUsers @Inject constructor(val bufferooRepository: RandomRepository,
                                        threadExecutor: ThreadExecutor,
                                        postExecutionThread: PostExecutionThread):
        SingleUseCase<List<User>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<User>> {
        return bufferooRepository.getUsers()
    }

}
package android.erick.domain.executor

import io.reactivex.Scheduler

/**
 * Created by ericktijero on 11/8/17.
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}
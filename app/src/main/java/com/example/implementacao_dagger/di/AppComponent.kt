package com.example.implementacao_dagger.di

import com.example.implementacao_dagger.presentation.UserActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class,
        AndroidInjectionModule::class,
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {

    fun inject(activity: UserActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build(): AppComponent
    }
}
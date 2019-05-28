package com.murtazin.vkapp.presentation.screen.profileView

import com.arellomobile.mvp.InjectViewState
import com.murtazin.vkapp.domain.entity.PostEntity
import com.murtazin.vkapp.domain.entity.ProfileEntity
import com.murtazin.vkapp.domain.repository.PostRepository
import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.converter.Converter
import com.murtazin.vkapp.presentation.converter.PostConverter
import com.murtazin.vkapp.presentation.converter.ProfileConverter
import com.murtazin.vkapp.presentation.model.Post
import com.murtazin.vkapp.presentation.model.Profile
import com.murtazin.vkapp.presentation.navigation.Screen
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileViewPresenter @Inject constructor(
    private val router: Router,
    private val postRepository: PostRepository,
    private val profileRepository: ProfileRepository,
    private val profileConverter: Converter<ProfileEntity, Profile>,
    private val postConverter: Converter<List<PostEntity>, List<Post>>

) : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getProfile()
        getPosts()

    }

    private fun getPosts(){
        postRepository.getPosts(1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showFeed(postConverter.convert(it))
            }, {
                viewState.showNetworkError()
            })
            .untilDestroy()

    }
    private fun getProfile() {
        profileRepository.getProfile()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showProfile(profileConverter.convert(it))
                },
                {
                    viewState.showNetworkError()
                }
            ).untilDestroy()
    }

    fun logout() {
        router.newRootScreen(Screen.LogInScreen())
    }

    fun edit() {
        router.navigateTo(Screen.ProfileEditScreen())

    }
}
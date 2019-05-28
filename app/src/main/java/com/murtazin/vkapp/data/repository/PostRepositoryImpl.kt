package com.murtazin.vkapp.data.repository

import com.murtazin.vkapp.data.converters.DataConverter
import com.murtazin.vkapp.data.datasource.interfaces.PostDataSource
import com.murtazin.vkapp.data.response.PostsResponse
import com.murtazin.vkapp.domain.entity.PostEntity
import com.murtazin.vkapp.domain.repository.PostRepository
import com.murtazin.vkapp.presentation.model.Post
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postDataSource: PostDataSource,
    private val postsConverter: DataConverter<PostsResponse, List<PostEntity>>
): PostRepository {

    override fun getPosts(page:Int): Single<List<PostEntity>> =
        postDataSource.getPosts(140798,page)
            .subscribeOn(Schedulers.io())
            .map(postsConverter::convert)


}
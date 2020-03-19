package dev.shreyaspatil.foodium.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.shreyaspatil.foodium.databinding.ItemPostBinding
import dev.shreyaspatil.foodium.model.Post
import dev.shreyaspatil.foodium.ui.viewholder.PostViewHolder
import javax.inject.Inject

class PostListAdapter @Inject constructor() :
    RecyclerView.Adapter<PostViewHolder>() {

    private val mPostList: MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = createPostViewHolder(parent)

    override fun getItemCount() = mPostList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
        holder.bind(mPostList[position])

    private fun createPostViewHolder(parent: ViewGroup) =
        PostViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    fun setPosts(postList: List<Post>) {
        clearAllPosts()
        mPostList.addAll(postList)
        notifyDataSetChanged()
    }

    fun clearAllPosts() {
        mPostList.clear()
    }
}
package android.erick.ui.main

import android.erick.ui.R
import android.erick.ui.model.UserViewModel
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import javax.inject.Inject

/**
 * Created by ericktijero on 11/9/17.
 */
class MainAdapter @Inject constructor(): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var users: List<UserViewModel> = arrayListOf()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.nameText.text = user.name.first
        holder.titleText.text = user.name.title

        Glide.with(holder.itemView.context)
                .load(user.picture.medium)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.avatarImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var avatarImage: ImageView
        var nameText: TextView
        var titleText: TextView

        init {
            avatarImage = view.findViewById(R.id.image_avatar)
            nameText = view.findViewById(R.id.text_name)
            titleText = view.findViewById(R.id.text_title)
        }
    }

}
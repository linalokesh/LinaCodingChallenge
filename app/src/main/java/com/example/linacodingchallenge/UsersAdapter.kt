package com.example.linacodingchallenge

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.TextView
import kotlinx.android.synthetic.main.user_row.view.*

class UsersAdapter(private val users: List<User>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount()= users.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        //Log.d("Lina","phone number? ${user.phone}")
        holder.name.text= user.name
        holder.email.text= user.email
        holder.phone.text=user.phone

    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val name:TextView= itemView.name
        val email: TextView= itemView.email
        val phone: TextView = itemView.phone

    }

}

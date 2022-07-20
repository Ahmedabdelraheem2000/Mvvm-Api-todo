package com.shopping.mvvmapi.ui.Mvvm_Api_Activity.Utils_Api_Activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shopping.mvvmapi.databinding.ItemTodosBinding
import com.shopping.mvvmapi.model.ToDo_Api

class Api_Adapter : RecyclerView.Adapter<Api_Adapter.Api_Holder>() {
    inner class Api_Holder(val binding: ItemTodosBinding) : RecyclerView.ViewHolder(binding.root){}

    private val diffcallback=object : DiffUtil.ItemCallback<ToDo_Api>(){
        override fun areItemsTheSame(oldItem: ToDo_Api, newItem: ToDo_Api): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: ToDo_Api, newItem: ToDo_Api): Boolean {
            return oldItem==newItem
        }

    }

    private val differ=AsyncListDiffer(this,diffcallback)

    var todo: List<ToDo_Api>
        get() {
          return differ.currentList
        }
        set(value) {  differ.submitList(value)  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Api_Holder {
       return Api_Holder(ItemTodosBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Api_Holder, position: Int) {
        holder.binding.apply {
            val TD_Api=todo[position]
            tvTitleTodo.setText(TD_Api.title)
            checkBoxTodo.isChecked=TD_Api.completed
        }
    }

    override fun getItemCount(): Int {
        return todo.size
    }

}
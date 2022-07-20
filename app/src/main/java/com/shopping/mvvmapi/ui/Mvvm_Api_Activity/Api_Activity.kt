package com.shopping.mvvmapi.ui.Mvvm_Api_Activity

import android.os.Bundle
import android.util.Log
import android.util.Log.ASSERT
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.shopping.mvvmapi.databinding.ActivityApiBinding
import com.shopping.mvvmapi.model.ToDo_Api
import com.shopping.mvvmapi.server.Todos_Api_Instence
import com.shopping.mvvmapi.ui.Mvvm_Api_Activity.Utils_Api_Activity.Api_Adapter
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.Exception
import kotlin.math.log

class Api_Activity : AppCompatActivity() {
    lateinit var binding: ActivityApiBinding
    private lateinit var todolistadapter:Api_Adapter
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        binding=ActivityApiBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)

        lifecycleScope.launchWhenCreated {
            binding.progressTodoActivity.isVisible=true
             val response =try{

                Todos_Api_Instence.api.getTodos()

            }
             catch (e:HttpException){
                binding.progressTodoActivity.isVisible=false
                return@launchWhenCreated
            }
            catch (e:IOException){
                binding.progressTodoActivity.isVisible=false
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body()!=null){                Toast.makeText(this@Api_Activity,"Resbonce Not Successful",Toast.LENGTH_SHORT)
                binding.progressTodoActivity.isVisible=false

                todolistadapter.todo=response.body()!!
            }
            else{

                binding.progressTodoActivity.isVisible=false

            }

        }
        Get_Data_to_Recycler()


    }
    fun Get_Data_to_Recycler()=
        binding.recyclerViewTodo.apply {
             todolistadapter =Api_Adapter()
            adapter=todolistadapter
            layoutManager=LinearLayoutManager(this@Api_Activity)

    }
}
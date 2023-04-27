package com.example.implementacao_dagger.presentation

import android.os.Bundle
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.implementacao_dagger.data.model.UserDetails
import com.example.implementacao_dagger.di.MyApplication
import com.example.implementacao_dagger.di.ViewModelFactory
import com.example.implementaodagger.databinding.ActivityMainBinding
import javax.inject.Inject

class UserActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: UserViewModel

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MyApplication).appComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupViewModel()
        setupRecyclerView()
        setupAddButton()

        viewModel.getUsers()
    }

    private fun setupViewModel() {
        viewModel.userLiveData.observe(this) { state ->
            when (state) {
                is UserState.SuccessList -> showList(state.response)
                is UserState.SuccessAddName -> toastSuccess()
            }
        }
    }

    private fun setupAddButton() {
        binding.button.setOnClickListener {
            val user = binding.editText.text.toString()
            val userDetails = UserDetails(name = user, id = 0L)
            viewModel.addName(userDetails)
            binding.editText.text.clear()

            /**
             * esconde o teclado virtual
             */
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.button.windowToken, 0)
        }
    }

    private fun toastSuccess() {
        val toast = Toast.makeText(this, "Usuario cadastrado", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }

    private fun setupRecyclerView() {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter()
        binding.recycler.adapter = adapter
    }

    private fun showList(list: List<UserDetails>) {
        adapter.update(list)
    }
}
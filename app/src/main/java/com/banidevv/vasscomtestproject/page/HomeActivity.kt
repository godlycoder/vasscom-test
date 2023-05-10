package com.banidevv.vasscomtestproject.page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.banidevv.vasscomtestproject.databinding.ActivityHomeBinding
import com.banidevv.vasscomtestproject.domain.uimodel.ProductUiModel
import com.banidevv.vasscomtestproject.domain.uimodel.ServiceUiModel
import com.banidevv.vasscomtestproject.page.adapter.ProductAdapter
import com.banidevv.vasscomtestproject.page.adapter.ServicesAdapter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.appBar.setOnMenuClickListener {
            binding.ltDrawer.root.isVisible = true
        }

        binding.ltDrawer.closeDrawer.setOnClickListener {
            binding.ltDrawer.root.isVisible = false
        }

        binding.ltDrawer.directProfile.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }

        binding.rvServices.adapter = ServicesAdapter().apply {
            setData(arrayListOf(
                ServiceUiModel("PCR Swab Test (Drive Thru)\n" +
                    "Hasil 1 Hari Kerja", 1000000, "https://res.cloudinary.com/dk0z4ums3/image/upload/v1625808772/attached_image/apakah-pcr-bisa-membedakan-jenis-varian-virus-corona-0-alodokter.jpg",
                    "Santosa Hospital", "Kopo, Bandung"
                )
            ))
        }

        binding.rvProduct.adapter = ProductAdapter().apply {
            setData(arrayListOf(
                ProductUiModel("Suntik Steril",
                    1000000,
                    4.5f,
                    "https://res.cloudinary.com/dk0z4ums3/image/upload/v1625808772/attached_image/apakah-pcr-bisa-membedakan-jenis-varian-virus-corona-0-alodokter.jpg",true
                )
            ))
        }
    }
}
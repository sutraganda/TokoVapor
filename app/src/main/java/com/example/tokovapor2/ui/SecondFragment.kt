package com.example.tokovapor2.ui

import android.content.ContentProviderClient
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tokovapor2.R
import com.example.tokovapor2.aplication.VaporsApp
import com.example.tokovapor2.databinding.FragmentSecondBinding
import com.example.tokovapor2.model.Vapors
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), OnMapReadyCallback,  GoogleMap.OnMarkerDragListener {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!
    private lateinit var applicationContext: Context
    private val vaporsViewModel: VaporsViewModel by viewModels {
        VaporViewModelFactory((applicationContext as VaporsApp).repository)
    }
    private val args : SecondFragmentArgs by navArgs()
    private var vapors: Vapors? = null
    private lateinit var mMap: GoogleMap
    private var currentLatLang: LatLng? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onAttach(context: Context) {
        super.onAttach(context)
        applicationContext = requireContext().applicationContext
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vapors = args.vapors
//kita cek
        if (vapors != null) {
            binding.deleteButton.visibility = View.VISIBLE
            binding.saveButton.text = "UBAH"
            binding.nameEditText.setText(vapors?.name)
            binding.addressEditTextText2.setText(vapors?.address)
            binding.goodsEditTextText3.setText(vapors?.goods)
            binding.typeEditTextText.setText(vapors?.type)
            binding.amountgoodsEditTextText2.setText(vapors?.amountgoods)
        }

        //binding map
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        checkPermission()

        val name = binding.nameEditText.text
        val address = binding.addressEditTextText2.text
        val goods = binding.goodsEditTextText3.text
        val type = binding.typeEditTextText.text
        val amountgoods = binding.amountgoodsEditTextText2.text
        binding.saveButton.setOnClickListener {
            if (name.isEmpty() ){
                Toast.makeText(context, "Nama Tidak Boleh kosong", Toast.LENGTH_SHORT).show()

                } else if (address.isEmpty() ){
                 Toast.makeText(context, "Alamat Tidak Boleh kosong", Toast.LENGTH_SHORT).show()

                } else {
                    //jika berhasil run
                    //masukan data latitude
                if (vapors == null) {
                    val vapors = Vapors(0, name.toString(), address.toString(),
                        goods.toString(), type.toString(), amountgoods.toString(), currentLatLang?.latitude, currentLatLang?.longitude)
                    vaporsViewModel.insert(vapors)

                } else {
                    val vapors = Vapors(vapors?.id!!, name.toString(), address.toString(),
                        goods.toString(), type.toString(), amountgoods.toString(), currentLatLang?.latitude, currentLatLang?.longitude)
                    vaporsViewModel.update(vapors)

                }
                val vapors = Vapors(0, name.toString(), address.toString(),
                    goods.toString(), type.toString(), amountgoods.toString(), currentLatLang?.latitude, currentLatLang?.longitude)
                vaporsViewModel.insert(vapors)
                findNavController().popBackStack() // untuk dismiss halaman ini
            }

        }

        binding.deleteButton.setOnClickListener {
                vapors?.let { vaporsViewModel.delete(it) }
                findNavController().popBackStack()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        //drag marker

        val uiSetting = mMap.uiSettings
        uiSetting.isZoomControlsEnabled = true
        mMap.setOnMarkerDragListener(this)
    }

    override fun onMarkerDrag(p0: Marker) {
    }

    override fun onMarkerDragEnd(marker: Marker) {
        val newPosition = marker.position
        currentLatLang = LatLng(newPosition.latitude, newPosition.longitude)
        Toast.makeText(context, currentLatLang.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onMarkerDragStart(p0: Marker) {
    }

    private fun checkPermission() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(applicationContext)
        if (ContextCompat.checkSelfPermission(
            applicationContext,
            android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            getCurrentLocation()
        } else {
            Toast.makeText(applicationContext, "Akses lokasi ditolak", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getCurrentLocation() {
        //ngecek
        if (ContextCompat.checkSelfPermission(
                applicationContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        //untuk test
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    val latLang = LatLng(location.latitude, location.longitude)
                    currentLatLang = latLang
                    var title = "Marker"
                    //menampilkan lokasi sesuai koordnat
                    if (vapors != null) {
                        title = vapors?.name.toString()
                        val newCurrentLocation = LatLng(vapors?.latitude!!, vapors?.longitude!!)
                        latLang
                    }
                    val markerOptions = MarkerOptions()
                        .position(latLang)
                        .title("title")
                        .draggable(true)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_electronic_cigar_32))

                    mMap.addMarker(markerOptions)
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLang,15f))
            }

            }
    }
}
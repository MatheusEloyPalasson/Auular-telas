    package com.example.auular

    import android.content.Context
    import android.content.Intent
    import android.graphics.Bitmap
    import android.graphics.Canvas
    import android.graphics.drawable.BitmapDrawable
    import android.graphics.drawable.Drawable
    import android.os.Bundle
    import android.util.Log
    import android.widget.Button
    import android.widget.EditText
    import android.widget.Toast
    import androidx.annotation.DrawableRes
    import androidx.appcompat.app.AppCompatActivity
    import androidx.appcompat.content.res.AppCompatResources
    import androidx.databinding.DataBindingUtil.setContentView
    import com.example.auular.api.ApiUrl
    import com.example.auular.api.BrasilApi
    import com.example.auular.domain.HotelAddress
    import com.mapbox.geojson.Point
    import com.mapbox.maps.MapView
    import com.mapbox.maps.Style
    import com.mapbox.maps.plugin.annotation.annotations
    import com.mapbox.maps.plugin.annotation.generated.OnPointAnnotationClickListener
    import com.mapbox.maps.plugin.annotation.generated.PointAnnotation
    import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
    import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response

    class activity_mapa : AppCompatActivity() {
        private val apiUsuario = BrasilApi.findPlace()
        private val apiAular = ApiUrl.getApiUsuarios()
        private var mapView: MapView? = null

        var longitudePetTutor = -23.546562

        var latitudePetTutor = -46.634024

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_mapa)
            mapView = findViewById(R.id.mapView)
            mapView?.getMapboxMap()?.loadStyleUri(Style.MAPBOX_STREETS, object : Style.OnStyleLoaded {

                override fun onStyleLoaded(style: Style) {
                    val pointAnnotationManager = mapView?.annotations?.createPointAnnotationManager(mapView!!)

                    // Configurar o clique nos ícones
                    pointAnnotationManager?.addClickListener(OnPointAnnotationClickListener { pointAnnotation ->

                        val logar = Intent(applicationContext, Login::class.java)
                        startActivity(logar)
                        // Exemplo de ação ao clicar no ícone
                        Toast.makeText(this@activity_mapa, "Ícone clicado", Toast.LENGTH_SHORT).show()

                        true // Retorna 'true' para consumir o clique no ícone
                    })
                }
            })
            val buttonPesquisar = findViewById<Button>(R.id.bt_pesquisar)

            val buttonCadastrar = findViewById<Button>(R.id.bt_cadastro)

            buttonCadastrar.setOnClickListener {
                val cadastro = Intent(applicationContext, Cadastro::class.java)
                startActivity(cadastro)
            }

            val buttonLogin = findViewById<Button>(R.id.bt_login)

            buttonLogin.setOnClickListener {
                val login = Intent(applicationContext, Login::class.java)
                startActivity(login)
            }

            var cep = findViewById<EditText>(R.id.et_cep)

            buttonPesquisar.setOnClickListener {

                Log.i(
                    "CEP",
                    cep.text.toString()
                )
                val result: Call<Address> = apiUsuario.buscar(cep.text.toString())
                val result2 = apiAular.getHotelAddresses()

                result.enqueue(object : Callback<Address> {
                    override fun onResponse(call: Call<Address>, response: Response<Address>) {
                        if (response.isSuccessful) {
                            val address = response.body()
                            Log.i(
                                "TUTOR",
                                address.toString()
                            )
                            longitudePetTutor = address!!.location.coordinates.longitude
                            latitudePetTutor = address.location.coordinates.latitude

                            addAnnotationToMap(longitudePetTutor, latitudePetTutor)
                            cep.getText().clear();

                        }
                    }

                    override fun onFailure(call: Call<Address>, t: Throwable) {
                        Toast.makeText(
                            baseContext, "Erro na API: ${t.message}", Toast.LENGTH_SHORT
                        ).show()
                        t.printStackTrace()
                    }
                })

                result2.enqueue(object : Callback<List<HotelAddress>> {
                    override fun onResponse(
                        call: Call<List<HotelAddress>>, response: Response<List<HotelAddress>>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let { pinHotelAddresses(it) }
                        }
                    }

                    override fun onFailure(call: Call<List<HotelAddress>>, t: Throwable) {
                        Toast.makeText(
                            baseContext, "Erro na API: ${t.message}", Toast.LENGTH_SHORT
                        ).show()
                        t.printStackTrace()
                    }
                })
            }
        }

        private fun pinHotelAddresses(addresses: List<HotelAddress>) {
            for (hotel: HotelAddress in addresses) {
                val result = this.apiUsuario.buscar(hotel.addressCode)

                result.enqueue(object : Callback<Address> {
                    override fun onResponse(call: Call<Address>, response: Response<Address>) {
                        if (response.isSuccessful) {
                            val address = response.body()
                            val longitude = address!!.location.coordinates.longitude
                            val latitude = address.location.coordinates.latitude

                            addHotelAnnotationToMap(longitude, latitude)

                        }
                    }

                    override fun onFailure(call: Call<Address>, t: Throwable) {
                        Toast.makeText(
                            baseContext, "Erro na API: ${t.message}", Toast.LENGTH_SHORT
                        ).show()
                        t.printStackTrace()
                    }
                })
            }
        }


        private fun addAnnotationToMap(longitude: Double, latitude: Double) {
            bitmapFromDrawableRes(
                this@activity_mapa, R.mipmap.dog
            )?.let {
                val annotationApi = mapView?.annotations
                val pointAnnotationManager = annotationApi?.createPointAnnotationManager(mapView!!)
                val pointAnnotationOptions: PointAnnotationOptions =
                    PointAnnotationOptions().withPoint(Point.fromLngLat(longitude, latitude))
                        .withIconImage(it).withIconSize(0.6)
                pointAnnotationManager?.create(pointAnnotationOptions)
            }
        }

        private fun addHotelAnnotationToMap(longitude: Double, latitude: Double): PointAnnotation?{
           return bitmapFromDrawableRes(
                this@activity_mapa, R.mipmap.hotel
            )?.let {
                val annotationApi = mapView?.annotations
                val pointAnnotationManager = annotationApi?.createPointAnnotationManager(mapView!!)
                val pointAnnotationOptions: PointAnnotationOptions =
                    PointAnnotationOptions().withPoint(Point.fromLngLat(longitude, latitude))
                        .withIconImage(it).withIconSize(0.6)
                return pointAnnotationManager?.create(pointAnnotationOptions)
            }
        }

        private fun bitmapFromDrawableRes(context: Context, @DrawableRes resourceId: Int) =
            convertDrawableToBitmap(AppCompatResources.getDrawable(context, resourceId))

        private fun convertDrawableToBitmap(sourceDrawable: Drawable?): Bitmap? {
            if (sourceDrawable == null) {
                return null
            }
            return if (sourceDrawable is BitmapDrawable) {
                sourceDrawable.bitmap
            } else {
                val constantState = sourceDrawable.constantState ?: return null
                val drawable = constantState.newDrawable().mutate()
                val bitmap: Bitmap = Bitmap.createBitmap(
                    drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888
                )
                val canvas = Canvas(bitmap)
                drawable.setBounds(0, 0, canvas.width, canvas.height)
                drawable.draw(canvas)
                bitmap
            }
        }






    }

package upt.solmovi.mymapapplicationcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*


@Composable
fun MiMapa(ubicacion:LatLng){
  val cameraPositionState= rememberCameraPositionState{
    position = CameraPosition.fromLatLngZoom(ubicacion,12f)
  }
  val lugar = rememberMarkerState(position = ubicacion)
  GoogleMap(
    modifier = Modifier.fillMaxSize(),
    cameraPositionState = cameraPositionState,
    onMapClick={ lugar.position = it}
  ){
    Marker(
      state = MarkerState(position = ubicacion),
      title = "Universidad Privada de Tacna",
      snippet = "UPT"
    )
    Marcador(lugar,"Selección personal")
  }
}

@Composable
fun Marcador(lugar:MarkerState,title:String){
  Marker(
    lugar,title = title
  )
}



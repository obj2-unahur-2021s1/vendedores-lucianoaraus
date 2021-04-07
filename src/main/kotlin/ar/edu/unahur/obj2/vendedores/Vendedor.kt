package ar.edu.unahur.obj2.vendedores
import Centros.*
import Ciudad.*


//Vendedores POO 1
class Certificacion(val esDeProducto: Boolean, val puntaje: Int)
  // Cada certificacion otorga puntos
  // Algunas son sobre productos, otras no

abstract class Vendedor{
  // Acá es obligatorio poner el tipo de la lista, porque como está vacía no lo puede inferir.
  // Además, a una MutableList se le pueden agregar elementos
  val certificaciones = mutableListOf<Certificacion>()

  // Definimos el método abstracto.
  // Como no vamos a implementarlo acá, es necesario explicitar qué devuelve.
  abstract fun puedeTrabajarEn(ciudad: Ciudad): Boolean
  fun esVersatil() =
    certificaciones.size >= 3
    && certificaciones.any { this.especialidad() == "productos" }
    && ! certificaciones.any { this.especialidad() == "productos" }

  fun esFirme() = certificaciones.sumBy { this.puntos() >= 30 }
  fun adquirirCertificacion(certificacionAAdquirir : Certificacion){ certificaciones.add(certificacionAAdquirir) }
  //fun afinidadAlCentro(centro : Ciudad)
  fun esCandidato(centro : Ciudad) = it.esVersatil()
}

class VendedorFijo(val ciudadDeResidencia: Ciudad) : Vendedor {

  fun puedeTrabajar(ciudad : Ciudad) = ciudadDeResidencia == ciudad
  fun esInfluyente() = false
  override fun afinidadAlCentro(centro : Ciudad) = it.puedeTrabajar(centro.ciudad())
  override fun esCandidato(centro : Ciudad) = super(centro) && it.afinidadAlCentro(centro : Ciudad) //Ver q onda con el Super
  fun esHumano() = true

}

class Viajante(val provinciasHabilitadas : List<Provincia>) : Vendedor {

  fun puedeTrabajar(ciudad : Ciudad) = provinciasHabilitadas.contains(ciudad.provincia())
  fun esInfluyente() = provinciasHabilitadas.sumBy { this.poblacion() >= 10000000 }
  override fun afinidadAlCentro(centro : Ciudad) = it.puedeTrabajar(centro.ciudad())
  override fun esCandidato(centro : Ciudad) = super(centro) && it.afinidadAlCentro(centro)
  fun esHumano() = true
}

class ComercioCorresponsal(val ciudadesConSucursales : List<Ciudad> ) : Vendedor {

  fun puedeTrabajar(ciudad : Ciudad) = ciudadesConSucursales.contains(ciudad)
  fun esInfluyente() =
    ciudadesConSucursales.size >= 5
    || ciudadesConSucursales.map( { this.provincia() } ).asSet().size >= 3
  override fun afinidadAlCentro(centro : Ciudad) =
    it.puedeTrabajar(centro.ciudad())
    && ciudadesConSucursales.any { c -> ! centro.puedeCubrir(c) }
  override fun esCandidato(centro : Ciudad) = super(centro) && it.afinidadAlCentro(centro)
  fun esHumano() = false
}

/* 1st Try
class Certificacion(val esDeProducto: Boolean, val puntaje: Int)

abstract class Vendedor { //abstract: No tiene implementacion, solo declaracion.

  // Acá es obligatorio poner el tipo de la lista, porque como está vacía no lo puede inferir.
  // Además, a una MutableList se le pueden agregar elementos
  val certificaciones = mutableListOf<Certificacion>()

  // Definimos el método abstracto.
  // Como no vamos a implementarlo acá, es necesario explicitar qué devuelve.
  abstract fun puedeTrabajarEn(ciudad: Ciudad): Boolean

  // En las funciones declaradas con = no es necesario explicitar el tipo
  fun esVersatil() =
    certificaciones.size >= 3
    && this.certificacionesDeProducto() >= 1
    && this.otrasCertificaciones() >= 1

  // Si el tipo no está declarado y la función no devuelve nada, se asume Unit (es decir, vacío)
  fun agregarCertificacion(certificacion: Certificacion) {
    certificaciones.add(certificacion)
  }

  fun esFirme() = this.puntajeCertificaciones() >= 30

  fun certificacionesDeProducto() = certificaciones.count { it.esDeProducto }
  fun otrasCertificaciones() = certificaciones.count { !it.esDeProducto }

  fun puntajeCertificaciones() = certificaciones.sumBy { c -> c.puntaje }

  abstract fun esInfluyente(): Boolean
}

// En los parámetros, es obligatorio poner el tipo
class VendedorFijo(val ciudadOrigen: Ciudad) : Vendedor() { // ":" == "Inherits"
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return ciudad == ciudadOrigen
  }
  override fun esInfluyente(): Boolean = false
}

// A este tipo de List no se le pueden agregar elementos una vez definida
class Viajante(val provinciasHabilitadas: List<Provincia>) : Vendedor() {
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return provinciasHabilitadas.contains(ciudad.provincia)
  }

  override fun esInfluyente() = this.provinciasHabilitadas.sumBy { it.poblacion } >= 10000000

  /*Se puede hacer asi tambien pere es mas largo:
  override fun esInfluyente() = provinciasHabilitadas.sumBy { provincia.poblacion } >= 10000000
  */
}

class ComercioCorresponsal(val ciudades: List<Ciudad>) : Vendedor() {
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return ciudades.contains(ciudad)
  }
  override fun esInfluyente(): Boolean {
    return ciudades.toSet().size >= 5 or ciudades.map{ciudad.provincia()}.toSet().size >= 3
  }
}
*/
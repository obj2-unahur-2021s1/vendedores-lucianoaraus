package ar.edu.unahur.obj2.vendedores

import java.lang.Exception

class CentroDistribucion(val ciudad: Ciudad){
    val vendedores = mutableListOf<Vendedor>()

    //lo que hace el check es tirar el error si no se cumple la condición
    /*fun agregarVendedor(vendedor: Vendedor){ //No devuelve nada
        check(vendedores.contains(vendedor)){ vendedores.add(vendedor) } //Si no esta registrado -> agrega al vendedor
        "El vendedor ya esta registrado"
    }*/
    //ALTERNATIVA:
    fun agregarVendedor(vendedor: Vendedor){ //No devuelve nada
        if(vendedores.contains(vendedor)){
            throw Exception("El vendedor ya esta registrado") }
            else { vendedores.add(vendedor) }
        //Si no esta registrado -> agrega al vendedor
    }//*/

    // ETAPA 3
    fun vendedorEstrella() = vendedores.maxBy { it.puntajeCertificaciones() } //Devuelve el vendedor con maximo puntaje en 'Certificaciones'.
    fun puedeCubrir(ciudadRequerida : Ciudad) = vendedores.any { it.puedeTrabajarEn(ciudadRequerida) }
    fun vendedoresGenericos() = vendedores.filter { it.esGenerico() }.toSet()
    fun esRobusto() = vendedores.count {  it.esFirme()  } >= 3

    //fun totalCertificacionesPorVendedor() = vendedores.map { it.certificaciones } //Devuelve lista de certificaciones
    //fun puntosCertificacionesPorVendedor() = this.totalCertificacionesPorVendedor().map { it.puntaje() } //Devuelve lista de puntajes de certificaciones
}

/* Testear Error:
    Para testearlo seria algo asi. Si explota, el test pasa... si no explota, falla:
        it("tira error cuando esta registrado") {
            shouldThrowAny {
            centroLiniers.agregarVendedor(julieta) Asumiendo que a julieta se la agrego al centro previamente
        }
}*/


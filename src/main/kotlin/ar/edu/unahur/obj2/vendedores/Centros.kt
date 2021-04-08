package ar.edu.unahur.obj2.vendedores

class CentroDistribucion(val ciudad: Ciudad){
    val vendedores = mutableListOf<Vendedor>()

    //lo que hace el check es tirar el error si no se cumple la condición
    fun agregarVendedor(vendedor: Vendedor){
        check(vendedores.contains(vendedor)){ "El vendedor ya esta registrado" }
        vendedores.add(vendedor)//Si no esta registrado -> agrega al vendedor
    }
    // ETAPA 3
    fun vendedorEstrella() = vendedores.maxBy { it.certificaciones.sumBy { it.puntos() } }//hacer 1 metodo para los puntos
    fun puedeCubrir(ciudadRequerida : Ciudad) = vendedores.any { it.puedeTrabajarEn(ciudadRequerida) }
    fun vendedoresGenericos() = vendedores.any { it.certificaciones != "productos" }//hacer 1 metodo para los vendedores genericos
    fun esRobusto() = vendedores.count( { it.esFirme() } ) >= 3
}

//ERROR: La clase CentroDistribucion no reconoce la clase vendedores.
//ERROR 2 - La clase Viajante y ComercioCorresponsal no reconocen la clase Ciudad

/* Testear Error:
    Para testearlo seria algo asi. Si explota, el test pasa... si no explota, falla:
        it("tira error cuando esta registrado") {
            shouldThrowAny {
            centroLiniers.agregarVendedor(julieta) Asumiendo que a julieta se la agrego al centro previamente
        }
}*/


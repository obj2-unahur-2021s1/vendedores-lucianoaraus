package ar.edu.unahur.obj2.vendedores
import vendedor.*
import ciudad.*

class CentroDistribucion(val ciudad: Ciudad){
    val vendedores : List<Vendedor>

    //lo que hace el check es tirar el error si no se cumple la condición
    fun agregarVendedor(vendedor: Vendedor){
        check(vendedores.contains(vendedor)){ "El vendedor ya esta registrado" }
        vendedores.add(vendedor)//Si no esta registrado -> agrega al vendedor
    }
    fun vendedorEstrella() = vendedores.max( { this.certificaciones().sumBy { this.puntos() } } )
    fun puedeCubrir(ciudadRequerida : Ciudad) = vendedores.any { this.puedeTrabajar(ciudadRequerida) }
    fun vendedoresGenericos() = vendedores.any { this.certificaciones() != "productos" }
    fun esRobusto() = vendedores.count( { this.esFirme() } ) >= 3
    fun repartirCertificacion(certificacionAOtorgar : Certificacion){
        vendedores.forEach( { this.adquirirCertificacion(certificacionAOtorgar) } )
    }
}

/* Testear Error:
    Para testearlo seria algo asi. Si explota, el test pasa... si no explota, falla:
        it("tira error cuando esta registrado") {
            shouldThrowAny {
            objetos2.inscribir(unoQueNoCursoObjetos1)
        }
}*/
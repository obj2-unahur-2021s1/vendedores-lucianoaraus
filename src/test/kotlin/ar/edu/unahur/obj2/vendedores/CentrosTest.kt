package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

//ETAPA 3
class CentrosDistribucionTest : DescribeSpec({

    //Provincias
    val misiones = Provincia(1300000)
    val rioDeJaneiro = Provincia(10000000)
    val ohio = Provincia(11690000)
    //Ciudades
    val sanIgnacio = Ciudad(misiones)
    val rio = Ciudad(rioDeJaneiro)
    val toronto = Ciudad(ohio)

    //Vendedores
    val vendedor1 = VendedorFijo(sanIgnacio)
    val vendedor2 = VendedorFijo(toronto)
    val vendedor3 = VendedorFijo(rio)
    //Certificaciones
    val certificacionProducto = Certificacion(true, 15)
    val certificacionNoProducto = Certificacion(false, 10)

    //Centros de Distribucion
    val centroDistribucion1 = CentroDistribucion(sanIgnacio)
    val centroDistribucion2 = CentroDistribucion(sanIgnacio)
    val centroDistribucion3 = CentroDistribucion(rio)

    //Instancias:
        // Vendedor 1
        vendedor1.agregarCertificacion(certificacionProducto)
        vendedor1.agregarCertificacion(certificacionProducto)
        vendedor1.agregarCertificacion(certificacionProducto)
        // Vendedor 2
        vendedor2.agregarCertificacion(certificacionProducto)
        vendedor2.agregarCertificacion(certificacionProducto)
        vendedor2.agregarCertificacion(certificacionNoProducto)

        // Vendedor 3
        vendedor3.agregarCertificacion(certificacionProducto)
        vendedor3.agregarCertificacion(certificacionProducto)
        vendedor3.agregarCertificacion(certificacionProducto)

        // Centro Distribucion 1
        centroDistribucion1.agregarVendedor(vendedor1)
        centroDistribucion1.agregarVendedor(vendedor2)
        centroDistribucion1.agregarVendedor(vendedor3)

        // Centro Distribucion 2
        centroDistribucion2.agregarVendedor(vendedor1)
        centroDistribucion2.agregarVendedor(vendedor2)
        centroDistribucion2.agregarVendedor(vendedor3)

    //1
    describe("Vendedor Estrella"){
        it("el vendedor 1 tiene mayor puntaje total por certificaciones") {
            centroDistribucion1.vendedorEstrella().shouldBe(vendedor1) // Devuelve un objeto
        }
        it("el vendedor 2 no es vendedor estrella") {
            centroDistribucion1.vendedorEstrella().shouldNotBe(vendedor2) // Devuelve un objeto
        }
    }

    //2
    describe("Puede Cubrir"){
        it("el vendedor puede cubrir la ciudad dada") {
            centroDistribucion1.puedeCubrir(sanIgnacio).shouldBeTrue()
        }
        it("el vendedor NO puede cubrir la ciudad dada") {
            centroDistribucion3.puedeCubrir(rio).shouldBeFalse()
        }
    }

    //3
    describe("Vendedores Genericos"){
        it("el vendedor tiene una certificacion que no es de productos") {
            centroDistribucion1.vendedoresGenericos().shouldContain(vendedor2)
        }
        it("el vendedor NO es generico") {
            centroDistribucion1.vendedoresGenericos().shouldContain(vendedor1)
        }
    }

    //4
    describe("Es robusto"){
        it("al menos 3 vendedores son firmes") {
            centroDistribucion1.esRobusto().shouldBeTrue()
        }
        it("no hay 3 vendedores firmes") {
            centroDistribucion3.esRobusto().shouldBeFalse()
        }
    }
})
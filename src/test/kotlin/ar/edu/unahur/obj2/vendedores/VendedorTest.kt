package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class VendedorTest : DescribeSpec({

  //Provincias
  val misiones = Provincia(1300000)
  val rioDeJaneiro = Provincia(10000000)
  val ohio = Provincia(11690000)
  //Ciudades
  val sanIgnacio = Ciudad(misiones)
  val rio = Ciudad(rioDeJaneiro)

  //Certificados
  val certificacionProducto = Certificacion(true, 10)
  val certificacionNoProducto = Certificacion(false, 8)

  
  describe("Vendedor Fijo") {
    //Ciudad
    val obera = Ciudad(misiones)
    //Vendedores
    val vendedorFijo = VendedorFijo(obera)
    val vendedorFijo2 = VendedorFijo(obera)

    //ETAPA 1
    describe("Puede trabajar") {
      it("puedeTrabajar en su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
    }

    //ETAPA 1
    describe("Es versatil") {
      vendedorFijo.agregarCertificacion(certificacionProducto)
      vendedorFijo.agregarCertificacion(certificacionNoProducto)
      vendedorFijo.agregarCertificacion(certificacionNoProducto)

      it("tiene al menos 1 certificacion de productos, otra que no es de productos, y otra mas") {
        vendedorFijo.esVersatil().shouldBeTrue()
      }
      it("No tiene certificaciones") {
        vendedorFijo2.esVersatil().shouldBeFalse()
      }
    }

    //ETAPA 1
    describe("Es firme") {
      vendedorFijo.agregarCertificacion(certificacionProducto)
      vendedorFijo.agregarCertificacion(certificacionProducto)
      vendedorFijo.agregarCertificacion(certificacionNoProducto)
      vendedorFijo.agregarCertificacion(certificacionNoProducto)
      it("tiene un puntaje en certificaciones igual o mayor a 30") {
        vendedorFijo.esFirme().shouldBeTrue()
      }
      it("No tiene un puntaje en certificaciones igual o mayor a 30") {
        vendedorFijo2.esFirme().shouldBeFalse()
      }
    }

    //ETAPA 2
    describe("Es influyente") {
      it("No es influyente") {
        vendedorFijo.esInfluyente().shouldBeFalse()
      }
    }
  }

  //ETAPA 3 - Pendiente


  describe("Viajante") {
    val cordoba = Provincia(2000000)
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante(listOf(misiones))

    val viajanteBrasilero = Viajante(listOf(rioDeJaneiro))

    //ETAPA 1
    describe("Puede trabajar en") {
      it("una ciudad que pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(villaDolores).shouldBeFalse()
      }
    }
    //ETAPA 1
    describe("Es versatil") {
      viajante.agregarCertificacion(certificacionProducto)
      viajante.agregarCertificacion(certificacionNoProducto)
      viajante.agregarCertificacion(certificacionNoProducto)

      it("tiene al menos 1 certificacion de productos, otra que no es de productos, y otra mas") {
        viajante.esVersatil().shouldBeTrue()
      }
      it("No tiene certificaciones") {
        viajanteBrasilero.esVersatil().shouldBeFalse()
      }
    }

    //ETAPA 1
    describe("Es firme") {
      viajante.agregarCertificacion(certificacionProducto)
      viajante.agregarCertificacion(certificacionProducto)
      viajante.agregarCertificacion(certificacionNoProducto)
      viajante.agregarCertificacion(certificacionNoProducto)
      it("tiene un puntaje en certificaciones igual o mayor a 30") {
        viajante.esFirme().shouldBeTrue()
      }
      it("No tiene un puntaje en certificaciones igual o mayor a 30") {
        viajanteBrasilero.esFirme().shouldBeFalse()
      }

    }
    //ETAPA 2
    describe("Es influyente") {
      it("La poblacion debe ser >= a 10.000.000") {
        viajanteBrasilero.esInfluyente().shouldBeTrue()
      }
      it("La poblacion NO debe superer los 10.000.000 habitantes") {
        viajante.esInfluyente().shouldBeFalse()
      }
    }
  }

  describe("Comercio Corresponsal") {
    //Provincia
    val buenosAires = Provincia(1500000)
    //Ciudades
    val caballito = Ciudad(buenosAires)
    val torcuato = Ciudad(rioDeJaneiro)
    val castelar = Ciudad(ohio)
    val moron = Ciudad(buenosAires)
    //Comercios
    val comercioCorresponsal = ComercioCorresponsal(listOf(sanIgnacio, caballito, torcuato, castelar, moron))
    val comercioCorresponsal2 = ComercioCorresponsal(listOf(sanIgnacio, torcuato, castelar))
    val comercioCorresponsal3 = ComercioCorresponsal(listOf(sanIgnacio, caballito))

    //ETAPA 1
    describe("Puede trabajar en") {
      it("Una ciudad que pertenece a las ciudades habilitadas") {
        comercioCorresponsal.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("Una ciudad que NO pertenece a las ciudades habilitadas") {
        comercioCorresponsal2.puedeTrabajarEn(caballito).shouldBeFalse()
      }
    }
    //ETAPA 1
    describe("Es versatil") {
      comercioCorresponsal.agregarCertificacion(certificacionProducto)
      comercioCorresponsal.agregarCertificacion(certificacionNoProducto)
      comercioCorresponsal.agregarCertificacion(certificacionNoProducto)

      it("tiene al menos 1 certificacion de productos, otra que no es de productos, y otra mas") {
        comercioCorresponsal.esVersatil().shouldBeTrue()
      }
      it("No tiene certificaciones") {
        comercioCorresponsal2.esVersatil().shouldBeFalse()
      }
    }

    //ETAPA 1
    describe("Es firme") {
      comercioCorresponsal.agregarCertificacion(certificacionProducto)
      comercioCorresponsal.agregarCertificacion(certificacionProducto)
      comercioCorresponsal.agregarCertificacion(certificacionNoProducto)
      comercioCorresponsal.agregarCertificacion(certificacionNoProducto)
      it("tiene un puntaje en certificaciones igual o mayor a 30") {
        comercioCorresponsal.esFirme().shouldBeTrue()
      }
      it("No tiene un puntaje en certificaciones igual o mayor a 30") {
        comercioCorresponsal2.esFirme().shouldBeFalse()
      }
    }

    //ETAPA 2
    describe("Es influyente") {
      it("Tiene 5 o mas sucursales") {
        comercioCorresponsal.esInfluyente().shouldBeTrue()
      }
      it("Tiene sucursales en al menos 3 provincias") {
        comercioCorresponsal2.esInfluyente().shouldBeTrue()
      }
      it("No tiene 5 o mas sucursales") {
        comercioCorresponsal3.esInfluyente().shouldBeFalse()
      }
    }
  }
})



package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class VendedorTest : DescribeSpec({
  val misiones = Provincia(1300000)
  val rioDeJaneiro = Provincia(10000000)
  val ohio = Provincia(11690000)
  val sanIgnacio = Ciudad(misiones)
  val rio = Ciudad(rioDeJaneiro)

  describe("Vendedor Fijo") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)

    describe("puedeTrabajar") {
      it("puedeTrabajar en su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
    }
    describe("esInfluyente") {
      it("No es influyente") {
        vendedorFijo.esInfluyente().shouldBeFalse()
      }
    }
  }

  describe("Viajante") {
    val cordoba = Provincia(2000000)
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante(listOf(misiones))

    val viajanteBrasilero = Viajante(listOf(rioDeJaneiro))

    describe("puedeTrabajarEn") {
      it("una ciudad que pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(villaDolores).shouldBeFalse()
      }
    }
    describe("esInfluyente") {
      it("La poblacion debe ser >= a 10.000.000") {
        viajanteBrasilero.esInfluyente().shouldBeTrue()
      }
      it("La poblacion debe ser >= a 10.000.000") {
        viajante.esInfluyente().shouldBeFalse()
      }
    }
  }

  describe("Comercio Corresponsal") {
    val buenosAires = Provincia(1500000)
    val caballito = Ciudad(buenosAires)
    val torcuato = Ciudad(rioDeJaneiro)
    val castelar = Ciudad(ohio)
    val moron = Ciudad(buenosAires)
    val comercioCorresponsal = ComercioCorresponsal(listOf(sanIgnacio, caballito, torcuato, castelar, moron))
    val comercioCorresponsal2 = ComercioCorresponsal(listOf(sanIgnacio, torcuato, castelar))
    val comercioCorresponsal3 = ComercioCorresponsal(listOf(sanIgnacio, caballito, torcuato))

    describe("puedeTrabajarEn") {
      it("Una ciudad que pertenece a las ciudades habilitadas") {
        comercioCorresponsal.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("Una ciudad que NO pertenece a las ciudades habilitadas") {
        comercioCorresponsal.puedeTrabajarEn(caballito).shouldBeFalse()
      }
    }
    describe("esInfluyente") {
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

/*Estructura del test
class MyTests : DescribeSpec({
  describe("score") {
    it("start as zero") {
      // test here
    }
    describe("with a strike") {
      it("adds ten") {
        // test here
      }
      it("carries strike to the next frame") {
        // test here
      }
    }

    describe("for the opposite team") {
      it("Should negate one score") {
        // test here
      }
    }
  }
})*/


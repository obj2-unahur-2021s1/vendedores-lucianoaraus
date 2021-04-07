package ar.edu.unahur.obj2.vendedores
import Vendedor.*

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class comercioCorresponsal : DescribeSpec({

  //Sucursal #1
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)

  describe("Vendedor Fijo"){
      val obera = Ciudad(provincia = misiones)
      val vendedorFijo = Ciudad(ciudadDeResidencia = obera)

      it("puedeTrabajar en su ciudad de origen") {
          vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
      }
  }

/*Vendedores viejo POO 1
  assert.that(comercioCorresponsal1.esInfluyente())

  //Sucursal #2
  val santaFe = new Provincia(poblacion = 3000000)
  val cordoba = new Provincia(poblacion = 3000000)
  val entreRios = new Provincia(poblacion = 3000000)

  val rosario = new Ciudad(provincia = santaFe)
  val rafaela = new Ciudad(provincia = santaFe)
  val sanFrancisco = new Ciudad(provincia = cordoba)
  val diamante = new Ciudad(provincia = entreRios)

  val comercioCorresponsal2 = new ComercioCorresponsal(certificaciones = [], ciudadesConSucursales = [rosario, rafaela, sanFrancisco, diamante])

  assert.that(comercioCorresponsal2.esInfluyente())

  //Sucursal #3
  val amstrong = new Ciudad(provincia = santaFe)

  val comercioCorresponsal3 = new ComercioCorresponsal(certificaciones = [], ciudadesConSucursales = [rosario, rafaela, amstrong, diamante])

  assert.notThat(comercioCorresponsal3.esInfluyente())

})
*/

//Estructura del test
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
})

/* Codigo del ejercicio
class VendedorTest : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)

  describe("Vendedor fijo") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)

    describe("puedeTrabajarEn") {
      it("su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
    }
  }

  describe("Viajante") {
    val cordoba = Provincia(2000000)
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante(listOf(misiones))

    describe("puedeTrabajarEn") {
      it("una ciudad que pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(villaDolores).shouldBeFalse()
      }
    }
  }
})
*/
package com.mouredev.weeklychallenge2022

/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 *
 */

fun main() {

    /*
    SOLUCION MARTINEZ
    */
    val miTriangulo = Poligono(10.2f, 5.6f, Poligono.Tipo.TRIANGULO)
    val miCuadrado = Poligono(4.2f, 4.2f, Poligono.Tipo.CUADRADO)
    val miRectangulo = Poligono(12.2f, 6.6f, Poligono.Tipo.TRIANGULO)
    println("Este es el área: ${calcularArea(miTriangulo)}")
    println("Este es el área: ${calcularArea(miCuadrado)}")
    println("Este es el área: ${calcularArea(miRectangulo)}")

    /*
    SOLUCION MOURE
    */
    area(Triangle(10.0, 5.0))
    area(Rectangle(5.0, 7.0))
    area(Square(4.0))

}

/*
SOLUCION MARTINEZ----------------------------------------------------------------------------------
*/
class Poligono (var base : Float, var altura : Float, var tipo : Tipo){
    enum class Tipo{
        TRIANGULO, CUADRADO, RECTANGULO,
    }
}

fun calcularArea (p : Poligono) : Float{

    return when (p.tipo){
        Poligono.Tipo.TRIANGULO -> (p.base * p.altura / 2)
        Poligono.Tipo.CUADRADO -> (p.base * p.altura)
        else -> (p.base * p.altura)
    }
}

/*
SOLUCION MOURE-------------------------------------------------------------------------------------
*/
interface Polygon {

    fun area(): Double
    fun printArea()
}

data class Triangle(val base: Double, val height: Double): Polygon {

    override fun area(): Double {
        return (base * height) / 2
    }

    override fun printArea() {
        println("El área del triángulo es ${area()}")
    }
}

data class Rectangle(val length: Double, val width: Double): Polygon {

    override fun area(): Double {
        return length * width
    }

    override fun printArea() {
        println("El área del rectángulo es ${area()}")
    }
}

data class Square(val side: Double): Polygon {

    override fun area(): Double {
        return side * side
    }

    override fun printArea() {
        println("El área del cuadrado es ${area()}")
    }
}

private fun area(polygon: Polygon): Double {
    polygon.printArea()
    return polygon.area()
}
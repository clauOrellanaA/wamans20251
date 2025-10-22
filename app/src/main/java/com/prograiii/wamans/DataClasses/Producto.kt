package com.prograiii.wamans.DataClasses

data class Producto(
    var nombre: String,
    var tipo: String,
    var frecuencia: String,
    var fechaApertura: String,
    var fechaCaducidad: String,
    var alertaCaducidad: Boolean = false
)

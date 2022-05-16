package com.example.miscuentas.model

class superMarketProvider {
    companion object {
        var markerList = mutableListOf<SuperMarketModel>(
            SuperMarketModel("Arroz",80.73),
            SuperMarketModel("Mayonesa",120.82),
            SuperMarketModel("Queso",326.36),
            SuperMarketModel("Leche",85.45),
            SuperMarketModel("Cerveza",96.034),
            SuperMarketModel("Galletitas",20.00),
            SuperMarketModel("Arroz1",87.73),
            SuperMarketModel("Mayonesa1",125.82),
            SuperMarketModel("Queso1",350.36),
            SuperMarketModel("Leche1",101.45),
            SuperMarketModel("Cerveza1",180.03),
            SuperMarketModel("Galletitas1",27.30),
            SuperMarketModel("Arroz2",120.73),
            SuperMarketModel("Mayonesa2",100.32),
            SuperMarketModel("Queso2",826.36),
            SuperMarketModel("Leche2",30.45),
            SuperMarketModel("Cerveza2",198.03),
            SuperMarketModel("Galletitas2",28.00),

        )
    }


}

private fun <E> MutableList<E>.add(name: String, precio: Double) {
}
